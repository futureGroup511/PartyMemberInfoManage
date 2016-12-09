package com.future.partymember.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IPartySecretaryInfoDao;
import com.future.partymember.entity.PartyMemberInfo;
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
		String hql="from PartySecretaryInfo psi where psi.account=? and psi.password=?";
		PartySecretaryInfo psi=(PartySecretaryInfo)uniqueResult(hql, partySecretaryInfo.getAccount(),partySecretaryInfo.getPassword());
		System.out.println(psi);
		return psi;
	}

	//更新个人信息
	@Override
	public String updatePersonInfo(PartySecretaryInfo partySecretaryInfo) {
		updateEntity(partySecretaryInfo);
		return null;
	}

	//根据id得到书记
	@Override
	public PartySecretaryInfo findById(int id) {
		return getEntity(id);
	}

	@Override
	public List<PartySecretaryInfo> getList(int first, int num) {
		// TODO Auto-generated method stub
		return this.getEntityLimitList("from PartySecretaryInfo", first, num);
	}

	@Override
	public void add(PartySecretaryInfo p) {
		this.saveEntity(p);
		
	}

	@Override
	public boolean delete(int id) {
		PartySecretaryInfo partySecretaryInfo=this.getEntity(id);
		if (partySecretaryInfo==null) {
			return false;
		}
		this.deleteEntity(partySecretaryInfo);
		return true;
	}

	
}
