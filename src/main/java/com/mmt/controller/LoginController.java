package com.mmt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController 
{
	private Logger logger = LoggerFactory.getLogger(getClass());

	/*
	@RequestMapping(value="/")
	public String home()
	{
		logger.info("++++++++login action++++++++++");
		return "manage/login";
	}
	*/
	
	
	@RequestMapping(value="/manage/login")
	public String index() {
		logger.info("++++++++login action++++++++++");
		return "manage/login";
	}
	
	@RequestMapping("/manage/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "manage/login";
	}
	
	@RequestMapping("/manage/404")
	public String notFound(Model model) {
		return "manage/404";
	}
	
	@RequestMapping("/manage/403")
	public String notAccess(Model model) {
		return "manage/403";
	}
}
