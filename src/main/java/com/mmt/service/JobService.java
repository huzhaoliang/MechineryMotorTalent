package com.mmt.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.mmt.entity.Job;

public interface JobService {
	Job insertJob(Job job);
	
	Page<Job> getJobs(int pageNumber, int pageSize);
	
	List<Job> getAllJobs();
	
	List<Job> getJobsByCompany(Long companyId);
	
	List<Job> getJobRecommend();
	
	void deleteJobs(List<Job> jobs);
	
	void deleteJobById(Long id);
	
	List<Job> findJobsByAreaJobFunctionName(String name);
	
	List<Job> findJobsByAreaJobFunctionIds(List<Long> cityIds, List<Long> jobTypeIds);
	
	List<Job> findJobsByAreaIds(List<Long> cityIds);
	
	List<Job> findJobsByJobFunctionIds(List<Long> jobTypeIds);
}
