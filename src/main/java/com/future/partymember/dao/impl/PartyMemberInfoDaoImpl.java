package com.future.partymember.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IPartyMemberInfoDao;
import com.future.partymember.entity.PartyMemberInfo;
import com.future.partymember.entity.PartySecretaryInfo;
import com.future.partymember.util.PageCut;

@Repository
public class PartyMemberInfoDaoImpl extends BaseDao<PartyMemberInfo> implements IPartyMemberInfoDao {

	/**
	 * 查询某个书记所管理的党员 丁赵雷
	 */
	@Override
	public List<PartyMemberInfo> findAllPartyMemberInfo(PartySecretaryInfo partySecretaryInfo, int curPage,
			int pageSize) {
		String hql = "from PartyMemberInfo pmi where  pmi.partyBranch=?";
		List<PartyMemberInfo> list = getEntityLimitList(hql, curPage, pageSize, partySecretaryInfo.getPartyBranch());
		return list;
	}

	 //执行限制数量的hql 丁赵雷 
	protected List<PartyMemberInfo> getEntityLimitList(String hql, int curPage, int pageSize, Object... objects) {
		Query query = this.getSession().createQuery(hql);
		for (int i = 0; i < objects.length; i++) {
			query.setParameter(i, objects[i]);
		}
		query.setFirstResult(pageSize * (curPage - 1));
		query.setMaxResults(pageSize);
		return query.list();
	}

	// 得到某个书记所管理的党员的数量以便分页查询 丁赵雷
	@Override
	public int getAllPartyMember(PartySecretaryInfo partySecretaryInfo) {
		String hql = "from PartyMemberInfo pmi where  pmi.partyBranch=?";
		List<PartyMemberInfo> list = getEntityList(hql, partySecretaryInfo.getPartyBranch());
		return list.size();
	}

	@Override
	public Boolean addPartyMemberInfo(PartyMemberInfo partyMemberInfo) {
		this.saveEntity(partyMemberInfo);
		return true;
	}

	@Override
	public Boolean deletePartyMemberInfo(PartyMemberInfo partyMemberInfo) {
		this.deleteEntity(this.getEntity(partyMemberInfo.getPtm_Id()));
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
	public List<PartyMemberInfo> getSomePartyMember(int first, int max, List<PartyMemberInfo> partyMemberList) {
		return null;
	}

	@Override
	public PageCut<PartyMemberInfo> getPageCut(int currentPage, int pageSize) {
		String hql = "select count(*) from PartyMemberInfo";
		int count = ((Long) this.uniqueResult(hql)).intValue();
		PageCut<PartyMemberInfo> pc = new PageCut<PartyMemberInfo>(currentPage, pageSize, count);
		pc.setData(this.getEntityLimitList("from PartyMemberInfo", (currentPage-1)*pageSize, pageSize));
		return pc;
	}

	@Override
	public boolean exist(String account) {
		// TODO Auto-generated method stub
		String hql="from PartyMemberInfo p where p.account=?";
		List list=this.getEntityList(hql, account);
		if(list==null||list.isEmpty()){
			return false;
		}
		return true;
	}

	@Override
	public PageCut<PartyMemberInfo> getPageCut(int page, int pageSize, String search) {
		// TODO Auto-generated method stub
		String hql ;
		int count=0;
		
		if(search ==null || search.length()==0){
			hql = "select count(*) from PartyMemberInfo";
			count = ((Long) this.uniqueResult(hql)).intValue();
		}else{
			hql = "select count(*) from PartyMemberInfo as p where p.account like :search or p.username like :search or p.idCard like :search";
			Query query=this.getSession().createQuery(hql);
			query.setString("search","%"+search+"%");
			
			count=((Long)query.uniqueResult()).intValue();
		}
		PageCut<PartyMemberInfo> pc = new PageCut<PartyMemberInfo>(page, pageSize, count);
		if(search==null || search.length()==0){
			hql="from PartyMemberInfo";
			pc.setData(this.getEntityLimitList(hql, (page-1)*pageSize, pageSize));
		}else{
			hql="from PartyMemberInfo as p where p.account like :search or p.username like :search or p.idCard like :search";
			Query query=this.getSession().createQuery(hql);
			query.setString("search","%"+search+"%");
			query.setFirstResult((page-1)*pageSize);
			query.setMaxResults(pageSize);
			pc.setData(query.list());
		}
		return pc;
	}

	public PartyMemberInfo login(String account, String password) {
		String hql="from PartyMemberInfo p where p.account='"+account+"' and p.password='"+password+"'";
		
		return (PartyMemberInfo)this.uniqueResult(hql);
	}

	//书记所用 丁赵雷
	@Override
	public PageCut<PartyMemberInfo> getPageCut(int currentPage, int pageSize, String search, String partyBranch) {
		String hql ;
		int count=0;
		
		if(search ==null || search.length()==0){
			hql = "select count(*) from PartyMemberInfo p where p.partyBranch=?";
			count = ((Long) this.uniqueResult(hql,partyBranch)).intValue();
		}else{
			hql = "select count(*) from PartyMemberInfo as p "
					+ "where p.partyBranch=? and p.account like :search or p.username like :search or p.idCard like :search";
			Query query=this.getSession().createQuery(hql);
			query.setParameter(0,partyBranch);
			query.setString("search","%"+search+"%");
			
			count=((Long)query.uniqueResult()).intValue();
		}
		
		
		PageCut<PartyMemberInfo> pc = new PageCut<PartyMemberInfo>(currentPage, pageSize, count);
		if(search==null || search.length()==0){
			hql="from PartyMemberInfo p where p.partyBranch=?";
			pc.setData(this.getEntityLimitList(hql, currentPage, pageSize, partyBranch));
		}else{
			hql="from PartyMemberInfo as p where p.partyBranch=? and "
					+ "p.phoneNo like :search or p.username like :search "
					+ "or p.nativePlace like :search  or p.nation like :search";
			Query query=this.getSession().createQuery(hql);
			query.setParameter(0,partyBranch);
			query.setString("search","%"+search+"%");
			query.setFirstResult((currentPage-1)*pageSize);
			query.setMaxResults(pageSize);
			pc.setData(query.list());
		}
		return pc;
	}
}
