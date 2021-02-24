package com.hiddenleaf.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "privilege_master")
public class Privilege implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String privilegeId;

	private String privilegeName;

	private String privilegeDesc;

	public String getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(String privilegeId) {
		this.privilegeId = privilegeId;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	public String getPrivilegeDesc() {
		return privilegeDesc;
	}

	public void setPrivilegeDesc(String privilegeDesc) {
		this.privilegeDesc = privilegeDesc;
	}

}
