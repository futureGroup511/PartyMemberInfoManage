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
		List<RedVideo> videosList=new ArrayList<RedVideo>();
		videosList=redVideoService.getNew(18);		
		this.getRequest().setAttribute("videosList", videosList);
		
		//获得文章
		
		return SUCCESS;
	}
}
