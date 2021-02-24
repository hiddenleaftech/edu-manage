package com.hiddenleaf.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hiddenleaf.domain.PortPairMaster;
import com.hiddenleaf.repository.PortPairRepository;
import com.hiddenleaf.service.PortPairService;
import com.hiddenleaf.service.dto.PortPairMasterDTO;
import com.hiddenleaf.service.mapper.PortPairMapper;

/**
 * Service Implementation for managing portPairMaster.
 */
@Service
@Transactional
public class PortPairServiceImpl implements PortPairService {

	private final Logger log = LoggerFactory.getLogger(PortPairServiceImpl.class);

	@Autowired
	PortPairRepository portPairRepository;

	@Autowired
	PortPairMapper portPairMapper;

	@Override
	public PortPairMasterDTO save(PortPairMasterDTO portPairMasterDTO) {

		log.debug("Request to save PortPairMaster : {}", portPairMasterDTO);

		PortPairMaster portPairMaster = portPairMapper.toEntity(portPairMasterDTO);
		portPairMaster = portPairRepository.save(portPairMaster);
		PortPairMasterDTO result = portPairMapper.toDto(portPairMaster);
		return result;
	}

	@Override
    @Transactional(readOnly = true)
	public List<PortPairMasterDTO> findAll() {

		log.debug("Request to get all PortPairMaster");
		return portPairRepository.findAll().stream().map(portPairMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<PortPairMasterDTO> findOne(String id) {
		log.debug("Request to get PortPairMaster : {}", id);
		return portPairRepository.findById(id).map(portPairMapper::toDto);
	}

	@Override
	public void delete(String id) {
		log.debug("Request to delete PortPairMaster : {}", id);
		portPairRepository.deleteById(id);

	}

}
