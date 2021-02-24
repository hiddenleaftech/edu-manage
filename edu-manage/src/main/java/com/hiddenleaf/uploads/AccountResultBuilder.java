package com.hiddenleaf.uploads;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hiddenleaf.domain.AccountsMaster;
import com.hiddenleaf.util.CustomStringUtil;
import com.hiddenleaf.util.JsonToStringBuilder;

public class AccountResultBuilder implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String IMPORT_SUCCESS = "succes";
	public static final String IMPORT_TEMP_ORDER = "temp_order";
	public static final String IMPORT_FAILURE = "failure";

	public static final String IMPORT_MESSAGE_INITIATED = "";
	public static final String IMPORT_MESSAGE_COMPLETED = "Inbound-Completed.";

	public static final String IMPORT_SO_MESSAGE_INITIATED = "Outbound-initiated.";
	public static final String IMPORT_SO_MESSAGE_COMPLETED = "Outbound-Completed.";
	public static final String IMPORT_SO_MESSAGE_TEMP_ORDER = "Outbound-Temp Order.";

	/** CSV data with error informations */
	private List<AccountMasterCSVRowErrorHolder> errorCSVResultList = null;

	/** This field holds the csv has error */
	private boolean csvHasError = false;
	/** This field holds the csv import job status */
	private String status = IMPORT_FAILURE;
	private String errorMessages = null;
	private boolean noPartsAvailable;
	private long noOfRecordsInserted = 0L;
	private boolean isDuplicate;
	private boolean importStatus;

	private StringBuffer stBufErrorMessages = new StringBuffer();

	private int noOfCorrectRecords = 0;
	private int noOfErrorRecords = 0;
	private int totalRecords = 0;

	public int getNoOfCorrectRecords() {
		return noOfCorrectRecords;
	}

	public void setNoOfCorrectRecords(int noOfCorrectRecords) {
		this.noOfCorrectRecords = noOfCorrectRecords;
	}

	public int getNoOfErrorRecords() {
		return noOfErrorRecords;
	}

	public void setNoOfErrorRecords(int noOfErrorRecords) {
		this.noOfErrorRecords = noOfErrorRecords;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public AccountResultBuilder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountResultBuilder(String status, String errorMessages, long noOfRecordsInserted, String orderId) {
		super();
		this.status = status;
		this.errorMessages = errorMessages;
		this.noOfRecordsInserted = noOfRecordsInserted;
	}

	public AccountResultBuilder(boolean csvHasError, String status, String errorMessages, long noOfRecordsInserted,
			String orderId) {
		super();
		this.csvHasError = csvHasError;
		this.status = status;
		this.errorMessages = errorMessages;
		this.noOfRecordsInserted = noOfRecordsInserted;
		this.importStatus = true;
	}

	public AccountResultBuilder(List<AccountMasterCSVRowErrorHolder> errorCSVResultList, boolean csvHasError,
			String status, String errorMessages, long noOfRecordsInserted, String orderId) {
		super();
		this.errorCSVResultList = errorCSVResultList;
		this.csvHasError = csvHasError;
		this.status = status;
		this.errorMessages = errorMessages;
		this.noOfRecordsInserted = noOfRecordsInserted;
	}

	/**
	 * Get the validated csv records.
	 * 
	 * @return
	 */

	@JsonIgnore
	public List<AccountsMaster> getImportReplen() {
		List<AccountsMaster> listImportReplenDTO = new ArrayList<AccountsMaster>();
		if (getErrorCSVResultList() != null) {
			try {
				for (AccountMasterCSVRowErrorHolder csvRowData : errorCSVResultList) {
					AccountsMaster importDTO = csvRowData.getImportReplenDTO();
					listImportReplenDTO.add(importDTO);
				}
			} catch (Exception e) {
				throw e;
			}
		}
		return listImportReplenDTO;
	}

	@JsonIgnore
	public LinkedHashMap<String, List<AccountMasterCSVRowErrorHolder>> getOrderedParts() {
//		if (errorCSVResultList != null && errorCSVResultList.size() > 0)
//			return errorCSVResultList.stream()
//					.collect(Collectors.groupingBy(holder -> holder.getImportReplenDTO().getCustomerReference(),
//							LinkedHashMap::new, Collectors.toList()));
//		else
		return null;
	}

	@JsonIgnore
	public void updateErrorRecords() {
		if (errorCSVResultList != null) {
			List<AccountMasterCSVRowErrorHolder> errorRows = new ArrayList<>();
			for (AccountMasterCSVRowErrorHolder csvRowData : errorCSVResultList) {
				if (!CustomStringUtil.isNullOrEmpty(csvRowData.getErrorFields()))
					errorRows.add(csvRowData);
			}
			errorCSVResultList = errorRows;
		}
	}

	public List<AccountMasterCSVRowErrorHolder> getErrorCSVResultList() {
		return errorCSVResultList;
	}

	public void addReplenImportCSVRowErrorHolder(AccountMasterCSVRowErrorHolder data) {
		if (this.errorCSVResultList == null) {
			this.errorCSVResultList = new ArrayList<AccountMasterCSVRowErrorHolder>();
		}
		this.errorCSVResultList.add(data);
	}

	public void addReplenImportCSVRowErrorHolderClear() {
		this.errorCSVResultList = null;
	}

	public boolean isCsvHasError() {
		return csvHasError;
	}

	public void setCsvHasError(boolean csvHasError) {
		this.csvHasError = csvHasError;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessages() {
		return errorMessages.toString();
	}

	public boolean setErrorMessages(String errorMessages) {
		status = AccountResultBuilder.IMPORT_FAILURE;
		stBufErrorMessages.append(errorMessages);
		this.errorMessages = errorMessages;
		this.importStatus = false;
		return true;
	}

	public long getNoOfRecordsInserted() {
		return noOfRecordsInserted;
	}

	public void setNoOfRecordsInserted(long noOfRecordsInserted) {
		this.noOfRecordsInserted = noOfRecordsInserted;
	}

	/**
	 * 
	 * @param messages
	 * @return
	 */
	public boolean setImportFailure(String messages) {
		if (messages != null) {
			this.setErrorMessages(messages);
		}

		this.csvHasError = true;
		this.noOfRecordsInserted = 0L;
		this.status = IMPORT_FAILURE;
		this.importStatus = false;
		return true;
	}

	/**
	 * 
	 * @param nofRecords
	 * @return
	 */
	public boolean setImportSuccess() {
		this.csvHasError = false;
		this.status = IMPORT_SUCCESS;
		this.errorMessages = IMPORT_MESSAGE_COMPLETED;
		this.importStatus = true;
		return true;
	}

	/**
	 * 
	 * @param nofRecords
	 * @return
	 */
	public boolean setImportSOSuccess() {
		this.csvHasError = false;
		this.status = IMPORT_SUCCESS;
		this.errorMessages = IMPORT_SO_MESSAGE_COMPLETED;
		this.importStatus = true;
		return true;
	}

	/**
	 * 
	 * @param nofRecords
	 * @return
	 */
	public boolean setImportSOTempOrderSuccess() {
		this.csvHasError = false;
		this.status = IMPORT_TEMP_ORDER;
		this.errorMessages = IMPORT_SO_MESSAGE_TEMP_ORDER;
		this.importStatus = true;
		return true;
	}

	public boolean isNoPartsAvailable() {
		return noPartsAvailable;
	}

	public void setNoPartsAvailable(boolean noPartsAvailable) {
		this.noPartsAvailable = noPartsAvailable;
	}

	public void setErrorCSVResultList(List<AccountMasterCSVRowErrorHolder> errorCSVResultList) {
		this.errorCSVResultList = errorCSVResultList;
	}

	public boolean isDuplicate() {
		return isDuplicate;
	}

	public void setDuplicate(boolean isDuplicate) {
		this.isDuplicate = isDuplicate;
	}

	public boolean isImportStatus() {
		return importStatus;
	}

	public void setImportStatus(boolean importStatus) {
		this.importStatus = importStatus;
	}

	@Override
	public String toString() {
		JsonToStringBuilder builder = new JsonToStringBuilder(this);
		builder.append("errorCSVResultList", errorCSVResultList);
		builder.append("csvHasError", csvHasError);
		builder.append("status", status);
		builder.append("errorMessages", errorMessages);
		builder.append("noOfRecordsInserted", noOfRecordsInserted);
		builder.append("noPartsAvailable", noPartsAvailable);
		builder.append("isDuplicate", isDuplicate);
		builder.append("noOfCorrectRecords", noOfCorrectRecords);
		builder.append("noOfErrorRecords", noOfErrorRecords);
		builder.append("totalRecords", totalRecords);
		builder.append("importStatus", importStatus);
		return builder.build();
	}

}
