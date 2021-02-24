package com.hiddenleaf.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hiddenleaf.domain.ETLRunInfo;

@Repository
public interface ETLRunInfoRepository extends JpaRepository<ETLRunInfo, String> {
	List<ETLRunInfo> findFirstByOrderByIdDesc();
	
	List<ETLRunInfo> findByRowcountAfterAndReportProcess(int rowcount,String reportProcess);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE etlschedule set report_process =?1 where id =?2", nativeQuery = true)
		int updateReportProcessed(String reportProcess, String id);
	}
