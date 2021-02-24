package com.hiddenleaf.service.dto.custom;

public class SiteSiteTypeIsDeleted {

	private String id;

	private String siteTypeId;

	private Boolean isRecordDeleted;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSiteTypeId() {
		return siteTypeId;
	}

	public void setSiteTypeId(String siteTypeId) {
		this.siteTypeId = siteTypeId;
	}

	public Boolean getIsRecordDeleted() {
		return isRecordDeleted;
	}

	public void setIsRecordDeleted(Boolean isRecordDeleted) {
		this.isRecordDeleted = isRecordDeleted;
	}

	@Override
	public String toString() {
		return "SiteSiteTypeIsDeleted [id=" + id + ", siteTypeId=" + siteTypeId + ", isRecordDeleted=" + isRecordDeleted
				+ "]";
	}

}
