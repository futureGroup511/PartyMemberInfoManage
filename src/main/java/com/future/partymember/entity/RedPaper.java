package com.future.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 红色文章
 * @author 丁赵雷
 *
 */

@Entity
@Table(name = "red_paper", catalog = "partymember")
public class RedPaper {


	private int rp_Id;
	private String title;//标题
	private String content;//文章内容
	private int readNum;//阅读次数
	private int rp_tag;//文章状态
	
	
	public RedPaper(){
		
	}
	
	public RedPaper(String title, String content, int readNum, int rp_tag) {
		super();
		this.title = title;
		this.content = content;
		this.readNum = readNum;
		this.rp_tag = rp_tag;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "rp_Id", unique = true, nullable = false)
	public int getRp_Id() {
		return rp_Id;
	}
	public void setRp_Id(int rp_Id) {
		this.rp_Id = rp_Id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	@Column(name = "content", nullable = false,columnDefinition="TEXT")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadNum() {
		return readNum;
	}
	public void setReadNum(int readNum) {
		this.readNum = readNum;
	}
	public int getRp_tag() {
		return rp_tag;
	}
	public void setRp_tag(int rp_tag) {
		this.rp_tag = rp_tag;
	}
}
