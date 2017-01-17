package com.future.partymember.dao.impl;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IExamPerRecordDao;
import com.future.partymember.entity.ExamPerRecord;

@Repository
public class ExamPerRecordDaoImpl extends BaseDao<ExamPerRecord> implements IExamPerRecordDao {

	@Override
	public Boolean addExamPerRecord(ExamPerRecord examPerRecord) {
		this.saveEntity(examPerRecord);
		return true;
	}

	@Override
	public Boolean deleteExamPerRecord(int pt_Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateExamPerRecord(ExamPerRecord examPerRecord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExamPerRecord> getExamPerRecordsByUserId(int pt_Id, int tp_Id, int partySort) {
		String hql="from ExamPerRecord e where e.pt_Id="+pt_Id+" and e.tp_Id="+tp_Id+" and e.partySort="+partySort;
		
		return this.getEntityList(hql);
	}

	
	
}
