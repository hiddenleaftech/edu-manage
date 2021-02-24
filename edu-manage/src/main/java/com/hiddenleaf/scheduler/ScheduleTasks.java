package com.hiddenleaf.scheduler;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hiddenleaf.domain.Schedule;
import com.hiddenleaf.enums.ReportStatusTypes;
import com.hiddenleaf.enums.ScheduleTypes;
import com.hiddenleaf.repository.ETLRunInfoRepository;
import com.hiddenleaf.repository.ScheduleRepository;
import com.hiddenleaf.util.EmailWorkFlow;

@Component
public class ScheduleTasks {

	private final Logger log = LoggerFactory.getLogger("ScheduleTasks");

	@Autowired
	ScheduleRepository scheduleRepository;
	
	@Autowired
	ETLRunInfoRepository etlRunInfoRepository;

	@Autowired
	EmailWorkFlow emailWorkFlow;

	// SCHEDULE LOG VALIDATOR
	private boolean checkIfScheduleExists(LocalDate processDate, ScheduleTypes scheduleType) {

		// Right now always return true
		if (ScheduleTypes.CARGO_MASTER_REPORT.equals(scheduleType)) {
			List<Schedule> sch = scheduleRepository.findByProcessDateAndScheduleType(processDate, scheduleType);
			if (sch.size() > 0) {
				return true;
			} else {
				return false;
			}
		} else {

		}
		return false;
	}

	// REPORT GENERATION FOR CARGO WISH MASTER
	@Scheduled(cron = "0 30 7 * * ?") //UTC
	public void computeCargoMaster() {

	
		log.info("******* COMPUTE CARGO MASTER DETAIL SCHEDULER JOB START *******");
		Schedule newSchedule = null;

		try {
			Date d = new Date();

			int year = d.getYear() + 1900;
			int month = d.getMonth() + 1;
			int day = d.getDate();
			int hours = d.getHours();

			LocalDate processDate = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

			if (!checkIfScheduleExists(processDate, ScheduleTypes.CARGO_MASTER_REPORT)) {

				Schedule schedule = new Schedule();
				schedule.setYear(year);
				schedule.setMonth(month);
				schedule.setDay(day);
				schedule.setHours(hours);
				schedule.setStatus(ReportStatusTypes.CREATED);
				schedule.setScheduleType(ScheduleTypes.CARGO_MASTER_REPORT);
				schedule.setProcessDate(processDate);

				newSchedule = scheduleRepository.saveAndFlush(schedule);

				boolean reportFlag = false;
				/*List<ETLRunInfo> eltList = etlRunInfoRepository.findByRowcountAfterAndReportProcess(0, "P");
				log.info("eltList-->" + eltList.size());*/

			//	reportFlag = cargowishMasterImpl.computePercentage(true);

				log.info("Cargo ReportFlag-->" + reportFlag);

				if (reportFlag) {

					newSchedule.setStatus(ReportStatusTypes.SUCCESS);
					newSchedule = scheduleRepository.saveAndFlush(newSchedule);

				} else {
					newSchedule.setStatus(ReportStatusTypes.NOACTION);
					newSchedule = scheduleRepository.saveAndFlush(newSchedule);
				}

			} else {
				log.info("COMPUTE CARGO MASTER DETAIL SCHEDULER JOB ALREADY EXECUTED FOR THIS MONTH");
			}
			log.info("******* COMPUTE CARGO MASTER DETAIL SCHEDULER JOB END *******");
		} catch (Exception e) {
			/*newSchedule.setStatus(ReportStatusTypes.FAIL);
			scheduleRepository.saveAndFlush(newSchedule);*/
			e.printStackTrace();
		}
	}


}
