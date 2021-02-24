package com.hiddenleaf.hbm.generator;

import com.hiddenleaf.hbm.AbstractStringIDGenerator;

public class DefaultSiteIDGenerator extends AbstractStringIDGenerator{
	
	public static final String defaultsSequencePrefix = ENTITY_KEY_CODE.KEY_SITE_MASTER_MAPPING;
	public static final String defaultSsequenceIncrement = "1";
	public static final String stringFormat = "%02d";


	public DefaultSiteIDGenerator() {
		super();
	}

	
	
	@Override
	public String defaultEntityIdentifierPrefix() {
		// TODO Auto-generated method stub
		return defaultsSequencePrefix;
	}

	@Override
	public boolean isStringFormatDecimal() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getStringFormat() {
		// TODO Auto-generated method stub
		return stringFormat;
	}

	@Override
	public boolean isAssignedSequence() {
		// TODO Auto-generated method stub
		return false;
	}

}
