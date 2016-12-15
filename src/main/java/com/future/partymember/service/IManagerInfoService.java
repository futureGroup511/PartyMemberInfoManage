package com.future.partymember.service;

import com.future.partymember.entity.ManagerInfo;

public interface IManagerInfoService {
	ManagerInfo getById(int id);
	boolean addManager(ManagerInfo manager);
	boolean updateManager(ManagerInfo manager);
	ManagerInfo getByAccount(String account);
}
