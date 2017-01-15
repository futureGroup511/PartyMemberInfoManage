package com.future.partymember.action.manager.paper;


import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.RedPaper;
import com.future.partymember.entity.RedPaperType;
import com.future.partymember.util.PageCut;
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
	private int page;

	//删除文章
	public String deletePaper() throws Exception{
		String id=this.getRequest().getParameter("rp_Id");
		if(id.equals("")){
			this.getRequest().setAttribute("dTag", "删除失败");
		}else{
			redPaperService.deleteRedPaper(Integer.parseInt(id));
			this.getRequest().setAttribute("dTag", "删除成功");
		}
		return  "managePaper";
	}
	
	
	//修改文章
	public String updatePaper()  throws Exception{

		RedPaperType r=redPaperTypeService.findById(redPaper.getPaperTypeId());
		redPaper.setPaperType(r.getPaperType());
		redPaperService.updateRedPaper(redPaper);
		this.getRequest().setAttribute("p", "修改成功,如果您不满意,可继续修改");
		this.getRequest().setAttribute("paper",redPaper);		
		return "updatePaper";
	}
	
	
	//分页
	public String paper() throws Exception{
		if(page==0){
			page=1;
		}
		
		PageCut<RedPaper> pc=redPaperService.getPCByNew(page, 2);
		this.getRequest().setAttribute("pc", pc);
		return "managePaper";
	}


	//添加文章
	public String addPaper() throws Exception{
		
		if(redPaperService.findPaperByNameOne(redPaper.getTitle()).size()>0){
			this.getRequest().setAttribute("paper", "添加失败,该标题已存在");
			return "addPaper";
		}else{
			redPaper.setReleaseDate(SwitchTime.dateToStr(new Date()));
			RedPaperType r=redPaperTypeService.findById(redPaper.getPaperTypeId());
			redPaper.setPaperType(r.getPaperType());
			redPaperService.addRedPaper(redPaper);
			this.getRequest().setAttribute("paper", "添加成功,您可继续添加");
			return "addPaper";
		}
	}
	
	
    public RedPaper getRedPaper() {
		return redPaper;
	}
	public void setRedPaper(RedPaper redPaper) {
		this.redPaper = redPaper;
	}
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	


}
