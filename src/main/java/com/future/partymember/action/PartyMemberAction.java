package com.future.partymember.action;

import javax.annotation.Resource;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.PartyMemberInfo;

/*
 * 党员信息控制层
 * @author 焦祥宇
 */
public class PartyMemberAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource 
	private PartyMemberInfo partyMemberInfo;
	
	//查询党员个人信息
	/*public String getPartyMemberInfo(){
		partyMemberInfo=partyMemberInfoService.getPartyMemberInfoById(ptm_Id);
		return "getPartyMemberInfo";
	}*/
	
	//修改党员个人信息时，先获得党员信息以便修改
	public String getInfoBeforeUpdate(){
		
		return "getInfoBeforeUpdate";
	}
	
	//修改党员个人基本信息
	public String updatePartyMemberInfo(){
		
		return "updatePartyMemberInfo";
	}
	
	/*//修改密码
	public String updatePwd(){
		
		return "updatePwd";
	}*/
}
