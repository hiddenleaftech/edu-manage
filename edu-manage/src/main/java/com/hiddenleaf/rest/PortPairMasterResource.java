package com.hiddenleaf.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.hiddenleaf.rest.errors.BadRequestAlertException;
import com.hiddenleaf.service.PortPairService;
import com.hiddenleaf.service.dto.PortPairMasterDTO;
import com.hiddenleaf.util.HeaderUtil;
import com.hiddenleaf.util.WebResponseUtil;

/**
 * REST controller for managing PortPairMaster.
 */
@RestController
@RequestMapping("/api")
public class PortPairMasterResource {

	private final Logger log = LoggerFactory.getLogger(PortPairMasterResource.class);

	private static final String ENTITY_NAME = "portpairmaster";

	@Autowired
	PortPairService portPairService;
	
	/**
     * POST  /portpair-masters : Create a new portPairMaster.
     *
     * @param portPairMasterDTO the portPairMasterDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new portPairMasterDTO, or with status 400 (Bad Request) if the portPairMaster has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/portpair-masters")
    @Timed
    public ResponseEntity<PortPairMasterDTO> createPortPairMaster(@RequestBody PortPairMasterDTO portPairMasterDTO) throws URISyntaxException {
        log.debug("REST request to save PortPairMaster : {}", portPairMasterDTO);
        if (portPairMasterDTO.getId() != null) {
            throw new BadRequestAlertException("A new portPairMaster cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PortPairMasterDTO result = portPairService.save(portPairMasterDTO);
        return ResponseEntity.created(new URI("/api/portpair-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /portpair-masters : Updates an existing portPairMaster.
     *
     * @param portPairMasterDTO the portPairMasterDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated portPairMasterDTO,
     * or with status 400 (Bad Request) if the portPairMasterDTO is not valid,
     * or with status 500 (Internal Server Error) if the portPairMasterDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/portpair-masters")
    @Timed
    public ResponseEntity<PortPairMasterDTO> updatePortPairMaster(@RequestBody PortPairMasterDTO portPairMasterDTO) throws URISyntaxException {
        log.debug("REST request to update PortPairMaster : {}", portPairMasterDTO);
        if (portPairMasterDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PortPairMasterDTO result = portPairService.save(portPairMasterDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, portPairMasterDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /portpair-masters : get all the portPairMaster.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of portPairMaster in body
     */
    @GetMapping("/portpair-masters")
    @Timed
    public List<PortPairMasterDTO> getAllPortPairMasters() {
        log.debug("REST request to get all PortPairMasters");
        return portPairService.findAll();
    }

    /**
     * GET  /portpair-masters/:id : get the "id" portPairMaster.
     *
     * @param id the id of the portPairMasterDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the portPairMasterDTO, or with status 404 (Not Found)
     */
    @GetMapping("/portpair-masters/{id}")
    @Timed
    public ResponseEntity<PortPairMasterDTO> getPortPairMaster(@PathVariable String id) {
        log.debug("REST request to get PortPairMaster : {}", id);
        Optional<PortPairMasterDTO> portPairMasterDTO = portPairService.findOne(id);
        return WebResponseUtil .wrapOrNotFound(portPairMasterDTO);
    } 

    /**
     * DELETE  /portpair-masters/:id : delete the "id" portPairMaster.
     *
     * @param id the id of the portPairMasterDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/portpair-masters/{id}")
    @Timed
    public ResponseEntity<Void> deletePortPairMaster(@PathVariable String id) {
        log.debug("REST request to delete PortPairMaster : {}", id);
        portPairService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    
}
