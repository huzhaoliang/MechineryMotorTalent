package com.mmt.service;

import com.mmt.entity.SysAdminUser;

public interface SysAdminUserService {
	SysAdminUser checkUserByNameAndPwd(String name, String pwd);
	
	SysAdminUser checkUserByName(String name);
}
