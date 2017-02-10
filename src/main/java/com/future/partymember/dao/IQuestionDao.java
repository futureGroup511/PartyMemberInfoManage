package com.future.partymember.dao;

import java.util.List;

import com.future.partymember.entity.Question;
import com.future.partymember.entity.TestPaper;
import com.future.partymember.util.PageCut;

public interface IQuestionDao{
	
	public Question getById(int id);
	public String addQuestion(Question q );
	public Boolean deleteQuestion(int qt_Id); 
	public Boolean deleteByPaperId(int tp_Id);//根据试卷id，删除该试卷的所以试题
	public Boolean updateQuestion(Question q);
	//根据试卷id，获得这套试卷所有的试题(只获得考题信息，不获得答案)
	public List<Question> getQuestionsByTpId(int paperId);
	//根据试题id获得答案
	public Question getAnswersByQtId(int qt_Id);
	//根据试题id获得该试题的所有信息
		public Question getQuestionByQtId(int qt_Id);
	public PageCut<Question> getPC(int curr ,int pageSize);
	
	public PageCut<Question> getPC(int curr ,int pageSize,String search);
	
	//随机获得num个试题
	public List<Question> getRandomQuestions(int num);
}
