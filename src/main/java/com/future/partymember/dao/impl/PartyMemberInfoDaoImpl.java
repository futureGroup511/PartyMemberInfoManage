package com.future.partymember.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IPartyMemberInfoDao;
import com.future.partymember.entity.PartyMemberInfo;
import com.future.partymember.entity.PartySecretaryInfo;

@Repository
public class PartyMemberInfoDaoImpl extends BaseDao<PartyMemberInfo> implements IPartyMemberInfoDao {

	/**
	 * 查询某个书记所管理的党员  丁赵雷
	 */
	@Override
	public List<PartyMemberInfo> findAllPartyMemberInfo(PartySecretaryInfo partySecretaryInfo,
			int curPage,int pageSize) {
		String hql="from PartyMemberInfo pmi where  pmi.partyBranch=?";
		List<PartyMemberInfo> list=getEntityLimitList(hql, curPage,pageSize,partySecretaryInfo.getPartyBranch());
		return list;
	}
	
	/*执行限制数量的hql 丁赵雷*/
	protected List<PartyMemberInfo> getEntityLimitList(String hql,int curPage,int pageSize,
			Object ...objects){
		Query query=this.getSession().createQuery(hql);
		for(int i=0;i<objects.length;i++){
			query.setParameter(i, objects[i]);
		}
		query.setFirstResult(pageSize*(curPage-1));
		query.setMaxResults(pageSize);
		return query.list();
	}
	
	//得到某个书记所管理的党员的数量以便分页查询  丁赵雷
	@Override
	public int getAllPartyMember(PartySecretaryInfo partySecretaryInfo) {
		String hql="from PartyMemberInfo pmi where  pmi.partyBranch=?";
		List<PartyMemberInfo> list=getEntityList(hql, partySecretaryInfo.getPartyBranch());
		return list.size();
	}
	
	
	@Override
	public Boolean addPartyMemberInfo(PartyMemberInfo partyMemberInfo) {
		this.saveEntity(partyMemberInfo);
		return true;
	}

	@Override
	public Boolean delectPartyMemberInfo(PartyMemberInfo partyMemberInfo) {
		this.deleteEntity(partyMemberInfo);
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
