package com.future.partymember.service;

import java.util.List;

import com.future.partymember.entity.PartySecretaryInfo;

public interface IPartySecretaryInfoService {
	//根据用户名和密码查询
	public PartySecretaryInfo findByAccountAndPassword(PartySecretaryInfo partySecretaryInfo);
	//更新个人信息
	public String updatePersonInfo(PartySecretaryInfo partySecretaryInfo);
	//根据id得到书记对像
	public PartySecretaryInfo findById(int id);
	
	/**
	 * @param first
	 * @param num
	 * @return
	 * 分页获取
	 */
	public List<PartySecretaryInfo> getList(int first,int num); 
	
	/**
	 * @param p
	 * 添加
	 */
	public void add(PartySecretaryInfo p);
}
