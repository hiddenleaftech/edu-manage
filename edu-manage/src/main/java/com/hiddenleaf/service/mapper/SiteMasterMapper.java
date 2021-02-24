package com.hiddenleaf.service.mapper;

import org.mapstruct.Mapper;

import com.hiddenleaf.domain.SiteMaster;
import com.hiddenleaf.service.dto.SiteMasterDTO;

/**
 * Mapper for the entity SiteMaster and its DTO SiteMasterDTO.
 */

@Mapper(componentModel = "spring", uses = {})
public interface SiteMasterMapper extends EntityMapper<SiteMasterDTO, SiteMaster>{
	
//	SiteMasterDTO toDto(SiteMaster siteMaster);
//	
//	SiteMaster toEntity(SiteMasterDTO siteMasterDTO);

	default SiteMaster fromId(String id) {
		if (id == null) {
			return null;
		}
		SiteMaster siteMaster = new SiteMaster();
		siteMaster.setId(id);
		return siteMaster;
	}

}
