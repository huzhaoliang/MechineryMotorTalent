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
import com.mmt.service.SignUpService;




@RestController
@RequestMapping(value="/api/")
public class SignUpRestController 
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	SignUpService signUpService;
	
	
	@ResponseBody
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String doSignUp(@RequestParam("email") String _email, @RequestParam("password") String _pass)
	{
		logger.info("############hello############");
		
		
		//JSONObject jsonObject = JSONObject.parseObject(_signUpJson);
		logger.info(_email);
		logger.info(_pass);
		//able to be regisitered == true
		if(signUpService.checkIfUserExisted(_email)==true)
		{
			signUpService.doUserSignUp(_email, _pass);
		}
		
		return "Hello";
	}
	
	
}
