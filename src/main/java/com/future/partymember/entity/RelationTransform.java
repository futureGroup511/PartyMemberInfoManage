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
 * 党员关系转接类
 * @author 丁赵雷
 *
 */

@Entity
@Table(name = "relation_transform", catalog = "partymember")
public class RelationTransform {
	
	private int rtf_Id;
	private String oldPartyBranch;//原党支部
	private String newPartyBranch;//新党支部
	private Date transformDate;//转接时间
	private int partyMemberId;//党员的id
	private String proveAccessory;//转接证明附件
	
	
	
	
	public RelationTransform(){
		
	}
	
	public RelationTransform(String oldPartyBranch, String newPartyBranch, Date transformDate, int partyMemberId,
			String proveAccessory) {
		super();
		this.oldPartyBranch = oldPartyBranch;
		this.newPartyBranch = newPartyBranch;
		this.transformDate = transformDate;
		this.partyMemberId = partyMemberId;
		this.proveAccessory = proveAccessory;
	}
	
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "rtf_Id", unique = true, nullable = false)
	public int getRtf_Id() {
		return rtf_Id;
	}
	public void setRtf_Id(int rtf_Id) {
		this.rtf_Id = rtf_Id;
	}
	public String getOldPartyBranch() {
		return oldPartyBranch;
	}
	public void setOldPartyBranch(String oldPartyBranch) {
		this.oldPartyBranch = oldPartyBranch;
	}
	public String getNewPartyBranch() {
		return newPartyBranch;
	}
	public void setNewPartyBranch(String newPartyBranch) {
		this.newPartyBranch = newPartyBranch;
	}
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "transformDate",  nullable = false ,columnDefinition="DATE")
	public Date getTransformDate() {
		return transformDate;
	}
	public void setTransformDate(Date transformDate) {
		this.transformDate = transformDate;
	}
	public int getPartyMemberId() {
		return partyMemberId;
	}
	public void setPartyMemberId(int partyMemberId) {
		this.partyMemberId = partyMemberId;
	}
	public String getProveAccessory() {
		return proveAccessory;
	}
	public void setProveAccessory(String proveAccessory) {
		this.proveAccessory = proveAccessory;
	}

}
