package com.hiddenleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.hiddenleaf.domain.RouteContact;

@Repository
public interface RouteContactRepository extends JpaRepository<RouteContact, String>,QuerydslPredicateExecutor<RouteContact> {
	
	
}
