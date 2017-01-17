package com.future.partymember.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	private String paperName;//试卷名称——————焦祥宇加
	private String questions_stems;//题干	
	private String answer;//答案
	private String analysis;//解析
	private int question_socre;//该试题的分数

	//辅助属性——————焦祥宇加
	private String myAnswer;//考生答案
	private int myScore;//考生得分
	
	//A B C D选项
	private String a;
	private String b;
	private String c;
	private String d;
	
	
	
	public Question(){
		super();
	}

	
	public Question(String answer) {
		super();
		this.answer = answer;
	}


	public Question(int  qt_Id, String questions_stems,int question_socre,
			String a, String b, String c, String d) {
		this.qt_Id=qt_Id;
		this.questions_stems = questions_stems;				
		this.question_socre = question_socre;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	public Question(int paperId, String questions_stems, String answer, String analysis, int question_socre,
			String a, String b, String c, String d) {
		this.paperId = paperId;
		this.questions_stems = questions_stems;
		this.answer = answer;
		this.analysis = analysis;
		this.question_socre = question_socre;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}




	@Override
	public String toString() {
		return "Question [qt_Id=" + qt_Id + ", paperId=" + paperId + ", paperName=" + paperName + ", questions_stems="
				+ questions_stems + ", answer=" + answer + ", analysis=" + analysis + ", question_socre="
				+ question_socre + ", a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + "]";
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
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}
	public int getQuestion_socre() {
		return question_socre;
	}
	public void setQuestion_socre(int question_socre) {
		this.question_socre = question_socre;
	}

	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	
	@Transient
	public String getMyAnswer() {
		return myAnswer;
	}

	public void setMyAnswer(String myAnswer) {
		this.myAnswer = myAnswer;
	}
	@Transient
	public int getMyScore() {
		return myScore;
	}

	public void setMyScore(int myScore) {
		this.myScore = myScore;
	}


}
