package com.mmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.mmt.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long>{
	@Query(value="select a.* from job a where a.com_id=:companyId", nativeQuery = true)
	List<Job> findJobsByCompanyId(@Param("companyId")Long companyId);
	
	
	@Query(value = "select * from job order by publishTime Desc", nativeQuery = true)
	List<Job> findJobsByUpdateTime();
	
	
	@Modifying
	@Transactional
	@Query(value="delete from job where id=:id", nativeQuery = true)
	void deleteJobById(@Param("id")Long id);
	
	@Query(value = "select * from job j where j.city_id in :cities and j.type_id in :job_functions order by publish_time Desc", nativeQuery = true)
	List<Job> findJobsByCityAndJobFunctions(List<Long> cities, List<Long> job_functions);
}
