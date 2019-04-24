package com.mmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mmt.entity.User;

@Repository("UserRepository")
public interface UserRepository extends JpaSpecificationExecutor<User>, JpaRepository<User, Long>
{
	
	@Query(value="select a.* from user a where a.name=:name", nativeQuery = true)
	User getUserByName(@Param("name")String name);
	
	@Query(value="select count(*) from user a where a.name=:name", nativeQuery = true)
	int getUserAmountByName(@Param("name")String name);
	
	@Query(value="select a.* from user a where a.email=:email", nativeQuery = true)
	User getUserByEmail(@Param("email")String email);
	
	@Query(value="select count(*) from user a where a.email=:email", nativeQuery = true)
	int getUserAmountByEmail(@Param("email")String email);
	
	@Query(value="select a.* from user a where a.name=:name", nativeQuery = true)
	User getUserMaxId(@Param("name")String name);
	
	
	@Query(value="select a.* from user a where a.email=:email and a.password=:password", nativeQuery = true)
	User verifyUser(@Param("email")String email, @Param("password")String password);
	
	@Modifying
	@Transactional
	@Query(value="insert into user(id, email, password, status) values(?1, ?2, ?3, ?4)", nativeQuery = true)
	void regisiterUserByEmail(@Param("id")Long _userId, @Param("emal")String _email, @Param("password") String _pass, @Param("status")Integer _status);
	
	@Modifying
	@Transactional
	@Query(value="update user set status=:status where id=:id", nativeQuery = true)
	void updateUserStatusById(@Param("id")Long id, @Param("status")Integer status);
	

}
