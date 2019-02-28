package com.mmt.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.entity.SysAdminUser;
import com.mmt.service.SysAdminUserService;

@RestController
public class AdminController {
	
	@Autowired
	private SysAdminUserService adminService;
	
	@RequestMapping(value = "/verify", method = {RequestMethod.GET})
	public boolean verify(String name, String password) {
		System.out.println("++++++verify+++++++");
		SysAdminUser admin = adminService.checkUserByNameAndPwd(name, password);
		if(admin != null) {
			return true;
		}
		return false;
	}
}
