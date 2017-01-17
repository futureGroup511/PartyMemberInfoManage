package com.future.partymember.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.ITestPaperDao;
import com.future.partymember.entity.Question;
import com.future.partymember.entity.TestPaper;
import com.future.partymember.util.PageCut;

/*
*@author 焦祥宇
*/
@Repository
public class TestPaperDaoImpl extends BaseDao<TestPaper> implements ITestPaperDao {

	@Override
	public Boolean addTestPaper(TestPaper testPaper) {
		 this.saveEntity(testPaper);
		return true;
	}

	@Override
	public Boolean deleteTestPaper(int tp_Id) {
		String hql="delete from TestPaper tp where tp.tp_Id="+tp_Id;
		this.executeUpdate(hql);
		return true;
	}

	@Override
	public Boolean updateTestPaper(TestPaper testPaper) {
		this.updateEntity(testPaper);
		return true;
	}

	@Override
	public TestPaper getTestPaper(int tp_Id) {
		// TODO Auto-generated method stub
		return this.getEntity(tp_Id);
	}

	

	@Override
	public TestPaper getTestPaperByName(String paperName) {
		String hql="from TestPaper t where t.paperName='"+paperName+"'";	
		List<TestPaper> list=this.getEntityList(hql);
		if(list.size()>0){
			return (TestPaper)list.toArray()[0];
		}
		else{
			return null;
		}
	}

	@Override
	public PageCut<TestPaper> getPC(int curr, int pageSize) {
		PageCut<TestPaper> pageCut=new PageCut<>(curr,pageSize,this.getNum());
		pageCut.setData(this.getEntityLimitList("from TestPaper",(curr-1)*pageSize,pageSize));
		return pageCut;
		
	}

	@Override
	public List<TestPaper> getAllTestPaper() {
		// TODO Auto-generated method stub
		String hql="from TestPaper";
		return this.getEntityList(hql);
	}

	@Override
	public PageCut<TestPaper> getPC(int curr, int pageSize, String search) {
		// TODO Auto-generated method stub
		if(search==null || search.length()==0){
			return this.getPC(curr, pageSize);
		}
		
		String hql = "select count(*) from TestPaper as t where t.paperName like :search";
		Query query=this.getSession().createQuery(hql);
		query.setString("search","%"+search+"%");
		int count=((Long)query.uniqueResult()).intValue();
		
		hql= "from TestPaper as t where t.paperName like :search";
		query=this.getSession().createQuery(hql);
		query.setString("search","%"+search+"%");
		
		query.setFirstResult((curr-1)*pageSize);
		query.setMaxResults(pageSize);
		PageCut<TestPaper> pCut=new PageCut<>(curr,
				pageSize,count);
		pCut.setData(query.list());
		return pCut;
	}

}
