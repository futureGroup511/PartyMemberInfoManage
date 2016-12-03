package com.future.partymember.action.secretary;


import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.PartySecretaryInfo;
/**
 * 书记的转发类
 * @author 丁赵雷
 *
 */
public class PSForwardAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PartySecretaryInfo  partySecretaryInfo;//书记实体类
	
	
	public String pSForward_login() throws Exception{
		
		if(partySecretaryInfoService.findByAccountAndPassword(partySecretaryInfo)!=null){
			getRequest().getSession().setAttribute("", value);
		}
		
		return "login";
	}
	

	
	
	/***************get******set******************************************************************/
	public PartySecretaryInfo getPartySecretaryInfo() {
		return partySecretaryInfo;
	}
	public void setPartySecretaryInfo(PartySecretaryInfo partySecretaryInfo) {
		this.partySecretaryInfo = partySecretaryInfo;
	}

}
