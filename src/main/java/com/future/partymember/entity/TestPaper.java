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
	private String paperName ; //试卷名称 不能重复	
	private String description ; //试卷的说明， 描述 
	private String createDate ; // 试卷创建日期
	
	
	public TestPaper(){
		
	}
	
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "tp_Id", unique = true, nullable = false)
	public int getTp_Id() {
		return tp_Id;
	}

	public void setTp_Id(int tp_Id) {
		this.tp_Id = tp_Id;
	}

	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}
