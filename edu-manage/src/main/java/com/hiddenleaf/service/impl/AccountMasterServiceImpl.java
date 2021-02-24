package com.hiddenleaf.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hiddenleaf.domain.AccountsMaster;
import com.hiddenleaf.repository.AccountsMasterRepository;
import com.hiddenleaf.service.AccountsMasterService;
import com.hiddenleaf.service.dto.AccountsMasterDTO;
import com.hiddenleaf.service.mapper.AccountsMasterMapper;
import com.hiddenleaf.uploads.AccountMasterCSVRowErrorHolder;
import com.hiddenleaf.uploads.AccountResultBuilder;
import com.hiddenleaf.util.MasterUtil;
import com.hiddenleaf.util.StringUtil;
import com.hiddenleaf.validate.AccountMasterCSVDataValiadte;

@Service
public class AccountMasterServiceImpl implements AccountsMasterService {

	private static final Logger log = LoggerFactory.getLogger(AccountMasterServiceImpl.class);

	@Autowired
	private AccountsMasterMapper accountsMasterMapper;

	@Autowired
	private AccountsMasterRepository accountsMasterRepository;

	@Autowired
	private AccountMasterCSVDataValiadte accountMasterCSVDataValiadte;

	private AccountsMaster accountsMaster;

	/**
	 * Get all the accountsMasters.
	 *
	 * @return the list of entities
	 */
	@Override
	public List<AccountsMasterDTO> findAll() {
		return accountsMasterRepository.findAll().stream().map(accountsMasterMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	/**
	 * Save a accountsMasters.
	 *
	 * @param accountsMastersDTO the entity to save
	 * @return the persisted entity
	 */
	@Override
	public AccountsMasterDTO save(AccountsMasterDTO acountsMasterDTO) {

		AccountsMaster accountsMaster = accountsMasterMapper.toEntity(acountsMasterDTO);
		accountsMaster = accountsMasterRepository.save(accountsMaster);
		AccountsMasterDTO result = accountsMasterMapper.toDto(accountsMaster);
		return result;
	}

	/**
	 * Get one accountsMasters by id.
	 *
	 * @param id the id of the entity
	 * @return the entity
	 */
	@Override
	public Optional<AccountsMasterDTO> findByAccountId(String accountId) {
		return accountsMasterRepository.findByAccountId(accountId).map(accountsMasterMapper::toDto);
	}

	/**
	 * Delete the accountMaster by id.
	 *
	 * @param id the id of the entity
	 */

	@Override
	public void delete(String id) {
		log.debug("Request to delete accountMaster : {}", id);
		accountsMasterRepository.deleteById(id);

	}

	@Override
	public AccountResultBuilder processCSV(MultipartFile multipartFile) throws IOException {
		return processCSV(multipartFile.getInputStream());

	}

	private AccountResultBuilder processCSV(InputStream is) {

		MasterUtil ms = new MasterUtil();

		List<CSVRecord> listCsvRecord = null;
		Map<String, Integer> apheader = null;
		Map<String, Integer> mapheader = null;
		boolean isImportError = false;
		AccountResultBuilder resultWrapper = new AccountResultBuilder();
		String messages = null;
		log.info("AccountMaster processCSV started................");
		try {
			System.out.println("AccountMaster processCSV started.........Reading CSV in UTF format");
			CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new InputStreamReader(is, "utf-8"));
			listCsvRecord = parser.getRecords();

			System.out.println("List CSV Record " + listCsvRecord.toString());
			mapheader = parser.getHeaderMap();

			parser.close();
			if (!accountMasterCSVDataValiadte.isValidCSVRecordheader(mapheader)) {
				isImportError = resultWrapper.setImportFailure(messages);
				return resultWrapper;
			}
			if (listCsvRecord == null || listCsvRecord.size() <= 0) {
				isImportError = resultWrapper.setImportFailure(messages);
				return resultWrapper;
			} else if (listCsvRecord.size() > 1000) {
				isImportError = resultWrapper.setImportFailure(messages);
				return resultWrapper;
			}

			Map<String, List<Integer>> dupMap = new HashMap<String, List<Integer>>();

			boolean dupWithInCSV = false;
			int rowCount = 1;
			// Validate data in the CSV Records
			for (CSVRecord csvRecord : listCsvRecord) {
				AccountMasterCSVRowErrorHolder validatedRecord = accountMasterCSVDataValiadte
						.isValidCSVRecord(csvRecord);

				validatedRecord.setRowNumber(rowCount++);

				AccountsMaster am = validatedRecord.getImportReplenDTO();
				String keyForRow = am.getAccountId() + "," + am.getAccountName();

				if (dupMap.containsKey(keyForRow)) {
					List<Integer> newList = dupMap.get(keyForRow);
					newList.add(validatedRecord.getRowNumber());
					dupMap.put(keyForRow, newList);
					dupWithInCSV = true;
				} else {
					List<Integer> newList = new ArrayList();
					newList.add(validatedRecord.getRowNumber());
					dupMap.put(keyForRow, newList);
				}

				// Check for duplication with in the all records
				resultWrapper.addReplenImportCSVRowErrorHolder(validatedRecord);
			}

			// If duplicates are there with in CSV then
			if (dupWithInCSV) {
				StringBuffer dupErrorMsg = new StringBuffer();
				// Set error message
				for (Map.Entry<String, List<Integer>> entry : dupMap.entrySet()) {
					if (entry.getValue().size() > 1) {
						dupErrorMsg.append(
								"Duplicate rows for " + entry.getKey() + " : " + entry.getValue().toString() + "\n");
					}
				}

				resultWrapper.setCsvHasError(true);
				resultWrapper.setDuplicate(true);
				resultWrapper.setErrorMessages(resultWrapper.getErrorMessages() + "\n" + dupErrorMsg.toString());
			}

			if (resultWrapper.isCsvHasError())
				return resultWrapper;

			// Now CSV Does not have duplicates need to check if the same
			List<AccountsMaster> listOfMaster = resultWrapper.getImportReplen();
			StringBuffer dupErrorMsg = new StringBuffer();

			// Before checking for duplicates check if the values are correct in the
			rowCount = 1;
			boolean checkData = false;
			// Check if each record in CSV already exists or not
			for (AccountsMaster am : listOfMaster) {

				try {
					String errorMsg = ms.accountValidation(am, rowCount);

					if (errorMsg.length() > 30) {

						checkData = true;
						dupErrorMsg.append(errorMsg);
						log.error(errorMsg);
						System.out.println("Check data : " + errorMsg);
					}
					rowCount++;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (checkData) {
				resultWrapper.setCsvHasError(true);
				resultWrapper.setDuplicate(true);
				resultWrapper.setErrorMessages(resultWrapper.getErrorMessages() + "\n" + dupErrorMsg.toString());
				return resultWrapper;
			}

			List<AccountsMaster> updateAccountsMasters = new ArrayList<AccountsMaster>();
			rowCount = 0;
			boolean dupsInDB = false;
			// Check if each record in CSV already exists or not
			for (AccountsMaster record : listOfMaster) {

				try {

					List<AccountsMaster> ls = accountsMasterRepository.findAll();

					if (ls != null && ls.size() > 0) {
						accountsMaster = ls.get(0);
					}

					if (accountsMaster != null) {

						String keyForRow = record.getAccountId() + "," + record.getAccountName();

						String msg = "Duplicate in masters for " + keyForRow + " : " + rowCount + "\n";
						dupErrorMsg.append(msg);
						log.error(msg);
						System.out.println("Duplicate : " + msg);
						dupsInDB = true;
					}
					updateAccountsMasters.add(record);
					rowCount++;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (dupsInDB) {
				resultWrapper.setCsvHasError(true);
				resultWrapper.setDuplicate(true);
				resultWrapper.setErrorMessages(resultWrapper.getErrorMessages() + "\n" + dupErrorMsg.toString());
				return resultWrapper;
			}

			accountsMasterRepository.saveAll(updateAccountsMasters);

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			resultWrapper.setCsvHasError(true);
			resultWrapper.setErrorMessages(e.getMessage());

		} finally {
		}

		resultWrapper.setErrorCSVResultList(null);
		resultWrapper.setStatus("SUCCESS");
		resultWrapper.setDuplicate(false);
		resultWrapper.setCsvHasError(false);

		return resultWrapper;
	}

	protected boolean addErrorFieldsWithExisting(AccountMasterCSVRowErrorHolder validatedRecord, String message) {
		String prevError = validatedRecord.getErrorFields();
		validatedRecord.setErrorFields((prevError == null ? "" : prevError + ",") + message);
		return true;
	}

	protected boolean isRecordsHasDBError(AccountMasterCSVRowErrorHolder validatedRecord,
			Set<String> setCSVDuplicateRows) {

		Boolean isCsvHasError = false;
		AccountsMaster record = null;
		boolean isRowDuplicate = false;
		String rowDuplicate = null;

		try {
			record = validatedRecord.getImportReplenDTO();
			if (record == null) {
				isCsvHasError = addErrorFieldsWithExisting(validatedRecord, "Empty Rows");

			} else {
				String cellvalue = StringUtil.join(record.getAccountId());
				if (cellvalue.trim().isEmpty()) {
					isCsvHasError = addErrorFieldsWithExisting(validatedRecord, "empty.row");
				}
			}

			AccountsMaster accountsMaster = null;

			List<AccountsMaster> ls = null;

			AccountsMaster accountsRecord = null;

			if (accountsRecord.getAccountId() == null) {
				ls = accountsMasterRepository.findAll();

			}

			if (ls != null && ls.size() > 0)

			{
				accountsMaster = ls.get(0);
			}

			if (accountsMaster != null) {
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(" ");// for AccountId ");
				stringBuilder.append(accountsMaster.getAccountId());
				stringBuilder.append(", ");// for AccountName ");
				stringBuilder.append(accountsMaster.getAccountName());

				stringBuilder.append(" already exists.");
				isCsvHasError = addErrorFieldsWithExisting(validatedRecord, stringBuilder.toString());
				isCsvHasError = true;
			} else {
				if (record.getAccountId() == null) {
					AccountsMaster dto = accountsMasterRepository.findByAccountId(record.getAccountId()).orElse(null);
					if (dto != null) {

						dto.setAccountId(record.getAccountId());
						dto.setAccountName(record.getAccountName());
						dto.setCityGroup(record.isCityGroup());
						dto.setClusterGroup(record.isClusterGroup());
						dto.setKitruleSavail(record.isKitruleSavail());
						dto.setPucavail(record.isPucavail());

						dto.setTruckAvail(record.isTruckAvail());

						accountsMasterRepository.save(dto);
					}
				} else {

					// TODO : To support cost also in the future
					accountsMasterRepository.save(record);
				}
			}

		} catch (Exception e) {
			addErrorFieldsWithExisting(validatedRecord, "Please check your input.");
			isCsvHasError = true;
			e.printStackTrace();
		}
		if (isCsvHasError) {
			return true;
		} else {
			return false;
		}

	}
}
