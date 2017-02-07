package com.future.partymember.action.manager;

import java.io.File;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.RedVideo;
import com.future.partymember.util.PageCut;

/*
* @author 宋民举 860080937@qq.com  
* @date 2016年12月8日 下午7:37:48 
* @description 
*/
public class ManagerVideoAction extends BaseAction {
	
	private int page = 1;
	private int id;

	public String execute() {
		if(page<1){
			page=1;
		}
		String search=(String)this.getRequest().getAttribute("search");
		PageCut<RedVideo> pageCut = redVideoService.getPC(10, page,search);
		if(search==null || search.length()==0){
			
		}else{
			this.getRequest().setAttribute("search",search);
			for(RedVideo rv:pageCut.getData()){
				rv.setName(rv.getName().replaceAll(search,String.format("<span class=\"search\">%s</span>", search)));
			}
		}
		this.getRequest().setAttribute("pc",pageCut);
		return SUCCESS; 
	}

	public String delete() {

		RedVideo redVideo = redVideoService.get(id);
		if (redVideo == null) {
			return this.execute();
		}
		String path = this.getContext().getRealPath("/")+"/";
		File video = new File(path + redVideo.getVideoUrl());
		File img = new File(path + redVideo.getImgUrl());
		if (video.exists()) {
			video.delete();
		}
		if (img.exists()) {
			img.delete();
		}
		redVideoService.delete(id);
		this.getRequest().setAttribute("remind", "删除成功");
		return this.execute();
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
