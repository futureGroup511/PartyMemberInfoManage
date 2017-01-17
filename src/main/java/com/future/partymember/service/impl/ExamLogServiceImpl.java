package com.future.partymember.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.future.partymember.dao.IExamLogDao;
import com.future.partymember.entity.ExamLog;
import com.future.partymember.service.IExamLogService;

@Service
public class ExamLogServiceImpl implements IExamLogService{

	@Resource
	private IExamLogDao examLogDao;
	
	public IExamLogDao getExamLogDao() {
		return examLogDao;
	}

	public void setExamLogDao(IExamLogDao examLogDao) {
		this.examLogDao = examLogDao;
	}

	@Override
	public Boolean addExamLog(ExamLog examLog) {
		// TODO Auto-generated method stub
		return examLogDao.addExamLog(examLog);
	}

	@Override
	public Boolean deleteExamLog(int partyMemberId, int partySort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateExamLog(ExamLog examLog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExamLog> getAllExamLogBypartyMemberId(int partyMemberId, int partySort) {
		// TODO Auto-generated method stub
		return null;
	}

}
