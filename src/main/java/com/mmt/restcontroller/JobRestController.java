package com.mmt.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.entity.Job;
import com.mmt.service.JobService;

@RestController
@RequestMapping(value="/api/")
public class JobRestController 
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	JobService jobService;
	
	@ResponseBody
	@RequestMapping(value = "/hotJobs", method = RequestMethod.GET, produces = "application/json")
	public Page<Job> getHotJobs(@RequestParam("pageNumber") int _pageNumber)
	{
		//logger.info(jobService.getHotJobs().toString());
		logger.info("current page number is : " + _pageNumber);
		
		
		return jobService.getHotJobs(_pageNumber);
		
		
		
	}
	
	
}
