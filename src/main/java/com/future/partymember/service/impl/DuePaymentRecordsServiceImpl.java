package com.future.partymember.service.impl;
import java.util.List;

import javax.annotation.Resource;

/*
 * 党费缴纳记录的控制层实现类
 * @焦祥宇
 */
import org.springframework.stereotype.Service;

import com.future.partymember.dao.IDuePaymentRecordsDao;
import com.future.partymember.entity.DuePaymentRecords;
import com.future.partymember.service.IDuePaymentRecordsService;

@Service
public class DuePaymentRecordsServiceImpl implements IDuePaymentRecordsService{

	@Resource
	private IDuePaymentRecordsDao duePaymentRecordsDao;
	
	public IDuePaymentRecordsDao getDuePaymentRecordsDao() {
		return duePaymentRecordsDao;
	}

	public void setDuePaymentRecordsDao(IDuePaymentRecordsDao duePaymentRecordsDao) {
		this.duePaymentRecordsDao = duePaymentRecordsDao;
	}

	@Override
	public Boolean addDuePaymentRecords(DuePaymentRecords duePaymentRecords) {
		
		return duePaymentRecordsDao.addDuePaymentRecords(duePaymentRecords);
	}

	@Override
	public Boolean delectDuePaymentRecords(DuePaymentRecords duePaymentRecords) {
		
		return duePaymentRecordsDao.delectDuePaymentRecords(duePaymentRecords);
	}

	@Override
	public Boolean updateDuePaymentRecords(DuePaymentRecords duePaymentRecords) {
		
		return duePaymentRecordsDao.updateDuePaymentRecords(duePaymentRecords);
	}

	@Override
	public List<DuePaymentRecords> seekDuePaymentRecordsById(List<DuePaymentRecords> list,int pm_id) {
		
		return duePaymentRecordsDao.seekDuePaymentRecordsById( list,pm_id);
	}
	
	
}
