package com.mmt.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.mmt.entity.JobFair;

public interface JobFairService {
	JobFair insertJobFair(JobFair jobFair);
	
	Page<JobFair> getJobFairs(int pageNumber, int pageSize);
	
	void deleteJobFairs(List<JobFair> jobFairs);
	
	JobFair getOneJobFair(Long id);
	
	void deleteJobFairById(Long id);
}
