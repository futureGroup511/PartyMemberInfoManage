package com.future.partymember.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.future.partymember.dao.IQuestionDao;
import com.future.partymember.entity.Question;
import com.future.partymember.service.IQuestionService;

@Service
public class QuestionServiceImpl implements IQuestionService{
	
	@Resource
	private IQuestionDao questionDao;
	@Override
	public String addQuestion(Question q) {
		return questionDao.addQuestion(q);
	}
	@Override
	public Boolean deleteQuestion(Question q) {		
		return questionDao.deleteQuestion(q);
	}
	@Override
	public Boolean updateQuestion(Question q) {
		return questionDao.updateQuestion(q);
	}
	@Override
	public List<Question> getQuestion(int paperId) {
		
		return questionDao.getQuestion(paperId);
	}
	

}
