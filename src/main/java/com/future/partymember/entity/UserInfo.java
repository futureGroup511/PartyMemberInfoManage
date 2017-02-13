package com.future.partymember.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *  类属性：  用户身份、用户名、登录密码
 * @author 丁赵雷
 *用户类的父类
 */

@MappedSuperclass
public class UserInfo {
	private String sex;//性别
	private String account ;//账号
	
	private String username;//姓名
	private String password;//登录密码
	private int age;//年龄
	private String nation;//民族
	private Date birthdate;//出生日期
	private String nativePlace;//籍贯
	private String idCard;//身份证号
	private Date loginDate;//注册日期
	private String phoneNo;//手机号
	private long learnTime=0L;//学习时长 
	private String strLearnTime="0";//格式转化过的学习时长
	
	
	public UserInfo(String username, String password, int age, String nation, Date birthdate,
			String nativePlace, String idCard, Date loginDate, String phoneNo, String sex, long learnTime,
			String strLearnTime) {
		super();		
		this.username = username;
		this.password = password;
		this.age = age;
		this.nation = nation;
		this.birthdate = birthdate;
		this.nativePlace = nativePlace;
		this.idCard = idCard;
		this.loginDate = loginDate;
		this.phoneNo = phoneNo;
		this.sex=sex;
		this.learnTime=learnTime;
		this.strLearnTime=strLearnTime;
	}
	
	//焦祥宇修改
	/*account, sort, loginDate,  learnTime*/
	public UserInfo(String account, Date loginDate, long learnTime) {
		super();
		this.account=account;		
		this.loginDate = loginDate;		
		this.learnTime=learnTime;
	}
	
	public UserInfo() {
	}

	@Column(name = "username", nullable = false, length = 19)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	@Column(name = "password", nullable = false, length = 40)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Column(name = "age", nullable = false)
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	@Column(name = "nation", nullable = false, length = 19)
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "birthdate", nullable = false, length = 19 ,columnDefinition="DATE")
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	
	@Column(name = "nativePlace", nullable = false, length = 19)
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	
	
	@Column(name = "idCard", nullable = false, length = 19)
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "loginDate", nullable = false, length = 19, columnDefinition="DATE")
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	
	
	@Column(name = "phoneNo", nullable = false, length = 19)
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	@Column(name = "sex", nullable = false, length = 5)
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	@Column(columnDefinition="BIGINT")
	public long getLearnTime() {
		return learnTime;
	}
	public void setLearnTime(long learnTime) {
		this.learnTime = learnTime;
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	public String getStrLearnTime() {
		return strLearnTime;
	}

	public void setStrLearnTime(String strLearnTime) {
		this.strLearnTime = strLearnTime;
	}
}
