package com.future.partymember.dao;

import com.future.partymember.entity.StartTest;
import com.future.partymember.util.PageCut;

public interface IStartTestDao {
	public Boolean addStartTest(StartTest startTest);
	//根据试卷名称和时间获得获得考试记录id
	public int getStIdByDate(String paperName,String createDate);
	/**
	 * @param current
	 * @param pageSize
	 * @param search 搜索词，可在试卷名称中搜索，为空则不做限制
	 * @return 分页
	 * 宋民举
	 */
	PageCut<StartTest> getPC(int current,int pageSize,String search);
	boolean deleteAll();
	boolean deleteById(int id);
	StartTest getById(int id);
}
