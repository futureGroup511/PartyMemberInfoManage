package com.future.partymember.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 试卷类与试题类是一对多的关系
 * @author 丁赵雷
 */

@Entity
@Table(name = "test_paper", catalog = "partymember")
public class TestPaper {
	private int tp_Id;
	private String paperName;//试卷名称 不能重复
	
	
	
	public TestPaper(){
		
	}
	
	public TestPaper(String paperName) {
		super();
		this.paperName = paperName;
	}
	
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "tp_Id", unique = true, nullable = false)
	public int getTp_id() {
		return tp_Id;
	}
	public void setTp_id(int tp_id) {
		this.tp_Id = tp_id;
	}
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

}
