package com.mmt.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.entity.User;
import com.mmt.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user", method = {RequestMethod.GET})
	public Page<User> index(@RequestParam("pageNumber")int pageNumber, @RequestParam("pageSize")int pageSize) {
		return userService.getUsers(pageNumber, pageSize);
	}
}
