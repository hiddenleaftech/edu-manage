package com.hiddenleaf.domain;

import java.security.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "consol_planner")
public class ConsolPlanner {

	private static final long serialVersionUID = 1L;

	@Id
	
	private String schID;

	private String laneID;

	private String scheduleDate;

	private String estimatedDepatureDate;

	private String estimatedArivalDate;

	private String createdBy;

	private Timestamp createdDateTime;

	public String getSchID() {
		return schID;
	}

	public void setSchID(String schID) {
		this.schID = schID;
	}

	public String getLaneID() {
		return laneID;
	}

	public void setLaneID(String laneID) {
		this.laneID = laneID;
	}

	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getEstimatedDepatureDate() {
		return estimatedDepatureDate;
	}

	public void setEstimatedDepatureDate(String estimatedDepatureDate) {
		this.estimatedDepatureDate = estimatedDepatureDate;
	}

	public String getEstimatedArivalDate() {
		return estimatedArivalDate;
	}

	public void setEstimatedArivalDate(String estimatedArivalDate) {
		this.estimatedArivalDate = estimatedArivalDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Timestamp createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
}