package com.future.partymember.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.future.partymember.dao.ITestPaperDao;
import com.future.partymember.entity.TestPaper;
/*
*@author 焦祥宇
*/
import com.future.partymember.service.ITestPaperService;
import com.future.partymember.util.PageCut;


@Service
public class TestPaperServiceImpl implements ITestPaperService {

	@Resource
	private ITestPaperDao testPaperDao;
	
	@Override
	public Boolean addTestPaper(TestPaper testPaper) {
		// TODO Auto-generated method stub
		return testPaperDao.addTestPaper(testPaper);
	}

	@Override
	public Boolean deleteTestPaper(int tp_Id) {
		// TODO Auto-generated method stub
		return testPaperDao.deleteTestPaper(tp_Id);
	}

	@Override
	public Boolean updateTestPaper(TestPaper testPaper) {
		// TODO Auto-generated method stub
		return testPaperDao.updateTestPaper(testPaper);
	}

	@Override
	public TestPaper getTestPaper(int tp_Id) {
		// TODO Auto-generated method stub
		return testPaperDao.getTestPaper(tp_Id);
	}

	

	@Override
	public TestPaper getTestPaperByName(String paperName) {
		// TODO Auto-generated method stub
		TestPaper testPaper=testPaperDao.getTestPaperByName(paperName);
		
		return testPaper ;
	}

	@Override
	public PageCut<TestPaper> getPC(int curr, int pageSize) {
		// TODO Auto-generated method stub
		return testPaperDao.getPC(curr, pageSize);
	}

	@Override
	public List<TestPaper> getAllTestPaper() {
		// TODO Auto-generated method stub
		return testPaperDao.getAllTestPaper();
	}

	@Override
	public PageCut<TestPaper> getPC(int curr, int pageSize, String search) {
		// TODO Auto-generated method stub
		return testPaperDao.getPC(curr, pageSize, search);
	}

}
