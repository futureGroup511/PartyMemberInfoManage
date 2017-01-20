package com.future.partymember.dao;

import com.future.partymember.entity.ExamLog;
import com.future.partymember.util.PageCut;

public interface IExamLogDao{
	
	boolean deleteById(int id);
	boolean deleteAll();
	ExamLog getById(int id);
	
	public Boolean addExamLog(ExamLog examLog);
	//根据用户id和身份删除考试记录
	public Boolean deleteExamLog(int partyMemberId,int partySort);
	public Boolean updateExamLog(ExamLog examLog);
	//根据用户id和身份获得考试记录
	public PageCut<ExamLog> getExamLogsBypartyMemberId(int curr ,int pageSize,int partyMemberId,int partySort);
	//根据用户id，用户身份，试卷id,考试记录id获得考试总分
	public ExamLog getExamLogByTpId(int partyMemberId,int partySort,int tp_Id,int st_Id);
	//根据开启试卷记录st_Id获得考试记录的id
	public int grtElIdByDate(int st_Id);
	
	PageCut<ExamLog> getPC(int current,int pageSize,String search);
	//书记专用
	PageCut<ExamLog> getPC(int current,int pageSize,String search , String partyBranch);
}
