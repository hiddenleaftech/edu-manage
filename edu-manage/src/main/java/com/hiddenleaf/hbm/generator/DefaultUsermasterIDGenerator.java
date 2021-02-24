package com.hiddenleaf.hbm.generator;

import com.hiddenleaf.hbm.AbstractStringIDGenerator;

public class DefaultUsermasterIDGenerator extends AbstractStringIDGenerator {
	
	private static final long serialVersionUID = 1L;

	public static final String defaultSsequencePrefix = ENTITY_KEY_CODE.KEY_USER_MASTER;
	public static final String defaultSsequenceIncrement = "1";
	public static final String stringFormat = "%03d";

	
	public DefaultUsermasterIDGenerator() {
		super();
	}
	
	@Override
	public String defaultEntityIdentifierPrefix() {
		return defaultSsequencePrefix;
	}

	@Override
	public boolean isStringFormatDecimal() {
		return true;
	}

	

	@Override
	public String getStringFormat() {
		// --String.format("%010d", nextValue);
		return stringFormat;
	}

	@Override
	public boolean isAssignedSequence() {
		return false;
	}

}
