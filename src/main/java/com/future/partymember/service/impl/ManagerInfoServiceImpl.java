package com.future.partymember.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.future.partymember.dao.IManagerInfoDao;
import com.future.partymember.entity.ManagerInfo;
import com.future.partymember.service.IManagerInfoService;

@Service
public class ManagerInfoServiceImpl implements IManagerInfoService{

	@Resource
	private IManagerInfoDao managerDao;
	@Override
	public ManagerInfo getById(int id) {
		// TODO Auto-generated method stub
		return managerDao.getById(id);
	}
	@Override
	public boolean addManager(ManagerInfo manager) {
		// TODO Auto-generated method stub
		return managerDao.addManager(manager);
	}
	@Override
	public boolean updateManager(ManagerInfo manager) {
		// TODO Auto-generated method stub
		return managerDao.updateManager(manager);
	}
	@Override
	public ManagerInfo getByAccount(String account) {
		// TODO Auto-generated method stub
		return managerDao.getByAccount(account);
	}

}
