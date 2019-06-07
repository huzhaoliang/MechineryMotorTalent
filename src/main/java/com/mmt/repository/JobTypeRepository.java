package com.mmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mmt.entity.JobType;

public interface JobTypeRepository extends JpaRepository<JobType, Long>{

	@Query(value="select a.* from job_type a where a.flag=1", nativeQuery = true)
    List<JobType> findAllLevelOneJobType();
    
    @Query(value="select a.* from job_type a where a.flag=2", nativeQuery = true)
    List<JobType> findAllLevelTwoJobType();
    
    @Query(value="select a.* from job_type a where a.flag=3", nativeQuery = true)
    List<JobType> findAllLevelThreeJobType();
    
    @Query(value="select a.* from job_type a where a.type in :names", nativeQuery = true)
    List<JobType> findJobTypeByNames(List<String> names);
    
    @Query(value="select a.* from job_type a where a.parentId=:parentId", nativeQuery = true)
    List<JobType> findJobTypeByParentId(Long parentId);
}
