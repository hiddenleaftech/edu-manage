package com.hiddenleaf.hbm.generator;

import com.hiddenleaf.hbm.AbstractStringIDGenerator;

public class DefaultRouteContactIDGenerator extends AbstractStringIDGenerator {

	public static final String defaultSsequencePrefix = ENTITY_KEY_CODE.KEY_ROUTE_CONTACT;
	public static final String defaultSsequenceIncrement = "1";
	public static final String stringFormat = "%010d";

	public DefaultRouteContactIDGenerator() {
		super();
	}

	@Override
	public String defaultEntityIdentifierPrefix() {
		return defaultSsequencePrefix;
	}

	@Override
	public boolean isStringFormatDecimal() {
		return false;
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
