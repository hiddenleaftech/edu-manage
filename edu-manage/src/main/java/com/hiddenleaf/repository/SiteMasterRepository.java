package com.hiddenleaf.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiddenleaf.domain.SiteMaster;



@Repository
public interface SiteMasterRepository extends JpaRepository<SiteMaster, String> {
	
	List<SiteMaster> findAll();
	
	List<SiteMaster> findByAccountID(String id);

	Optional<SiteMaster> findByid(String id);
	
	
}
