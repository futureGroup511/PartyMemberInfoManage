package com.future.partymember.service;

import java.util.List;

import com.future.partymember.entity.ExamPerRecord;

public interface IExamPerRecordService {
	public Boolean addExamPerRecord(ExamPerRecord examPerRecord);
	public Boolean deleteExamPerRecord(int pt_Id);//根据考生id删除
	public Boolean updateExamPerRecord(ExamPerRecord examPerRecord);
	//根据用户id，试卷id和用户类型获得该卷的考试记录
	public List<ExamPerRecord> getExamPerRecordsByUserId(int pt_Id,int tp_Id,int partySort);

}
