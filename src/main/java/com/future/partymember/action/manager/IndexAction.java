package com.future.partymember.action.manager;

import java.io.IOException;

import com.future.partymember.base.BaseAction;
import com.future.partymember.dao.impl.ManagerInfoDaoImpl;
import com.future.partymember.entity.ManagerInfo;

/*
*@auther:宋民举
*@mail:860080937@qq.com
*@Date:2016年12月2日,下午6:29:10
*@Descritpion:
*/
public class IndexAction extends BaseAction{
	private String account;
	private String password;
	private String randStr;
	public String execute(){
		return SUCCESS;
	}
	public String login(){
		return "login";
	}
	public String loginDo() throws IOException{
		
		String vCode=(String)this.getRequest().getSession().getAttribute("randStr");
		this.getRequest().getSession().removeAttribute("randStr");
		if(randStr==null || !randStr.equals(vCode) ){
			this.getRequest().setAttribute("remind", "验证码错误，请重试");
			return "login";
		}
		ManagerInfo managerInfo=managerInfoService.getByAccount(account);
		if (managerInfo!=null && managerInfo.getPassword().equals(password)) {
			this.getRequest().getSession().setAttribute("user",managerInfo);
			this.getResponse().sendRedirect("index");
			return null;
		}else{
			this.getRequest().setAttribute("remind","登录失败，请检查账号和密码");
			return "login";
		}
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRandStr() {
		return randStr;
	}
	public void setRandStr(String randStr) {
		this.randStr = randStr;
	}
	
}