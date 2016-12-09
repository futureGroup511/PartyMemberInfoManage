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
	private int page=1;
	private int id;
	public String execute(){
		PageCut<RedVideo> pageCut=new PageCut<>(page,2,456);
		this.getRequest().setAttribute("videoList", redVideoService.getList((page-1)*pageCut.getPageSize(), pageCut.getPageSize()));
		return SUCCESS;
	}
	public String delete(){
		redVideoService.delete(id);
		this.getRequest().setAttribute("remind","删除成功");
		PageCut<RedVideo> pageCut=new PageCut<>(page,2,456);
		this.getRequest().setAttribute("videoList", redVideoService.getList((page-1)*pageCut.getPageSize(), pageCut.getPageSize()));
		return SUCCESS;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
