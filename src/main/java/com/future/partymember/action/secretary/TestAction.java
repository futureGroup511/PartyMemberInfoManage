package com.future.partymember.action.secretary;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.PartySecretaryInfo;
import com.future.partymember.entity.StartTest;
import com.future.partymember.service.IExamPerRecordService;
import com.future.partymember.service.IStartTestService;
import com.future.partymember.service.ITestPaperService;
import com.future.partymember.util.PageCut;

/**
 * 查询所属党员的考试记录
 * @author 丁赵雷
 *@see 2017-01-20
 */
@Controller(value="testAction")
@Scope(value="prototype")
public class TestAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private PartySecretaryInfo partySecretaryInfo;
	private PageCut<?> pageCut; 
	private int page=1;
	
/*	 testPaperService;
	 examPerRecordService;
	 startTestService;*/

	//查看所有的的考试记录
	public String startTestLog(){
		
		if(page<1){
			page=1;
		}
		String search=this.getRequest().getParameter("search");
		PageCut<StartTest> pCut=startTestService.getPC(page, 10, search);
		
		String s1=String.format("<span class=\"search\">%s</span>",search);
		
		//防止前台提交参数错误，注释掉高亮搜索词的功能。
		
		/*
		if(search == null || "".equals(search)){
			
		}else{
			for(StartTest e:pCut.getData()){
				e.setPaperName(e.getPaperName().replaceAll(search, s1));
			}
		}
		*/
		this.getRequest().setAttribute("pc",pCut);
		this.getRequest().setAttribute("search",search);
		return "startTestLog";
	}
	
	
	
	public PartySecretaryInfo getPartySecretaryInfo() {
		return partySecretaryInfo;
	}
	public void setPartySecretaryInfo(PartySecretaryInfo partySecretaryInfo) {
		this.partySecretaryInfo = partySecretaryInfo;
	}
	public PageCut<?> getPageCut() {
		return pageCut;
	}
	public void setPageCut(PageCut<?> pageCut) {
		this.pageCut = pageCut;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
}
