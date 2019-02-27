package com.mmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.service.SysAdminUserService;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login")
	public String index() {
		System.out.println("++++++++login action++++++++++");
		return "manage/login";
	}

}
