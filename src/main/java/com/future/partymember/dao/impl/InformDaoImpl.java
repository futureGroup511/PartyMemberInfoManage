package com.future.partymember.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IInformDao;
import com.future.partymember.entity.Inform;
import com.future.partymember.util.PageCut;

@Repository
public class InformDaoImpl extends BaseDao<Inform> implements IInformDao {

	@Override
	public void addInform(Inform inform) {
		this.saveEntity(inform);
		
	}
	public int getNum() {
		String hql="select count(*) from Inform";
		return ((Long) this.uniqueResult(hql)).intValue();
	}

	@Override
	public void updateInform(Inform inform) {
		this.updateEntity(inform);
	}

	@Override
	public void deleteInform(int id) {
		Inform inform=this.getEntity(id);
		if(inform==null){
			return;
		}
		this.deleteEntity(inform);
	}

	@Override
	public PageCut<Inform> getPCByNew(int curr, int pageSize) {
		int first=(curr-1)*pageSize;
		List<Inform> list=this.getEntityLimitList("from Inform order by info_Id desc", first,pageSize);
		PageCut<Inform> pc=new PageCut<>(curr,pageSize,this.getNum());
		pc.setData(list);
		return pc;	
	}
	@Override
	public Inform getById(int id) {
		return this.getEntity(id);
	}

	
	//根据相应的hql语句获得结果集的数量
	public int getNum(String hql) {
		return ((Long) this.uniqueResult(hql)).intValue();
	}
	

	@Override
	public PageCut<Inform> getQuery(int curr, int pageSize, String hql , String hqlCount) {
		int first=(curr-1)*pageSize;
		List<Inform> list=this.getEntityLimitList(hql, first,pageSize);
		PageCut<Inform> pc=new PageCut<>(curr,pageSize,this.getNum(hqlCount));
		pc.setData(list);
		return pc;	
	}
	


}
