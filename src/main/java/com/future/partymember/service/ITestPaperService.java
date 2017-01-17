package com.future.partymember.service;



import java.util.List;

import javax.crypto.interfaces.PBEKey;

import com.future.partymember.entity.TestPaper;
import com.future.partymember.util.PageCut;

/*
*@author 焦祥宇
*/
public interface ITestPaperService {
	public Boolean addTestPaper(TestPaper testPaper);
	public Boolean deleteTestPaper(int tp_Id);
	public Boolean updateTestPaper(TestPaper testPaper);
	public TestPaper getTestPaper(int tp_Id);
	public TestPaper getTestPaperByName(String paperName);
	public List<TestPaper> getAllTestPaper();
	public PageCut<TestPaper> getPC(int curr ,int pageSize);
	
	/**
	 * @param curr
	 * @param pageSize
	 * @param search
	 * @return 
	 * 根据试卷名称搜索 ，宋民举
	 */
	public PageCut<TestPaper> getPC(int curr ,int pageSize,String search);
}
