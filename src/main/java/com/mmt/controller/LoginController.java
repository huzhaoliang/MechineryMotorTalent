package com.mmt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mmt.service.SysAdminUserService;


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
}
