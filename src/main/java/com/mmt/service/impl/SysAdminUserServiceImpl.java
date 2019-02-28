package com.mmt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmt.entity.SysAdminUser;
import com.mmt.repository.SysAdminUserRepository;
import com.mmt.service.SysAdminUserService;

@Service(value="SysAdminUserService")
public class SysAdminUserServiceImpl implements SysAdminUserService{
	@Autowired
	private SysAdminUserRepository adminRepository;

	@Override
	public SysAdminUser checkUserByNameAndPwd(String name, String password) {
		return adminRepository.checkUserByNameAndPwd(name, password);
	}
}
