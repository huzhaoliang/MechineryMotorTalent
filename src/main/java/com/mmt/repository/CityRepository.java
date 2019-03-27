package com.mmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmt.entity.City;

public interface CityRepository extends JpaRepository<City, Long> {
	
}
