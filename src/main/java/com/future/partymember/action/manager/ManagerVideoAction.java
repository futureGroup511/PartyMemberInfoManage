package com.future.partymember.action.manager;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.RedVideo;
import com.future.partymember.util.PageCut;

/*
* @author 宋民举 860080937@qq.com  
* @date 2016年12月8日 下午7:37:48 
* @description 
*/
public class ManagerVideoAction extends BaseAction {
	private int page;
	public String execute(){
		PageCut<RedVideo> pageCut=new PageCut<>(page,2,456);
		this.getRequest().setAttribute("videoList", redVideoService.getList((page-1)*2, 2));
		return SUCCESS;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
}
