package com.future.partymember.dao.impl;

import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IStartTestDao;
import com.future.partymember.entity.StartTest;

@Repository
public class StartTestDaoImpl  extends BaseDao<StartTest> implements IStartTestDao {

	@Override
	public Boolean addStartTest(StartTest startTest) {
		this.saveEntity(startTest);
		return true;
	}

}
