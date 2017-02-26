package com.future.partymember.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 党委简介
 * @author 丁赵雷
 *
 */
@Entity
@Table(name = "party_introduction", catalog = "partymember")
public class PartyIntroduction {
	private int id;
	private String introduction;//党委简介
	
	
	
	public PartyIntroduction() {
		super();
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
	
	@Column(columnDefinition="TEXT")
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	
	@Override
	public String toString() {
		return "PartyIntroduction [id=" + id + ", introduction=" + introduction + "]";
	}

}
