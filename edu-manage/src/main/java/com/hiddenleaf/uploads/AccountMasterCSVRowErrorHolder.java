package com.hiddenleaf.uploads;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hiddenleaf.domain.AccountsMaster;
import com.hiddenleaf.util.ImportErrorDetails;
import com.hiddenleaf.util.JsonToStringBuilder;

public class AccountMasterCSVRowErrorHolder extends ImportErrorDetails {

	private static final long serialVersionUID = 1L;

	private AccountsMaster accountsMaster;
	private int rowNumber = 1;

	public AccountMasterCSVRowErrorHolder() {
		super();
	}

	public AccountMasterCSVRowErrorHolder(AccountsMaster importReplenDTO) {
		super();
		this.accountsMaster = importReplenDTO;
	}

	public AccountsMaster getImportReplenDTO() {
		return accountsMaster;
	}

	public void setImportReplenDTO(AccountsMaster importReplenDTO) {
		this.accountsMaster = importReplenDTO;
	}

	@JsonIgnore
	public boolean isNullOrEmpty(String str) {
		if (str != null && !str.isEmpty())
			return false;
		return true;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

//	@Override
//	public String toString() {
//		return "ImportOrderCSVRowErrorHolder [importReplenDTO=" + importReplenDTO + ", rowNumber=" + rowNumber + "]";
//	}
//	

	@JsonIgnore
	public String getRowAsString(int mode) {
		StringBuilder builder = new StringBuilder();

		if (mode == 1) {
			if (!isNullOrEmpty(this.accountsMaster.getAccountId()))
				builder.append(accountsMaster.getAccountId());

			if (!isNullOrEmpty(this.accountsMaster.getAccountName()))
				builder.append(accountsMaster.getAccountName());

		}
		return builder.toString();
	}

	@Override
	public String toString() {
		JsonToStringBuilder builder = new JsonToStringBuilder(this);
		builder.append("accountsMaster", accountsMaster);
		builder.append("isError()", isError());
		builder.append("getErrorFields()", getErrorFields());
		builder.append("row", rowNumber);
		return builder.build();
	}

}
