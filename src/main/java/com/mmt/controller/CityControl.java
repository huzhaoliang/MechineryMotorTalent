package com.mmt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		List<City> provinces = cityService.getProvinces();
		Map<Long, String> provinceMap = new HashMap<Long, String>();
		for(City city:provinces) {
			provinceMap.put(city.getId(), city.getName());
		}
		model.addAttribute("provinces", provinceMap);
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
	
	@RequestMapping(value="/manage/city_save", method=RequestMethod.POST)
	public String save(@ModelAttribute(value="cityForm") City city) {
		logger.info("++++++++city save++++++++++");
		if(city.getFlag() == 1l) {
			city.setParentId(null);
		}
		cityService.saveCity(city);
		return "manage/city_list";
	}
	
	@RequestMapping(value="/manage/city_update")
	public String update(Model model, @ModelAttribute(value="id") Long id) {
		logger.info("++++++++city update++++++++++");
		City city = cityService.getOneCity(id);
		if(city != null) {
			model.addAttribute("city", city);
		}
		List<City> provinces = cityService.getProvinces();
		if(provinces != null) {
			model.addAttribute("provinces", provinces);
		}
		return "manage/city_update";
	}
}
