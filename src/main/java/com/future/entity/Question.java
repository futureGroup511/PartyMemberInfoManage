package com.future.entity;

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

	private int  qt_Id;
	private String questions_stems;//题干
	private String answer;//答案
	private String analysis;//解析
	
	
	
	public Question(){
		
	}
	
	public Question(String questions_stems, String answer, String analysis) {
		super();
		this.questions_stems = questions_stems;
		this.answer = answer;
		this.analysis = analysis;
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
}
