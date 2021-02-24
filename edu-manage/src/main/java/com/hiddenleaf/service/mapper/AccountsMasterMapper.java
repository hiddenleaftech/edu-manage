package com.hiddenleaf.service.mapper;

import org.mapstruct.Mapper;

import com.hiddenleaf.domain.AccountsMaster;
import com.hiddenleaf.service.dto.AccountsMasterDTO;

@Mapper(componentModel = "Spring", uses = {})
public interface AccountsMasterMapper extends EntityMapper<AccountsMasterDTO, AccountsMaster> {
//
//	AccountsMasterDTO toDto(AccountsMaster accountsMaster);
//
//	AccountsMaster toEntity(AccountsMasterDTO accountsMasterDTO);

	default AccountsMaster fromId(String accountId) {

		if (accountId == null) {
			return null;
		}

		AccountsMaster accountsMaster = new AccountsMaster();
		accountsMaster.setAccountId(accountId);
		return accountsMaster;

	}

}
