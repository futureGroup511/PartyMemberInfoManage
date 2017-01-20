package com.future.partymember.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IStartTestDao;
import com.future.partymember.entity.StartTest;
import com.future.partymember.util.PageCut;

@Repository
public class StartTestDaoImpl  extends BaseDao<StartTest> implements IStartTestDao {

	@Override
	public Boolean addStartTest(StartTest startTest) {
		this.saveEntity(startTest);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageCut<StartTest> getPC(int current, int pageSize, String search) {
		if(search==null|| search.length()==0){
			String hql="select count(*) from StartTest";
			int count=( (Long)this.uniqueResult(hql)).intValue();
			PageCut<StartTest> pCut=new PageCut<>(current,pageSize,count);
			
			hql="from StartTest order by id desc";
			
			pCut.setData(this.getEntityLimitList(hql, (current-1)*pageSize, pageSize));
			
			return pCut;
		}else{
			String hql="select count(*) from StartTest as st where st.paperName like :search";
			Query query=this.getSession().createQuery(hql);
			query.setString("search", "%" + search + "%");
			int count=( (Long)query.uniqueResult()).intValue();
			PageCut<StartTest> pCut=new PageCut<>(current,pageSize,count);
			hql="from StartTest as st where st.paperName like :search order by id desc";
			query=this.getSession().createQuery(hql);
			query.setString("search","%"+search+"%");
			query.setFirstResult(current*pageSize - pageSize);
			query.setMaxResults(pageSize);
			pCut.setData(query.list());	
			return pCut;
		}
	}

	@Override
	public boolean deleteById(int id) {
		return this.deleteEntity(this.getEntity(id));
	}

	@Override
	public StartTest getById(int id) {
		return this.getEntity(id);
	}

	@Override
	public boolean deleteAll() {
		String hql="delete from StartTest";
		this.executeUpdate(hql);
		return true;
	}
	public int getStIdByDate(String paperName, String createDate) {
		String hql="from StartTest s where s.paperName='"+paperName+"' and s.createDate='"+createDate+"'";
		List<StartTest> list=this.getEntityList(hql);
		if(list==null || list.size()==0){
			return 0;
		}else{
			return ((StartTest)list.toArray()[0]).getSt_Id();
		}		
	}

}
