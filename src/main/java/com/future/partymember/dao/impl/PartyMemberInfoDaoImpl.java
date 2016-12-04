package com.future.partymember.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IPartyMemberInfoDao;
import com.future.partymember.entity.PartyMemberInfo;
import com.future.partymember.entity.PartySecretaryInfo;

@Repository
public class PartyMemberInfoDaoImpl extends BaseDao<PartyMemberInfo> implements IPartyMemberInfoDao {

	//查询某个书记所管理的党员
	@Override
	public List<PartyMemberInfo> findAllPartyMemberInfo(PartySecretaryInfo partySecretaryInfo) {
		String hql="from PartyMemberInfo pmi where  pmi.partyBranch=?";
		List<PartyMemberInfo> list=getEntityList(hql, partySecretaryInfo.getPartyBranch());
		return list;
	}
	
	
	@Override
	public Boolean addPartyMemberInfo(PartyMemberInfo partyMemberInfo) {
		this.saveEntity(partyMemberInfo);
		return true;
	}

	@Override
	public Boolean delectPartyMemberInfo(PartyMemberInfo partyMemberInfo) {
		this.delectPartyMemberInfo(partyMemberInfo);
		return true;
	}

	@Override
	public Boolean updatePartyMemberInfo(PartyMemberInfo partyMemberInfo) {
		this.updateEntity(partyMemberInfo);
		return true;
	}

	@Override
	public PartyMemberInfo getPartyMemberInfoById(int ptm_Id) {		
		return this.getEntity(ptm_Id);
	}

	@Override
	public List<PartyMemberInfo> getAllPartyMember(List<PartyMemberInfo> partyMemberList) {
		
		return null;
	}

	@Override
	public List<PartyMemberInfo> getSomePartyMember(int first, int max,List<PartyMemberInfo> partyMemberList) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
