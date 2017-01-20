package com.future.partymember.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 考试记录类
 * @author 丁赵雷
 *
 */

@Entity
@Table(name = "exam_log", catalog = "partymember")
public class ExamLog {

	private int el_Id;
	private int st_Id;//开启试卷记录的id
	private int paper_Id;//试卷id	
	private String paperName;//试卷名称
	private int partyMemberId;//党员的id
	private String partyMemberName;//党员名称
	private String partyBranch;//所在党支部
	private int  partySort;//党员身份     1:书记  0：党员
	private int totalScore;//考试总成绩
	private String examTime;//考试时间
	private String testTime;//考试时长
	private int testTotalScore;//试卷总分
	private int testNum;//试卷总题数
	
	public ExamLog() {
		
	}		
	
	public ExamLog(int st_Id, int paper_Id, String paperName, int partyMemberId, String partyMemberName,
			String partyBranch, int partySort, int totalScore, String examTime, String testTime, int testTotalScore,
			int testNum) {
		super();
		this.st_Id = st_Id;
		this.paper_Id = paper_Id;
		this.paperName = paperName;
		this.partyMemberId = partyMemberId;
		this.partyMemberName = partyMemberName;
		this.partyBranch = partyBranch;
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
	
	public int getSt_Id() {
		return st_Id;
	}
	public void setSt_Id(int st_Id) {
		this.st_Id = st_Id;
	}
	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	@Column(name = "totalScore")	
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
	
	public String getPartyMemberName() {
		return partyMemberName;
	}

	public void setPartyMemberName(String partyMemberName) {
		this.partyMemberName = partyMemberName;
	}

	/*@Temporal(TemporalType.DATE)
	@Column(name = "examTime")*/
	public String getExamTime() {
		return examTime;
	}
	public void setExamTime(String examTime) {
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


	public String getPartyBranch() {
		return partyBranch;
	}

	public void setPartyBranch(String partyBranch) {
		this.partyBranch = partyBranch;
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
