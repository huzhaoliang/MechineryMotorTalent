package com.mmt.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.entity.EnterpriseUser;
import com.mmt.service.EnterpriseService;


@CrossOrigin
@RestController
@RequestMapping(value="/api/")
public class EnterpriseRestController 
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@Autowired
	EnterpriseService enterpriseService;
	
	/*
	@ResponseBody
	@RequestMapping(value = "/HotEnterprises", method = RequestMethod.POST)
	public List<EnterpriseUser> getHotEnterprises()
	{
		return null;
	}
	*/
	
	public void showCompany()
	{
		
	}
	
	
	
	
}
