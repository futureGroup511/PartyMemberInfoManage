package com.future.partymember.action.manager;
/*
*@author 焦祥宇
*/

import java.util.List;



import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.Question;
import com.future.partymember.entity.StartTest;
import com.future.partymember.entity.TestPaper;
import com.future.partymember.util.PageCut;

public class TestManageAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int page = 1;
	private int id;

	private Question question;
	
	private StartTest startTest;

	//跳转到updaet页面
	
	public String update(){
		if(id<1){
			return null;
		}
		this.getRequest().setAttribute("question", questionService.getById(id));
		return "update";
	}
	
	public String updateDo(){
		if(question==null || question.getQt_Id() <1){
			return null;
		}
		questionService.updateQuestion(question);
		this.getRequest().setAttribute("question", questionService.getById(question.getQt_Id()));
		return "update";
	}
	
	// 试卷的增删改查
	public String getTestPaper() throws Exception {
		String search=this.getRequest().getParameter("search");
		PageCut<TestPaper> pc=testPaperService.getPC(page, 10,search);
		
		if(search ==null || search.length()==0){
			
		}else{
			this.getRequest().setAttribute("search", search);
			for(TestPaper t:pc.getData()){
				t.setPaperName(t.getPaperName().replaceAll(search,String.format("<span class=\"search\">%s</span>", search) ));
			}
		}
		this.getRequest().setAttribute("pc", pc);
		return "getTestPaper";
	}

	public String delete() throws Exception {
		Boolean bool = testPaperService.deleteTestPaper(id);
		if (bool == true) {
			// 删除该试卷的所以试题
			//Boolean bool2 = questionService.deleteByPaperId(id);
			Boolean bool2=true;
			if (bool2 == true) {
				this.getRequest().setAttribute("delectTpMsg", "删除成功");
			} else {
				this.getRequest().setAttribute("delectTpMsg", "删除失败，试卷不存在");
			}
		}else {
			this.getRequest().setAttribute("delectTpMsg", "删除失败，试卷不存在");
		}
		return this.getTestPaper();
	}

	// 试题的增删改查
	public String manageQuestion() throws Exception {
		String search=this.getRequest().getParameter("search");
		PageCut<Question> pc=questionService.getPC(page, 10,search);
		
		if(search ==null || search.length()==0){
			
		}else{
			this.getRequest().setAttribute("search", search);
			String format=String.format("<span class=\"search\">%s</span>", search);
			for(Question q:pc.getData()){
				q.setPaperName(q.getPaperName().replaceAll(search,format));
				q.setQuestions_stems(q.getQuestions_stems().replaceAll(search,format));
			}
		}
		this.getRequest().setAttribute("pc", pc);
		return "getQuestion";
	}

	public String deleteQuestion() throws Exception {
		Boolean bool = questionService.deleteQuestion(id);
		if (bool == true) {
			this.getRequest().setAttribute("delectQtMsg", "成功删除试题");
		} else {
			this.getRequest().setAttribute("delectQtMsg", "删除试题失败");
		}
		return this.manageQuestion();
	}

	// 链接到开启考试页面
	public String toStartTest() throws Exception {
		List<TestPaper> testPaperNameList = testPaperService.getAllTestPaper();
		this.getSession().put("testPaperNameList", testPaperNameList);
		return "toStartTest";
	} 

	// 开启考试
	public String startTest() throws Exception {

		TestPaper testPaper = testPaperService.getTestPaperByName(startTest.getPaperName());
		startTest.setTestPaper(testPaper);				
		this.getRequest().getSession().getServletContext().setAttribute("startTest",startTest);		
		this.getRequest().setAttribute("startMeg", "开启成功");		
		return "startTest";
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

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public StartTest getStartTest() {
		return startTest;
	}

	public void setStartTest(StartTest startTest) {
		this.startTest = startTest;
	}
	
}