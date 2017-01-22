package com.future.partymember.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.future.partymember.base.BaseDao;
import com.future.partymember.dao.IWatchVideoRecordDao;
import com.future.partymember.entity.WatchVideoRecord;

@Repository
public class WatchVideoRecordDaoImpl extends BaseDao<WatchVideoRecord> implements IWatchVideoRecordDao {

	
	
	@Override
	public Boolean addWVR(WatchVideoRecord watchVideoRecord) {
		System.out.println("return this.saveEntity(watchVideoRecord);");
		return this.saveEntity(watchVideoRecord);
	}

	@Override
	public Boolean updateWVR(WatchVideoRecord watchVideoRecord) {
		System.out.println("return this.updateEntity(watchVideoRecord);");
		return this.updateEntity(watchVideoRecord);
	}

	@Override
	public Boolean delectWVR(WatchVideoRecord watchVideoRecord) {
		return this.deleteEntity(watchVideoRecord);
	}

	//丁赵雷修改 增加了一个辨识身份的参数
	@Override
	public WatchVideoRecord getWVR(int rv_id, int pm_id,int partySort) {
		String hql="from WatchVideoRecord wvr where wvr.rv_id="+rv_id+" and wvr.pm_id="+pm_id+
				"and wvr.partySort="+partySort; 
		List<WatchVideoRecord> list=new ArrayList<>();
		list=this.getEntityList(hql);
		if(list.size()>0){
			return (WatchVideoRecord)list.toArray()[0];
		}
		else{
			return null;
		}
		
	}

}
