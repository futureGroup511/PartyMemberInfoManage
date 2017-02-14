package com.future.partymember.action.manager;

import java.io.IOException;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.ManagerInfo;

/*
*@auther:宋民举
*@mail:860080937@qq.com
*@Date:2016年12月3日,下午3:04:34
*@Descritpion:
*/
public class InfoAction extends BaseAction {
	public String execute(){
		ManagerInfo managerInfo = (ManagerInfo)this.getRequest().getSession().getAttribute("user");
		return SUCCESS;
	}
	public String logout() throws IOException{
		this.getRequest().getSession().invalidate();
		this.getResponse().sendRedirect("index");
		return null;
	}
}
