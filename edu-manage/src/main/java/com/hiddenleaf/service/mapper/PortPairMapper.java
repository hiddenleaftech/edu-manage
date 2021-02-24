package com.hiddenleaf.service.mapper;

import org.mapstruct.Mapper;

import com.hiddenleaf.domain.PortPairMaster;
import com.hiddenleaf.service.dto.PortPairMasterDTO;

/**
 * Mapper for the entity PortPairMaster and its DTO PortPairMasterDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PortPairMapper extends EntityMapper<PortPairMasterDTO, PortPairMaster> {

	default PortPairMaster fromId(String id) {
		if (id == null) {
			return null;
		}
		
		PortPairMaster portpair = new PortPairMaster();
		portpair.setId(id);
		return portpair;
	}
}
