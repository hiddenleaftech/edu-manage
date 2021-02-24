package com.hiddenleaf.rest;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiddenleaf.domain.RolesMaster;
import com.hiddenleaf.repository.PrivilegeRepository;
import com.hiddenleaf.repository.RolesMasterRepository;
import com.hiddenleaf.util.MasterUtil;

@RestController
@RequestMapping("/api")
public class RolesMasterResource {

	private static final Logger log = LoggerFactory.getLogger(RolesMasterResource.class);

	@Autowired
	private RolesMasterRepository cargoRoleRepository;

	@Autowired

	private PrivilegeRepository privilegeRepository;

	@PostMapping("/rolesmaster")
	public ResponseEntity<String> save(@RequestBody RolesMaster cargorole) throws Exception {

		return updateOrSave(cargorole);
	}

	private ResponseEntity<String> updateOrSave(@RequestBody RolesMaster cargorole) {

		try {
			if (cargorole == null) {
				return new ResponseEntity("CARGOMASTER role object can not be null", HttpStatus.INTERNAL_SERVER_ERROR);
			}

			if (cargorole.getRoleName() == null && cargorole.getRoleName().length() <= 0) {
				return new ResponseEntity("CARGOMASTER role name can not be null", HttpStatus.INTERNAL_SERVER_ERROR);
			}

			if (cargorole.getAssignedPermissions() == null && cargorole.getAssignedPermissions().length() <= 0) {
				return new ResponseEntity("CARGOMASTER permissions can not be null", HttpStatus.INTERNAL_SERVER_ERROR);
			}

			MasterUtil mu = new MasterUtil();
			// Check if the role name already exists

			if (cargorole.getRoleId() == null) {

				Map<String, String> rolesMap = mu.convertRolesListToMap(cargoRoleRepository.findAll());

				if (rolesMap.containsKey(cargorole.getRoleName())) {
					return new ResponseEntity("CARGOMASTER role name already exists, please use some other name.",
							HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}

			// Check if permission names exist in theDB
			Map<String, String> maps = mu.convertPrivilegeListToMap(privilegeRepository.findAll());

			String permString = cargorole.getAssignedPermissions();

			String[] permArray = permString.split(",");
			String msg = "";
			Set<String> permList = new TreeSet<String>();
			for (String name : permArray) {

				if (!maps.containsKey(name)) {
					msg = msg + name + ",";
				} else {
					permList.add(name);
				}
			}

			if (msg.length() >= 1) {
				return new ResponseEntity("CARGOMASTER does not exist " + msg, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			String premissionString = "";

			for (String name : permList) {
				premissionString = premissionString + name + ",";
			}

			premissionString = premissionString.substring(0, premissionString.length() - 1);

			System.out.println(" premissionString " + premissionString);
			cargorole.setAssignedPermissions(premissionString);

			// Check all the permissions exists or not
			cargoRoleRepository.save(cargorole);

		} catch (Exception e) {
			return new ResponseEntity("Error  : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity("Success", HttpStatus.OK);

	}

	@PutMapping("/rolesmaster")
	public ResponseEntity<String> update(@RequestBody RolesMaster cargorole) throws Exception {

		if (cargorole.getRoleId() == null) {
			return new ResponseEntity("CARGOMASTER id can not be null.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return updateOrSave(cargorole);

	}

	@GetMapping("/rolesmaster")
	public List<RolesMaster> getAllUserMasterDetails() {
		return cargoRoleRepository.findAll();

	}

	@GetMapping("/rolesmaster/{roleName}")
	public RolesMaster getUserMasterByUserId(@PathVariable String roleName) {
		return cargoRoleRepository.findOneByRoleName(roleName);
	}

}
