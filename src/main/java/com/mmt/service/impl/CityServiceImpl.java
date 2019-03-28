package com.mmt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mmt.entity.City;
import com.mmt.repository.CityRepository;
import com.mmt.service.CityService;

@Service("CityService")
public class CityServiceImpl implements CityService{
	
	@Autowired
	private CityRepository cityRepository;

	@Override
	public City insertCity(City city) {
		return cityRepository.saveAndFlush(city);
	}

	@Override
	public Page<City> getCitys(int pageNumber, int pageSize) {
		PageRequest request = PageRequest.of(pageNumber - 1, pageSize);
		Page<City> citys = cityRepository.findAll(request);
		return citys;
	}

	@Override
	public List<City> getProvinces() {
		return cityRepository.findProvinces();
	}
	
	

}
