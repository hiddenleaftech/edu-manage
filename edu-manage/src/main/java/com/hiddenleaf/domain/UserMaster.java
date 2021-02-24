package com.hiddenleaf.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.hiddenleaf.hbm.generator.DefaultUsermasterIDGenerator;


@Entity
@Table(name = "usermaster")
public class UserMaster extends AbstractAuditingEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(name = "userMastersmaster_string_id_generator", strategy = "com.hiddenleaf.hbm.generator.DefaultUsermasterIDGenerator", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence_prefix", value = DefaultUsermasterIDGenerator.defaultSsequencePrefix),
			@org.hibernate.annotations.Parameter(name = "sequence_increment", value = DefaultUsermasterIDGenerator.defaultSsequenceIncrement) })

	@GeneratedValue(generator = "userMastersmaster_string_id_generator")
	
	private String userMasterId; 

	private boolean status; //User status
	
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
	
	@Column(name="CompanyName")
	private String companyName;
	
	@Column(name="ContactPerson")
	private String contactPerson;

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

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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

}
