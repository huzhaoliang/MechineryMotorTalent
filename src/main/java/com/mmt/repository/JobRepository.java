package com.mmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mmt.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long>{
	@Query(value="select a.* from job a where a.com_id=:companyId", nativeQuery = true)
	List<Job> findJobsByCompanyId(@Param("companyId")Long companyId);
}
