package com.future.partymember.action.manager.paper;


import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.RedPaper;
import com.future.partymember.entity.RedPaperType;
import com.future.partymember.util.SwitchTime;

/**
 * 文章管理
 * @author 丁赵雷
 *
 */
@Controller(value="managePaperAction")
@Scope(value="prototype")
public class ManagePaperAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private RedPaper redPaper;
	


	//添加文章
	public String addPaper() throws Exception{
		redPaper.setReleaseDate(SwitchTime.dateToStr(new Date()));
		RedPaperType r=redPaperTypeService.findById(redPaper.getPaperTypeId());
		redPaper.setPaperType(r.getPaperType());
		redPaperService.addRedPaper(redPaper);
		this.getRequest().setAttribute("paper", "添加成功,您可继续添加");
		return "addPaper";
	}
	
	
    public RedPaper getRedPaper() {
		return redPaper;
	}
	public void setRedPaper(RedPaper redPaper) {
		this.redPaper = redPaper;
	}
	
	


}
