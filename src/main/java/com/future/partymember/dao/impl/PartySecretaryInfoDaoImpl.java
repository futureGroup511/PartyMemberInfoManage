package com.future.partymember.dao.impl;

import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IPartySecretaryInfoDao;
import com.future.partymember.entity.PartySecretaryInfo;

@Repository
public class PartySecretaryInfoDaoImpl extends BaseDao<PartySecretaryInfo> 
	implements IPartySecretaryInfoDao {

	/**
	 * @return 书记对象
	 * @author 丁赵雷
	 * @param 书记对象
	 */
	@Override
	public PartySecretaryInfo findByAccountAndPassword(PartySecretaryInfo partySecretaryInfo) {
		String hql="form PartySecretaryInfo psi where psi.account=? and psi.password=?";
		PartySecretaryInfo psi=(PartySecretaryInfo)uniqueResult(hql, partySecretaryInfo.getAccount(),partySecretaryInfo.getPassword());
		System.out.println(psi);
		return psi;
	}
	
}
