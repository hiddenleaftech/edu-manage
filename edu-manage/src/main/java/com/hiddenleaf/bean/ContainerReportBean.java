package com.hiddenleaf.bean;

import java.time.LocalDate;

public class ContainerReportBean {

	private Double weight;
	private Double volumn;
	private String shipmentIds;
	private String source;
	private String consolID;
	private String destination;
	private LocalDate containerCloseDate;

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getVolumn() {
		return volumn;
	}

	public void setVolumn(Double volumn) {
		this.volumn = volumn;
	}

	public String getShipmentIds() {
		return shipmentIds;
	}

	public void setShipmentIds(String shipmentIds) {
		this.shipmentIds = shipmentIds;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getContainerCloseDate() {
		return containerCloseDate;
	}

	public void setContainerCloseDate(LocalDate containerCloseDate) {
		this.containerCloseDate = containerCloseDate;
	}

	public String getConsolID() {
		return consolID;
	}

	public void setConsolID(String consolID) {
		this.consolID = consolID;
	}
	
}