package com.future.partymember.action;

import com.future.partymember.base.BaseAction;

/*
* @author 宋民举 860080937@qq.com  
* @date 2016年12月7日 下午4:43:59 
* @description 
*/
public class VideoAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	
	public String execute(){
		//记录浏览记录
		
		
		//视频浏览次数加一
		redVideoService.updatewatchNumById(id);
		
		//播放视频
		this.getRequest().setAttribute("video",redVideoService.get(id));
		return SUCCESS;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
