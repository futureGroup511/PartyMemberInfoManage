package com.future.partymember.entity;

/*
*@author 焦祥宇
*/
public class StartTest {
	
	private String paperName;
	private String startTime;
	private String endTime;
	private int testNum;
	private String testPeople;
	private TestPaper testPaper;
	private String testTime;//考试时长
	
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
