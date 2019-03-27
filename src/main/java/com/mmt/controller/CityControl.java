package com.mmt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CityControl {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value="/manage/city_list")
	public String list(Model model) {
		logger.info("++++++++city list++++++++++");
		
		return "manage/city_list";
	}
	
	@RequestMapping(value="/manage/city_add")
	public String add(Model model) {
		logger.info("++++++++city add++++++++++");
		
		return "manage/city_add";
	}
}
