package com.hiddenleaf.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.hiddenleaf.hbm.generator.DefaultRolesMasterIDGenerator;



@Entity
@Table(name = "rolesmaster")
public class RolesMaster implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(name = "CARGORoles_string_id_generator", strategy = "com.hiddenleaf.hbm.generator.DefaultRolesMasterIDGenerator", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence_prefix", value = DefaultRolesMasterIDGenerator.defaultSsequencePrefix),
			@org.hibernate.annotations.Parameter(name = "sequence_increment", value = DefaultRolesMasterIDGenerator.defaultSsequenceIncrement) })

	@GeneratedValue(generator = "CARGORoles_string_id_generator")
	private String roleId;

	private String roleName;

	// Its a permissions separated by ,
	private String assignedPermissions;


	public String getAssignedPermissions() {
		return assignedPermissions;
	}

	public void setAssignedPermissions(String assignedPermissions) {
		this.assignedPermissions = assignedPermissions;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
