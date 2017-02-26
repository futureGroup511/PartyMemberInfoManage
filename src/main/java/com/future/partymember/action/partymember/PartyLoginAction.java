package com.future.partymember.action.partymember;

import java.util.List;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.IndexImage;
import com.future.partymember.entity.Inform;
import com.future.partymember.entity.RedPaper;
import com.future.partymember.entity.RedVideo;
import com.future.partymember.util.PageCut;
import com.future.partymember.util.PaperUtil;

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
		//获得轮播图片
		List<IndexImage> indexImages=indexImageService.getByNew(4);
		this.getRequest().setAttribute("indexImages",indexImages);
		//获得公告
		List<Inform> informList=informService.getNew(2);
		this.getRequest().setAttribute("informList",informList);
		//获得文章	
		List<RedPaper> newPaperList=redPaperService.getNew(5);
		newPaperList =PaperUtil.titleLength(newPaperList, 15);
		List<RedPaper> hotPaperList=redPaperService.getHot(5);
		hotPaperList = PaperUtil.titleLength(hotPaperList, 15);
		this.getRequest().setAttribute("newPaperList",newPaperList);
		this.getRequest().setAttribute("hotPaperList",hotPaperList);
		//获得视频
		List<RedVideo> recommendVideosList=redVideoService.getRecommend(7);		
		List<RedVideo> newVideosList=redVideoService.getNew(7);	
		this.getRequest().setAttribute("newVideosList", newVideosList);
		this.getRequest().setAttribute("recommendVideosList", recommendVideosList);
		
		return SUCCESS;
	}
}
