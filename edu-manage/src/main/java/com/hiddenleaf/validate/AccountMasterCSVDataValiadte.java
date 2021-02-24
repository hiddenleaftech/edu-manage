package com.hiddenleaf.validate;

import java.text.ParseException;

import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import com.hiddenleaf.domain.AccountsMaster;
import com.hiddenleaf.uploads.AbstractImportAccountCSVHeaderValidator;
import com.hiddenleaf.uploads.AccountMasterCSVRowErrorHolder;

@Component
public class AccountMasterCSVDataValiadte extends AbstractImportAccountCSVHeaderValidator {

	private final int COL_AccountId = 0;
	private final int COL_AccountName = 1;
	private final int COL_TruckAvail = 2;
	private final int COL_CityGroup = 3;
	private final int COL_ClusterGroup = 4;
	private final int COL_Pucavail = 5;
	private final int COL_KitruleSavail = 6;

	public int COL_MAX = 7;

	public final int COL_NAME_SERIAL_NO_MIN_LENGTH = 8;
	public final int COL_NAME_SERIAL_NO_MAX_LENGTH = 30;

	/**
	 * Here we can set the column name of the CSV headers.
	 */

	private final String COL_NAME_AccountId = "AccountId";
	private final String COL_NAME_AccountName = "AccountName";
	private final String COL_NAME_TruckAvail = "TruckAvail";
	private final String COL_NAME_CityGroup = "CityGroup";
	private final String COL_NAME_ClusterGroup = "ClusterGroup";
	private final String COL_NAME_Pucavail = "Pucavail";
	private final String COL_NAME_KitruleSavail = "KitruleSavail";

	@Override
	public int getNoOfColoumnsMax() {
		// TODO Auto-generated method stub
		return COL_MAX;
	}

	@Override
	public String[][] getImportFileColoumnHeaders() {
		// TODO Auto-generated method stub

		String[][] importCSVHeadersArray = new String[IMPORT_ROW_MAX][COL_MAX];

		importCSVHeadersArray[IMPORT_ROW_COLOUMN_NAME][COL_AccountId] = COL_NAME_AccountId;
		importCSVHeadersArray[IMPORT_ROW_COLOUMN_DATA_TYPE][COL_AccountId] = IMPORT_COL_TYPE_STRING;
		importCSVHeadersArray[IMPORT_ROW_COLOUMN_DATA_MANDATORY][COL_AccountId] = IMPORT_COL_MANDATORY_YES;

		importCSVHeadersArray[IMPORT_ROW_COLOUMN_NAME][COL_AccountName] = COL_NAME_AccountName;
		importCSVHeadersArray[IMPORT_ROW_COLOUMN_DATA_TYPE][COL_AccountName] = IMPORT_COL_TYPE_STRING;
		importCSVHeadersArray[IMPORT_ROW_COLOUMN_DATA_MANDATORY][COL_AccountName] = IMPORT_COL_MANDATORY_YES;

		importCSVHeadersArray[IMPORT_ROW_COLOUMN_NAME][COL_TruckAvail] = COL_NAME_TruckAvail;
		importCSVHeadersArray[IMPORT_ROW_COLOUMN_DATA_TYPE][COL_TruckAvail] = IMPORT_COL_TYPE_BOOLEAN;
		importCSVHeadersArray[IMPORT_ROW_COLOUMN_DATA_MANDATORY][COL_TruckAvail] = IMPORT_COL_MANDATORY_YES;

		importCSVHeadersArray[IMPORT_ROW_COLOUMN_NAME][COL_CityGroup] = COL_NAME_CityGroup;
		importCSVHeadersArray[IMPORT_ROW_COLOUMN_DATA_TYPE][COL_CityGroup] = IMPORT_COL_TYPE_BOOLEAN;
		importCSVHeadersArray[IMPORT_ROW_COLOUMN_DATA_MANDATORY][COL_CityGroup] = IMPORT_COL_MANDATORY_YES;

		importCSVHeadersArray[IMPORT_ROW_COLOUMN_NAME][COL_ClusterGroup] = COL_NAME_ClusterGroup;
		importCSVHeadersArray[IMPORT_ROW_COLOUMN_DATA_TYPE][COL_ClusterGroup] = IMPORT_COL_TYPE_BOOLEAN;
		importCSVHeadersArray[IMPORT_ROW_COLOUMN_DATA_MANDATORY][COL_ClusterGroup] = IMPORT_COL_MANDATORY_YES;

		importCSVHeadersArray[IMPORT_ROW_COLOUMN_NAME][COL_Pucavail] = COL_NAME_Pucavail;
		importCSVHeadersArray[IMPORT_ROW_COLOUMN_DATA_TYPE][COL_Pucavail] = IMPORT_COL_TYPE_BOOLEAN;
		importCSVHeadersArray[IMPORT_ROW_COLOUMN_DATA_MANDATORY][COL_Pucavail] = IMPORT_COL_MANDATORY_YES;

		importCSVHeadersArray[IMPORT_ROW_COLOUMN_NAME][COL_KitruleSavail] = COL_NAME_KitruleSavail;
		importCSVHeadersArray[IMPORT_ROW_COLOUMN_DATA_TYPE][COL_KitruleSavail] = IMPORT_COL_TYPE_BOOLEAN;
		importCSVHeadersArray[IMPORT_ROW_COLOUMN_DATA_MANDATORY][COL_KitruleSavail] = IMPORT_COL_MANDATORY_YES;

		return importCSVHeadersArray;
	}

	@Override
	public String[] getImportFileColoumnHeadersNames() {
		String[][] inputArray = getImportFileColoumnHeaders();
		String[] csvHeaderArray = new String[COL_MAX];
		for (int intLoop = 0; intLoop < COL_MAX; intLoop++) {
			csvHeaderArray[intLoop] = inputArray[IMPORT_ROW_COLOUMN_NAME][intLoop];
		}
		return csvHeaderArray;

	}

	@Override
	public AccountsMaster fillStagingRecords(String header, String value, String dataType, AccountsMaster accountMaster)
			throws ParseException {
		switch (header) {

		case COL_NAME_AccountId:
			accountMaster.setAccountId(value);
			break;

		case COL_NAME_AccountName:
			accountMaster.setAccountName(value);
			break;

		case COL_NAME_CityGroup:
			if (value != null && value.equalsIgnoreCase("active")) {
				accountMaster.setCityGroup(true);
			} else {
				accountMaster.setCityGroup(false);
			}
			break;

		case COL_NAME_ClusterGroup:
			if (value != null && value.equalsIgnoreCase("active")) {
				accountMaster.setClusterGroup(true);
			} else {
				accountMaster.setClusterGroup(false);
			}
			break;

		case COL_NAME_KitruleSavail:
			if (value != null && value.equalsIgnoreCase("active")) {
				accountMaster.setKitruleSavail(true);
			} else {
				accountMaster.setKitruleSavail(false);
			}
			break;

		case COL_NAME_Pucavail:
			if (value != null && value.equalsIgnoreCase("active")) {
				accountMaster.setPucavail(true);
			} else {
				accountMaster.setPucavail(false);
			}
			break;

		case COL_NAME_TruckAvail:
			if (value != null && value.equalsIgnoreCase("active")) {
				accountMaster.setTruckAvail(true);
			} else {
				accountMaster.setTruckAvail(false);
			}
			break;

		}
		return accountMaster;

	}

	/**
	 * 
	 * @param csvData
	 * @return
	 */
	public AccountMasterCSVRowErrorHolder isValidCSVRecord(CSVRecord csvRecord) {
		return isValidRecord(csvRecord, null, MODE_CSV);
	}
}
