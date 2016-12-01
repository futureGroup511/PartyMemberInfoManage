package com.future.entity;

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
	private Date startWatch ;//开始看视频时间
	private Date endWatch;//结束看视频的时间
	
	
	public WatchVideoRecord() {
		super();
	}

	public WatchVideoRecord(int pm_id, int rv_id, Date startWatch, Date endWatch) {
		super();
		this.pm_id = pm_id;
		this.rv_id = rv_id;
		this.startWatch = startWatch;
		this.endWatch = endWatch;
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
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getStartWatch() {
		return startWatch;
	}
	public void setStartWatch(Date startWatch) {
		this.startWatch = startWatch;
	}
	
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getEndWatch() {
		return endWatch;
	}
	public void setEndWatch(Date endWatch) {
		this.endWatch = endWatch;
	}
}
