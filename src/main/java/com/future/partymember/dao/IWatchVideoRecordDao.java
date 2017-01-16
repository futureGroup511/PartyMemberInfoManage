package com.future.partymember.dao;

import com.future.partymember.entity.WatchVideoRecord;

public interface IWatchVideoRecordDao {
	public Boolean addWVR(WatchVideoRecord watchVideoRecord);
	public Boolean updateWVR(WatchVideoRecord watchVideoRecord);
	public Boolean delectWVR(WatchVideoRecord watchVideoRecord);
	public WatchVideoRecord getWVR(int wvr_id,int pm_id,int partySort);
}
