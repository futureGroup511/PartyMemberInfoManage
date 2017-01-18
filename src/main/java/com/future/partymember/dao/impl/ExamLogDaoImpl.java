package com.future.partymember.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IExamLogDao;
import com.future.partymember.entity.ExamLog;

@Repository
public class ExamLogDaoImpl extends BaseDao<ExamLog> implements IExamLogDao {

	@Override
	public Boolean addExamLog(ExamLog examLog) {
		this.saveEntity(examLog);
		return true;
	}

	@Override
	public Boolean deleteExamLog(int partyMemberId, int partySort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateExamLog(ExamLog examLog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExamLog> getAllExamLogBypartyMemberId(int partyMemberId, int partySort) {

		String hql="from ExamLog e where e.partyMemberId='"+partyMemberId+"' and e.partySort='"+partySort+"'";
		return this.getEntityList(hql);
	}

	@Override
	public ExamLog getExamLogByTpId(int partyMemberId, int partySort, int tp_Id) {
		String hql="from ExamLog e where  e.partyMemberId="+partyMemberId+" and e.partySort="+partySort +"and e.paper_Id="+tp_Id;
		return (ExamLog)this.uniqueResult(hql);

	}

}
