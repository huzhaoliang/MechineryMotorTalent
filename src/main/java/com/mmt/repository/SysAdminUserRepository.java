package com.mmt.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mmt.entity.SysAdminUser;

public interface SysAdminUserRepository extends JpaRepository<SysAdminUser, Long>{

}
