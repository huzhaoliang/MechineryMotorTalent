package com.mmt.service;

import org.springframework.data.domain.Page;

import com.mmt.entity.EnterpriseUser;

public interface EnterpriseService {
	EnterpriseUser insertEnterprise(EnterpriseUser user);
	
	Page<EnterpriseUser> getEnterpriseUsers(int pageNumber, int pageSize);
}
