package com.hiddenleaf.service;

import java.util.List;

import java.util.Optional;

import com.hiddenleaf.service.dto.SiteMasterDTO;

public interface SiteMasterService {
	
	/**
	 * Get all the SiteMasterDTO.
	 *
	 * @return the list of entities
	 */
	List<SiteMasterDTO> findAll();
	
	/**
	 * Get the "id" SiteMasterDTO.
	 *
	 * @param id the id of the entity
	 * @return the entity
	 */
	
	Optional<SiteMasterDTO> findByid(String id);
	
	public List<SiteMasterDTO> findByAccount(String id);
	
	
	/**
	 * Save a SiteMaster.
	 *
	 * @param SiteMasterDTO the entity to save
	 * @return the persisted entity
	 */
	
	SiteMasterDTO save(SiteMasterDTO siteMasterDTO);
	
	boolean updateSiteMaster();
	
	
}
