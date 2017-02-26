package com.future.partymember.action.manager;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.PartyIntroduction;

/**
 * 修改党委简介
 * @author 丁赵雷
 *
 */
public class PartyIntroductionAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//转发到修改页面
	public String update(){
		if(partyIntroductionService.findAll().size()>0){
			this.getRequest().setAttribute("partyIntroduction",partyIntroductionService.findAll().get(0) );
		}else{
			this.getRequest().setAttribute("notice", "暂时无任何内容");
		}
		
		return "update";
	}
	
	//修改
	public String updateDo(){
		String introduction =this.getRequest().getParameter("introduction");
		System.out.println("党委简介"+introduction);
		if(introduction!=null&&!introduction.equals("")){
			
			if(partyIntroductionService.findAll().size()>0){
				PartyIntroduction partyIntroduction=partyIntroductionService.findAll().get(0);
				partyIntroduction.setIntroduction(introduction);
				partyIntroductionService.updatePartyIntroduction(partyIntroduction);
				this.getRequest().setAttribute("partyIntroduction",partyIntroductionService.findAll().get(0));
				this.getRequest().setAttribute("notice", "修改成功");
			}else{
				this.getRequest().setAttribute("notice", "修改失败");
			}
		}else{
			this.getRequest().setAttribute("notice", "修改失败");
		}
		
		return "update";
	}
}
