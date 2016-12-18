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
		//测试，添加书记 后期删除
		/*
		PartySecretaryInfo p=new PartySecretaryInfo();
		p.setAccount("1");
		p.setBirthdate(new Date());
		p.setLoginDate(new Date());
		p.setJoinPartyDate(new Date());
		p.setAge(45);
		p.setDuties("fd");
		p.setIdCard("fdsa");
		p.setLearnTime(45645646456l);
		p.setNation("fdsa");
		p.setUsername("fds");
		p.setSort("fds");
		p.setSex("m");
		p.setPhoneNo("2156");
		p.setPartyBranch("fdsa");
		p.setNativePlace("fdsa");
		p.setNation("fdsa");
		p.setPassword("fdsaf");
		partySecretaryInfoService.add(p);
		*/
		PageCut<PartySecretaryInfo> pageCut=new PageCut<>(page, 5, 123);
		pageCut.setData(partySecretaryInfoService.getList((page-1)*pageCut.getPageSize(), pageCut.getPageSize()));
		this.getRequest().setAttribute("pageCut", pageCut);
		return SUCCESS;
	}
	
	public String add(){
		return "add";
	}
	public String addDo(){
		if(partySecretaryInfoService.exist(partySecretaryInfo.getAccount())){
			this.getRequest().setAttribute("remind", "账号已经存在，请重新填写。");
			return "add";
		}
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
		
		partySecretaryInfo.setSort("书记");
		partySecretaryInfo.setLoginDate(new Date());
		partySecretaryInfo.setJoinPartyDate(SwitchTime.strToDate(this.getRequest().getParameter("joinPartyDate").toString()));
		
		partySecretaryInfoService.add(partySecretaryInfo);
		this.getRequest().setAttribute("remind", "添加成功");
		this.getRequest().setAttribute("partyMember", partySecretaryInfo);
		return "add";
	}
	public String update() {
		String id=this.getRequest().getParameter("id");
		this.getRequest().setAttribute("id", id);
		return "update";
	}
	public String updateDo(){
		if(partySecretaryInfo==null){
			return null;
		}
		PartySecretaryInfo ps=partySecretaryInfoService.findById(partySecretaryInfo.getPst_Id());
		if(ps==null){
			return null;
		}
		if(partySecretaryInfo.getPhoneNo()!=null && partySecretaryInfo.getPhoneNo().length()>0){
			ps.setPhoneNo(partySecretaryInfo.getPhoneNo());
		}
		if(partySecretaryInfo.getPassword()!=null && partySecretaryInfo.getPassword().length()>0){
			ps.setPassword(partySecretaryInfo.getPassword());
		}
		partySecretaryInfoService.updatePersonInfo(ps);//更新个人信息
		this.getRequest().setAttribute("remind", "更新成功");
		this.getRequest().setAttribute("id", ps.getPst_Id());
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
