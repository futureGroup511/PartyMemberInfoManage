package com.future.partymember.service;
import java.util.List;

/*
 * 党员信息业务层
 * @author 焦祥宇
 */
import com.future.partymember.entity.PartyMemberInfo;
import com.future.partymember.entity.PartySecretaryInfo;
import com.future.partymember.util.PageCut;

public interface IPartyMemberInfoService {
	
	//添加党员个人信息
	public Boolean addPartyMemberInfo(PartyMemberInfo partyMemberInfo);
	//删除党员个人信息
	public Boolean deletePartyMemberInfo(PartyMemberInfo partyMemberInfo);
	//修改党员个人基本信息
	public Boolean updatePartyMemberInfo(PartyMemberInfo partyMemberInfo);
	//查询党员个人信息
	public PartyMemberInfo  getPartyMemberInfoById(int ptm_Id);			
	//查询所有党员的个人信息
	public List<PartyMemberInfo> getAllPartyMember();
	//限制数量查询党员个人信息
	public List<PartyMemberInfo> getSomePartyMember(int first,int max); 

	//获取指定条件的分页对象  宋民举
	public PageCut<PartyMemberInfo> getPageCut(int currentPage,int pageSize);
	/**
	 * @param currentPage
	 * @param pageSize
	 * @param search,can be null
	 * @return
	 */
	public PageCut<PartyMemberInfo> getPageCut(int currentPage,int pageSize,String search);
	
	//用来查询某一党支部的党员
	public PageCut<PartyMemberInfo> getPageCut(int currentPage,int pageSize,String search, String partyBranch);
	//是否存在账号
	public boolean exist(String account);
	//登录
	public PartyMemberInfo login(String account,String password);
		
}
