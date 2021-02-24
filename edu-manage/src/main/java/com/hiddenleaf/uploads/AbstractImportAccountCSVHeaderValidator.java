package com.hiddenleaf.uploads;

import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.hiddenleaf.domain.AccountsMaster;
import com.hiddenleaf.util.CustomStringUtil;
import com.hiddenleaf.util.interfaceCSVDataTypeValidatorParseData;

@Component
public abstract class AbstractImportAccountCSVHeaderValidator implements interfaceCSVDataTypeValidatorParseData {

	private static final Logger logger = LoggerFactory.getLogger(AbstractImportAccountCSVHeaderValidator.class);

	public abstract int getNoOfColoumnsMax();

	public abstract String[][] getImportFileColoumnHeaders();

	public abstract String[] getImportFileColoumnHeadersNames();

	public abstract AccountsMaster fillStagingRecords(final String header, final String value, final String dataType,AccountsMaster accountMaster)
			throws ParseException;

	public final int MODE_CSV = 1;
	public final int MODE_XLS = 2;
	public final int MODE_XLSX = 3;
	public int COL_MAX = 13;

	public boolean isNullOrEmpty(String strValue) {
		if (strValue != null && !strValue.isEmpty())
			return false;
		return true;
	}

	/**
	 * Validate the CSV data from the each columns.
	 * 
	 * @param csvData
	 * @return
	 */
	public AccountMasterCSVRowErrorHolder isValidRecord(CSVRecord csvData, Map<String, String> xlsData, int mode) {
		logger.info("isValidRecord started, inputs are {} ", csvData);
		String[][] headerArray = getImportFileColoumnHeaders();
		AccountMasterCSVRowErrorHolder staggingRecord = new AccountMasterCSVRowErrorHolder();
		AccountsMaster accountMaster = new AccountsMaster();
		boolean isMandatory = false;

		try {
			for (int intLoopRow = IMPORT_ROW_COLOUMN_NAME; intLoopRow < IMPORT_ROW_MAX - 2; intLoopRow++) {
				StringBuilder sbError = new StringBuilder();
				boolean isColumnError = false;
				COL_MAX = getNoOfColoumnsMax();
				for (int intLoopColumn = 0; intLoopColumn < COL_MAX; intLoopColumn++) {
					String strHeader = headerArray[intLoopRow][intLoopColumn];
					String strCellValue = "";
					try {
						if (mode == MODE_CSV && csvData != null) {
							strCellValue = csvData.get(strHeader);
						} else if ((mode == MODE_XLS || mode == MODE_XLSX) && xlsData != null) {
							strCellValue = xlsData.get(strHeader);
						}
					} catch (Exception e) {
						strCellValue = null;
					}
					String strDataType = headerArray[intLoopRow + 1][intLoopColumn];
					String strMandatory = headerArray[intLoopRow + 2][intLoopColumn];
					String strFieldEror = "";// --Empty
					// --logger.info("Mode: {} ,Value : {} ",mode, strMandatory);
					// --logger.info(mode+", header :" + strHeader+ "," );
					if (!CustomStringUtil.isValidString(strCellValue)) {
						if (strMandatory.equalsIgnoreCase(IMPORT_COL_MANDATORY_YES)) {
							isMandatory = true;
						} else {
							isMandatory = false;
						}
					} else {
						strCellValue = strCellValue.trim();
					}
					if (CustomStringUtil.isNullOrEmpty(strCellValue)) {
						if (isMandatory) {
							staggingRecord.setError(true);
							strFieldEror = strHeader + " expected field is mandatory.";
							sbError.append(strFieldEror);
							isColumnError = true;
						}
					} else {
						switch (strDataType) {
						case IMPORT_COL_TYPE_STRING:
							// TODO : We need to make sure we use only Alphanumerics $ pound also present in
							// the data
							// if (!CustomStringUtil.isValidString(strCellValue)) {
							// staggingRecord.setError(true);
							// strFieldEror = strHeader + "[" + strCellValue + "]"
							// + " expected string format is { alphanumeric}.";
							// sbError.append(strFieldEror);
							// isColumnError = true;
							// }
							break;
						case IMPORT_COL_TYPE_INT:
							if (!CustomStringUtil.isValidInteger(strCellValue)) {
								staggingRecord.setError(true);
								strFieldEror = strHeader + "[" + strCellValue + "]" + " expected numeric format ";
								sbError.append(strFieldEror);
								isColumnError = true;
							}
							break;
						case IMPORT_COL_TYPE_DATE:
							if (!CustomStringUtil.isValidDate(strCellValue)) {
								staggingRecord.setError(true);
								strFieldEror = strHeader + "[" + strCellValue + "]" + " expected date format is {"
										+ CustomStringUtil.DATE_PATTERN + "}.";
								sbError.append(strFieldEror);
								isColumnError = true;
							}
							break;
						case IMPORT_COL_TYPE_BOOLEAN:
							if (!CustomStringUtil.isValid(strCellValue)) {
								staggingRecord.setError(true);
								strFieldEror = strHeader + "[" + strCellValue + "]" + " expected date format is {"
										+ CustomStringUtil.BOOLEANPATTERN + "}.";
								sbError.append(strFieldEror);
								isColumnError = true;
							}
							break;
						case IMPORT_COL_TYPE_DOUBLE:
							if (!CustomStringUtil.isValidDoule(strCellValue)) {
								staggingRecord.setError(true);
								strFieldEror = strHeader + "[" + strCellValue + "]" + " expected numeric format ";
								sbError.append(strFieldEror);
								isColumnError = true;
							}
							break;
						default:
							break;
						}
					}
					if (!sbError.toString().isEmpty())
						logger.info("isValidRecord error {} ", sbError.toString());
					if (isColumnError) {
						sbError.append("#");
						if (sbError.toString().length() > 0) {
							strFieldEror = sbError.toString();
							strFieldEror = strFieldEror.substring(0, strFieldEror.length() - 1);
							// --error.delete( 0, error.length() );
							staggingRecord.setErrorFields(strFieldEror);
						}
						isColumnError = false;
					}
					accountMaster = fillStagingRecords(strHeader, strCellValue, strDataType, accountMaster);
				} // --csv columns

				staggingRecord.setImportReplenDTO(accountMaster);

				logger.info("isValidRecord isColumnError {} ", isColumnError);
				logger.info("isValidRecord replanRecord {} ", accountMaster.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Stagging records update error : {} ", e.getMessage());
		} finally {
			headerArray = null;
		}
		logger.info("isValidRecord End.");
		return staggingRecord;
	}

	/**
	 * 
	 * @param inputCSVHeader
	 * @return
	 */
	public boolean isValidCSVRecordheader(Map<String, Integer> inputCSVHeader) {
		logger.debug("Input header : " + inputCSVHeader);

		if (inputCSVHeader == null)
			return false;

		boolean success = true;
		StringBuilder msg = new StringBuilder();
		String[][] importCSVHeaders = getImportFileColoumnHeaders();

		String[] csvInHeaderArray = new String[inputCSVHeader.keySet().size()];
		int intkeycsvHeaderArray = 0;
		for (String key : inputCSVHeader.keySet()) {
			csvInHeaderArray[intkeycsvHeaderArray++] = key;
		}

		String[] csvSysHeader = getImportFileColoumnHeadersNames();
		if (!checkHeaderNames(csvSysHeader, csvInHeaderArray)) {
			msg.append("Please check the import csv file coloumn order / fields names.");
			success = false;
		}

		try {
			for (String key : inputCSVHeader.keySet()) {
				int columnIndex = inputCSVHeader.get(key);
				String header = importCSVHeaders[IMPORT_ROW_COLOUMN_NAME][columnIndex];
				header = header.trim();
				key = key.trim();
				logger.debug(key + "(" + key.length() + "),header=" + header + "(" + header.length() + ")");

				// --TODO special or /n/r/t values in column names.
				if (!key.equalsIgnoreCase(header)) {
					msg.append("{ Coloumn:" + key + ",Value :" + inputCSVHeader.get(key) + "},");
					success = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			importCSVHeaders = null;
		}
		if (!success) {
			logger.debug("Please check the import csv file coloumn order / fields names ," + msg);
		}
		return success;
	}

	/**
	 * 
	 * @param csvHeader
	 * @param inputHeader
	 * @return
	 */
	private boolean checkHeaderNames(String[] csvHeader, String[] inputHeader) {

		// --checking length of arrays
		logger.debug("CSV System Header : " + Arrays.asList(csvHeader));
		logger.debug("CSV Input file Header : " + Arrays.asList(inputHeader));

		if (csvHeader.length != inputHeader.length)
			return false;

		for (int i = 0; i < csvHeader.length; i++) {
			if (!csvHeader[i].equalsIgnoreCase(inputHeader[i])) {
				logger.info("Mismatch => {} and {}", csvHeader[i], inputHeader[i]);
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param csvheader
	 * @return
	 */
	public boolean isValidXLSRecordheader(Map<Integer, String> inputXLSHeader) {
		if (inputXLSHeader == null)
			return false;

		String[][] importXLSHeaders = getImportFileColoumnHeaders();

		Map<String, Integer> xlsheaderTransform = new HashMap<String, Integer>();
		for (Integer key : inputXLSHeader.keySet()) {
			xlsheaderTransform.put(inputXLSHeader.get(key), key);
		}

		boolean success = true;
		StringBuilder msg = new StringBuilder();
		try {
			for (String key : xlsheaderTransform.keySet()) {
				String header = importXLSHeaders[IMPORT_ROW_COLOUMN_NAME][xlsheaderTransform.get(key)];
				header = header.trim();
				key = key.trim();
				// --log.debug(key.length() + " "+header.length());
				// --TODO special or /n/r/t values in column names.
				if (!key.equalsIgnoreCase(header)) {
					msg.append("{ Coloumn:" + key + ",Value :" + xlsheaderTransform.get(key) + "},");
					success = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			xlsheaderTransform = null;
			importXLSHeaders = null;
		}
		if (!success) {

			logger.debug("Please check the import xls file coloumn order / fields names ," + msg);
		}
		return success;
	}
}
