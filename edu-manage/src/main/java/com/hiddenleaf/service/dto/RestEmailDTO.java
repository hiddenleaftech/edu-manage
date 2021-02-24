package com.hiddenleaf.service.dto;

import java.util.List;

public class RestEmailDTO {

	private List<String> ccList;

	private List<String> toList;

	private Boolean isFileAttached;

	private Boolean isHtml;

	private String subject;

	private String text;
	private List<String> bccList;

	public List<String> getCcList() {
		return ccList;
	}

	public void setCcList(List<String> ccList) {
		this.ccList = ccList;
	}

	public List<String> getToList() {
		return toList;
	}

	public void setToList(List<String> toList) {
		this.toList = toList;
	}

	public Boolean getIsFileAttached() {
		return isFileAttached;
	}

	public void setIsFileAttached(Boolean isFileAttached) {
		this.isFileAttached = isFileAttached;
	}

	public Boolean getIsHtml() {
		return isHtml;
	}

	public void setIsHtml(Boolean isHtml) {
		this.isHtml = isHtml;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<String> getBccList() {
		return bccList;
	}

	public void setBccList(List<String> bccList) {
		this.bccList = bccList;
	}

	@Override
	public String toString() {
		return "RestEmailDTO [ccList=" + ccList + ", toList=" + toList + ", isFileAttached=" + isFileAttached
				+ ", isHtml=" + isHtml + ", subject=" + subject + ", text=" + text + ", bccList=" + bccList + "]";
	}

}
