package com.hiddenleaf.service.dto;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;

import com.hiddenleaf.domain.AbstractAuditingEntity;

public class UserMasterDTO extends AbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userMasterId; 

	private String userId; //RVW UserID

	private String userName; //Employee Name

	//private String keyclockID;
	
	private String designation;

	private String roles; 

	private String contactNumber;
	
	private String emailID;
	
	private String country;
	
	private String branch;
	
	private String laneMapping;
	
	private Set<String> assignedPermissions;

	private String companyName;
	
	private String contactPerson;
	
	private boolean status; //User status


	public String getUserMasterId() {
		return userMasterId;
	}



	public void setUserMasterId(String userMasterId) {
		this.userMasterId = userMasterId;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getDesignation() {
		return designation;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public String getRoles() {
		return roles;
	}



	public void setRoles(String roles) {
		this.roles = roles;
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



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getBranch() {
		return branch;
	}



	public void setBranch(String branch) {
		this.branch = branch;
	}



	public String getLaneMapping() {
		return laneMapping;
	}



	public void setLaneMapping(String laneMapping) {
		this.laneMapping = laneMapping;
	}


	public Set<String> getAssignedPermissions() {
		return assignedPermissions;
	}



	public void setAssignedPermissions(Set<String> assignedPermissions) {
		this.assignedPermissions = assignedPermissions;
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



	public boolean isStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "UserMasterDTO [userMasterId=" + userMasterId + ", userName=" + userName + ", roles=" + roles
				+ ", assignedPermissions=" + assignedPermissions + "]";
	}

}
