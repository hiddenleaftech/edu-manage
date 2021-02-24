package com.hiddenleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiddenleaf.domain.IcargoConfiguration;

@Repository
public interface IcargoConfigRepository extends JpaRepository<IcargoConfiguration, Long>{

	IcargoConfiguration findByComponetId(long filter);
}
