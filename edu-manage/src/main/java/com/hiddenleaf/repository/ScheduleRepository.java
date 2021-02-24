package com.hiddenleaf.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiddenleaf.domain.Schedule;
import com.hiddenleaf.enums.ScheduleTypes;

/**
 * Spring Data repository for the Schedule entity.
 */
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, String> {

	List<Schedule> findByProcessDateAndScheduleType(LocalDate processDate,ScheduleTypes scheduleType);

}
