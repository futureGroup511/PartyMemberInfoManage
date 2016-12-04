package com.future.partymember.dao;

import java.util.List;

import com.future.partymember.entity.PartyMemberInfo;
import com.future.partymember.entity.PartySecretaryInfo;

public interface IPartyMemberInfoDao {
	// 添加党员个人信息
	public Boolean addPartyMemberInfo(PartyMemberInfo partyMemberInfo);

	// 删除党员个人信息
	public Boolean delectPartyMemberInfo(PartyMemberInfo partyMemberInfo);

	// 修改党员个人基本信息
	public Boolean updatePartyMemberInfo(PartyMemberInfo partyMemberInfo);

	// 查询党员个人信息
	public PartyMemberInfo getPartyMemberInfoById(int ptm_Id);

	// 查询所有党员的个人信息
	public List<PartyMemberInfo> getAllPartyMember(List<PartyMemberInfo> partyMemberList);

	// 限制数量查询党员个人信息
	public List<PartyMemberInfo> getSomePartyMember(int first, int max,List<PartyMemberInfo> partyMemberList);

	//查询某个书记所管理的党员
	public List<PartyMemberInfo> findAllPartyMemberInfo(PartySecretaryInfo partySecretaryInfo);
}
