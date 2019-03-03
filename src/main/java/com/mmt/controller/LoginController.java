package com.mmt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController 
{
	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value="/")
	public String home()
	{
		logger.info("++++++++login action++++++++++");
		return "manage/login";
	}
	
	@RequestMapping(value="/login")
	public String index() {
		logger.info("++++++++login action++++++++++");
		return "manage/login";
	}
	@RequestMapping(value = "/main")
	public String main() {
		System.out.println("++++++to main.html+++++");
		return "manage/main";
	}
}
