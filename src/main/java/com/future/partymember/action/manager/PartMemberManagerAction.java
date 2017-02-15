package com.future.partymember.action.manager;

import java.util.Calendar;
import java.util.Date;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.PartyMemberInfo;
import com.future.partymember.util.PageCut;
import com.future.partymember.util.SwitchTime;

public class PartMemberManagerAction extends BaseAction {
	private int page = 1;
	private PartyMemberInfo partyMemberInfo;

	public String execute() {
		String search=(String)this.getRequest().getAttribute("search");

		PageCut<PartyMemberInfo> pCut=partyMemberInfoService.getPageCut(page,10, search);
		if( search==null || search.length()==0){
			
		}else{
			
			for(PartyMemberInfo p:pCut.getData()){
				String format="<span class=\"search\">%s</span>";
				p.setAccount(p.getAccount().replaceAll(search, String.format(format, search)));
				p.setUsername(p.getUsername().replaceAll(search, String.format(format, search)));
				p.setIdCard(p.getIdCard().replaceAll(search, String.format(format, search)));
			}
		}
		this.getRequest().setAttribute("pc", pCut);
		this.getRequest().setAttribute("search", search);
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
		boolean flag = partyMemberInfoService.deletePartyMemberInfo(pm);
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
		
		PartyMemberInfo part=partyMemberInfoService.getPartyMemberInfoById(partyMemberInfo.getPtm_Id());
		
		if( part.getAccount() !=null && (!part.getAccount().equals(partyMemberInfo.getAccount())) && partyMemberInfoService.exist(partyMemberInfo.getAccount())){
			this.getRequest().setAttribute("remind", "账号已经存在，请重新填写。");
			this.getRequest().setAttribute("partyMember", partyMemberInfoService.getPartyMemberInfoById(partyMemberInfo.getPtm_Id()));
			return "update";
		}
		
		if(partyMemberInfo.getPassword().length()<8){
			partyMemberInfo.setPassword(part.getPassword());
			this.getRequest().setAttribute("remind", "失败，密码太短");
			this.getRequest().setAttribute("partyMemberInfo", partyMemberInfoService.getPartyMemberInfoById(partyMemberInfo.getPtm_Id()));
			return "update";
		} 
		try{
			String idc=partyMemberInfo.getIdCard();
			int year=Integer.parseInt(idc.substring(6, 10));
			String birth=idc.substring(6,14);
			partyMemberInfo.setBirthdate(SwitchTime.strToDate(birth));
			int s=Integer.parseInt(idc.charAt(16)+"");
			if(s%2==0){
				partyMemberInfo.setSex("女");
			}else{
				partyMemberInfo.setSex("男");
			}
			Calendar calendar=Calendar.getInstance();
			int nowY=calendar.get(Calendar.YEAR);
			int age=nowY-year;
			partyMemberInfo.setAge(age);
			partyMemberInfo.setLoginDate(new Date());
			String dateStr=this.getRequest().getParameter("joinPartyDate").toString();
			partyMemberInfo.setJoinPartyDate(SwitchTime.strToDate(dateStr));
			partyMemberInfo.setIdAccessory("");
			partyMemberInfoService.updatePartyMemberInfo(partyMemberInfo);
		}catch(Exception e){
			e.printStackTrace();
			this.getRequest().setAttribute("remind", "请正确填写信息");
			this.getRequest().setAttribute("partyMemberInfo", partyMemberInfoService.getPartyMemberInfoById(partyMemberInfo.getPtm_Id()));
			return "update";
		}
		this.getRequest().setAttribute("remind", "更改成功");
		this.getRequest().setAttribute("partyMemberInfo", partyMemberInfoService.getPartyMemberInfoById(partyMemberInfo.getPtm_Id()));
		return "update";
	}

	public String add() {
		return "add";
	}
	public String addDo() {
		String dateStr=this.getRequest().getParameter("joinPartyDate").toString();
		if(partyMemberInfoService.exist(partyMemberInfo.getAccount())){
			this.getRequest().setAttribute("remind", "账号已经存在，请重新填写。");
			this.getRequest().setAttribute("partyMember", partyMemberInfo);
			return "add";
		}else if (partyMemberInfo.getAccount().length()>10 || partyMemberInfo.getAccount().length()<8){
			this.getRequest().setAttribute("remind", "错误，账号长度需要为8-10位");
			this.getRequest().setAttribute("partyMember", partyMemberInfo);
			return "add";
		}
		String remind = "";
		try{
			remind = "身份证填写有误";
			String idc=partyMemberInfo.getIdCard();
			int year=Integer.parseInt(idc.substring(6, 10));
			String birth=idc.substring(6,14);
			partyMemberInfo.setBirthdate(SwitchTime.strToDate(birth));
			int s=Integer.parseInt(idc.charAt(16)+"");
			if(s%2==0){
				partyMemberInfo.setSex("女");
			}else{
				partyMemberInfo.setSex("男");
			}
			Calendar calendar=Calendar.getInstance();
			int nowY=calendar.get(Calendar.YEAR);
			int age=nowY-year;
			partyMemberInfo.setAge(age);
			partyMemberInfo.setLoginDate(new Date());
			partyMemberInfo.setJoinPartyDate(SwitchTime.strToDate(dateStr));
			partyMemberInfo.setIdAccessory("");
			
			//默认密码为a123456789,存入数据库的是sha1加密后
			partyMemberInfo.setPassword("82e19fa12aab7cfc718a002fc82c0f074bf070e7");
			partyMemberInfoService.addPartyMemberInfo(partyMemberInfo);
			this.getRequest().setAttribute("remind", "添加成功");
			return "add";
		}catch(Exception e){
			this.getRequest().setAttribute("remind", remind);
			this.getRequest().setAttribute("partyMember", partyMemberInfo);
			return "add";
		}
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
