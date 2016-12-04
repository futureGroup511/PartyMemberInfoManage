package com.future.partymember.action.manager;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.ManagerInfo;
import com.future.partymember.util.ManagerCheck;

/*
*@auther:宋民举
*@mail:860080937@qq.com
*@Date:2016年12月3日,下午4:21:30
*@Descritpion:管理员信息修改
*/
public class ChangeAction extends BaseAction{
	private ManagerInfo user;
	public String info(){
		if(!ManagerCheck.check(user)){
			this.getRequest().setAttribute("reming", "请正确填写信息");
			return SUCCESS;
		}
		ManagerInfo old=(ManagerInfo)this.getRequest().getSession().getAttribute("user");
		user.setId(old.getId());
		user.setAccount(old.getAccount());
		user.setSort(old.getSort());
		managerInfoService.updateManager(user);
		this.getRequest().getSession().setAttribute("user", user);
		this.getRequest().setAttribute("remied", "修改成功");
		return SUCCESS;
	}
	public ManagerInfo getUser() {
		return user;
	}
	public void setUser(ManagerInfo user) {
		this.user = user;
	}
}
