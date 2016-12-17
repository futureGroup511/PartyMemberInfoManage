package com.future.partymember.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.ITestPaperDao;
import com.future.partymember.entity.TestPaper;

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
	public Boolean delectTestPaper(TestPaper testPaper) {
		this.deleteEntity(testPaper);
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
	public List<TestPaper> grtAllTestPaper() {
		// TODO Auto-generated method stub
		return null;
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

}