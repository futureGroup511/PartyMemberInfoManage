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
	public Boolean delectPartyMemberInfo(PartyMemberInfo partyMemberInfo) {		
		return partyMemberInfoDao.delectPartyMemberInfo(partyMemberInfo);
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

	/**
	 * @author 丁赵雷
	 * 查询所属党员信息
	 */
	@Override
	public List<PartyMemberInfo> findAllPartyMemberInfo(PartySecretaryInfo partySecretaryInfo, 
			int curPage,int pageSize) {
		return partyMemberInfoDao.findAllPartyMemberInfo(partySecretaryInfo, curPage, pageSize);
	}

	
	/**
	 * @author 丁赵雷
	 * 初始化分页类
	 */
	@Override
	public PageCut<PartyMemberInfo> getPagerCut(int pageSize, int curPage, PartySecretaryInfo partySecretaryInfo) {
		int count=partyMemberInfoDao.getAllPartyMember(partySecretaryInfo);//记录的总数量
		PageCut<PartyMemberInfo> p=new PageCut(curPage, pageSize, count);//初始化分页类 
		return p;
	}

	@Override
	public PageCut<PartyMemberInfo> getPageCut(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return partyMemberInfoDao.getPageCut(currentPage, pageSize);
	}


	
	
}
