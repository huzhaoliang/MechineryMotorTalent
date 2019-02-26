package com.mmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mmt.entity.User;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<User, Long>{
}
