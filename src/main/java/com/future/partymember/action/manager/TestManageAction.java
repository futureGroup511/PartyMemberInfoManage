package com.future.partymember.action.manager;
/*
*@author 焦祥宇
*/



import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.Question;
import com.future.partymember.entity.TestPaper;
import com.future.partymember.util.PageCut;

public class TestManageAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int page=1;
	private int id;
	
	//试卷的增删改查
	public String getTestPaper() throws Exception{
		PageCut<TestPaper> pc;		
		pc=testPaperService.getPC(page, 2);		
		this.getRequest().setAttribute("pc", pc);
		return "getTestPaper";
	}
	public String delete() throws Exception{
		if(id==0){
			return null;
		}
		TestPaper testPaper=testPaperService.getTestPaper(id);
		if(testPaper==null){
			this.getRequest().setAttribute("remind", "删除失败，试卷不存在");
			return this.execute();
		}
		testPaperService.delectTestPaper(testPaper);	
		this.getRequest().setAttribute("remind", "添加成功");
		return this.getTestPaper();
	}
	
	//试题的增删改查
	public String getQuestion() throws Exception{
		PageCut<Question> pageCut;
		pageCut=questionService.getPC(page,4);
		this.getRequest().setAttribute("pc", pageCut);
		return "getQuestion";
	}
	
	public String  deleteQuestion() throws Exception {
		Boolean bool=questionService.deleteQuestion(id);
		if(bool==true){
			this.getRequest().setAttribute("delectQtMsg", "成功删除试题");
		}else{
			this.getRequest().setAttribute("delectQtMsg", "删除试题失败");
		}
		return this.getQuestion();
	}
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}