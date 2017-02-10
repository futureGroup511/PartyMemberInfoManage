package com.future.partymember.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IQuestionDao;
import com.future.partymember.entity.Question;
import com.future.partymember.entity.TestPaper;
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
		this.executeUpdate(hql);
		return true;
	}

	@Override
	public Boolean deleteByPaperId(int tp_Id) {
		String hql="delete from Question q where q.paperId="+tp_Id;
		this.executeUpdate(hql);
		return true;
	}

	@Override
	public Boolean updateQuestion(Question q) {
		this.updateEntity(q);
		return true;
	}

	@Override
	public List<Question> getQuestionsByTpId(int paperId) {
		String hql="select new Question(qt_Id,questions_stems,question_socre,a,b,c,d) from Question q where q.paperId="+paperId;		
		return this.getEntityList(hql);
		
	}

	@Override
	public PageCut<Question> getPC(int curr, int pageSize) {
		PageCut<Question> pageCut=new PageCut<>(curr,pageSize,this.getNum());
		pageCut.setData(this.getEntityLimitList("from Question",(curr-1)*pageSize,pageSize));
		return pageCut;
	}

	@Override
	public Question getAnswersByQtId(int qt_Id) {
		String hql="select new Question(answer) from Question q where q.qt_Id="+qt_Id;		 
		return (Question)this.uniqueResult(hql);
	}

	@Override
	public PageCut<Question> getPC(int curr, int pageSize, String search) {
		
		if(search==null || search.length()==0){
			return this.getPC(curr, pageSize);
		}
		
		String hql = "select count(*) from Question as q where q.paperName like :search or q.questions_stems like :search";
		Query query=this.getSession().createQuery(hql);
		query.setString("search","%"+search+"%");
		int count=((Long)query.uniqueResult()).intValue();
		hql="from Question as q where q.paperName like :search or q.questions_stems like :search";
		query=this.getSession().createQuery(hql);
		query.setString("search","%"+search+"%");
		
		query.setFirstResult((curr-1)*pageSize);
		query.setMaxResults(pageSize);
		PageCut<Question> pCut=new PageCut<>(curr,pageSize,count);
		pCut.setData(query.list());
		return pCut;
	}

	@Override
	public Question getById(int id) {
		
		return this.getEntity(id);
	}

	@Override
	public Question getQuestionByQtId(int qt_Id) {
		String hql="from Question q where q.qt_Id="+qt_Id;
		return (Question)this.uniqueResult(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getRandomQuestions(int num) {
		String sql="SELECT * FROM question  ORDER BY  RAND() LIMIT " +num;
		return this.executeSQLQuery(Question.class,sql);
	}

	
	

}
