package com.mmt.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.entity.SysPermission;
import com.mmt.entity.User;
import com.mmt.service.UserService;

@RestController
@RequestMapping(value="/manage/admin_permit")
public class AdminPermitControl {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public Page<SysPermission> list(@RequestParam("pageNumber")int pageNumber, @RequestParam("pageSize") {
		logger.info("++++++++admin_permit restful++++++++++");
		return "manage/admin_permit";
	}
}
