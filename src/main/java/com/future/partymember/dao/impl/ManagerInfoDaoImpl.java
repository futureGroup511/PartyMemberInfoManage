package com.future.partymember.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IManagerInfoDao;
import com.future.partymember.entity.ManagerInfo;
import com.future.partymember.entity.PartyMemberInfo;
import com.future.partymember.entity.PartySecretaryInfo;

@Repository
public class ManagerInfoDaoImpl extends BaseDao<ManagerInfo> implements IManagerInfoDao {

	@Override
	public ManagerInfo getById(int id) {
		return this.getEntity(id);
	}

	@Override
	public boolean addManager(ManagerInfo manager) {
		// TODO Auto-generated method stub
		return this.saveEntity(manager);
	}

	@Override
	public boolean updateManager(ManagerInfo manager) {
		return this.updateEntity(manager);
	}


}
