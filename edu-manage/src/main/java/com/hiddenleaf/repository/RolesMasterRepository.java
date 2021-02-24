package com.hiddenleaf.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiddenleaf.domain.RolesMaster;

@Repository
public interface RolesMasterRepository extends JpaRepository<RolesMaster, String> {

	Optional<RolesMaster> findByRoleId(String roleId);

	List<RolesMaster> findByRoleNameIn(List<String> roleNameList);

	RolesMaster findOneByRoleName(String roleName);
}
