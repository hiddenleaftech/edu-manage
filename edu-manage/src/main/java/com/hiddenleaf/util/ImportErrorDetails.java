package com.hiddenleaf.util;

import java.io.Serializable;

public class ImportErrorDetails implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean isError = false;
	private String errorFields;

	public ImportErrorDetails() {
		super();
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public String getErrorFields() {
		return errorFields;
	}

	public void setErrorFields(String errorFields) {
		this.errorFields = errorFields;
	}

	@Override
	public String toString() {
		return "ImportErrorDetails [isError=" + isError + ", errorFields=" + errorFields + "]";
	}

}
