package com.future.partymember.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.future.partymember.dao.IQuestionDao;
import com.future.partymember.entity.Question;
import com.future.partymember.service.IQuestionService;

@Service
public class QuestionServiceImpl implements IQuestionService{
	
	@Resource
	private IQuestionDao iQuestionDao;
	@Override
	public String addQuestion(Question q) {
		return iQuestionDao.addQuestion(q);
	}

}
