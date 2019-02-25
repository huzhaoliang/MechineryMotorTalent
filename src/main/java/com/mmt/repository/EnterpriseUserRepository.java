package com.mmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mmt.entity.EnterpriseUser;

public interface EnterpriseUserRepository extends JpaRepository<EnterpriseUser, Long>{

}
