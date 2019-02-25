package com.mmt.service;

import org.springframework.data.domain.Page;

import com.mmt.entity.User;

public interface UserService {
	User insertUser(User user);
	
	Page<User> getUsers(int pageNumber, int pageSize);
}
