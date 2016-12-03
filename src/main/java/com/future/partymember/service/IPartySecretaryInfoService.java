package com.future.partymember.service;

import com.future.partymember.entity.PartySecretaryInfo;

public interface IPartySecretaryInfoService {
	//根据用户名和密码查询
	public PartySecretaryInfo findByAccountAndPassword(PartySecretaryInfo partySecretaryInfo);

}
