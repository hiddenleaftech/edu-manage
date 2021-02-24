package com.hiddenleaf.hbm.generator;

import com.hiddenleaf.hbm.AbstractStringIDGenerator;

public class DefaultAuthConfigGenerator extends AbstractStringIDGenerator {
	
	private static final long serialVersionUID = 1L;

	public static final String defaultSsequencePrefix = ENTITY_KEY_CODE.KEY_AUTH_CONFIG;
	public static final String defaultSsequenceIncrement = "1";
	public static final String stringFormat = "%03d";

	
	public DefaultAuthConfigGenerator() {
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
