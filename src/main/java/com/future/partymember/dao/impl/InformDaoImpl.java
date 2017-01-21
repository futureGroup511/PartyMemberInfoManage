package com.future.partymember.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IInformDao;
import com.future.partymember.entity.Inform;
import com.future.partymember.util.PageCut;
import com.opensymphony.xwork2.util.finder.ClassFinder.Info;

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
	public int getNum(String hql,Object ...objects) {
		return ((Long) this.uniqueResult(hql,objects)).intValue();
	}
	

	@Override
	public PageCut<Inform> getQuery(int curr, int pageSize, String hql , String hqlCount, Object ...objects) {
		int first=(curr-1)*pageSize;
		List<Inform> list=this.getEntityLimitList(hql, first,pageSize,objects);
		PageCut<Inform> pc=new PageCut<>(curr,pageSize,this.getNum(hqlCount,objects));
		pc.setData(list);
		return pc;	
	}
	@Override
	public PageCut<Inform> getPCByNew(int curr, int pageSize, String search) {
		// TODO Auto-generated method stub
		
		if(search == null || search.length()==0){
			return this.getPCByNew(curr, pageSize);
		}
		String hql="select count(*) from Inform as i where i.title like :search or i.content like :search";
		Query query = this.getSession().createQuery(hql);
		query.setString("search","%" + search + "%");
		int count =((Long)query.uniqueResult()).intValue();
		PageCut<Inform> pCut= new PageCut<>(curr,pageSize,count);
		if(count==0){
			return pCut;
		}
		hql="from Inform as i where i.title like :search or i.content like :search order by i.info_Id desc";
		query=this.getSession().createQuery(hql);
		query.setString("search","%"+search+ "%");
		query.setFirstResult(pageSize*curr-pageSize);
		query.setMaxResults(pageSize);
		pCut.setData(query.list());
		return pCut;
		
	}
	@Override
	public List<Inform> getNew(int size) {
		String hql="from Inform where info_tag=1 or info_tag=3 order by info_Id desc";
		
		return getEntityLimitList(hql,0,size);
	}
	


}
