package com.mmt.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.mmt.entity.City;

public interface CityService {
	City saveCity(City city);
	
	Page<City> getCitys(int pageNumber, int pageSize);
	
	List<City> getProvinces();
	
	List<City> findAllLevelOneArea();
	
	List<City> findAllLevelTwoArea();
	
	List<City> findAllLevelThreeArea();
	
	List<City> findCityByNames(List<String> names);
	
	void deleteCities(List<City> cities);
	
	City getOneCity(Long id);
	
	Page<City> getCitysByQueries(Long parentId, String name, int pageNumber, int pageSize);
	
	void deleteCityById(Long id);
}
