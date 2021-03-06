package com.mmt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.mmt.entity.JobFair;
import com.mmt.repository.JobFairRepository;
import com.mmt.service.JobFairService;

public class JobFairServiceImpl implements JobFairService{
	
	@Autowired
	private JobFairRepository jobFairRepository;

	@Override
	public JobFair insertJobFair(JobFair jobFair) {
		return jobFairRepository.saveAndFlush(jobFair);
	}

	@Override
	public Page<JobFair> getJobFairs(int pageNumber, int pageSize) {
		Sort sort = new Sort(Sort.Direction.DESC, "publishTime");
		PageRequest request = PageRequest.of(pageNumber - 1, pageSize, sort);
		Page<JobFair> jobFairs = jobFairRepository.findAll(request);
		return jobFairs;
	}

	@Override
	public void deleteJobFairs(List<JobFair> jobFairs) {
		jobFairRepository.deleteInBatch(jobFairs);
	}

	@Override
	public JobFair getOneJobFair(Long id) {
		return jobFairRepository.getOne(id);
	}

	@Override
	public void deleteJobFairById(Long id) {
		jobFairRepository.deleteJobFairById(id);
	}
}
