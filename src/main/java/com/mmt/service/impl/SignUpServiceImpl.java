package com.mmt.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmt.repository.UserRepository;
import com.mmt.service.SignUpService;
import com.mmt.service.UserService;
import com.mmt.entity.User;


@Service(value="SignUpService")
public class SignUpServiceImpl implements SignUpService
{
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	UserRepository userRepository;
	
	

	@Override
	public boolean doUserSignUp(String _email, String _pass) 
	{
		
		logger.info("+++ check if the user is existed +++");
		
		User user = userRepository.getUserByEmail(_email);
		
		if(user==null)
		{
			logger.info("+++ current useremail is able to be regisitered +++");
			user.setEmail(_email);
			user.setPassword(_pass);
			
			logger.info("+++ to regisiter user +++");
			userRepository.
			User insertUser(User user);
			
		}
		else
		{
			logger.info("+++ current useremail has been regisitered +++");
			return false;
		}
		
		
		return true;
	}

}
