package com.mmt.restcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.google.gson.Gson;
import com.mmt.entity.Job;
import com.mmt.jsonformat.HotJobs;
import com.mmt.service.JobService;


@CrossOrigin
@RestController
@RequestMapping(value="/api/")
public class JobRestController 
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	JobService jobService;
	
	
	@RequestMapping(value = "hotJobs", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Job> getHotJobs()
	{

		return jobService.getHotJobs();
		
	}
	
	
	@RequestMapping(value = "searchJobs", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Job> searchJobs() throws Exception
	{
		 jobService.getHotJobs();
		 return null;
//		List<Job> jobs = jobService.getHotJobs();
//		List<HotJobs> hotJobsList;
//		if(jobs.size()>0)
//		{
//			hotJobsList = new ArrayList<HotJobs>();
//			
//			System.out.print("###Hello World###");
//			
//		}
//		else
//		{
//			throw new Exception("no job fund");
//		}
//		
//		
//		for(int i = 0; i < jobs.size(); i++)
//		{
//			HotJobs hotJob = new HotJobs();
//			
//			hotJob.setJobId(jobs.get(i).getId());
//			hotJob.setJobName(jobs.get(i).getName());
//			hotJob.setCity(jobs.get(i).getCity().getName());
//			hotJob.setEducation(jobs.get(i).getEdu());
//			hotJob.setExperence(jobs.get(i).getExp());
//			hotJob.setStartSalary(jobs.get(i).getStartSalary());
//			hotJob.setEndSalary(jobs.get(i).getEndSalary());
//			hotJob.setDescription(jobs.get(i).getDescription().toString());
//			hotJobsList.add(hotJob);
//		}
//		
//		return hotJobsList;
	}
	
	public Job showJob()
	{
		return null;
	}
	
	
	public String followJob()
	{
		return null;
	}
	
	public String unFollowJob()
	{
		return null;
	}
	
	
	
	
	
	
}
