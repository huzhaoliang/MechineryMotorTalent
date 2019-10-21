package com.mmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.mmt.entity.Job;

public interface JobRepository extends JpaSpecificationExecutor<Job>, JpaRepository<Job, Long>
{
	
	@Query(value="select a.* from job a where a.com_id=:companyId", nativeQuery = true)
	List<Job> findJobsByCompanyId(@Param("companyId")Long companyId);
	
	
	//@Query(value = "select j.id, j.name, j.edu, j.salary, j.city, j.exp from job j", nativeQuery = true)
	@Query(value = "select j.* from job j order by publish_time", nativeQuery = true)
	List<Job> findHotJobs();
	
	@Modifying
	@Transactional
	@Query(value="delete from job where id=:id", nativeQuery = true)
	void deleteJobById(@Param("id")Long id);
	
	@Query(value = "select * from job where job.city_id in :cityIds and job.type_id in :jobTypeIds order by publish_time Desc", nativeQuery = true)
	List<Job> findJobsByAreaJobFunctionIds(List<Long> cityIds, List<Long> jobTypeIds);
	
	@Query(value = "select * from job where job.city_id in :cityIds order by publish_time Desc", nativeQuery = true)
	List<Job> findJobsByAreaIds(List<Long> cityIds);
	
	@Query(value = "select * from job where job.type_id in :jobTypeIds order by publish_time Desc", nativeQuery = true)
	List<Job> findJobsByJobFunctionIds(List<Long> jobTypeIds);
	
	@Query(value="select * from job where job.com_id=:enterpriseId", nativeQuery = true)
	List<Job> findJobsByEnterprise(Long enterpriseId);
	
}
