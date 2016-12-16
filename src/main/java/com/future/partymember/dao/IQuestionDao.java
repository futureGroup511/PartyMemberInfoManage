package com.future.partymember.dao;

import java.util.List;

import com.future.partymember.entity.Question;

public interface IQuestionDao{
	public String addQuestion(Question q );
	public Boolean deleteQuestion(Question q); 
	public Boolean updateQuestion(Question q);
	public List<Question> getQuestion(int paperId);//根据试卷id，获得这套试卷所有的试题
}
