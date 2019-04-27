package com.mmt.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobRestController 
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@ResponseBody
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String getRecommendJobsList()
	{
		return null;
	}
	
	
}
