package com.mmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmt.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
