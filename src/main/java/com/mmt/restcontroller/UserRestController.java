package com.mmt.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String signUp(@RequestParam("email") String _email, @RequestParam("password") String _pass)
	{
		//JSONObject jsonObject = JSONObject.parseObject(_signUpJson);
		logger.info(_email);
		logger.info(_pass);
		//able to be regisitered == true
		if(userService.getUserAmoumtByEmail(_email)>0)
		{
			logger.info("############ email existed ############");
			return "email existed";
		}
		
		if(userService.getUserAmoumtByEmail(_email)==0)
		{
			User user = new User();
			user.setEmail(_email);
			user.setPassword(_pass);
			userService.insertUser(user);
			logger.info("############ current new user is regisitered ############");
		}
		
		return "Hello";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public String signIn(@RequestParam("email") String _email, @RequestParam("password") String _pass)
	{
		this.jsonHashMap = new HashMap<String, Object>();
		JSONObject jsonObject = null;
		
		if(userService.getUserAmoumtByEmail(_email)!=1)
		{
			logger.info("############ email not existed ############");
			
			this.jsonHashMap.put("ReturnCode", 101);
			this.jsonHashMap.put("Message", "User Account doesn't exist");
			jsonObject = new JSONObject(this.jsonHashMap);
			return jsonObject.toString();
			
		}
		
		
		try
		{
			User user = userService.verifyUser(_email, _pass);
			
			if(user != null)
			{
				this.token = UserTokenService.generateToken(_email, _pass);
				logger.info("####current token is####" + this.token);
				
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
			e.printStackTrace();
			logger.info("#### login in error #######");
			this.jsonHashMap.put("ReturnCode", 103);
			this.jsonHashMap.put("Message", "Sign In Error !");
			jsonObject = new JSONObject(this.jsonHashMap);
			
		}
		
		//String str = jsonObject.toJSONString();
		logger.info(jsonObject.toString());
		return jsonObject.toString();

	}
	
	//to verify if user is signed in
	@ResponseBody
	@RequestMapping(value = "/verifyToken", method = RequestMethod.POST)
	public String verifyToken(@RequestBody TokenJosnFormat jsonBody)
	{
		logger.info("######");
		logger.info(jsonBody.toString());
		logger.info("######");
		//UserTokenService.ver
		return null;
	}
	
}
