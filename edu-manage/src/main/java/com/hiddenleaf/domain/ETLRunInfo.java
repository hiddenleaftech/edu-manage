package com.hiddenleaf.domain;

import java.sql.Date;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "etlschedule")
public class ETLRunInfo {

	@Id
	private String id;

	@Column(name = "date")
	private Date date;

	@Column(name = "file_date")
	private String filedate;

	@Column(name = "start_time")
	private LocalTime starttime;

	@Column(name = "end_time")
	private LocalTime endtime;

	@Column(name = "status")
	private String status;

	@Column(name = "row_count")
	private int rowcount;

	@Column(name = "error_msg")
	private String errormsg;
	
	@Column(name="report_process",columnDefinition = "varchar(1) default 'P'")
	private String reportProcess;

	public ETLRunInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ETLRunInfo(String id, Date date, String filedate, LocalTime starttime, LocalTime endtime, String status,
			int rowcount, String errormsg, String cwmJoinID, String reportProcess) {
		super();
		this.id = id;
		this.date = date;
		this.filedate = filedate;
		this.starttime = starttime;
		this.endtime = endtime;
		this.status = status;
		this.rowcount = rowcount;
		this.errormsg = errormsg;
		this.reportProcess = reportProcess;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFiledate() {
		return filedate;
	}

	public void setFiledate(String filedate) {
		this.filedate = filedate;
	}

	public LocalTime getStarttime() {
		return starttime;
	}

	public void setStarttime(LocalTime starttime) {
		this.starttime = starttime;
	}

	public LocalTime getEndtime() {
		return endtime;
	}

	public void setEndtime(LocalTime endtime) {
		this.endtime = endtime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getRowcount() {
		return rowcount;
	}

	public void setRowcount(int rowcount) {
		this.rowcount = rowcount;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String getReportProcess() {
		return reportProcess;
	}

	public void setReportProcess(String reportProcess) {
		this.reportProcess = reportProcess;
	}

	@Override
	public String toString() {
		return "ETLRunInfo [id=" + id + ", date=" + date + ", filedate=" + filedate + ", starttime=" + starttime
				+ ", endtime=" + endtime + ", status=" + status + ", rowcount=" + rowcount + ", errormsg=" + errormsg
				+ ", reportProcess=" + reportProcess + "]";
	}
}
