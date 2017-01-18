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
import javax.persistence.Transient;
/**
 * 通知类
 * 属性：id、标题、内容、发件人、日期  通知的状态
 * @author 丁赵雷
 *
 */
@Entity
@Table(name = "inform", catalog = "partymember")
public class Inform {
	
	private int info_Id;
	private String title;//通知标题
	private String content;//通知内容
	private int senderId;
	private int senderType;//0管理员，1书记
	private String addresser;//发布人
	private Date sendDate;//发布时间
	@Column(length=20)
	private String partBranch;//所属党支部

	/**
	 * 添加人：丁赵雷
	 * 目的：通知应有应该有四种情况 管理员可看 书记 党员 全体
	 */
	//0：仅管理员可见，即不可用状态；1：管理员、书记可看，即给书记的通知；2：管理员、党员能看，即
	//给党员的通知；3全体
	private int info_tag;

	public Inform() {
		super();
	}
	
	public Inform(String title, String content, String addresser, Date sendDate, int info_tag) {

		this.title = title;
		this.content = content;
		this.addresser = addresser;
		this.sendDate = sendDate;
		this.info_tag=info_tag;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "info_Id", unique = true, nullable = false)
	public int getInfo_Id() {
		return info_Id;
	}
	public void setInfo_Id(int info_Id) {
		this.info_Id = info_Id;
	}
	
	@Column(name = "title", nullable = false)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "content", nullable = false)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name = "addresser", nullable = false, length = 19)
	public String getAddresser() {
		return addresser;
	}
	public void setAddresser(String addresser) {
		this.addresser = addresser;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "sendDate", nullable = false, length = 19)
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	
	@Column(name = "info_tag", nullable = false)
	public int getInfo_tag() {
		return info_tag;
	}
	public void setInfo_tag(int info_tag) {
		this.info_tag = info_tag;
	}
	
	
	
	@Transient
	public String getStrTag(){
		switch(this.info_tag){
		case 0:
			return "仅管理员可见";
		case 1:
			return "仅书记可见";
		case 2:
			return "仅党员可见";
		case 3:
			return "所有人可见";
		default:
			return "未定义";
		}
	}
	
	
	@Override
	public String toString() {
		return "Inform [info_Id=" + info_Id + ", title=" + title + ", content=" + content + ", senderId=" + senderId
				+ ", senderType=" + senderType + ", addresser=" + addresser + ", sendDate=" + sendDate + ", partBranch="
				+ partBranch + ", info_tag=" + info_tag + "]";
	}


	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getSenderType() {
		return senderType;
	}

	public void setSenderType(int senderType) {
		this.senderType = senderType;
	}

	public String getPartBranch() {
		return partBranch;
	}

	public void setPartBranch(String partBranch) {
		this.partBranch = partBranch;
	}

}
