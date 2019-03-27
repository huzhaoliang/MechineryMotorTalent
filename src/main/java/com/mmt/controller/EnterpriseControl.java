package com.mmt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EnterpriseControl {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value="/manage/enter_list")
	public String list(Model model) {
		logger.info("++++++++enterprise list++++++++++");
		
		return "manage/enter_list";
	}
}
