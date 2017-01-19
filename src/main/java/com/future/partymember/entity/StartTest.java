package com.future.partymember.entity;

/*
*@author 焦祥宇
*/
public class StartTest {
	
	private String paperName;//试卷名称
	private String startTime;//开始时间
	private String endTime;//结束时间
	private int testNum;//试题数目
	private String testPeople;//考试人的身份
	private TestPaper testPaper;//试卷类
	private String testTime;//考试时长
	private int totalScore;//试卷总分
	
 
	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}


	public int getTestNum() {
		return testNum;
	}

	public void setTestNum(int testNum) {
		this.testNum = testNum;
	}

	public String getTestPeople() {
		return testPeople;
	}

	public void setTestPeople(String testPeople) {
		this.testPeople = testPeople;
	}

	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public TestPaper getTestPaper() {
		return testPaper;
	}

	public void setTestPaper(TestPaper testPaper) {
		this.testPaper = testPaper;
	}

	public String getTestTime() {
		return testTime;
	}

	public void setTestTime(String testTime) {
		this.testTime = testTime;
	}

	@Override
	public String toString() {
		return "StartTest [paperName=" + paperName + ", startTime=" + startTime + ", endTime=" + endTime + ", testNum="
				+ testNum + ", testPeople=" + testPeople + ", testPaper=" + testPaper + ", testTime=" + testTime + "]";
	}

}
