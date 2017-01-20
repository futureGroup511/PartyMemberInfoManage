package com.future.partymember.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IExamLogDao;
import com.future.partymember.entity.ExamLog;
import com.future.partymember.util.PageCut;

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
	public ExamLog getExamLogByTpId(int partyMemberId, int partySort, int tp_Id,int st_Id) {
		String hql="from ExamLog e where  e.partyMemberId="+partyMemberId+" and e.partySort="+partySort +"and e.paper_Id="+tp_Id+" and e.st_Id="+st_Id;                        
		return (ExamLog)this.uniqueResult(hql);

	}

	@SuppressWarnings("unchecked")
	@Override
	public PageCut<ExamLog> getPC(int current, int pageSize, String search) {
		// TODO Auto-generated method stub
		//return null;
		String hql ="";
		int count=0;
		
		
		
		if(search ==null || search.length()==0){
			hql = "select count(*) from ExamLog";
			count = ((Long) this.uniqueResult(hql)).intValue();
		}else{
			hql = "select count(*) from ExamLog as e where e.paperName like :search or e.partyMemberName like :search";
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
		}
		return pc;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return this.deleteEntity(this.getEntity(id));
	}

	@Override
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		String hql="delete from ExamLog";
		this.executeUpdate(hql);
		return true;
	}

	@Override
<<<<<<< HEAD
	public ExamLog getById(int id) {
		// TODO Auto-generated method stub
		return this.getEntity(id);
=======
	public int grtElIdByDate(int st_Id) {
		String hql="from ExamLog e where  e.st_Id='"+st_Id+"'";	
		List<ExamLog> list=this.getEntityList(hql);
		if(list==null || list.size()==0){
			return 0;
		}
		else{
			return ((ExamLog)list.toArray()[0]).getEl_Id();
		}
		
	}

	@Override
	public PageCut<ExamLog> getExamLogsBypartyMemberId(int curr, int pageSize, int partyMemberId, int partySort) {
		PageCut<ExamLog> pageCut=new PageCut<>(curr,pageSize,this.getNum());		
		String hql="from ExamLog e where e.partyMemberId='"+partyMemberId+"' and e.partySort='"+partySort+"'";
		pageCut.setData(this.getEntityLimitList(hql,(curr-1)*pageSize,pageSize));
		return pageCut;
		
>>>>>>> b81875919f1806c8e2023ce29da7ddf7fc97fdfa
	}

}
