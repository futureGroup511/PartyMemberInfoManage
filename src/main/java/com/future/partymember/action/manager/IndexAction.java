package com.future.partymember.action.manager;

import com.future.partymember.base.BaseAction;
import com.future.partymember.dao.impl.ManagerInfoDaoImpl;

/*
*@auther:宋民举
*@mail:860080937@qq.com
*@Date:2016年12月2日,下午6:29:10
*@Descritpion:
*/
public class IndexAction extends BaseAction{
	public String execute(){
		this.getRequest().getSession().setAttribute("user", managerInfoService.getById(1));
		return SUCCESS;
	}
}