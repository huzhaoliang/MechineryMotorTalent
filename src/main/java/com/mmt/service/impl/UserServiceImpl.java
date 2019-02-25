package com.mmt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmt.entity.User;
import com.mmt.repository.UserRepository;
import com.mmt.service.UserService;

@Service(value="UserService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		
		return 0;
	}

}
