package com.hiddenleaf.util;
/**
 * This interface is mapped with logback-spring.xml 
 * eg. logger name="uploadFileLog"
 * @author Raghunathan R
 * Created : 19-Jan-2019
 */
public interface LogConstant {

	public static final String UPLOAD_INBOUND_LOG = "uploadFileLog";
	
	public static final String SEQUECE_FILE_LOG = "sequenceFileLog";
	
	public static final String UPLOAD_OUTBOUND_LOG = "soUploadFileLog";
	
	public static final String UPLOAD_HUS_INBOUND_LOG = "uploadJSONFileLog";
	
	public static final String HUS_LABEL_GENERATION_LOG = "husqlabelgenerationLog";
	
}
