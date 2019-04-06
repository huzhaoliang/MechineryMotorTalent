package com.mmt.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.mmt.entity.City;
import com.mmt.repository.CityRepository;
import com.mmt.service.CityService;

@Service("CityService")
public class CityServiceImpl implements CityService{
	
	@Autowired
	private CityRepository cityRepository;

	@Override
	public City saveCity(City city) {
		return cityRepository.saveAndFlush(city);
	}

	@Override
	public Page<City> getCitys(int pageNumber, int pageSize) {
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		PageRequest request = PageRequest.of(pageNumber - 1, pageSize, sort);
		Page<City> citys = cityRepository.findAll(request);
		return citys;
	}

	@Override
	public List<City> getProvinces() {
		return cityRepository.findProvinces();
	}

	@Override
	public void deleteCities(List<City> cities) {
		cityRepository.deleteInBatch(cities);
	}

	@Override
	public City getOneCity(Long id) {
		return cityRepository.getOne(id);
	}

	@Override
	public Page<City> getCitysByQueries(City param, int pageNumber, int pageSize) {
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		PageRequest request = PageRequest.of(pageNumber - 1, pageSize, sort);
		Specification<City> spec = new Specification<City>() {
			public Predicate toPredicate(Root<City> root, CriteriaQuery<?> query,CriteriaBuilder cb) {
				Path<String> name = root.get("name");
				Path<Integer> age = root.get("parentId");
				Predicate p1 = cb.like(name, "%"+param.getName()+"%");
				Predicate p2 = cb.equal(age, param.getParentId());
				Predicate p = cb.and(p1, p2);
				return p;
			}  
		};
		Page<City> citys = cityRepository.findAll(spec, request);
		return citys;
	}

	@Override
	public void deleteCityById(Long id) {
		cityRepository.deleteCityById(id);
	}
}
