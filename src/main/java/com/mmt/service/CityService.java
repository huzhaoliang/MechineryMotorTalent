package com.mmt.service;

import org.springframework.data.domain.Page;

import com.mmt.entity.City;

public interface CityService {
	City insertCity(City city);
	
	Page<City> getCitys(int pageNumber, int pageSize);
}
