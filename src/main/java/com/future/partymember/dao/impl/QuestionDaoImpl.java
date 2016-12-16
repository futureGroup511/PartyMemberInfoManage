package com.future.partymember.dao.impl;

import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IQuestionDao;
import com.future.partymember.entity.Question;

@Repository
public class QuestionDaoImpl extends BaseDao<Question> implements IQuestionDao{

	//添加试题
	@Override
	public String addQuestion(Question q) {
		saveEntity(q);
		return "su";
	}

}
