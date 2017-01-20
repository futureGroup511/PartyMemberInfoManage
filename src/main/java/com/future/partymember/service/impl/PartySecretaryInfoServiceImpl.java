package com.future.partymember.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.future.partymember.dao.IPartySecretaryInfoDao;
import com.future.partymember.entity.PartySecretaryInfo;
import com.future.partymember.service.IPartySecretaryInfoService;
import com.future.partymember.util.PageCut;

@Service
public class PartySecretaryInfoServiceImpl implements IPartySecretaryInfoService{
	
	@Resource
	private IPartySecretaryInfoDao iPartySecretaryInfoDao;
	
	
	@Override
	public PartySecretaryInfo findByAccountAndPassword(String account,String password) {
		return iPartySecretaryInfoDao.findByAccountAndPassword(account, password);
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

	@Override
	public boolean delete(int id) {
		return iPartySecretaryInfoDao.delete(id);
		
	}

	@Override
	public boolean exist(String account) {
		// TODO Auto-generated method stub
		return iPartySecretaryInfoDao.exist(account);
	}

	@Override
	public PageCut<PartySecretaryInfo> getPageCut(int page, int pageSize,String search) {
		// TODO Auto-generated method stub
		return iPartySecretaryInfoDao.getPageCut(page, pageSize,search);
	}

}
