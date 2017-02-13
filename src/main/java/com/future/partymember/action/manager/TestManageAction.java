package com.future.partymember.action.manager;
/*
*@author 焦祥宇
*/

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.EPRModel;
import com.future.partymember.entity.ExamLog;
import com.future.partymember.entity.ExamPerRecord;
import com.future.partymember.entity.Question;
import com.future.partymember.entity.StartTest;
import com.future.partymember.entity.TestPaper;
import com.future.partymember.util.PageCut;
import com.future.partymember.util.SwitchTime;

public class TestManageAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int page = 1;
	private int id;

	private Question question;

	private StartTest startTest;

	// 跳转到updaet页面

	public String update() {
		if (id < 1) {
			return null;
		}
		this.getRequest().setAttribute("question", questionService.getById(id));
		return "update";
	}

	public String updateDo() {
		if (question == null || question.getQt_Id() < 1) {
			return null;
		}
		questionService.updateQuestion(question);
		this.getRequest().setAttribute("question", questionService.getById(question.getQt_Id()));
		return "update";
	}

	// 试卷的增删改查
	public String getTestPaper() throws Exception {
		String search = (String) this.getRequest().getAttribute("search");
		PageCut<TestPaper> pc = testPaperService.getPC(page, 10, search);

		if (search == null || search.length() == 0) {

		} else {
			this.getRequest().setAttribute("search", search);
			for (TestPaper t : pc.getData()) {
				t.setPaperName(
						t.getPaperName().replaceAll(search, String.format("<span class=\"search\">%s</span>", search)));
			}
		}
		this.getRequest().setAttribute("pc", pc);
		return "getTestPaper";
	}

	public String delete() throws Exception {
		Boolean bool = testPaperService.deleteTestPaper(id);
		if (bool == true) {
			// 删除该试卷的所以试题
			// Boolean bool2 = questionService.deleteByPaperId(id);
			Boolean bool2 = true;
			if (bool2 == true) {
				this.getRequest().setAttribute("delectTpMsg", "删除成功");
			} else {
				this.getRequest().setAttribute("delectTpMsg", "删除失败，试卷不存在");
			}
		} else {
			this.getRequest().setAttribute("delectTpMsg", "删除失败，试卷不存在");
		}
		return this.getTestPaper();
	}

	// 试题的增删改查
	public String manageQuestion() throws Exception {
		String search = (String) this.getRequest().getAttribute("search");
		PageCut<Question> pc = questionService.getPC(page, 10, search);

		if (search == null || search.length() == 0) {

		} else {
			this.getRequest().setAttribute("search", search);
			String format = String.format("<span class=\"search\">%s</span>", search);
			
			for (Question q : pc.getData()) {
				//q.setPaperName(q.getPaperName().replaceAll(search, format));
				q.setQuestions_stems(q.getQuestions_stems().replaceAll(search, format));
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
		List<Question> questionList = questionService.getQuestionsByTpId(testPaper.getTp_Id());
		if (questionList.size() > 0) {
			startTest.setTestPaper(testPaper);
			long time = SwitchTime.strToTime(startTest.getEndTime()).getTime()
					- SwitchTime.strToTime(startTest.getStartTime()).getTime();
			String testTime = SwitchTime.switchTime(time);
			startTest.setTestTime(testTime);
			String date = SwitchTime.dateToTimeStr((new Date()));
			startTest.setCreateDate(date);
			// 判断是否开启
			int wetherAdd = startTestService.getStIdByDate(startTest.getPaperName(), date);
			if (wetherAdd == 0) {
				Boolean bool = startTestService.addStartTest(startTest);
				if (bool == true) {
					int st_Id = startTestService.getStIdByDate(startTest.getPaperName(), date);
					startTest.setSt_Id(st_Id);
					this.getRequest().getSession().getServletContext().setAttribute("startTest", startTest);
					this.getRequest().setAttribute("startMeg", "开启成功！");
				} else {
					this.getRequest().setAttribute("startMeg", "开启失败！");
				}
			} else {
				this.getRequest().setAttribute("startMeg", "一分钟内已开启该卷，请一分钟后刷新再开启！");
			}
		} else {
			this.getRequest().setAttribute("startMeg", "该试卷没有录题，开启失败！");
		}
		return "startTest";

	}

	public String log() {
		if (page < 1) {
			page = 1;
		}

		String search = (String) this.getRequest().getAttribute("search");
		String encode = this.getRequest().getParameter("encode");
		if ("1".equals(encode)) {
			try {
				byte[] str1 = search.getBytes("iso8859-1");
				search = new String(str1, "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		PageCut<ExamLog> pCut = examLogService.getPC(page, 10, search);
		String s1 = String.format("<span class=\"search\">%s</span>", search);
		if (search == null || "".equals(search)) {

		} else {
			for (ExamLog e : pCut.getData()) {
				e.setPaperName(e.getPaperName().replaceAll(search, s1));
				e.setPartyMemberName(e.getPartyMemberName().replaceAll(search, s1));
			}
		}
		this.getRequest().setAttribute("pc", pCut);
		this.getRequest().setAttribute("search", search);
		return "log";
	}

	public String info() {
		if (id < 1) {
			return null;
		}
		ExamLog examLog = examLogService.getById(id);
		if (examLog == null) {
			return null;
		}
		List<ExamPerRecord> examPerRecords = examPerRecordService.getExamPerRecordsByUserId(examLog.getPartyMemberId(),
				examLog.getPaper_Id(), examLog.getPartySort());
		if (examPerRecords == null || examPerRecords.size() < 1) {
			this.getRequest().setAttribute("remind", "找不到记录");
			return "info";
		}
		EPRModel[] eprModels = new EPRModel[examPerRecords.size() - 1];

		for (int i = 0; i < eprModels.length; i++) {
			eprModels[i] = new EPRModel();
			eprModels[i].setExamPerRecord(examPerRecords.get(i));
			eprModels[i].setTestPaper(testPaperService.getTestPaper(examPerRecords.get(i).getTp_Id()));
			eprModels[i].setQuestion(questionService.getById(examPerRecords.get(i).getQt_Id()));
			eprModels[i].setAnswer(examPerRecords.get(i).getAnswer());
			if (examPerRecords.get(i).getPartySort() == 0) {
				try {
					eprModels[i].setPersonName(partyMemberInfoService
							.getPartyMemberInfoById(examPerRecords.get(i).getPt_Id()).getUsername());
				} catch (Exception e) {
					e.printStackTrace();
					eprModels[i].setPersonName("未知");
				}
			} else {
				try {
					eprModels[i].setPersonName(
							partySecretaryInfoService.findById(examPerRecords.get(i).getPt_Id()).getUsername());
				} catch (Exception e) {
					e.printStackTrace();
					eprModels[i].setPersonName("未知");
				}
			}

		}
		this.getRequest().setAttribute("eprModels", eprModels);
		return "info";
	}

	public String logDel() {
		if (id < 1) {
			return null;
		}
		if (examLogService.deleteById(id)) {
			this.getRequest().setAttribute("remind", "删除成功。");
		} else {
			this.getRequest().setAttribute("remind", "删除失败。");
		}
		return this.log();
	}

	public String logDelAll() {
		if (examLogService.deleteAll()) {
			examPerRecordService.deleteAll();
			startTestService.deleteAll();
			this.getRequest().setAttribute("remind", "删除成功。");
		} else {
			this.getRequest().setAttribute("remind", "删除失败。");
		}
		return this.log();
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