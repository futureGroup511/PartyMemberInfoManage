package com.future.partymember.dao;

import com.future.partymember.entity.ManagerInfo;

public interface IManagerInfoDao {
	ManagerInfo getById(int id);
	boolean addManager(ManagerInfo manager);

	boolean updateManager(ManagerInfo manager);
}
