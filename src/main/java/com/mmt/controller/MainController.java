package com.mmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmt.service.SysAdminUserService;

@Controller
@RequestMapping("/manage")
public class MainController {

	@Autowired
	private SysAdminUserService userService;
	
	@PreAuthorize("hasAuthority('MAIN')")
	@RequestMapping(value = "/main")
	public String main() {
		System.out.println("++++++to main.html+++++");
		return "manage/main";
	}
}
