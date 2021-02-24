package com.hiddenleaf.service;

import java.util.List;
import java.util.Optional;

import com.hiddenleaf.service.dto.PortPairMasterDTO;

public interface PortPairService {

	 /**
     * Save a portPairMaster.
     *
     * @param portPairMasterDTO the entity to save
     * @return the persisted entity
     */
    PortPairMasterDTO save(PortPairMasterDTO cityMasterDTO);

    /**
     * Get all the portPairMaster.
     *
     * @return the list of entities
     */
    List<PortPairMasterDTO> findAll();

   
    /**
     * Get the "id" portPairMaster.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<PortPairMasterDTO> findOne(String id);

    /**
     * Delete the "id" portPairMaster.
     *
     * @param id the id of the entity
     */
    void delete(String id);

 
}
