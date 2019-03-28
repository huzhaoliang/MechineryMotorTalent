package com.mmt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mmt.entity.User;
import com.mmt.repository.UserRepository;
import com.mmt.service.UserService;

@Service(value="UserService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

	@Override
	public User insertUser(User user) {
		return userRepository.saveAndFlush(user);
	}

	@Override
	public Page<User> getUsers(int pageNumber, int pageSize) {
		PageRequest request = PageRequest.of(pageNumber - 1, pageSize);
		Page<User> users = userRepository.findAll(request);
		return users;
	}

}
