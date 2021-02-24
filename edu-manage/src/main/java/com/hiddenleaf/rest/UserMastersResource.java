package com.hiddenleaf.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.hiddenleaf.domain.UserDesignationConfig;
import com.hiddenleaf.domain.UserMaster;
import com.hiddenleaf.repository.RolesMasterRepository;
import com.hiddenleaf.repository.UserDesignationRepository;
import com.hiddenleaf.repository.UserMasterRepository;
import com.hiddenleaf.service.dto.UserMasterDTO;
import com.hiddenleaf.util.JwtTokenUtil;
import com.hiddenleaf.util.MasterUtil;

@RestController
@RequestMapping("/api")
public class UserMastersResource {

	private static final Logger log = LoggerFactory.getLogger(UserMastersResource.class);

	@Autowired
	private UserMasterRepository userMasterRepository;

	@Autowired
	private RolesMasterRepository cargoRoleRepository;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserDesignationRepository userDesignationConfig;

	/**
	 * Save a Report.
	 *
	 * @param UserMasterDTO the entity to save
	 * @return the persisted entity
	 */

	@PostMapping("/usermasters")
	public ResponseEntity<String> save(@RequestBody UserMaster userMaster) throws Exception {
		return updateOrSave(userMaster);
	}

	private ResponseEntity<String> updateOrSave(UserMaster userMaster) {
		try {

			if (userMaster == null) {
				return new ResponseEntity("CARGOMASTER user object can not be null", HttpStatus.INTERNAL_SERVER_ERROR);
			}

			if (userMaster.getUserId() == null && userMaster.getUserId().length() <= 0) {
				return new ResponseEntity("CARGOMASTER user name can not be null", HttpStatus.INTERNAL_SERVER_ERROR);
			}

			if (userMaster.getRoles() == null && userMaster.getRoles().length() <= 0) {
				return new ResponseEntity("CARGOMASTER roles can not be null", HttpStatus.INTERNAL_SERVER_ERROR);
			}

			MasterUtil mu = new MasterUtil();

			if (userMaster.getUserMasterId() == null) {
				// Check if the user already exist
				Map<String, String> uMap = mu.convertUserListToMap(userMasterRepository.findAll());

				if (uMap.containsKey(userMaster.getUserId())) {
					return new ResponseEntity("User already exists.", HttpStatus.NOT_ACCEPTABLE);
				}
			}

			Map<String, String> maps = mu.convertRolesListToMap(cargoRoleRepository.findAll());

			String roleString = userMaster.getRoles();
			String[] roleArray = roleString.split(",");
			String msg = "";
			List<String> roleList = new ArrayList<String>();
			for (String name : roleArray) {

				if (!maps.containsKey(name)) {
					msg = msg + name + ",";
				} else {
					roleList.add(name);
				}
			}

			if (msg.length() >= 1) {
				return new ResponseEntity("Roles does not exist " + msg, HttpStatus.NOT_ACCEPTABLE);
			}

			String rolesStringToSave = "";

			for (String name : roleList) {
				rolesStringToSave = rolesStringToSave + name + ",";
			}

			rolesStringToSave = rolesStringToSave.substring(0, rolesStringToSave.length() - 1);

			System.out.println(" premissionString " + rolesStringToSave);
			userMaster.setRoles(rolesStringToSave);

			// Check all the permissions exists or not
			userMasterRepository.save(userMaster);

		} catch (Exception e) {
			return new ResponseEntity("Error " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity("Success", HttpStatus.OK);

	}

	@PutMapping("/usermasters")
	public ResponseEntity<String> update(@RequestBody UserMaster userMaster) throws Exception {

		if (userMaster.getUserMasterId() == null) {
			return new ResponseEntity("CARGOMASTER user object can not be null", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return updateOrSave(userMaster);
	}

	@GetMapping("/usermasters")
	@Timed
	public List<UserMaster> getAllUserMasterDetails() {
		return userMasterRepository.findAll();

	}

	@GetMapping("/usermaster/{userId}")
	public UserMaster getUserMasterByUserId(String userId) {
		return userMasterRepository.findByUserId(userId).get();
	}

	@GetMapping("/usermasters/currentuserprofile")
	@Timed
	public ResponseEntity<UserMasterDTO> findUserProfile() {

		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			Object token = auth.getCredentials();
			String authToken = token.toString();
			String userName = jwtTokenUtil.getUsername(authToken);
			Optional<UserMaster> pum = userMasterRepository.findByUserId(userName);
			if (pum == null) {
				UserMasterDTO um = new UserMasterDTO();
				um.setUserName(userName);
				new ResponseEntity<UserMasterDTO>(um, HttpStatus.OK);
			}

			// Convert roles to permissions list
			MasterUtil mu = new MasterUtil();
			// Check if the role name already exists

			Map<String, String> rolesMap = mu.convertRolesListToMap(cargoRoleRepository.findAll());

			UserMasterDTO userDto = mu.converUsagerMasterToDTO(pum.get(), rolesMap);

			return new ResponseEntity<UserMasterDTO>(userDto, HttpStatus.OK);

		} catch (Exception e) {
			UserMasterDTO um = new UserMasterDTO();
			um.setUserName("");
			return new ResponseEntity<UserMasterDTO>(um, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/usermasters/getDesignation")
	public ResponseEntity<List<UserDesignationConfig>> getAllDesignation() throws Exception {
		try {
			List<UserDesignationConfig> config = userDesignationConfig.findAll();
			return new ResponseEntity<List<UserDesignationConfig>>(config, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
