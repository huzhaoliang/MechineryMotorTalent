package com.mmt.service.impl;

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

import com.mmt.entity.User;
import com.mmt.repository.UserRepository;
import com.mmt.service.UserService;

@Service(value="UserService")
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;

	@Override
	public User insertUser(User user) {
		return userRepository.saveAndFlush(user);
	}
	
	@Override
	public User updateUser(User user) 
	{
		return userRepository.saveAndFlush(user);
	}

	@Override
	public Page<User> getUsers(int pageNumber, int pageSize) {
		PageRequest request = PageRequest.of(pageNumber - 1, pageSize);
		Page<User> users = userRepository.findAll(request);
		return users;
	}

	@Override
	public Page<User> getUsersByQueries(String name, int pageNumber, int pageSize) {
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		PageRequest request = PageRequest.of(pageNumber - 1, pageSize, sort);
		Specification<User> spec = new Specification<User>() {
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query,CriteriaBuilder cb) {
				Path<String> nameAttribute = root.get("name");
				Predicate p1 = cb.like(nameAttribute, "%"+name+"%");
				Predicate p = cb.and(p1);
				return p;
			}  
		};
		Page<User> users = userRepository.findAll(spec, request);
		return users;
	}

	@Override
	public void updateUserStatus(Long id, Integer status) {
		userRepository.updateUserStatusById(id, status);
	}

	@Override
	public User getUserByName(String name) {
		return userRepository.getUserByName(name);
	}
	
	@Override
	public User getUserByEmail(String email) 
	{
		return userRepository.getUserByEmail(email);
	}
	
	@Override
	public int getUserAmoumtByEmail(String email) 
	{
		return userRepository.getUserAmountByEmail(email);
	}

	@Override
	public int getUserAmoumtByName(String name) 
	{
		return userRepository.getUserAmountByName(name);
	}

	@Override
	public User verifyUser(String email, String pass) 
	{
		return userRepository.verifyUser(email, pass);
	}

	@Override
	public boolean checkUserNameExisted(String name) 
	{
		User user = userRepository.checkUserNameExisted(name);
		if (user == null)
			return false;
		return true;
	}

	@Override
	public boolean checkUserEmailExisted(String email) 
	{
		User user = userRepository.checkUserEmailExisted(email);
		if (user == null)
			return false;
		return true;
	}

	@Override
	public User getUser(Long id) {
		return userRepository.getOne(id);
	}

	

}
