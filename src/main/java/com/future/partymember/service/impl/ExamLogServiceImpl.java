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
	public ExamLog getExamLogByTpId(int partyMemberId, int partySort, int tp_Id,int st_Id) {
		
		return examLogDao.getExamLogByTpId(partyMemberId, partySort, tp_Id,st_Id);
	}

	@Override
	public PageCut<ExamLog> getPC(int current, int pageSize, String search) {
		// TODO Auto-generated method stub
		return examLogDao.getPC(current, pageSize, search);
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return examLogDao.deleteById(id);
	}

	@Override
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return examLogDao.deleteAll();
	}

	@Override
<<<<<<< HEAD
	public ExamLog getById(int id) {
		// TODO Auto-generated method stub
		return examLogDao.getById(id);
	}

=======
	public int grtElIdByDate(int st_Id) {		
		return examLogDao.grtElIdByDate(st_Id);
	}

	@Override
	public PageCut<ExamLog> getExamLogsBypartyMemberId(int curr, int pageSize, int partyMemberId, int partySort) {
		// TODO Auto-generated method stub
		return examLogDao.getExamLogsBypartyMemberId(curr, pageSize, partyMemberId, partySort);
	}


>>>>>>> b81875919f1806c8e2023ce29da7ddf7fc97fdfa
}
