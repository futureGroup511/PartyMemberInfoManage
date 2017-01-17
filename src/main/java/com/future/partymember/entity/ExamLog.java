package com.future.partymember.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 考试记录类
 * @author 丁赵雷
 *
 */

@Entity
@Table(name = "exam_log", catalog = "partymember")
public class ExamLog {

	private int el_Id;
	private int paper_Id;//试卷id
	private String paperName;//试卷名称
	private int partyMemberId;//党员的id
	private int partySort;//党员身份     1:书记  0：党员
	private int totalScore;//考试总成绩
	private Date examTime;//考试时间
	private String testTime;//考试时长
	private int testTotalScore;//试卷总分
	private int testNum;//试卷总题数
	
	public ExamLog() {
		
	}
	

	public ExamLog(int paper_Id, String paperName, int partyMemberId, int partySort, int totalScore, Date examTime,
			String testTime, int testTotalScore, int testNum) {
		super();
		this.paper_Id = paper_Id;
		this.paperName = paperName;
		this.partyMemberId = partyMemberId;
		this.partySort = partySort;
		this.totalScore = totalScore;
		this.examTime = examTime;
		this.testTime = testTime;
		this.testTotalScore = testTotalScore;
		this.testNum = testNum;
	}


	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "el_Id", unique = true, nullable = false)
	public int getEl_Id() {
		return el_Id;
	}
	public void setEl_Id(int el_Id) {
		this.el_Id = el_Id;
	}
	
	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	@Column(name = "totalScore",  nullable = false)
	
	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	
	@Column(name = "partyMember_id",  nullable = false)
	public int getPartyMemberId() {
		return partyMemberId;
	}
	public void setPartyMemberId(int partyMemberId) {
		this.partyMemberId = partyMemberId;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "examTime",  nullable = false)
	public Date getExamTime() {
		return examTime;
	}
	public void setExamTime(Date examTime) {
		this.examTime = examTime;
	}
	
	public int getPaper_Id() {
		return paper_Id;
	}

	public void setPaper_Id(int paper_Id) {
		this.paper_Id = paper_Id;
	}
	
	public int getPartySort() {
		return partySort;
	}

	public void setPartySort(int partySort) {
		this.partySort = partySort;
	}

	public String getTestTime() {
		return testTime;
	}

	public void setTestTime(String testTime) {
		this.testTime = testTime;
	}

	public int getTestTotalScore() {
		return testTotalScore;
	}


	public void setTestTotalScore(int testTotalScore) {
		this.testTotalScore = testTotalScore;
	}


	public int getTestNum() {
		return testNum;
	}

	public void setTestNum(int testNum) {
		this.testNum = testNum;
	}

	@Override
	public String toString() {
		return "ExamLog [el_Id=" + el_Id + ", paper_Id=" + paper_Id + ", partyMemberId=" + partyMemberId
				+ ", partySort=" + partySort + ", socre=" + totalScore + ", examTime=" + examTime + "]";
	}
	
}
