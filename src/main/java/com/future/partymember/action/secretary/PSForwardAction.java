package com.future.partymember.action.secretary;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.PartySecretaryInfo;
/**
 * 书记的转发类
 * @author 丁赵雷
 *
 */
@Controller(value="pSForwardAction")
@Scope("prototype")
public class PSForwardAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PartySecretaryInfo  partySecretaryInfo;//书记实体类
	
	
	public String login() throws Exception{
		//判断登录
		if((partySecretaryInfo=partySecretaryInfoService.
				findByAccountAndPassword(partySecretaryInfo))!=null){
			
			session.put("secretary",partySecretaryInfo);
			return "login";
		}else{
			return "error";
		}
	}
	

	
	
	/***************get******set******************************************************************/
	public PartySecretaryInfo getPartySecretaryInfo() {
		return partySecretaryInfo;
	}
	public void setPartySecretaryInfo(PartySecretaryInfo partySecretaryInfo) {
		this.partySecretaryInfo = partySecretaryInfo;
	}

}
