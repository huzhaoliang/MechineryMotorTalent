package com.mmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.mmt.entity.JobFair;

public interface JobFairRepository extends JpaRepository<JobFair, Long>{
	
	@Modifying
	@Transactional
	@Query(value="delete from jobFair where id=:id", nativeQuery = true)
	void deleteJobFairById(@Param("id")Long id);

}
