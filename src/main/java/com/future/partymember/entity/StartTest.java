package com.future.partymember.entity;

/*
*@author 焦祥宇
*/
public class StartTest {
	private String paperName;
	private String startTime;
	private String endTime;
	private String testPeople;
	private TestPaper testPaper;
	
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

	@Override
	public String toString() {
		return "StartTest [paperName=" + paperName + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", testPaper=" + testPaper + "]";
	}

}
