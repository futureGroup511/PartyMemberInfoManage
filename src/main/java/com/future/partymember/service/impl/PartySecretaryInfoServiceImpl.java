package com.future.partymember.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.future.partymember.dao.IPartySecretaryInfoDao;
import com.future.partymember.entity.PartySecretaryInfo;
import com.future.partymember.service.IPartySecretaryInfoService;

@Service
public class PartySecretaryInfoServiceImpl implements IPartySecretaryInfoService{
	
	@Resource
	private IPartySecretaryInfoDao iPartySecretaryInfoDao;
	
	
	@Override
	public PartySecretaryInfo findByAccountAndPassword(PartySecretaryInfo partySecretaryInfo) {
		return iPartySecretaryInfoDao.findByAccountAndPassword(partySecretaryInfo);
	}

}
