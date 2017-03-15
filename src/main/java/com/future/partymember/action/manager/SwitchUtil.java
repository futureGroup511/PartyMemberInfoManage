package com.future.partymember.action.manager;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.PartyMemberInfo;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

public class SwitchUtil extends BaseAction{
	public String execute(){
		
		int id = 1;
		while(true){
			PartyMemberInfo party =partyMemberInfoService.getPartyMemberInfoById(id);
			if(party == null){
				break;
			}
			String result = "";
			try {
				result = PinyinHelper.convertToPinyinString(party.getUsername(),"", PinyinFormat.WITHOUT_TONE);
				result +="1234";
			} catch (PinyinException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			party.setAccount(result);
			partyMemberInfoService.updatePartyMemberInfo(party);
			id ++;
		}
		this.getRequest().setAttribute("remind", id);
		
		return SUCCESS;
		
	}
}
