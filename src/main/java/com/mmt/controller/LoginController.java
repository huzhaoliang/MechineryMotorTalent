package com.mmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login")
	public String index() {
		System.out.println("++++++++login action++++++++++");
		return "manage/login";
	}

}
