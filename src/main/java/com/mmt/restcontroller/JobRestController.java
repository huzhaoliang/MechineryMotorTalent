package com.mmt.restcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.google.gson.Gson;
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
	@RequestMapping(value = "hotJobs", method = RequestMethod.GET)
	public JSONArray getHotJobs()
	{
		

		List<Job> jobs = new ArrayList<Job>();
		jobs = jobService.getHotJobs();
		
		
		if(jobs == null)
		{
			return null;
		}
		Map<String, Object> jobsMap = new HashMap<String, Object>();
		
		int index = 0;
		while(index < jobs.size())
		{
			jobsMap.put("id", jobs.get(index).getId());
			
			
			index++;
		}
		
		
		JSONArray jobJSONArray = null;
		
		
			jobJSONArray = JSONArray.parseArray(jobsMap.toString());
			System.out.println("####");
			System.out.println(jobJSONArray.toString());
		
		//Gson gson = new Gson(); 
		//String str = gson.toJson(jobs);
				
				
		
		return jobJSONArray;
		
		
	}
	
	
}
