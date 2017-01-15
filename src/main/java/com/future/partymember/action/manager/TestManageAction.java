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

	private StartTest startTest;

	// 试卷的增删改查
	public String getTestPaper() throws Exception {
		PageCut<TestPaper> pc;
		pc = testPaperService.getPC(page, 8);
		this.getRequest().setAttribute("pc", pc);
		return "getTestPaper";
	}

	public String delete() throws Exception {
		Boolean bool = testPaperService.deleteTestPaper(id);
		if (bool == true) {
			// 删除该试卷的所以试题
			Boolean bool2 = questionService.deleteByPaperId(id);
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
	public String getQuestion() throws Exception {
		PageCut<Question> pageCut;
		pageCut = questionService.getPC(page, 8);
		this.getRequest().setAttribute("pc", pageCut);
		return "getQuestion";
	}

	public String deleteQuestion() throws Exception {
		Boolean bool = questionService.deleteQuestion(id);
		if (bool == true) {
			this.getRequest().setAttribute("delectQtMsg", "成功删除试题");
		} else {
			this.getRequest().setAttribute("delectQtMsg", "删除试题失败");
		}
		return this.getQuestion();
	}

	// 链接到开启考试页面
	public String toStartTest() throws Exception {
		List<TestPaper> testPaperNameList = testPaperService.getAllTestPaper();
		session.put("testPaperNameList", testPaperNameList);
		return "toStartTest";
	}

	// 开启考试
	public String startTest() throws Exception {

		TestPaper testPaper = testPaperService.getTestPaperByName(startTest.getPaperName());
		startTest.setTestPaper(testPaper);
		session.put("startTest", startTest);
		/*
		 * System.out.println(startTest.getEndTime()-startTest.getStartTime());
		 */
		this.getRequest().setAttribute("startMeg", "开启成功");
		System.out.println(startTest);
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

	public StartTest getStartTest() {
		return startTest;
	}

	public void setStartTest(StartTest startTest) {
		this.startTest = startTest;
	}

}