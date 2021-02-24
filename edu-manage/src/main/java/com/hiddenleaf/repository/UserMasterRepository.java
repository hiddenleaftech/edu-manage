package com.hiddenleaf.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hiddenleaf.domain.UserMaster;

@Repository
public interface UserMasterRepository extends JpaRepository<UserMaster, String> {

	Optional<UserMaster> findByUserId(String userId);

	List<UserMaster> findByUserName(String userName);
	
	@Query(value = "select * from usermaster where concat(',',laneMapping,',') like %?1% and status=1", nativeQuery = true)
	List<UserMaster> findByLaneMapping(String filter1);
	
	@Query(value = "select * from usermaster where concat(',',laneMapping,',') like %?1% and concat(',',roles,',') like %?2% and status=1", nativeQuery = true)
	List<UserMaster> findByLaneMappingAndRoles(String filter1,String filder2);
}
