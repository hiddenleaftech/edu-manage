package com.hiddenleaf.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiddenleaf.domain.SiteMaster;
import com.hiddenleaf.repository.SiteMasterRepository;
import com.hiddenleaf.service.SiteMasterService;
import com.hiddenleaf.service.dto.SiteMasterDTO;
import com.hiddenleaf.service.mapper.SiteMasterMapper;

@Service
public class SiteMasterServiceImpl implements SiteMasterService {

	@Autowired
	private SiteMasterRepository siteMasterRepository;
	
	@Autowired
	private SiteMasterMapper siteMasterMapper;

	@Override
	public List<SiteMasterDTO> findAll() {
		return siteMasterRepository.findAll().stream().map(siteMasterMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));

	}

	@Override
	public Optional<SiteMasterDTO> findByid(String id) {
		return siteMasterRepository.findById(id).map(siteMasterMapper::toDto);
	}

	@Override
	public List<SiteMasterDTO> findByAccount(String id) {
		return siteMasterRepository.findByAccountID(id).stream().map(siteMasterMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}
	@Override
	public boolean updateSiteMaster() {
		return false;
	}

	
	@Override
	public SiteMasterDTO save(SiteMasterDTO siteMasterDTO) {

		SiteMaster siteMaster = siteMasterMapper.toEntity(siteMasterDTO);
		siteMaster = siteMasterRepository.save(siteMaster);
		SiteMasterDTO result = siteMasterMapper.toDto(siteMaster);
		return result;

	}

}
