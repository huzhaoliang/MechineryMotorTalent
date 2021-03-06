package com.mmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.mmt.entity.City;

public interface CityRepository extends JpaSpecificationExecutor<City>, JpaRepository<City, Long> {
	@Query(value="select a.* from city a where a.flag=1", nativeQuery = true)
	List<City> findProvinces();
	
	@Query(value="select a.* from city a where a.flag=1", nativeQuery = true)
	List<City> findAllLevelOneArea();
	
	@Query(value="select a.* from city a where a.flag=2", nativeQuery = true)
	List<City> findAllLevelTwoArea();
	
	@Query(value="select a.* from city a where a.flag=3", nativeQuery = true)
	List<City> findAllLevelThreeArea();
	
	@Query(value="select a.* from city a where a.name IN :names", nativeQuery = true)
	List<City> findCityByNames(List<String> names);
	
	@Modifying
	@Transactional
	@Query(value="delete from city where id=:id", nativeQuery = true)
	void deleteCityById(@Param("id")Long id);
	
	@Query(value="select a.* from city a where a.name like CONCAT('%',:name,'%')", nativeQuery = true)
	List<City> findCityByName(String name);
}
