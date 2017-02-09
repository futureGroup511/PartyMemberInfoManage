package com.future.partymember.entity;
/*
* @author 宋民举 860080937@qq.com  
* @date 2017年1月20日 上午10:05:03 
* @description 
*/

//不是实体类，管理员专用，用于TestManageAction
public class EPRModel {
	
	private ExamPerRecord examPerRecord;
	private TestPaper testPaper;
	private Question question;
	private String personName;
	
	private String answer;
	public ExamPerRecord getExamPerRecord() {
		return examPerRecord;
	}
	public void setExamPerRecord(ExamPerRecord examPerRecord) {
		this.examPerRecord = examPerRecord;
	}
	public TestPaper getTestPaper() {
		return testPaper;
	}
	public void setTestPaper(TestPaper testPaper) {
		this.testPaper = testPaper;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
}
