package com.mmt.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import org.json.JSONException;
import org.json.JSONObject;

import com.mmt.support.UserTokenService;
import com.mmt.service.UserService;
import com.mmt.entity.User;
import com.mmt.jsonformat.TokenJosnFormat;

import java.util.HashMap;
import java.util.Map;

import org.json.*;



@RestController
@RequestMapping(value="/api/")
public class UserRestController 
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	private String token = null;
	private Map<String, Object> jsonHashMap;
	
	
	@Autowired
	UserService userService;
	

	@ResponseBody
	@RequestMapping(value = "/signUp", method = RequestMethod.POST, produces = "application/json")
	public String signUp(@RequestParam("name") String _name, @RequestParam("email") String _email, @RequestParam("password") String _pass)
	{
		//JSONObject jsonObject = JSONObject.parseObject(_signUpJson);
		logger.info(_name);
		logger.info(_email);
		logger.info(_pass);
		
		//verify if name is existed
		if(userService.checkUserNameExisted(_name)==true)
		{
			logger.info("############ username existed ############");
			return "用户已经存在";
		}
		
		//able to be regisitered == true
		if(userService.checkUserEmailExisted(_email)==true)
		{
			logger.info("############ email existed ############");
			return "邮箱已经存在";
		}
		else
		{
			User user = new User();
			user.setName(_name);
			user.setEmail(_email);
			user.setPassword(_pass);
			userService.insertUser(user);
			logger.info("############ current new user is regisitered ############");
		}
		return "注册成功，请登录。";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/signIn", method = RequestMethod.POST, produces = "application/json")
	public User signIn(@RequestParam("email") String _email, @RequestParam("password") String _pass)
	{
		this.jsonHashMap = new HashMap<String, Object>();
		JSONObject jsonObject = null;
		
		if(userService.getUserAmoumtByEmail(_email)!=1)
		{
			logger.info("############ email not existed ############");
			
			this.jsonHashMap.put("ReturnCode", 101);
			this.jsonHashMap.put("Message", "User Account doesn't exist");
			jsonObject = new JSONObject(this.jsonHashMap);
			//return jsonObject.toString();
			
		}
		
		User user = null;
		try
		{
			user = userService.verifyUser(_email, _pass);
			
			if(user != null)
			{
				this.token = UserTokenService.generateToken(user.getName());
				logger.info("####current token is####" + this.token);
				user.setToken(this.token);
				user = userService.updateUser(user);
				
				this.jsonHashMap.put("ReturnCode", 001);
				this.jsonHashMap.put("Message", "User Signed In Successfully");
				this.jsonHashMap.put("Token", this.token);
			}
			else
			{
				logger.info("#### not able to find user ######");
				this.jsonHashMap.put("ReturnCode", 102);
				this.jsonHashMap.put("Message", "Incorrect email or password");
				
			}
			jsonObject = new JSONObject(this.jsonHashMap);
	
		}
		catch(Exception e)
		{
			this.token = null;
			e.printStackTrace();
			logger.info("#### login in error #######");
			this.jsonHashMap.put("ReturnCode", 103);
			this.jsonHashMap.put("Message", "Sign In Error !");
			jsonObject = new JSONObject(this.jsonHashMap);
			
		}
		
		//String str = jsonObject.toJSONString();
		logger.info(jsonObject.toString());
		//return jsonObject.toString();
		
		
		return user;

	}
	
	
	
	
	
	//to verify if user is signed in
	@ResponseBody
	@RequestMapping(value = "/verifyToken", method = RequestMethod.POST)
	public boolean verifyToken(@RequestBody String token)
	{
		logger.info("######");
		logger.info(token);
		logger.info("######");
		String userName = UserTokenService.verifyToken(token);
		
		if(userService.checkUserNameExisted(userName)==true)
			return true;
		return false;
	}
	
}
