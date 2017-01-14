package com.future.partymember.entity;

import java.util.Date;

/*
*@author 焦祥宇
*/
public class StartTest {
	private String paperName;
	private Date startTime;
	private Date  endTime;
	private TestPaper testPaper;
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public Date  getStartTime() {
		return startTime;
	}
	public void setStartTime(Date  startTime) {
		this.startTime = startTime;
	}
	public Date  getEndTime() {
		return endTime;
	}
	public void setEndTime(Date  endTime) {
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
