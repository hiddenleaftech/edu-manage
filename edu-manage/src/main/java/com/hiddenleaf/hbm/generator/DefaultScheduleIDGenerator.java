package com.hiddenleaf.hbm.generator;

import com.hiddenleaf.hbm.AbstractStringIDGenerator;

public class DefaultScheduleIDGenerator extends AbstractStringIDGenerator {

	public static final String defaultsSequencePrefix = "SCH";
	public static final String defaultSsequenceIncrement = "1";
	public static final String stringFormat = "%06d";

	public DefaultScheduleIDGenerator() {
		super();
	}

	@Override
	public String defaultEntityIdentifierPrefix() {
		return defaultsSequencePrefix;
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
