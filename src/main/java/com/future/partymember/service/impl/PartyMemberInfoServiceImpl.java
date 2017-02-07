package com.future.partymember.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.future.partymember.dao.IPartyMemberInfoDao;
import com.future.partymember.entity.PartyMemberInfo;
import com.future.partymember.entity.PartySecretaryInfo;
import com.future.partymember.service.IPartyMemberInfoService;
import com.future.partymember.util.PageCut;

@Service
public class PartyMemberInfoServiceImpl implements IPartyMemberInfoService{
	
	@Resource
	private IPartyMemberInfoDao partyMemberInfoDao;
	
	@Override
	public Boolean addPartyMemberInfo(PartyMemberInfo partyMemberInfo) {		
		return partyMemberInfoDao.addPartyMemberInfo(partyMemberInfo);
	}

	@Override
	public Boolean deletePartyMemberInfo(PartyMemberInfo partyMemberInfo) {		
		return partyMemberInfoDao.deletePartyMemberInfo(partyMemberInfo);
	}

	@Override
	public Boolean updatePartyMemberInfo(PartyMemberInfo partyMemberInfo) {
		
		return partyMemberInfoDao.updatePartyMemberInfo(partyMemberInfo);
	}

	@Override
	public PartyMemberInfo getPartyMemberInfoById(int ptm_Id) {		
		return partyMemberInfoDao.getPartyMemberInfoById(ptm_Id);
	}

	@Override
	public List<PartyMemberInfo> getAllPartyMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PartyMemberInfo> getSomePartyMember(int first, int max) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public PageCut<PartyMemberInfo> getPageCut(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return partyMemberInfoDao.getPageCut(currentPage, pageSize);
	}

	@Override
	public boolean exist(String account) {
		// TODO Auto-generated method stub
		return partyMemberInfoDao.exist(account);
	}

	@Override
	public PageCut<PartyMemberInfo> getPageCut(int currentPage, int pageSize, String search) {
		// TODO Auto-generated method stub
		return partyMemberInfoDao.getPageCut(currentPage, pageSize,search);
	}
	public PartyMemberInfo login(String account, String password) {		
		return partyMemberInfoDao.login(account, password);
	}

	@Override
	public PageCut<PartyMemberInfo> getPageCut(int currentPage, int pageSize, String search, String partyBranch) {
		return partyMemberInfoDao.getPageCut(currentPage, pageSize, search, partyBranch) ;
	}	
	
}
