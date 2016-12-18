package com.future.partymember.action.manager.paper;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.RedPaperType;
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
	
	public String addPaper() throws Exception{
		List<RedPaperType> list=redPaperTypeService.getAllPaperType();
		session.put("redPaperTypeList", list);
		return "fAddPaper";
	}

}
