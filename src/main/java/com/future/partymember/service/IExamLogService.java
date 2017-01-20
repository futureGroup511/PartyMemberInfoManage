package com.future.partymember.service;


import com.future.partymember.entity.ExamLog;
import com.future.partymember.util.PageCut;

public interface IExamLogService {
	public Boolean addExamLog(ExamLog examLog);
	
	/**
	 * @param id
	 * @return
	 * 删除单个记录，宋
	 */
	boolean deleteById(int id);
	ExamLog getById(int id);
	
	boolean deleteAll();
	
	//根据用户id和身份删除考试记录
	public Boolean deleteExamLog(int partyMemberId,int partySort);
	public Boolean updateExamLog(ExamLog examLog);
	//根据用户id和身份获得考试记录
	public PageCut<ExamLog> getExamLogsBypartyMemberId(int curr ,int pageSize,int partyMemberId,int partySort);

	//根据用户id，用户身份，试卷id,考试记录id获得考试总分
	public ExamLog getExamLogByTpId(int partyMemberId,int partySort,int tp_Id,int st_Id);
	//根据开启试卷记录st_Id获得考试记录的id
	public int grtElIdByDate(int st_Id);
	
	/**
	 * @param current
	 * @param pageSize
	 * @param search 搜索词，可在试卷名称，考试人名称中搜索，为空则不做限制
	 * @return 分页
	 * 宋民举
	 */
	PageCut<ExamLog> getPC(int current,int pageSize,String search);
	
	//书记专用  搜索所属党员的考试记录
	PageCut<ExamLog> getPC(int current,int pageSize,String search, String partyBranch);

}
