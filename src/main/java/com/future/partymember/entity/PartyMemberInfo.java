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
 * 党员类
 * @author 丁赵雷
 *
 */

@Entity
@Table(name = "party_member_info", catalog = "partymember")
public class PartyMemberInfo extends UserInfo {
	

	private int ptm_Id;//党员的id
	private String idAccessory;//身份附件
	private Date joinPartyDate;//入党日期
	private String duties;//职务
	private String introducer;//介绍人
	private String partyBranch;//所在党支部
	
		
	public PartyMemberInfo( String username, String password, int age, String nation, Date birthdate,
			String nativePlace, String idCard, Date loginDate, String phoneNo, String idAccessory, Date joinPartyDate,
			String duties, String introducer, String partyBranch, String sex, long learnTime, String strLearnTime) {
		super( username, password, age, nation, birthdate, nativePlace, idCard, loginDate, phoneNo, sex, learnTime, strLearnTime);
		this.idAccessory = idAccessory;
		this.joinPartyDate = joinPartyDate;
		this.duties = duties;
		this.introducer = introducer;
		this.partyBranch = partyBranch;
	}
	
	//焦祥宇修改
	/*public PartyMemberInfo(String username, String password, int age, String nation, Date birthdate,
			String nativePlace, String idCard, String phoneNo, String idAccessory, 
			 String sex) {
		super( username, password, age, nation, birthdate, nativePlace, idCard, phoneNo, sex, );
		this.idAccessory = idAccessory;
		this.joinPartyDate = joinPartyDate;
		this.duties = duties;
		this.introducer = introducer;
		this.partyBranch = partyBranch;
	}*/
	public void updatePartyMemberInfo(int ptm_Id,String account, Date loginDate,  Date joinPartyDate,
			String duties, String introducer, String partyBranch, long learnTime) {
		
		/*super(account,sort,   loginDate,  learnTime);	*/
		this.setAccount(account);
		this.setLoginDate(loginDate);
		this.setLearnTime(learnTime);
		this.ptm_Id=ptm_Id;
		this.joinPartyDate = joinPartyDate;
		this.duties = duties;
		this.introducer = introducer;
		this.partyBranch = partyBranch;
	}
	
	public PartyMemberInfo() {
	}



	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ptm_Id", unique = true, nullable = false)
	public int getPtm_Id() {
		return ptm_Id;
	}
	public void setPtm_Id(int ptm_Id) {
		this.ptm_Id = ptm_Id;
	}
	
	
	@Column(name = "idAccessory",  nullable = false)
	public String getIdAccessory() {
		return idAccessory;
	}
	public void setIdAccessory(String idAccessory) {
		this.idAccessory = idAccessory;
	}
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "joinPartyDate",  nullable = false, columnDefinition="DATE")
	public Date getJoinPartyDate() {
		return joinPartyDate;
	}
	public void setJoinPartyDate(Date joinPartyDate) {
		this.joinPartyDate = joinPartyDate;
	}
	
	
	@Column(name = "duties", nullable = false, length = 19)
	public String getDuties() {
		return duties;
	}
	public void setDuties(String duties) {
		this.duties = duties;
	}
	
	
	@Column(name = "introducer", nullable = false, length = 19)
	public String getIntroducer() {
		return introducer;
	}
	public void setIntroducer(String introducer) {
		this.introducer = introducer;
	}
	
	
	@Column(name = "partyBranch", nullable = false, length = 19)
	public String getPartyBranch() {
		return partyBranch;
	}
	public void setPartyBranch(String partyBranch) {
		this.partyBranch = partyBranch;
	}

	@Override
	public String toString() {
		return this.getAccount()+" | "+this.getPassword()+"PartyMemberInfo [ptm_Id=" + ptm_Id + ", idAccessory=" + idAccessory + ", joinPartyDate=" + joinPartyDate
				+ ", duties=" + duties + ", introducer=" + introducer + ", partyBranch=" + partyBranch + "]";
	}
	
}
