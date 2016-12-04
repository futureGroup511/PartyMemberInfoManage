package com.future.partymember.dao.impl;
/*
 * 党费缴纳记录的数据层实现类
 * @焦祥宇
 * 
 */
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IDuePaymentRecordsDao;
import com.future.partymember.entity.DuePaymentRecords;

@Repository
public class DuePaymentRecordsDaoImpl extends BaseDao<DuePaymentRecords> implements IDuePaymentRecordsDao {

	@Override
	public Boolean addDuePaymentRecords(DuePaymentRecords duePaymentRecords) {
		this.saveEntity(duePaymentRecords);
		return true;
	}

	@Override
	public Boolean delectDuePaymentRecords(DuePaymentRecords duePaymentRecords) {
		this.deleteEntity(duePaymentRecords);
		return true;
	}

	@Override
	public Boolean updateDuePaymentRecords(DuePaymentRecords duePaymentRecords) {
		this.updateEntity(duePaymentRecords);
		return true;
	}

	//根据党员id搜索
	@SuppressWarnings("unchecked")
	@Override
	public List<DuePaymentRecords> seekDuePaymentRecordsById(List<DuePaymentRecords> list,int pm_id) {
		try{
			String hql="form DuePaymentRecords due where due.pm_id="+pm_id;
			Query q=this.getSession().createQuery(hql);
			list=q.list();
		}catch (HibernateException e) {
			e.printStackTrace();
		}
		return list;
	}

}
