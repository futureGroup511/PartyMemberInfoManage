package com.future.partymember.action.manager;


import java.util.Calendar;
import java.util.Date;

import javax.print.attribute.ResolutionSyntax;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.PartySecretaryInfo;
import com.future.partymember.util.PageCut;
import com.future.partymember.util.SwitchTime;
/*
*@auther:宋民举
*@mail:860080937@qq.com
*@Date:2016年12月4日,下午3:32:21
*@Descritpion:
*/
public class PartSecretaryManagerAction extends BaseAction {
	
	private static final long serialVersionUID = 1L;
	private int page=1;
	private PartySecretaryInfo partySecretaryInfo;
	public String execute(){
		PageCut<PartySecretaryInfo> pageCut=new PageCut<>(page, 5, 213);
		pageCut.setData(partySecretaryInfoService.getList((page-1)*pageCut.getPageSize(), pageCut.getPageSize()));
		this.getRequest().setAttribute("pageCut", pageCut);
		return SUCCESS;
	}
	
	public String add(){
		return "add";
	}
	public String addDo(){
		String dateStr=this.getRequest().getParameter("joinPartyDate").toString();
		this.getRequest().setAttribute("dateStr", dateStr);
		if(partySecretaryInfoService.exist(partySecretaryInfo.getAccount())){
			this.getRequest().setAttribute("remind", "账号已经存在，请重新填写。");
			this.getRequest().setAttribute("partySecretaryInfo", partySecretaryInfo);
			return "add";
		}
		try{
			String idc=partySecretaryInfo.getIdCard();
			int year=Integer.parseInt(idc.substring(6, 10));
			String birth=idc.substring(6,14);
			partySecretaryInfo.setBirthdate(SwitchTime.strToDate(birth));
			int s=Integer.parseInt(idc.charAt(16)+"");
			if(s%2==0){
				partySecretaryInfo.setSex("女");
			}else{
				partySecretaryInfo.setSex("男");
			}
			Calendar calendar=Calendar.getInstance();
			int nowY=calendar.get(Calendar.YEAR);
			int age=nowY-year;
			partySecretaryInfo.setAge(age);
			partySecretaryInfo.setLoginDate(new Date());
			partySecretaryInfo.setJoinPartyDate(SwitchTime.strToDate(dateStr));
			
			partySecretaryInfoService.add(partySecretaryInfo);
			this.getRequest().setAttribute("remind", "添加成功");
			this.getRequest().removeAttribute("dateStr");
			return "add";
		}catch(Exception e){
			this.getRequest().setAttribute("remind", "填写的数据有误,请重新填写.");
			this.getRequest().setAttribute("partySecretaryInfo", partySecretaryInfo);
			return "add";
		}
		
	}
	public String update() {
		String id=this.getRequest().getParameter("id");
		this.getRequest().setAttribute("partySecretaryInfo", partySecretaryInfoService.findById(Integer.parseInt(id)));
		return "update";
	}
	public String updateDo(){
		
		PartySecretaryInfo p=partySecretaryInfoService.findById(partySecretaryInfo.getPst_Id());
		
		if(!(p.getAccount().equals(partySecretaryInfo.getAccount())) && partySecretaryInfoService.exist(partySecretaryInfo.getAccount())){
			this.getRequest().setAttribute("remind", "账号已经存在，请重新填写。");
			this.getRequest().setAttribute("partySecretaryInfo", partySecretaryInfoService.findById(partySecretaryInfo.getPst_Id()));
			return "update";
		}
		try{
			String idc=partySecretaryInfo.getIdCard();
			int year=Integer.parseInt(idc.substring(6, 10));
			String birth=idc.substring(6,14);
			partySecretaryInfo.setBirthdate(SwitchTime.strToDate(birth));
			int s=Integer.parseInt(idc.charAt(16)+"");
			if(s%2==0){
				partySecretaryInfo.setSex("女");
			}else{
				partySecretaryInfo.setSex("男");
			}
			Calendar calendar=Calendar.getInstance();
			int nowY=calendar.get(Calendar.YEAR);
			int age=nowY-year;
			partySecretaryInfo.setAge(age);
			partySecretaryInfo.setLoginDate(new Date());
			
			String dateStr=this.getRequest().getParameter("joinPartyDate").toString();
			
			partySecretaryInfo.setJoinPartyDate(SwitchTime.strToDate(dateStr));
			partySecretaryInfoService.updatePersonInfo(partySecretaryInfo);
		}catch(Exception e){
			e.printStackTrace();
			this.getRequest().setAttribute("remind", "请正确填写信息");
			this.getRequest().setAttribute("partySecretaryInfo", partySecretaryInfoService.findById(partySecretaryInfo.getPst_Id()));
			return "update";
		}
		this.getRequest().setAttribute("remind", "更改成功");
		this.getRequest().setAttribute("partySecretaryInfo", partySecretaryInfoService.findById(partySecretaryInfo.getPst_Id()));
		return "update";
	}
	
	public String delete(){
		String id=this.getRequest().getParameter("id");
		if(id==null||id.equals("")){
			return null;
		}
		boolean flag=partySecretaryInfoService.delete(Integer.parseInt(id));
		if(flag){
			this.getRequest().setAttribute("remind", "删除成功");
		}
		return this.execute();
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public PartySecretaryInfo getPartySecretaryInfo() {
		return partySecretaryInfo;
	}

	public void setPartySecretaryInfo(PartySecretaryInfo partySecretaryInfo) {
		this.partySecretaryInfo = partySecretaryInfo;
	}

}
