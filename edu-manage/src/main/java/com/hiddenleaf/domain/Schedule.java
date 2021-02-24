package com.hiddenleaf.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.elasticsearch.annotations.Document;

import com.hiddenleaf.enums.ReportStatusTypes;
import com.hiddenleaf.enums.ScheduleTypes;
import com.hiddenleaf.hbm.generator.DefaultScheduleIDGenerator;
import com.hiddenleaf.util.Identifiable;

@Entity
@Table(name = "schedule")
@Document(indexName = "schedule")
public class Schedule extends AbstractAuditingEntity implements Identifiable<String> {

	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "schedule_string_id_generator", strategy = "com.hiddenleaf.hbm.generator.DefaultScheduleIDGenerator", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence_prefix", value = DefaultScheduleIDGenerator.defaultsSequencePrefix),
			@org.hibernate.annotations.Parameter(name = "sequence_increment", value = DefaultScheduleIDGenerator.defaultSsequenceIncrement) })

	@GeneratedValue(generator = "schedule_string_id_generator")
	private String id;

	private int year;
	private int month;
	private int week;
	private int day;
	private int hours;
	private int minutes;
	private LocalDate processDate;

	private ScheduleTypes scheduleType;

	private ReportStatusTypes status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getProcessDate() {
		return processDate;
	}

	public void setProcessDate(LocalDate processDate) {
		this.processDate = processDate;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public ReportStatusTypes getStatus() {
		return status;
	}

	public void setStatus(ReportStatusTypes status) {
		this.status = status;
	}

	public ScheduleTypes getScheduleType() {
		return scheduleType;
	}

	public void setScheduleType(ScheduleTypes scheduleTypes) {
		this.scheduleType = scheduleTypes;
	}

}
