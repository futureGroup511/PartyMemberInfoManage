package com.future.partymember.action.manager;

import java.util.Date;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.PartyMemberInfo;

import javassist.expr.NewArray;

public class PartMemberManagerAction extends BaseAction {
	private int page = 1;
	private PartyMemberInfo partyMemberInfo=new PartyMemberInfo();

	public String execute() {
		this.getRequest().setAttribute("pc", partyMemberInfoService.getPageCut(page, 5));
		return SUCCESS;
	}

	public String delete() {
		String id = this.getRequest().getParameter("id");
		if (id == null || id.equals("")) {
			return null;
		}
		PartyMemberInfo pm = partyMemberInfoService.getPartyMemberInfoById(Integer.parseInt(id));
		if (pm == null) {
			return this.execute();

		}
		boolean flag = partyMemberInfoService.delectPartyMemberInfo(pm);
		if (flag) {
			this.getRequest().setAttribute("remind", "删除成功");
		}
		return this.execute();
	}

	public String update() {
		String id = this.getRequest().getParameter("id");
		partyMemberInfo=partyMemberInfoService.getPartyMemberInfoById(Integer.parseInt(id));
		this.getRequest().setAttribute("partyMember", partyMemberInfo);
		return "update";
	}

	public String updateDo() {
		if(partyMemberInfo==null){
			return "update";
		}
		PartyMemberInfo p=partyMemberInfoService.getPartyMemberInfoById(partyMemberInfo.getPtm_Id());
		partyMemberInfo.setBirthdate(p.getBirthdate());
		partyMemberInfo.setJoinPartyDate(p.getJoinPartyDate());
		partyMemberInfo.setLoginDate(p.getLoginDate());
		partyMemberInfo.setSort(p.getSort());
		partyMemberInfo.setDuties(p.getDuties());
		partyMemberInfo.setIdAccessory(p.getIdAccessory());
		partyMemberInfo.setIntroducer(p.getIntroducer());
		partyMemberInfo.setPartyBranch(p.getPartyBranch());
		partyMemberInfoService.addPartyMemberInfo(partyMemberInfo);
		this.getRequest().setAttribute("remind", "修改成功");
		this.getRequest().setAttribute("partyMember", partyMemberInfo);
		return "update";
	}

	public String add() {
		return "add";
	}
	public String addDo() {
		if(partyMemberInfo==null){
			return "add";
		}
		Date date=new Date();
		partyMemberInfo.setBirthdate(date);
		partyMemberInfo.setJoinPartyDate(date);
		partyMemberInfo.setLoginDate(date);
		partyMemberInfo.setSort("");
		partyMemberInfo.setIdAccessory("");
		partyMemberInfoService.addPartyMemberInfo(partyMemberInfo);
		this.getRequest().setAttribute("remind", "添加成功");
		this.getRequest().setAttribute("partyMember", partyMemberInfo);
		return "add";
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public PartyMemberInfo getPartyMemberInfo() {
		return partyMemberInfo;
	}

	public void setPartyMemberInfo(PartyMemberInfo partyMemberInfo) {
		this.partyMemberInfo = partyMemberInfo;
	}



}
