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

import com.alibaba.fastjson.JSONObject;
import com.mmt.support.UserTokenService;
import com.mmt.service.UserService;
import com.mmt.entity.User;
import org.json.*;



@RestController
@RequestMapping(value="/api/")
public class UserRestController 
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	private String token = null;
	
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
		if(userService.getUserAmoumtByEmail(_email)!=1)
		{
			logger.info("############ email not existed ############");
			return "{\"result\":\"Email doesn't existed\"}";
		}
		
		String jsonStr = null;
		try
		{
			User user = userService.verifyUser(_email, _pass);
			
			if(user != null)
			{
				this.token = UserTokenService.generateToken(_email, _pass);
				logger.info("####current token is####" + this.token);
				jsonStr = "{\"token\":\"" + this.token + "\"}";
				//JSONObject jsonObject = new JSONObject(jsonStr);
				
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return jsonStr;
		
	}
	
	
}
