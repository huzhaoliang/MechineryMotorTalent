package com.mmt.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.mmt.entity.City;
import com.mmt.entity.Job;
import com.mmt.entity.JobType;
import com.mmt.repository.CityRepository;
import com.mmt.repository.JobRepository;
import com.mmt.repository.JobTypeRepository;
import com.mmt.service.JobService;

@Service("JobService")
public class JobServiceImpl implements JobService{

	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private JobTypeRepository jobTypeRepository;
	
	@Override
	public Job insertJob(Job job) {
		return jobRepository.saveAndFlush(job);
	}

	@Override
	public Page<Job> getJobs(int pageNumber, int pageSize) {
		PageRequest request = PageRequest.of(pageNumber - 1, pageSize, null);
		Page<Job> jobs = jobRepository.findAll(request);
		return jobs;
	}

	@Override
	public List<Job> getAllJobs() {
		return jobRepository.findAll();
	}

	@Override
	public List<Job> getJobsByCompany(Long companyId) {
		return jobRepository.findJobsByCompanyId(companyId);
	}

	@Override
	public void deleteJobs(List<Job> jobs) {
		jobRepository.deleteInBatch(jobs);
	}

	@Override
	public void deleteJobById(Long id) {
		jobRepository.deleteJobById(id);
	}

	@Override
	public List<Job> getHotJobs() 
	{
		return jobRepository.findHotJobs();
	}

	@Override
	public List<Job> findJobsByAreaJobFunctionIds(List<Long> cityIds, List<Long> jobTypeIds) {
		return jobRepository.findJobsByAreaJobFunctionIds(cityIds, jobTypeIds);
	}

	@Override
	public List<Job> findJobsByAreaIds(List<Long> cityIds) {
		return jobRepository.findJobsByAreaIds(cityIds);
	}

	@Override
	public List<Job> findJobsByJobFunctionIds(List<Long> jobTypeIds) {
		return jobRepository.findJobsByJobFunctionIds(jobTypeIds);
	}

	@Override
	public Page<Job> searchJobs(String s_area, String s_jobfunction, String s_job, int pageNumber, int pageSize) {
		Sort sort = new Sort(Sort.Direction.DESC, "publishTime");
		PageRequest request = PageRequest.of(pageNumber - 1, pageSize, sort);
		Page<Job> jobs = null;
		List<Long> city_ids = new ArrayList<Long>();
		List<Long> jobtype_ids = new ArrayList<Long>();
		List<Long> no_result_ids = new ArrayList<Long>();
		no_result_ids.add(-100L);
		
		List<City> city_list_filter = null;
		List<JobType> jobtype_list_filter = null;
		
		if (s_job != null && !s_job.isEmpty()) {
			List<City> city_list = cityRepository.findCityByName(s_job);
			List<JobType> jobtype_list = jobTypeRepository.findJobTypeByName(s_job);
			
			if (city_list != null && !city_list.isEmpty()) {
				for (City c : city_list) {
					city_ids.add(c.getId());
				}
			}
			
			if (jobtype_list != null && !jobtype_list.isEmpty()) {
				for (JobType j : jobtype_list) {
					jobtype_ids.add(j.getId());
				}
			}
		}
		
		if (s_area != null && !s_area.isEmpty()) {
			String[] s_areas = s_area.split("-");
			city_list_filter = cityRepository.findCityByNames(Arrays.asList(s_areas));
			if (city_list_filter != null) {
				for (City c : city_list_filter) {
					if (!city_ids.contains(c.getId())) {
						city_ids.add(c.getId());
					}
				}
			}
		}
		
		if (s_jobfunction != null && !s_jobfunction.isEmpty()) {
			String[] s_jobfunctions = s_jobfunction.split("-");
			jobtype_list_filter = jobTypeRepository.findJobTypeByNames(Arrays.asList(s_jobfunctions));
			if (jobtype_list_filter != null) {
				for (JobType j : jobtype_list_filter) {
					if (j.getFlag() == 3) {
						jobtype_ids.add(j.getId());
					} else if (j.getFlag() == 2) {
						for (JobType l3_j : jobTypeRepository.findJobTypeByParentId(j.getParentId())) {
							jobtype_ids.add(l3_j.getId());
						}
					}
				}
			}
		}
		
		Specification<Job> spec = new Specification<Job>() {
			public Predicate toPredicate(Root<Job> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate p = null;
				Predicate p1 = null;
				Predicate p2 = null;
				Predicate p3 = null;
				Predicate p4 = null;
				
				if (s_job != null && !s_job.isEmpty()) {
					Path<String> nameAttribute = root.get("name");
					p4 = cb.like(nameAttribute, "%"+s_job+"%");
				}
				
				if(!city_ids.isEmpty()){
					Expression<Long> exp = root.get("city");
					p1 = exp.in(city_ids);
				}
				
				if (!jobtype_ids.isEmpty()) {
					Expression<Long> exp = root.get("jobType");
					p2 = exp.in(jobtype_ids);
				}
				
				if (p1!=null && p2!=null && p4!=null) {
					p = cb.and(p1, p2, p4);
				} else if (p1!=null && p4 !=null) {
					p = cb.and(p1, p4);
				} else if (p2!=null && p4 !=null) {
					p = cb.and(p2, p4);
				} else if (p1!=null && p2 !=null) {
					p = cb.and(p1, p2);
				} else if (p4 != null) {
					p = cb.and(p4);
				} else if (p1 != null) {
					p = cb.and(p1);
				} else if (p2 != null) {
					p = cb.and(p2);
				} else if (p1 == null && p2 == null && p4 == null) {
					Expression<Long> exp = root.get("city");
					p3 = exp.in(no_result_ids);
					p = cb.and(p3);
				}
				
				return p;
			}
		};
		
		jobs = jobRepository.findAll(spec, request);
		
		return jobs;
	}

	@Override
	public Job getJobById(Long jobId) {
		return jobRepository.getOne(jobId);
	}

	@Override
	public List<Job> findJobsByEnterprise(Long enterpriseId) {
		return jobRepository.findJobsByEnterprise(enterpriseId);
	}
}
