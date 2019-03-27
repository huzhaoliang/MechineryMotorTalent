package com.mmt.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.mmt.entity.City;

public interface CityService {
	City insertCity(City city);
	
	Page<City> getCitys(int pageNumber, int pageSize);
	
	List<City> getProvinces();
}
