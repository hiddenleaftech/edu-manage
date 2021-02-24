package com.hiddenleaf.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.hiddenleaf.service.dto.AccountsMasterDTO;
import com.hiddenleaf.uploads.AccountResultBuilder;

public interface AccountsMasterService {

	/**
	 * Get all the AccountsMasterService.
	 *
	 * @return the list of entities
	 */

	List<AccountsMasterDTO> findAll();

	/**
	 * Get the "id" AccountsMaster.
	 *
	 * @param id the id of the entity
	 * @return the entity
	 */

	Optional<AccountsMasterDTO> findByAccountId(String accountId);

	/**
	 * Save a AccountsMaster.
	 *
	 * @param AccountsMasterDTO the entity to save
	 * @return the persisted entity
	 */

	AccountsMasterDTO save(AccountsMasterDTO acountsMasterDTO);

	/**
	 * Delete the "id" AccountsMaster.
	 *
	 * @param id the id of the entity
	 */
	void delete(String id);

	AccountResultBuilder processCSV(MultipartFile multipartFile) throws IOException;

}
