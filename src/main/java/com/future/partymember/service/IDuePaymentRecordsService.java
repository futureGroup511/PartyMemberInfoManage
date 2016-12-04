package com.future.partymember.service;

import java.util.List;

import com.future.partymember.entity.DuePaymentRecords;

/*
 * 党费缴纳记录的控制层接口
 * @焦祥宇
 */
public interface IDuePaymentRecordsService {
	public Boolean addDuePaymentRecords(DuePaymentRecords duePaymentRecords);
	public Boolean delectDuePaymentRecords(DuePaymentRecords duePaymentRecords);
	public Boolean updateDuePaymentRecords(DuePaymentRecords duePaymentRecords);
	public List<DuePaymentRecords> seekDuePaymentRecordsById(List<DuePaymentRecords> list,int pm_id);
}
