package com.mmt.restcontroller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.entity.SysAdminUser;
import com.mmt.service.SysAdminUserService;

@RestController
public class AdminController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SysAdminUserService adminService;
	
	@RequestMapping(value = "/verify", method = {RequestMethod.GET})
	public boolean verify(String name, String password) throws IOException{
		SysAdminUser admin = adminService.checkUserByNameAndPwd(name, password);
		System.out.println(password);
		if(admin != null) {
			System.out.println("login verify: username is " + name);
			return true;
		}
		return false;
	}
}
