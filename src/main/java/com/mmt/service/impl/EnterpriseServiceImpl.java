package com.mmt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mmt.entity.EnterpriseUser;
import com.mmt.repository.EnterpriseRepository;
import com.mmt.service.EnterpriseService;

@Service("EnterpriseService")
public class EnterpriseServiceImpl implements EnterpriseService{

	@Autowired
	private EnterpriseRepository enterpriseRepository;
	
	@Override
	public EnterpriseUser insertEnterprise(EnterpriseUser user) {
		return enterpriseRepository.saveAndFlush(user);
	}

	@Override
	public Page<EnterpriseUser> getEnterpriseUsers(int pageNumber, int pageSize) {
		PageRequest request = PageRequest.of(pageNumber - 1, pageSize, null);
		Page<EnterpriseUser> enterprises = enterpriseRepository.findAll(request);
		return enterprises;
	}

}
