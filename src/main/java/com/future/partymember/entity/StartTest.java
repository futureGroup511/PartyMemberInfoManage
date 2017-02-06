package com.future.partymember.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/*
*@author 焦祥宇
*/
@Entity
@Table(name = "start_test", catalog = "partymember")
public class StartTest {
	
	private int st_Id;
	private String paperName;//试卷名称
	private String startTime;//开始时间
	private String endTime;//结束时间
	private String createDate;//创建时间
	
	private int testNum;//试题数目
	private String testPeople;//考试人的身份	
	private TestPaper testPaper;//试卷类
	private String testTime;//考试时长
 
	private int totalScore;//试卷总分
	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "st_Id", unique = true, nullable = false)
	public int getSt_Id() {
		return st_Id;
	}

	public void setSt_Id(int st_Id) {
		this.st_Id = st_Id;
	}	
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Transient
	public int getTotalScore() {
		return totalScore;
	}	
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	@Transient
	public int getTestNum() {
		return testNum;
	}

	public void setTestNum(int testNum) {
		this.testNum = testNum;
	}
	@Transient
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

	@Transient
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
