package com.hiddenleaf.service.dto;

public class PortPairMasterDTO {

	private String id;

	private String tradeLane;

	private String originPort;

	private String originPortCode;

	private String destinationPort;

	private String destinationPortCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTradeLane() {
		return tradeLane;
	}

	public void setTradeLane(String tradeLane) {
		this.tradeLane = tradeLane;
	}

	public String getOriginPort() {
		return originPort;
	}

	public void setOriginPort(String originPort) {
		this.originPort = originPort;
	}

	public String getOriginPortCode() {
		return originPortCode;
	}

	public void setOriginPortCode(String originPortCode) {
		this.originPortCode = originPortCode;
	}

	public String getDestinationPort() {
		return destinationPort;
	}

	public void setDestinationPort(String destinationPort) {
		this.destinationPort = destinationPort;
	}

	public String getDestinationPortCode() {
		return destinationPortCode;
	}

	public void setDestinationPortCode(String destinationPortCode) {
		this.destinationPortCode = destinationPortCode;
	}

}
