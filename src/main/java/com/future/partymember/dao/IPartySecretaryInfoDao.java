package com.future.partymember.dao;

import java.util.List;

import com.future.partymember.entity.PartySecretaryInfo;

/**
 * 书记表的数据访问层接口
 * @author 丁赵雷
 */
public interface IPartySecretaryInfoDao {
	//根据用户名和密码查询
	public PartySecretaryInfo findByAccountAndPassword(PartySecretaryInfo partySecretaryInfo);

}
