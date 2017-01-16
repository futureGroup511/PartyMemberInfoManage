package com.future.partymember.dao;

import java.util.List;

import com.future.partymember.entity.Question;
import com.future.partymember.util.PageCut;

public interface IQuestionDao{
	public String addQuestion(Question q );
	public Boolean deleteQuestion(int qt_Id); 
	public Boolean deleteByPaperId(int tp_Id);//根据试卷id，删除该试卷的所以试题
	public Boolean updateQuestion(Question q);
	public List<Question> getQuestionsByTpId(int paperId);//根据试卷id，获得这套试卷所有的试题
	public PageCut<Question> getPC(int curr ,int pageSize);
}
