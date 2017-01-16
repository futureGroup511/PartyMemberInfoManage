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
 * 党支部书记
 * @author 丁赵雷
 *
 */

@Entity
@Table(name = "party_secretary_info", catalog = "partymember")
public class PartySecretaryInfo extends UserInfo {
	
	private int pst_Id;//书记的id
	private Date joinPartyDate;//入党日期
	private String duties;//职务
	private String partyBranch;//所在党支部
	
	
	public PartySecretaryInfo(){
		
	}
	


	public PartySecretaryInfo( String username, String password, int age, String nation, Date birthdate,
			String nativePlace, String idCard, Date loginDate, String phoneNo, String sex, Date joinPartyDate,
			String duties, String partyBranch, long learnTime , String strLearnTime) {
		super( username, password, age, nation, birthdate, nativePlace, idCard, loginDate, phoneNo, sex, learnTime ,strLearnTime);
		this.joinPartyDate = joinPartyDate;
		this.duties = duties;
		this.partyBranch = partyBranch;
	}
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "pst_Id", unique = true, nullable = false)
	public int getPst_Id() {
		return pst_Id;
	}
	public void setPst_Id(int pst_Id) {
		this.pst_Id = pst_Id;
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
	
	
	@Column(name = "partyBranch", nullable = false, length = 19)
	public String getPartyBranch() {
		return partyBranch;
	}
	public void setPartyBranch(String partyBranch) {
		this.partyBranch = partyBranch;
	}
	
	@Override
	public String toString() {
		return "PartySecretaryInfo [pst_Id=" + pst_Id + ", joinPartyDate=" + joinPartyDate + ", duties=" + duties
				+ ", partyBranch=" + partyBranch + "]";
	}

}
