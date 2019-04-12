package com.mmt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JobController 
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value="/job")
	public String job() 
	{
		logger.info("++++++++ job ++++++++++");
		
		
		return "job";
	}
	
}
