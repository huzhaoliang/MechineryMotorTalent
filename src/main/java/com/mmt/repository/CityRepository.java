package com.mmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.mmt.entity.City;

public interface CityRepository extends JpaSpecificationExecutor<City>, JpaRepository<City, Long> {
	@Query(value="select a.* from city a where a.flag=1", nativeQuery = true)
	List<City> findProvinces();
}
