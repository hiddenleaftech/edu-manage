package com.hiddenleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiddenleaf.domain.Privilege;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, String> {

}
