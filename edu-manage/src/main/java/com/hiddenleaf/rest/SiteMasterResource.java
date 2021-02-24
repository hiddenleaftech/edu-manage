package com.hiddenleaf.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.hiddenleaf.service.SiteMasterService;
import com.hiddenleaf.service.dto.SiteMasterDTO;
import com.hiddenleaf.util.FileConstant;
import com.hiddenleaf.util.WebResponseUtil;

@RestController
//@RequestMapping("/iosapi/api/v1/ios")
@RequestMapping("/api")
public class SiteMasterResource implements FileConstant{

	@Autowired
	private SiteMasterService siteMasterService;

	private static final Logger log = LoggerFactory.getLogger(SiteMasterResource.class);

	@GetMapping("/updateSiteMaster")
	@Timed
	public boolean updateSiteMaster() {
		log.debug("REST request to updateSiteMaster");
		return siteMasterService.updateSiteMaster();
	}

	@GetMapping("/siteMaster")
	@Timed
	public List<SiteMasterDTO> findAll() {
		return siteMasterService.findAll();

	}

	@GetMapping("/siteMasters/{id}")
	@Timed
	public ResponseEntity<SiteMasterDTO> getSiteMaster(@PathVariable String id) {
		log.debug("REST request to get SiteMaster : {}", id);
		Optional<SiteMasterDTO> siteMasterDTO = siteMasterService.findByid(id);
		return WebResponseUtil.wrapOrNotFound(siteMasterDTO);
	}
	
	@GetMapping("/siteMasters/account/{id}")
	@Timed
	public List<SiteMasterDTO> getSiteMasterByID(@PathVariable String id) {
		log.debug("REST request to get SiteMaster : {}", id);
		return siteMasterService.findByAccount(id);
	}

	@PostMapping("/siteMaster")
	@Timed
	public SiteMasterDTO save(@RequestBody SiteMasterDTO siteMasterDTO) {

		return siteMasterService.save(siteMasterDTO);
	}

}
