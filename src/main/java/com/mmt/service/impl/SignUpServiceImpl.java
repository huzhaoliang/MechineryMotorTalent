package com.mmt.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmt.repository.UserRepository;
import com.mmt.service.SignUpService;



@Service(value="SignUpService")
public class SignUpServiceImpl implements SignUpService
{
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	UserRepository userRepository;
	
	

	@Override
	public boolean doUserSignUp(String _username, String _password) 
	{
		logger.info("+++ check if the user is existed +++");
		if(userRepository.getUserByName(_username)==null)
		{
			logger.info("+++ current useremail is able to be regisitered +++");
			
			
			long userId = 0;
			
			logger.info("+++ to regisiter user +++");
			userRepository.regisiterUserByEmail();
		}
		else
		{
			logger.info("+++ current useremail has been regisitered +++");
			return false;
		}
		
		
		return false;
	}

}
