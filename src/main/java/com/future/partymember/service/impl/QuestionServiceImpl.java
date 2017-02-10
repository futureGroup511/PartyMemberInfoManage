package com.future.partymember.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.future.partymember.dao.IQuestionDao;
import com.future.partymember.entity.Question;
import com.future.partymember.entity.TestPaper;
import com.future.partymember.service.IQuestionService;
import com.future.partymember.util.PageCut;

@Service
public class QuestionServiceImpl implements IQuestionService{
	
	@Resource
	private IQuestionDao questionDao;
	@Override
	public String addQuestion(Question q) {
		return questionDao.addQuestion(q);
	}
	@Override
	public Boolean deleteQuestion(int qt_Id) {		
		return questionDao.deleteQuestion(qt_Id);
	}
	@Override
	public Boolean updateQuestion(Question q) {
		return questionDao.updateQuestion(q);
	}
	@Override
	public List<Question> getQuestionsByTpId(int paperId) {
		
		return questionDao.getQuestionsByTpId(paperId);
	}
	@Override
	public PageCut<Question> getPC(int curr, int pageSize) {
		
		return questionDao.getPC(curr, pageSize);
	}
	@Override
	public Boolean deleteByPaperId(int tp_Id) {
		
		return questionDao.deleteByPaperId(tp_Id);
	}
	@Override
	public Question getAnswersByQtId(int qt_Id) {
		
		return questionDao.getAnswersByQtId(qt_Id);
	}
	@Override
	public PageCut<Question> getPC(int curr, int pageSize, String search) {
		
		return questionDao.getPC(curr, pageSize, search);
	}
	@Override
	public Question getById(int id) {
		
		return questionDao.getById(id);
	}
	@Override
	public Question getQuestionByQtId(int qt_Id) {
		
		return questionDao.getQuestionByQtId(qt_Id);
	}
	@Override
	public List<Question> getRandomQuestions(int num) {
		
		return questionDao.getRandomQuestions(num);
	}
	

}
