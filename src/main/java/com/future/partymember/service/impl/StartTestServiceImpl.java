package com.future.partymember.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.future.partymember.dao.IStartTestDao;
import com.future.partymember.entity.StartTest;
import com.future.partymember.service.IStartTestService;
import com.future.partymember.util.PageCut;

@Service
public class StartTestServiceImpl implements IStartTestService {
	@Resource
	private IStartTestDao startTestDao;

	public IStartTestDao getStartTestDao() {
		return startTestDao;
	}

	public void setStartTestDao(IStartTestDao startTestDao) {
		this.startTestDao = startTestDao;
	}

	@Override
	public Boolean addStartTest(StartTest startTest) {
		
		return startTestDao.addStartTest(startTest);
	}

	@Override
	public PageCut<StartTest> getPC(int current, int pageSize, String search) {
		// TODO Auto-generated method stub
		return startTestDao.getPC(current, pageSize, search);
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return startTestDao.deleteById(id);
	}

	@Override
	public StartTest getById(int id) {
		// TODO Auto-generated method stub
		return startTestDao.getById(id);
	}

	@Override

	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return startTestDao.deleteAll();
	}
	public int getStIdByDate(String paperName, String createDate) {
		
		return startTestDao.getStIdByDate(paperName, createDate);

	}
	
}
