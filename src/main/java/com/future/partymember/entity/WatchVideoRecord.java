package com.future.partymember.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 观看视频记录类
 * @author 丁赵雷
 *
 */
@Entity
@Table(name="watch_video_record" , catalog="partymember")
public class WatchVideoRecord {

	private int wvr_id;
	private int pm_id ;//党员id
	
	private int rv_id;//视频id
	private long currentTime;//观看视频的当前时间
	private int partySort;//党员身份  党员 0，书记 1
	
	


	public WatchVideoRecord() {
		super();
	}


	

	public WatchVideoRecord(int pm_id, int rv_id, long currentTime, int partySort) {
		super();
		this.pm_id = pm_id;
		this.rv_id = rv_id;
		this.currentTime = currentTime;
		this.partySort = partySort;
	}




	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "wvr_id", unique = true, nullable = false)
	public int getWvr_id() {
		return wvr_id;
	}
	public void setWvr_id(int wvr_id) {
		this.wvr_id = wvr_id;
	}
	public int getPm_id() {
		return pm_id;
	}
	public void setPm_id(int pm_id) {
		this.pm_id = pm_id;
	}
	public int getRv_id() {
		return rv_id;
	}
	public void setRv_id(int rv_id) {
		this.rv_id = rv_id;
	}
	
	@Column(columnDefinition="BIGINT")
	public long getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(long currentTime) {
		this.currentTime = currentTime;
	}
	
	public int getPartySort() {
		return partySort;
	}

	public void setPartySort(int partySort) {
		this.partySort = partySort;
	}




	@Override
	public String toString() {
		return "WatchVideoRecord [wvr_id=" + wvr_id + ", pm_id=" + pm_id + ", rv_id=" + rv_id + ", currentTime="
				+ currentTime + ", 观看者的身份=" + partySort + "]";
	}
	

}
