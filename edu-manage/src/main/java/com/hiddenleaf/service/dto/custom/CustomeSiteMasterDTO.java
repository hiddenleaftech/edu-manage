package com.hiddenleaf.service.dto.custom;

import java.util.List;

public class CustomeSiteMasterDTO {

	private String siteId;

	private String addressId;

	private Long companyID;

	private Long siteLAT;

	private Long siteLON;

	private String siteName;

	private Long telephone;

	private String email;

	private String accountMasterId;

	private List<SiteSiteTypeIsDeleted> siteTypeMasterId;

	private String tenancyMasterId;

	private String pickTypeMasterId;

	private String address1;

	private String address2;

	private String address3;

	private String cityMasterId;

	private String statesMasterId;

	private String countriesMasterId;

	private String zipCodeId;

	public Long getCompanyID() {
		return companyID;
	}

	public void setCompanyID(Long companyID) {
		this.companyID = companyID;
	}

	public Long getSiteLAT() {
		return siteLAT;
	}

	public void setSiteLAT(Long siteLAT) {
		this.siteLAT = siteLAT;
	}

	public Long getSiteLON() {
		return siteLON;
	}

	public void setSiteLON(Long siteLON) {
		this.siteLON = siteLON;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccountMasterId() {
		return accountMasterId;
	}

	public void setAccountMasterId(String accountMasterId) {
		this.accountMasterId = accountMasterId;
	}

	public String getTenancyMasterId() {
		return tenancyMasterId;
	}

	public void setTenancyMasterId(String tenancyMasterId) {
		this.tenancyMasterId = tenancyMasterId;
	}

	public String getPickTypeMasterId() {
		return pickTypeMasterId;
	}

	public void setPickTypeMasterId(String pickTypeMasterId) {
		this.pickTypeMasterId = pickTypeMasterId;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getCityMasterId() {
		return cityMasterId;
	}

	public void setCityMasterId(String cityMasterId) {
		this.cityMasterId = cityMasterId;
	}

	public String getStatesMasterId() {
		return statesMasterId;
	}

	public void setStatesMasterId(String statesMasterId) {
		this.statesMasterId = statesMasterId;
	}

	public String getCountriesMasterId() {
		return countriesMasterId;
	}

	public void setCountriesMasterId(String countriesMasterId) {
		this.countriesMasterId = countriesMasterId;
	}

	public String getZipCodeId() {
		return zipCodeId;
	}

	public void setZipCodeId(String zipCodeId) {
		this.zipCodeId = zipCodeId;
	}

	@Override
	public String toString() {
		return "CustomeSiteMasterDTO [siteId=" + siteId + ", addressId=" + addressId + ", companyID=" + companyID
				+ ", siteLAT=" + siteLAT + ", siteLON=" + siteLON + ", siteName=" + siteName + ", telephone="
				+ telephone + ", email=" + email + ", accountMasterId=" + accountMasterId + ", siteTypeMasterId="
				+ siteTypeMasterId + ", tenancyMasterId=" + tenancyMasterId + ", pickTypeMasterId=" + pickTypeMasterId
				+ ", address1=" + address1 + ", address2=" + address2 + ", address3=" + address3 + ", cityMasterId="
				+ cityMasterId + ", statesMasterId=" + statesMasterId + ", countriesMasterId=" + countriesMasterId
				+ ", zipCodeId=" + zipCodeId + "]";
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public List<SiteSiteTypeIsDeleted> getSiteTypeMasterId() {
		return siteTypeMasterId;
	}

	public void setSiteTypeMasterId(List<SiteSiteTypeIsDeleted> siteTypeMasterId) {
		this.siteTypeMasterId = siteTypeMasterId;
	}

}
