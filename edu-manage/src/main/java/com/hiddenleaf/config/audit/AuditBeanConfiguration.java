package com.hiddenleaf.config.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditBeanConfiguration implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		Optional<String> result = Optional.of("System");
		return result;
	}

}
