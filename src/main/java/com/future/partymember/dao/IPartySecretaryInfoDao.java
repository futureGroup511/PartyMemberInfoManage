package com.future.partymember.dao;

import java.util.List;

import com.future.partymember.entity.PartyMemberInfo;
import com.future.partymember.entity.PartySecretaryInfo;

/**
 * 书记表的数据访问层接口
 * @author 丁赵雷
 */
public interface IPartySecretaryInfoDao {
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
	 * 分页查询
	 */
	public List<PartySecretaryInfo> getList(int first,int num);
	
	public void add(PartySecretaryInfo p);
	
	public boolean delete(int id);


}
