package com.mmt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminPermitControl {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value="/manage/admin_permit")
	public String index(Model model) {
		logger.info("++++++++admin_permit++++++++++");
		model.addAttribute("active", "admin");
		return "manage/admin_permit";
	}
}
