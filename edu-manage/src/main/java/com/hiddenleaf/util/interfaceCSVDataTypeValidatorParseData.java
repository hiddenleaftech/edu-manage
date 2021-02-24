package com.hiddenleaf.util;

/**
 * 
 * @author Raghunathan
 *
 */
public interface interfaceCSVDataTypeValidatorParseData {

	public final String DATETIME_FORMAT_PATTERN_YYYY_MM_dd_HHmmss_z = "yyyy/MM/dd HH:mm:ss z";

	public final String IMPORT_COL_DATA_MANDATORY = "#@#";
	public static final String IMPORT_COL_DATA_OPTIONAL = "#EMPTY#";

	public final String IMPORT_COL_TYPE_STRING = "STRING";
	public final String IMPORT_COL_TYPE_INT = "INT";
	public final String IMPORT_COL_TYPE_DATE = "DATE";
	public final String IMPORT_COL_TYPE_BOOLEAN = "BOOLEAN";

	public final String IMPORT_COL_TYPE_DOUBLE = "DOUBLE";

	public final String IMPORT_COL_MANDATORY_YES = "Y";
	public final String IMPORT_COL_MANDATORY_NO = "N";

	public final int IMPORT_ROW_COLOUMN_NAME = 0;
	public final int IMPORT_ROW_COLOUMN_DATA_TYPE = 1;
	public final int IMPORT_ROW_COLOUMN_DATA_MANDATORY = 2;
	public final int IMPORT_ROW_MAX = IMPORT_ROW_COLOUMN_DATA_MANDATORY + 1;
}
