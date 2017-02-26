package com.future.partymember.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IPartyIntroductionDao;
import com.future.partymember.entity.PartyIntroduction;

@Repository
public class PartyIntroductionDaoImpl extends BaseDao<PartyIntroduction> implements IPartyIntroductionDao {

	@Override
	public List<PartyIntroduction> findAll() {
		String hql="from PartyIntroduction";
		return this.getEntityList(hql);
	}

	@Override
	public boolean updatePartyIntroduction(PartyIntroduction p) {
		
		return this.updateEntity(p);
	}

}
