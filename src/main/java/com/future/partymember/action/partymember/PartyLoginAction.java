package com.future.partymember.action.partymember;

import java.util.ArrayList;
import java.util.List;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.RedVideo;

/*
*@author 焦祥宇
*/
public class PartyLoginAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
	@Override	
	public String  execute() throws Exception{
		//获得视频
		List<RedVideo> recommendVideosList=redVideoService.getRecommend(7);
		List<RedVideo> newVideosList=redVideoService.getNew(7);				
		this.getRequest().setAttribute("newVideosList", newVideosList);
		this.getRequest().setAttribute("recommendVideosList", recommendVideosList);
		//获得文章		
		return SUCCESS;
	}
}
