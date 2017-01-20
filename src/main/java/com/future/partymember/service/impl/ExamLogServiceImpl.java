package com.future.partymember.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.future.partymember.dao.IExamLogDao;
import com.future.partymember.entity.ExamLog;
import com.future.partymember.service.IExamLogService;
import com.future.partymember.util.PageCut;

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
		return examLogDao.addExamLog(examLog);
	}

	@Override
	public Boolean deleteExamLog(int partyMemberId, int partySort) {
		return null;
	}

	@Override
	public Boolean updateExamLog(ExamLog examLog) {
		return null;
	}

	@Override
	public ExamLog getExamLogByTpId(int partyMemberId, int partySort, int tp_Id,int st_Id) {
		return examLogDao.getExamLogByTpId(partyMemberId, partySort, tp_Id,st_Id);
	}

	@Override
	public PageCut<ExamLog> getPC(int current, int pageSize, String search) {
		return examLogDao.getPC(current, pageSize, search);
	}

	@Override
	public boolean deleteById(int id) {
		return examLogDao.deleteById(id);
	}

	@Override
	public boolean deleteAll() {
		return examLogDao.deleteAll();
	}

	@Override
	public ExamLog getById(int id) {
		return examLogDao.getById(id);
	}


	public int grtElIdByDate(int st_Id) {		
		return examLogDao.grtElIdByDate(st_Id);
	}

	@Override
	public PageCut<ExamLog> getExamLogsBypartyMemberId(int curr, int pageSize, int partyMemberId, int partySort) {
		return examLogDao.getExamLogsBypartyMemberId(curr, pageSize, partyMemberId, partySort);
	}

	@Override
	public PageCut<ExamLog> getPC(int current, int pageSize, String search, String partyBranch) {
		return examLogDao.getPC(current, pageSize, search, partyBranch);
	}

}
