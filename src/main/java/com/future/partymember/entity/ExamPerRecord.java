package com.future.partymember.entity;

public class ExamPerRecord {
	private int epr_id;
	private int tp_Id;//试卷id  用来标志 试题是否属于一套试卷
	private int qt_Id;//试题id
	private String answer;//答题答案	
	private int socre;//得分
	public int getEpr_id() {
		return epr_id;
	}
	public void setEpr_id(int epr_id) {
		this.epr_id = epr_id;
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
