package com.future.partymember.dao.impl;



import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IExamPerRecordDao;
import com.future.partymember.entity.ExamLog;
import com.future.partymember.entity.ExamPerRecord;
import com.future.partymember.util.PageCut;

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
	public List<ExamPerRecord> getExamPerRecordsByUserId(int pt_Id, int tp_Id,int el_Id, int partySort) {
		String hql="from ExamPerRecord e where e.pt_Id="+pt_Id+" and e.tp_Id="+tp_Id+"and e.el_Id="+el_Id+" and e.partySort="+partySort+"order by e.epr_id desc";         
		
		return this.getEntityList(hql);
	}

	@Override
	public PageCut<ExamPerRecord> getPC(int current, int pageSize, String search) {
		// TODO Auto-generated method stub
		String hql ="";
		int count=0;
		
		/*
		
		if(search ==null || search.length()==0){
			hql = "select count(*) from ExamPerRecord";
			count = ((Long) this.uniqueResult(hql)).intValue();
		}else{
			hql = "select count(*) from ExamPerRecord as e where e.paperName like :search or e.partyMemberName like :search";
			Query query=this.getSession().createQuery(hql);
			query.setString("search","%"+search+"%");
			
			count=((Long)query.uniqueResult()).intValue();
		}
		PageCut<ExamLog> pc = new PageCut<ExamLog>(current, pageSize, count);
		if(search==null || search.length()==0){
			hql="from ExamLog";
			pc.setData(this.getEntityLimitList(hql, (current-1)*pageSize, pageSize));
		}else{
			hql="from ExamLog as e where e.paperName like :search or e.partyMemberName like :search";
			Query query=this.getSession().createQuery(hql);
			query.setString("search","%"+search+"%");
			query.setFirstResult((current-1)*pageSize);
			query.setMaxResults(pageSize);
			pc.setData(query.list());
		}*/
		return null;
	}

	@Override
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		String hql="delete from ExamPerRecord";
		this.executeUpdate(hql);
		return true;
	}

	@Override
	public List<ExamPerRecord> getExamPerRecordsByUserId(int pt_Id, int tp_Id, int partySort) {
String hql="from ExamPerRecord e where e.pt_Id="+pt_Id+" and e.tp_Id="+tp_Id+" and e.partySort="+partySort;
		
		return this.getEntityList(hql);
	}

	
	
}
