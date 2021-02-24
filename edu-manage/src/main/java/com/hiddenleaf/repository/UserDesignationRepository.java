package com.hiddenleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiddenleaf.domain.UserDesignationConfig;

@Repository
public interface UserDesignationRepository extends JpaRepository<UserDesignationConfig, Long> {

}
