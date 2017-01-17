package com.future.partymember.dao;

import java.util.List;

import com.future.partymember.entity.ExamPerRecord;

public interface IExamPerRecordDao {
	public Boolean addExamPerRecord(ExamPerRecord examPerRecord);
	public Boolean deleteExamPerRecord(int pt_Id);//根据考生id删除
	public Boolean updateExamPerRecord(ExamPerRecord examPerRecord);
	//根据用户id和试卷id获得该卷的考试记录
	public List<ExamPerRecord> getExamPerRecordsByUserId(int userId,int tp_Id);

}
