package com.hiddenleaf.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.springframework.data.elasticsearch.annotations.Document;

@Audited
@Entity
@Table(name = "accounts_master")
@Document(indexName = "accountsmaster")
public class AccountsMaster {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private String accountId;

	private String accountName;

	private boolean truckAvail;

	private boolean cityGroup;

	private boolean clusterGroup;

	private boolean pucavail;

	private boolean kitruleSavail;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public boolean isTruckAvail() {
		return truckAvail;
	}

	public void setTruckAvail(boolean truckAvail) {
		this.truckAvail = truckAvail;
	}

	public boolean isCityGroup() {
		return cityGroup;
	}

	public void setCityGroup(boolean cityGroup) {
		this.cityGroup = cityGroup;
	}

	public boolean isClusterGroup() {
		return clusterGroup;
	}

	public void setClusterGroup(boolean clusterGroup) {
		this.clusterGroup = clusterGroup;
	}

	public boolean isPucavail() {
		return pucavail;
	}

	public void setPucavail(boolean pucavail) {
		this.pucavail = pucavail;
	}

	public boolean isKitruleSavail() {
		return kitruleSavail;
	}

	public void setKitruleSavail(boolean kitruleSavail) {
		this.kitruleSavail = kitruleSavail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
