package com.future.partymember.action.manager;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.PartyMemberInfo;
import com.future.partymember.entity.PartySecretaryInfo;

public class PartMemberManagerAction extends BaseAction{
	private int page=1;
	private PartyMemberInfo partMemberInfo;
	public String execute(){
		this.getRequest().setAttribute("pc", partyMemberInfoService.getPageCut(page, 5));
		return SUCCESS;
	}
	public String delete(){
		String id=this.getRequest().getParameter("id");
		if(id==null||id.equals("")){
			return null;
		}
		PartyMemberInfo pm =partyMemberInfoService.getPartyMemberInfoById(Integer.parseInt(id));
		if(pm==null){
			return this.execute();
			
		}
		boolean flag=partyMemberInfoService.delectPartyMemberInfo(pm);
		if(flag){
			this.getRequest().setAttribute("remind", "删除成功");
		}
		return this.execute();
	}
	public String update(){
		String id=this.getRequest().getParameter("id");
		this.getRequest().setAttribute("id", id);
		return "update";
	}
	public String updateDo(){
		if(partMemberInfo==null){
			return null;
		}
		PartyMemberInfo pm=partyMemberInfoService.getPartyMemberInfoById(partMemberInfo.getPtm_Id());
		if(pm==null){
			return null;
		}
		if(partMemberInfo.getPhoneNo()!=null && partMemberInfo.getPhoneNo().length()>0){
			pm.setPhoneNo(partMemberInfo.getPhoneNo());
		}
		if(partMemberInfo.getPassword()!=null && partMemberInfo.getPassword().length()>0){
			pm.setPassword(partMemberInfo.getPassword());
		}

		partyMemberInfoService.updatePartyMemberInfo(pm);//更新个人信息
		this.getRequest().setAttribute("remind", "更新成功");

		this.getRequest().setAttribute("id", pm.getPtm_Id());
		return "update";
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public PartyMemberInfo getPartMemberInfo() {
		return partMemberInfo;
	}
	public void setPartMemberInfo(PartyMemberInfo partMemberInfo) {
		this.partMemberInfo = partMemberInfo;
	}
	
}
