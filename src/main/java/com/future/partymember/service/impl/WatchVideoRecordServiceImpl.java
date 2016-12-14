package com.future.partymember.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.future.partymember.dao.IWatchVideoRecordDao;
import com.future.partymember.entity.WatchVideoRecord;
import com.future.partymember.service.IWatchVideoRecordService;

@Service
public class WatchVideoRecordServiceImpl implements IWatchVideoRecordService{

	@Resource
	private IWatchVideoRecordDao watchVideoRecordDao;
	
	@Override
	public Boolean addWVR(WatchVideoRecord watchVideoRecord) {
		// TODO Auto-generated method stub
		return watchVideoRecordDao.addWVR(watchVideoRecord);
	}

	@Override
	public Boolean updateWVR(WatchVideoRecord watchVideoRecord) {
		// TODO Auto-generated method stub
		return watchVideoRecordDao.updateWVR(watchVideoRecord);
	}

	@Override
	public Boolean delectWVR(WatchVideoRecord watchVideoRecord) {
		// TODO Auto-generated method stub
		return watchVideoRecordDao.delectWVR(watchVideoRecord);
	}

	@Override
	public WatchVideoRecord getWVR(int wvr_id, int pm_id) {
		// TODO Auto-generated method stub
		return watchVideoRecordDao.getWVR(wvr_id, pm_id);
	}

}
