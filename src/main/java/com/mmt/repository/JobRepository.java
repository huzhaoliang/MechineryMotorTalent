package com.mmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmt.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long>{

}
