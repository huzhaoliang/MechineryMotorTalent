package com.mmt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.entity.EnterpriseUser;
import com.mmt.service.EnterpriseService;

@Controller
public class EnterpriseController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private EnterpriseService enterpriseService;
	
	@RequestMapping(value="/manage/enter_list")
	public String list(Model model) {
		logger.info("++++++++enterprise list++++++++++");
		List<EnterpriseUser> list = enterpriseService.getAllEnterprise();
		model.addAttribute("enterprises", list);
		return "manage/enter_list";
	}
}
