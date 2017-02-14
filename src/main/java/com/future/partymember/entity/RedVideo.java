package com.future.partymember.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 红色视频类
 * @author 丁赵雷
 *
 */

@Entity
@Table(name = "red_video", catalog = "partymember")
public class RedVideo {

	private int rv_Id;                                                                                                                                                                                                                                 
	@Column(length=20)
	private String name;
	@Column(length=255)
	private String description;//视频简介
	/*
	
	@Column(length=10)
	private String videoHome;//视频来源站点，目前有优酷和腾讯
	@Column(length=20)
	private String xid;//视频播放id,由url生成。
	
	*/
	@Column(length=200)
	private String videoUrl;//视频地址
	@Column(length=30)
	private String imgUrl;
	private int watchNum;//观看次数
	private int rv_tag;//视频状态
	
	private Date createTime;
	
	public RedVideo(){
		
	}
	
	public RedVideo(String name,String description, String videoUrl, int watchNum, int rv_tag) {
		super();
		this.name=name;
		this.description = description;
		this.videoUrl = videoUrl;
		this.watchNum = watchNum;
		this.rv_tag = rv_tag;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "rv_Id", unique = true, nullable = false)
	public int getRv_Id() {
		return rv_Id;
	}
	public void setRv_Id(int rv_Id) {
		this.rv_Id = rv_Id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public int getWatchNum() {
		return watchNum;
	}
	public void setWatchNum(int watchNum) {
		this.watchNum = watchNum;
	}
	public int getRv_tag() {
		return rv_tag;
	}
	public void setRv_tag(int rv_tag) {
		this.rv_tag = rv_tag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return "RedVideo [rv_Id=" + rv_Id + ", name=" + name + ", description=" + description + ", videoUrl=" + videoUrl
				+ ", imgUrl=" + imgUrl + ", watchNum=" + watchNum + ", rv_tag=" + rv_tag + "]";
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
