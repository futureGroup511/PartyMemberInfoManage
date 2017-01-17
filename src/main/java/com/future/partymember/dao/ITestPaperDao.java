package com.future.partymember.dao;



import java.util.List;

import com.future.partymember.entity.TestPaper;
import com.future.partymember.util.PageCut;

/*
*@author 焦祥宇
*/
public interface ITestPaperDao {
	public Boolean addTestPaper(TestPaper testPaper);
	public Boolean deleteTestPaper(int tp_Id);
	public Boolean updateTestPaper(TestPaper testPaper);
	public TestPaper getTestPaper(int tp_Id);
	public TestPaper getTestPaperByName(String paperName);
	public List<TestPaper> getAllTestPaper();
	public PageCut<TestPaper> getPC(int curr ,int pageSize);
	
	public PageCut<TestPaper> getPC(int curr ,int pageSize,String search);
}
