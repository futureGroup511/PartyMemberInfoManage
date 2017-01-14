package com.future.partymember.service;

import java.util.List;

import com.future.partymember.entity.Question;
import com.future.partymember.util.PageCut;

public interface IQuestionService {
	public String addQuestion(Question q);
	public Boolean deleteQuestion(int qt_Id); 
	public Boolean updateQuestion(Question q);
	public List<Question> getQuestion(int paperId);//根据试卷id，获得这套试卷所有的试题
	public PageCut<Question> getPC(int curr ,int pageSize);
}
