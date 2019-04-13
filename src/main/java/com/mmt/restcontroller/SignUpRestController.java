package com.mmt.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import com.mmt.service.SignUpService;

import com.mmt.json.SignUpJson;


@RestController
@RequestMapping(value="/api/")
public class SignUpRestController 
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SignUpService signUpService;
	
	
	@ResponseBody
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String doSignUp(@RequestBody SignUpJson _signUpJson)
	{
		logger.info("############hello############");
		
		//signUpService.checkIfUserExisted();
		
		logger.info(_signUpJson.getEmail());
		
		return "Hello";
	}
	
	
}
