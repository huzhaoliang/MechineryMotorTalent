package com.mmt.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.mmt.entity.Job;

public interface JobService {
	Job insertJob(Job job);
	
	Page<Job> getJobs(int pageNumber, int pageSize);
	
	List<Job> getAllJobs();
	
	List<Job> getJobsByCompany(Long companyId);
}
