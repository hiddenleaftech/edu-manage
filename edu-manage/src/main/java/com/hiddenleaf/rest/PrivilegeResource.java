package com.hiddenleaf.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.hiddenleaf.domain.Privilege;
import com.hiddenleaf.repository.PrivilegeRepository;

@RestController
@RequestMapping("/api")
public class PrivilegeResource {

	private static final Logger log = LoggerFactory.getLogger(PrivilegeResource.class);

	@Autowired
	PrivilegeRepository privilegeRepository;

	@PostMapping("/privilege")
	@Timed
	public List<Privilege> getAllPriviledgeDetails() {
		return privilegeRepository.findAll();

	}

}
