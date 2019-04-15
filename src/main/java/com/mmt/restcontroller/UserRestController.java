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
import com.mmt.service.UserService;
import com.mmt.entity.User;



@RestController
@RequestMapping(value="/api/")
public class UserRestController 
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	UserService userService;
	

	@ResponseBody
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUp(@RequestParam("email") String _email, @RequestParam("password") String _pass)
	{
		
		
		logger.info("############hello############");
		
		
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
	
	
}
