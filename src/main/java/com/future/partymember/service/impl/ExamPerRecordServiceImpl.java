package com.future.partymember.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.future.partymember.dao.IExamPerRecordDao;
import com.future.partymember.entity.ExamPerRecord;
import com.future.partymember.service.IExamPerRecordService;
import com.future.partymember.util.PageCut;


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
	public List<ExamPerRecord> getExamPerRecordsByUserId(int pt_Id, int tp_Id,int el_Id, int partySort) {
		// TODO Auto-generated method stub
		return examPerRecordDao.getExamPerRecordsByUserId(pt_Id, tp_Id, el_Id, partySort);
	}

	@Override
	public PageCut<ExamPerRecord> getPC(int current, int pageSize, String search) {
		// TODO Auto-generated method stub
		return examPerRecordDao.getPC(current, pageSize, search);
	}

	@Override
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return examPerRecordDao.deleteAll();
	}

	@Override
	public List<ExamPerRecord> getExamPerRecordsByUserId(int pt_Id, int tp_Id, int partySort) {
		// TODO Auto-generated method stub
		return examPerRecordDao.getExamPerRecordsByUserId(pt_Id, tp_Id, partySort);
	}

	

	
	
}
