package com.future.partymember.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 管理员类
 * @author Administrator
 *
 */
@Entity
@Table(name = "manager_info", catalog = "partymember")
public class ManagerInfo {
	
	private int id;
	private String sex;//性别
	private int age;//年龄
	private String sort;//用户身份
	private String account;//账号
	private String username;//用户名
	private String password;//登录密码
	private String phoneNo;//手机号
	
	
	public ManagerInfo(){
		super();
	}
	
	
	public ManagerInfo(String sex, int age, String sort, String username, String password, String phoneNo) {
		super();
		this.sex = sex;
		this.age = age;
		this.sort = sort;
		this.username = username;
		this.password = password;
		this.phoneNo = phoneNo;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	@Column(name = "sex", nullable = false, length = 10)
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	@Column(name = "age", nullable = false, length = 10)
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	@Column(name = "sort", nullable = false, length = 10)
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	
	
	@Column(name = "username", nullable = false, length = 19)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	@Column(name = "password", nullable = false, length = 500)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Column(name = "phoneNo", nullable = false, length = 19)
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
}
