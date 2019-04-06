package com.mmt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/")
public class SignUpController 
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value="/signup")
	public String signup() 
	{
		logger.info("++++++++Sign up++++++++++");
		return "signup";
	}
	
}
