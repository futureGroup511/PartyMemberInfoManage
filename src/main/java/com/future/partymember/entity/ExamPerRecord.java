package com.future.partymember.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 考试的详细记录
 * @author Administrator
 *
 */
@Entity
@Table(name = "exam_per_record", catalog = "partymember")
public class ExamPerRecord {
	private int epr_id;
	private int el_Id;//考试记录id
	private int tp_Id;//试卷id  用来标志 试题是否属于一套试卷
	private int qt_Id;//试题id
	private String answer;//答题答案	
	private int socre;//得分
	private int pt_Id;//考生id
	private int partySort;//考生身份,0党员，1书记
	public ExamPerRecord(){
		
	}
 	
	public ExamPerRecord(int tp_Id, int qt_Id, String answer, int socre, int pt_Id, int partySort) {
		super();
		this.tp_Id = tp_Id;
		this.qt_Id = qt_Id;
		this.answer = answer;
		this.socre = socre;
		this.pt_Id = pt_Id;
		this.partySort = partySort;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "epr_Id", unique = true, nullable = false)
	public int getEpr_id() {
		return epr_id;
	}
	public void setEpr_id(int epr_id) {
		this.epr_id = epr_id;
	}	
	public int getEl_Id() {
		return el_Id;
	}

	public void setEl_Id(int el_Id) {
		this.el_Id = el_Id;
	}

	public int getPt_Id() {
		return pt_Id;
	}

	public void setPt_Id(int pt_Id) {
		this.pt_Id = pt_Id;
	}

	public int getPartySort() {
		return partySort;
	}

	public void setPartySort(int partySort) {
		this.partySort = partySort;
	}

	
	public int getTp_Id() {
		return tp_Id;
	}
	public void setTp_Id(int tp_Id) {
		this.tp_Id = tp_Id;
	}
	public int getQt_Id() {
		return qt_Id;
	}
	public void setQt_Id(int qt_Id) {
		this.qt_Id = qt_Id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getSocre() {
		return socre;
	}
	public void setSocre(int socre) {
		this.socre = socre;
	}
	@Override
	public String toString() {
		return "ExamPerRecord [epr_id=" + epr_id + ", tp_Id=" + tp_Id + ", qt_Id=" + qt_Id + ", answer=" + answer
				+ ", socre=" + socre + "]";
	}

}
