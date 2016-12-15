package com.future.partymember.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 试题类  只是选择题
 * @author 丁赵雷
 *
 */
@Entity
@Table(name = "question", catalog = "partymember")
public class Question {

	private int  qt_Id;//试题id 具有唯一性
	private int paperId;//试卷id  用来标志 试题是否属于一套试卷
	private String questions_stems;//题干
	private String answer;//答案

	private String analysis;//解析
	
	//A B C D选项
	private String A;
	private String B;
	private String C;
	private String D;
	
	
	
	public Question(){
		
	}
	
	



	public Question(int paperId, String questions_stems, String answer, String analysis, String a, String b, String c,
			String d) {
		super();
		this.paperId = paperId;
		this.questions_stems = questions_stems;
		this.answer = answer;
		this.analysis = analysis;
		A = a;
		B = b;
		C = c;
		D = d;
	}

	@Override
	public String toString() {
		return "Question [qt_Id=" + qt_Id + ", paperId=" + paperId + ", questions_stems=" + questions_stems
				+ ", answer=" + answer + ", analysis=" + analysis + ", A=" + A + ", B=" + B + ", C=" + C + ", D=" + D
				+ "]";
	}
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "qt_Id", unique = true, nullable = false)
	public int getQt_Id() {
		return qt_Id;
	}

	public void setQt_Id(int qt_Id) {
		this.qt_Id = qt_Id;
	}
	public String getQuestions_stems() {
		return questions_stems;
	}
	public void setQuestions_stems(String questions_stems) {
		this.questions_stems = questions_stems;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAnalysis() {
		return analysis;
	}
	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}
	public int getPaperId() {
		return paperId;
	}

	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}

	public String getA() {
		return A;
	}

	public void setA(String a) {
		A = a;
	}

	public String getB() {
		return B;
	}

	public void setB(String b) {
		B = b;
	}

	public String getC() {
		return C;
	}

	public void setC(String c) {
		C = c;
	}

	public String getD() {
		return D;
	}

	public void setD(String d) {
		D = d;
	}
}
