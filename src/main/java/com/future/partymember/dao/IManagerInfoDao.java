package com.future.partymember.dao;

import java.util.List;

import com.future.partymember.entity.ManagerInfo;
import com.future.partymember.entity.PartyMemberInfo;
import com.future.partymember.entity.PartySecretaryInfo;

public interface IManagerInfoDao {
	ManagerInfo getById(int id);
	boolean addManager(ManagerInfo manager);

	boolean updateManager(ManagerInfo manager);
	ManagerInfo getByAccount(String account);


}
