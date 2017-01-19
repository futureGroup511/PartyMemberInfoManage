package com.future.partymember.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.future.partymember.dao.IStartTestDao;
import com.future.partymember.entity.StartTest;
import com.future.partymember.service.IStartTestService;

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
	
}
