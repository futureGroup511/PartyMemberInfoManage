package com.future.partymember.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 红色文章的类别
 * @author 丁赵雷 便于程序扩展
 *
 */
@Entity
@Table(name="red_paper_type", catalog="partymember" )
public class RedPaperType {
	private int rpt_Id ;
	private String paperType ; // 红色文章的类别

	private String description ; //对于这个类别的描述
	
	
	public RedPaperType(String paperType, String description) {
		super();
		this.paperType = paperType;
		this.description = description;
	}
	
	public RedPaperType(){
		
	}
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "rpt_Id", unique = true, nullable = false)
	public int getRpt_Id() {
		return rpt_Id;
	}
	public void setRpt_Id(int rpt_Id) {
		this.rpt_Id = rpt_Id;
	}
	public String getPaperType() {
		return paperType;
	}
	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
