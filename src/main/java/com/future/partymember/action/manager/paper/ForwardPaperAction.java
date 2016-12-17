package com.future.partymember.action.manager.paper;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.future.partymember.base.BaseAction;
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
		return "addPaper";
	}

}
