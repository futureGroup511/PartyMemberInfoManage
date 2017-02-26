package com.future.partymember.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.future.partymember.dao.IPartyIntroductionDao;
import com.future.partymember.entity.PartyIntroduction;
import com.future.partymember.service.IPartyIntroductionService;

@Service
public class PartyIntroductionServiceImpl implements IPartyIntroductionService{

	@Resource
	private IPartyIntroductionDao  iPartyIntroductionDao;

	@Override
	public List<PartyIntroduction> findAll() {
		// TODO Auto-generated method stub
		return iPartyIntroductionDao.findAll();
	}

	@Override
	public boolean updatePartyIntroduction(PartyIntroduction p) {
		// TODO Auto-generated method stub
		return iPartyIntroductionDao.updatePartyIntroduction(p);
	}

}
