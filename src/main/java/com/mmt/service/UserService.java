package com.mmt.service;

import org.springframework.data.domain.Page;

import com.mmt.entity.User;

public interface UserService 
{
	User insertUser(User user);
	
	User updateUser(User user);
	
	Page<User> getUsers(int pageNumber, int pageSize);
	
	Page<User> getUsersByQueries(String name, int pageNumber, int pageSize);
	
	void updateUserStatus(Long id, Integer status);
	
	User getUserByName(String name);
	
	User getUserByEmail(String email);
	
	User verifyUser(String email, String pass);
	
	int getUserAmoumtByEmail(String email);
	
	int getUserAmoumtByName(String name);
	
	boolean checkUserNameExisted(String name);
	
	boolean checkUserEmailExisted(String email);
	
}
