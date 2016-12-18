package com.future.partymember.action.manager.paper;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.RedPaper;
import com.future.partymember.entity.RedPaperType;
import com.future.partymember.util.PageCut;
/**
 * 文章管理的中转站
 * @author 丁赵雷
 *
 */
@Controller(value="forwardPaperAction")
@Scope(value="prototype")
public class ForwardPaperAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	//转到编辑文章页面
	public String addPaper() throws Exception{
		List<RedPaperType> list=redPaperTypeService.getAllPaperType();
		session.put("redPaperTypeList", list);
		return "fAddPaper";
	}

	//转到管理文章页面
	public String fManagePaper() throws Exception{
		PageCut<RedPaper> pc= redPaperService.getPCByNew(1, 2);
		this.getRequest().setAttribute("pc", pc);
		return "fManagePaper";
	}
}