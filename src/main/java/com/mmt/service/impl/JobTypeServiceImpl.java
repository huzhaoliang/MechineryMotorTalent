package com.mmt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mmt.entity.JobType;
import com.mmt.repository.JobTypeRepository;
import com.mmt.service.JobTypeService;

@Service("JobTypeService")
public class JobTypeServiceImpl implements JobTypeService{
	
	@Autowired
	private JobTypeRepository jobTypeRepository;

	@Override
	public JobType saveJobType(JobType jobType) {
		return jobTypeRepository.saveAndFlush(jobType);
	}

	@Override
	public Page<JobType> getJobTypes(int pageNumber, int pageSize) {
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		PageRequest request = PageRequest.of(pageNumber - 1, pageSize, sort);
		Page<JobType> jobTypes = jobTypeRepository.findAll(request);
		return jobTypes;
	}

	@Override
	public void deleteJobType(List<JobType> jobTypes) {
		jobTypeRepository.deleteInBatch(jobTypes);
	}
	
	
	public List<JobType> findAllLevelOneJobType() {
		return jobTypeRepository.findAllLevelOneJobType();
	}

	public List<JobType> findAllLevelTwoJobType() {
		return jobTypeRepository.findAllLevelTwoJobType();
	}

	public List<JobType> findAllLevelThreeJobType() {
		return jobTypeRepository.findAllLevelThreeJobType();
	}

	@Override
	public List<JobType> findJobTypeByNames(List<String> names) {
		return jobTypeRepository.findJobTypeByNames(names);
	}

	public List<JobType> findJobTypeByParentId(Long parentId) {
		return jobTypeRepository.findJobTypeByParentId(parentId);
	}
}
