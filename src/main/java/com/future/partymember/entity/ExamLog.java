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
	private int partyMemberId;//党员的id
	private int socre;//考试成绩
	private Date examTime;//考试时间
	
	
	
	public ExamLog() {
		
	}
	
	public ExamLog(int partyMemberId, int socre, Date examTime) {
		super();
		this.partyMemberId = partyMemberId;
		this.socre = socre;
		this.examTime = examTime;
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
	
	
	@Column(name = "partyMember",  nullable = false)
	public int getPartyMemberId() {
		return partyMemberId;
	}
	public void setPartyMemberId(int partyMemberId) {
		this.partyMemberId = partyMemberId;
	}
	
	
	@Column(name = "socre",  nullable = false)
	public int getSocre() {
		return socre;
	}
	public void setSocre(int socre) {
		this.socre = socre;
	}
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "examTime",  nullable = false)
	public Date getExamTime() {
		return examTime;
	}
	public void setExamTime(Date examTime) {
		this.examTime = examTime;
	}
}
