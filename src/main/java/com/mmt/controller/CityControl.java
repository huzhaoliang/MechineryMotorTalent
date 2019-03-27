package com.mmt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.entity.City;
import com.mmt.service.CityService;

@Controller
public class CityControl {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CityService cityService;
	
	@RequestMapping(value="/manage/city_list")
	public String list(Model model) {
		logger.info("++++++++city list++++++++++");
		Page<City> citys = cityService.getCitys(1, 20);
		if(citys != null) {
			model.addAttribute("citys", citys);
		}
		return "manage/city_list";
	}
	
	@RequestMapping(value="/manage/city_add")
	public String add(Model model) {
		logger.info("++++++++city add++++++++++");
		List<City> provinces = cityService.getProvinces();
		if(provinces != null) {
			model.addAttribute("provinces", provinces);
		}
		return "manage/city_add";
	}
	
	@RequestMapping(value="/manage/city_save")
	public String save(Model model) {
		logger.info("++++++++city save++++++++++");
		
		return "manage/city_add";
	}
}
