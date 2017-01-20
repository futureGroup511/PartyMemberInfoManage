package com.future.partymember.service;

import java.util.List;

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
	public List<ExamLog> getAllExamLogBypartyMemberId(int partyMemberId,int partySort);

	//根据用户id，用户身份，试卷id获得考试总分
	public ExamLog getExamLogByTpId(int partyMemberId,int partySort,int tp_Id);
	
	
	/**
	 * @param current
	 * @param pageSize
	 * @param search 搜索词，可在试卷名称，考试人名称中搜索，为空则不做限制
	 * @return 分页
	 * 宋民举
	 */
	PageCut<ExamLog> getPC(int current,int pageSize,String search);

}
