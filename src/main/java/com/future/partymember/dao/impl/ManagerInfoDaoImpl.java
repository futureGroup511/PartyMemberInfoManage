package com.future.partymember.dao.impl;

import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IManagerInfoDao;
import com.future.partymember.entity.ManagerInfo;

@Repository
public class ManagerInfoDaoImpl extends BaseDao<ManagerInfo> implements IManagerInfoDao {

	@Override
	public ManagerInfo getById(int id) {
		return this.getEntity(id);
	}

}
