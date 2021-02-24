package com.hiddenleaf.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.hiddenleaf.domain.AccountsMaster;
import com.hiddenleaf.util.BaseJpaRepository;

@Repository
public interface AccountsMasterRepository extends BaseJpaRepository<AccountsMaster, String>,QuerydslPredicateExecutor<AccountsMaster>{

	Optional<AccountsMaster> findByAccountId(String accountId);
	
	List<AccountsMaster> findAll();
	
}
