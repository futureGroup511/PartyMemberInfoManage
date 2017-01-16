package com.future.partymember.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 非党员也就算是团员
 * @author 丁赵雷
 *
 */

@Entity
@Table(name="league_member" , catalog="partymember")
public class LeagueMember extends UserInfo {

	private int lm_id;
	private String status;//团员现在的状态，如积极分子
	private String activeAccessory;//成为积极分子时提交的附件
	private String developmentAccessory;//成为预备党员时提交的附件
	
/*	1、写入党申请书，申请加入中国共产党
	2、向所在专业的党支部提交入党申请书
	3、经过班级同学选举，成为入党积极分子
	4、经过党内人员选举决议，成为发展对象
	5、进过发展对象培训后，考试结业，填写入党志愿书，成为预备党员
	6、经过一年的预备期，考核合格后，转正为正式党员*/
	
	public LeagueMember() {
		
	}
	
	
	public LeagueMember( String username, String password, int age, String nation, Date birthdate,
			String nativePlace, String idCard, Date loginDate, String phoneNo, String sex, String status,
			String activeAccessory, String developmentAccessory, Long learnTime, String strLearnTime) {
		super( username, password, age, nation, birthdate, nativePlace, idCard, loginDate, phoneNo, sex, learnTime, strLearnTime);
		this.status = status;
		this.activeAccessory = activeAccessory;
		this.developmentAccessory = developmentAccessory;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "lm_Id", unique = true, nullable = false)
	public int getLm_id() {
		return lm_id;
	}

	public void setLm_id(int lm_id) {
		this.lm_id = lm_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getActiveAccessory() {
		return activeAccessory;
	}
	public void setActiveAccessory(String activeAccessory) {
		this.activeAccessory = activeAccessory;
	}
	public String getDevelopmentAccessory() {
		return developmentAccessory;
	}
	public void setDevelopmentAccessory(String developmentAccessory) {
		this.developmentAccessory = developmentAccessory;
	}
}
