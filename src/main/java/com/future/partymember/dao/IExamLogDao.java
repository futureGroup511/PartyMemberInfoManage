package com.future.partymember.dao;

import java.util.List;

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
	public List<ExamLog> getAllExamLogBypartyMemberId(int partyMemberId,int partySort);
	//根据用户id，用户身份，试卷id获得考试总分
	public ExamLog getExamLogByTpId(int partyMemberId,int partySort,int tp_Id);

	PageCut<ExamLog> getPC(int current,int pageSize,String search);
}
