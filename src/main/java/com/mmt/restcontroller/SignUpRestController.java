package com.mmt.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.service.SignUpService;


@RestController
public class SignUpRestController 
{
	@Autowired
	SignUpService signUpService;
	
	
	
	@ResponseBody
	@RequestMapping(value = "/doSignUp", method = RequestMethod.POST)
	public String doSignUp()
	{
		
		
		
		return "";
	}
	
	
}
