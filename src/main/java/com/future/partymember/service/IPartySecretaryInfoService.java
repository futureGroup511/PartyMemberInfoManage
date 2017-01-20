package com.future.partymember.service;

import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.future.partymember.entity.PartySecretaryInfo;
import com.future.partymember.util.PageCut;

public interface IPartySecretaryInfoService {
	//根据用户名和密码查询
	public PartySecretaryInfo findByAccountAndPassword(String account,String password);
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
	
	/**
	 * @param id
	 * 删除
	 */
	public boolean delete(int id);
	
	public boolean exist(String account);//是否存在账号
	
	
	/**
	 * @param page
	 * @param pageSize
	 * @return 分页对象
	 * song
	 */
	PageCut<PartySecretaryInfo> getPageCut(int page,int pageSize,String search);
}
