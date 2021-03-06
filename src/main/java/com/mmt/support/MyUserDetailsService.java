package com.mmt.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mmt.entity.SysAdminUser;
import com.mmt.entity.SysPermission;
import com.mmt.entity.SysRole;
import com.mmt.service.SysAdminUserService;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private SysAdminUserService adminService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("登录用户为："+ username);
		SysAdminUser sysUser = adminService.checkUserByName(username);
		if(null == sysUser) {
			throw new UsernameNotFoundException(username);
		}
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (SysRole role : sysUser.getRoleList()) {
			for (SysPermission permission : role.getPermissionList()) {
				authorities.add(new SimpleGrantedAuthority(permission.getCode()));
			}
		}
		System.out.println("登录用户为："+ sysUser.getName());
		return new User(sysUser.getName(), sysUser.getPassword(), authorities);
	}
}
