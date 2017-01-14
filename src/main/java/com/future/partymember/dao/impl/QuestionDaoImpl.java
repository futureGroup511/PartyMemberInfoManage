package com.future.partymember.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IQuestionDao;
import com.future.partymember.entity.Question;
import com.future.partymember.util.PageCut;

@Repository
public class QuestionDaoImpl extends BaseDao<Question> implements IQuestionDao{

	//添加试题
	@Override
	public String addQuestion(Question q) {
		saveEntity(q);
		return "su";
	}

	@Override
	public Boolean deleteQuestion(int qt_Id) {
		String hql="delete from Question q where q.qt_Id="+qt_Id;
		this.uniqueResult(hql);
		return true;
	}

	@Override
	public Boolean updateQuestion(Question q) {
		this.updateEntity(q);
		return true;
	}

	@Override
	public List<Question> getQuestion(int paperId) {
		String hql="from Question q where q.paperId="+paperId;		
		return this.getEntityList(hql);
		
	}

	@Override
	public PageCut<Question> getPC(int curr, int pageSize) {
		PageCut<Question> pageCut=new PageCut<>(curr,pageSize,this.getNum());
		pageCut.setData(this.getEntityLimitList("from Question",curr,pageSize));
		return pageCut;
	}

	

}
