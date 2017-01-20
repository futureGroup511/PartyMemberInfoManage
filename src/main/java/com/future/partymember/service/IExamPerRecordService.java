package com.future.partymember.service;

import java.util.List;

import com.future.partymember.entity.ExamPerRecord;
import com.future.partymember.util.PageCut;

public interface IExamPerRecordService {
	public Boolean addExamPerRecord(ExamPerRecord examPerRecord);
	public Boolean deleteExamPerRecord(int pt_Id);//根据考生id删除
	public Boolean updateExamPerRecord(ExamPerRecord examPerRecord);
	//根据用户id，试卷id,用户类型和考试记录id 获得该卷的考试记录
	public List<ExamPerRecord> getExamPerRecordsByUserId(int pt_Id,int tp_Id,int el_Id,int partySort);
	//根据用户id，试卷id,用户类型和考试记录id 获得该卷的考试记录
	public List<ExamPerRecord> getExamPerRecordsByUserId(int pt_Id,int tp_Id,int partySort);	
	
	/**
	 * @param current
	 * @param pageSize
	 * @param search 搜索词，可在试卷名称，考试人名称中搜索，为空则不做限制
	 * @return 分页
	 * 宋民举
	 */
	PageCut<ExamPerRecord> getPC(int current,int pageSize,String search);
	
	boolean deleteAll();


}
