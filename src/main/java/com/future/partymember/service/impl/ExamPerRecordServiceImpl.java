package com.future.partymember.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.future.partymember.dao.IExamPerRecordDao;
import com.future.partymember.entity.ExamPerRecord;
import com.future.partymember.service.IExamPerRecordService;


@Service
public class ExamPerRecordServiceImpl implements IExamPerRecordService {
	@Resource
	private IExamPerRecordDao examPerRecordDao;

	public IExamPerRecordDao getExamPerRecordDao() {
		return examPerRecordDao;
	}

	public void setExamPerRecordDao(IExamPerRecordDao examPerRecordDao) {
		this.examPerRecordDao = examPerRecordDao;
	}

	@Override
	public Boolean addExamPerRecord(ExamPerRecord examPerRecord) {
		
		return examPerRecordDao.addExamPerRecord(examPerRecord);
	}

	@Override
	public Boolean deleteExamPerRecord(int pt_Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateExamPerRecord(ExamPerRecord examPerRecord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExamPerRecord> getExamPerRecordsByUserId(int userId, int tp_Id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
