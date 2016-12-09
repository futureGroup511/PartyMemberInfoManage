package com.future.partymember.service.impl;

import java.util.List;

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

	//更新个人信息
	@Override
	public String updatePersonInfo(PartySecretaryInfo partySecretaryInfo) {
		return iPartySecretaryInfoDao.updatePersonInfo(partySecretaryInfo) ;
	}

	//根据id查找
	@Override
	public PartySecretaryInfo findById(int id) {
		return iPartySecretaryInfoDao.findById(id);
	}

	@Override
	public List<PartySecretaryInfo> getList(int first, int num) {
		// TODO Auto-generated method stub
		return iPartySecretaryInfoDao.getList(first, num);
	}

	@Override
	public void add(PartySecretaryInfo p) {
		// TODO Auto-generated method stub
		iPartySecretaryInfoDao.add(p);
	}

}
