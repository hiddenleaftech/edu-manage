package com.hiddenleaf.domain;

import java.security.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customername_master")
public class CustomerNameMaster {

	private static final long serialVersionUID = 1L;

	@Id
	
	private String custID;

	private String RVWCustID;

	private String laneID;

	private String companyName;

	private String contactPerson;

	private String contactNumber;

	private String emailID;

	private String createdBy;

	private Timestamp createdDateTime;

	public String getCustID() {
		return custID;
	}

	public void setCustID(String custID) {
		this.custID = custID;
	}

	public String getRVWCustID() {
		return RVWCustID;
	}

	public void setRVWCustID(String rVWCustID) {
		RVWCustID = rVWCustID;
	}

	public String getLaneID() {
		return laneID;
	}

	public void setLaneID(String laneID) {
		this.laneID = laneID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
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