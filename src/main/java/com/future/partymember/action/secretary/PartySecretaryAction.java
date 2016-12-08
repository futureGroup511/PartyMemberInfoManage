package com.future.partymember.action.secretary;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.PartyMemberInfo;
import com.future.partymember.entity.PartySecretaryInfo;
import com.future.partymember.util.PageCut;

@Controller(value="partySecretaryAction")
@Scope(value="prototype")
public class PartySecretaryAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PartySecretaryInfo partySecretaryInfo;
	private PageCut<PartyMemberInfo> pageCut; 
	



	/**
	 * 查看个人信息
	 * @return
	 * @throws Exception
	 */
	public String lookMyself() throws Exception{
		return "lookMyself";
	}
	
	
	//查看所管理的党员信息
	public String lookOfPartyMember() throws Exception{
		//先得到书记对象
		PartySecretaryInfo psi=(PartySecretaryInfo) session.get("secretary");
		List<PartyMemberInfo>  list=null;
		int curPage =1;
		
		if(pageCut==null){
			list=partyMemberInfoService.findAllPartyMemberInfo(psi,curPage,15);//一页15条记录
			pageCut=partyMemberInfoService.getPagerCut(15, curPage, psi);
		}else{
			curPage=pageCut.getCurrentPage();
			
			list=partyMemberInfoService.findAllPartyMemberInfo(psi,curPage,15);//一页15条记录
			pageCut=partyMemberInfoService.getPagerCut(15, curPage, psi);
		}

		
		this.getRequest().setAttribute("PMIlist", list);
		return "lookOfPartyMember";
	}
	
	
	//修改个人信息
	public String updataPerson() throws Exception{
		//先得到书记对象
		PartySecretaryInfo psi=(PartySecretaryInfo) session.get("secretary");
		System.out.println("psi"+psi);
		String password=partySecretaryInfo.getPassword();//第二次输入的新密码

		String oldPassword=(String)this.getRequest().getParameter("oldPassword");//旧密码
		String password1=(String)this.getRequest().getParameter("password1");//新密码
		System.out.println("新密码"+password1);
		
		//使用正则表达式来检验手机号
		String regex="^[1][358][0-9]\\d{9}$";
		String phoneNo=partySecretaryInfo.getPhoneNo();
		boolean flag=phoneNo.matches(regex);
		if(flag){
			psi.setPhoneNo(phoneNo);
		}else{
			System.out.println("您输入的手机号不合法");
		}
		if(oldPassword.equals(psi.getPassword())){
			if(password.equals(password1)){
				psi.setPassword(password);
			}else{
				System.out.println("两次输入的密码不一致");
			}
		}else{
			System.out.println("旧密码输入错误");
		}

		partySecretaryInfoService.updatePersonInfo(psi);//更新个人信息
		
		return "lookMyself";
	}

	public PartySecretaryInfo getPartySecretaryInfo() {
		return partySecretaryInfo;
	}

	public void setPartySecretaryInfo(PartySecretaryInfo partySecretaryInfo) {
		this.partySecretaryInfo = partySecretaryInfo;
	}
	
	public PageCut getPageCut() {
		return pageCut;
	}

	public void setPageCut(PageCut pageCut) {
		this.pageCut = pageCut;
	}

}
