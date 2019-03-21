package com.mmt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class indexController 
{
	@RequestMapping(value = "/index")
	public String index() 
	{
		System.out.println("++++++to index.html+++++");
		return "index";
	}
	
	@RequestMapping(value = "/")
	public String home() 
	{
		System.out.println("++++++to index.html+++++");
		return "index";
	}
	

	
}
