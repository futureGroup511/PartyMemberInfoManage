package com.future.partymember.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IPartySecretaryInfoDao;
import com.future.partymember.entity.PartySecretaryInfo;
import com.future.partymember.util.PageCut;

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

	@Override
	public boolean exist(String account) {
		// TODO Auto-generated method stub
		String hql="from PartySecretaryInfo p where p.account=?";
		List<PartySecretaryInfo> list=this.getEntityList(hql, account);
		if(list==null||list.isEmpty()){
			return false;
		}
		return true;
	}

	@Override
	public PageCut<PartySecretaryInfo> getPageCut(int page, int pageSize,String search) {
		// TODO Auto-generated method stub
		
		String hql ;
		int count=0;
		
		if(search ==null || search.length()==0){
			hql = "select count(*) from PartySecretaryInfo";
			count = ((Long) this.uniqueResult(hql)).intValue();
		}else{
			hql = "select count(*) from PartySecretaryInfo as p where p.account like :search or p.username like :search or p.idCard like :search";
			Query query=this.getSession().createQuery(hql);
			query.setString("search","%"+search+"%");
			
			count=((Long)query.uniqueResult()).intValue();
		}
		PageCut<PartySecretaryInfo> pc = new PageCut<PartySecretaryInfo>(page, pageSize, count);
		if(search==null || search.length()==0){
			hql="from PartySecretaryInfo";
			pc.setData(this.getEntityLimitList(hql, (page-1)*pageSize, pageSize));
		}else{
			hql="from PartySecretaryInfo as p where p.account like :search or p.username like :search or p.idCard like :search";
			Query query=this.getSession().createQuery(hql);
			query.setString("search","%"+search+"%");
			pc.setData(query.list());
		}
		return pc;
	}

	
}
