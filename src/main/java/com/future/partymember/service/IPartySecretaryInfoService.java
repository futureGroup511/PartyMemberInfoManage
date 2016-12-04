package com.future.partymember.service;

import com.future.partymember.entity.PartySecretaryInfo;

public interface IPartySecretaryInfoService {
	//根据用户名和密码查询
	public PartySecretaryInfo findByAccountAndPassword(PartySecretaryInfo partySecretaryInfo);
	//更新个人信息
	public String updatePersonInfo(PartySecretaryInfo partySecretaryInfo);
	//根据id得到书记对像
	public PartySecretaryInfo findById(int id);

}
