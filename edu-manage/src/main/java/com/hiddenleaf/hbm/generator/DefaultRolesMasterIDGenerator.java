package com.hiddenleaf.hbm.generator;

import com.hiddenleaf.hbm.AbstractStringIDGenerator;

public class DefaultRolesMasterIDGenerator extends AbstractStringIDGenerator {

	public static final String defaultSsequencePrefix = ENTITY_KEY_CODE.KEY_CARGO_ROLE;
	public static final String defaultSsequenceIncrement = "1";
	public static final String stringFormat = "%03d";

	
	public DefaultRolesMasterIDGenerator() {
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
