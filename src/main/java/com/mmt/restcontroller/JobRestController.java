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
	@RequestMapping(value = "hotJobs", method = RequestMethod.GET, produces="application/json")
	public String getHotJobs()
	{
		

		List<Job> jobs = jobService.getHotJobs();
		
//		for(int i = 0; i < jobs.size(); i++)
//		{
//			System.out.println(jobs.get(i));
//		}
		
		
//		Map<String, Object> jobsMap = new HashMap<String, Object>();
//		
//		int index = 0;
//		while(index < jobs.size())
//		{
//			jobsMap.put("id", jobs.get(index).getId());
//			
//			
//			index++;
//		}
//		
//		
		JSONArray jsonArray = new JSONArray();
		
		
		
		
		for(int i = 0; i < jobs.size(); i++)
		{
			List<String> jobList = new ArrayList<String>();
			jobList.add(String.valueOf(jobs.get(i).getId()));
			jobList.add(jobs.get(i).getName());
			jobList.add(jobs.get(i).getExp());
			jobList.add(jobs.get(i).getEdu());
			jobList.add(jobs.get(i).getStartSalary());
			jobList.add(jobs.get(i).getEndSalary());
			
			
			jsonArray.add(jobList);
		}
		
		
		return jsonArray.toJSONString();
		
		
//		
//		
//			jobJSONArray = JSONArray.parseArray(jobsMap.toString());
//			System.out.println("####");
//			System.out.println(jobJSONArray.toString());
		
		//Gson gson = new Gson(); 
		//String str = gson.toJson(jobs);
				
				
		
		
		
		
	}
	
	
}
