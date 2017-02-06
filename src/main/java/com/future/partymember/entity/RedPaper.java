package com.future.partymember.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 红色文章
 * @author 丁赵雷
 *
 */

@Entity
@Table(name = "red_paper", catalog = "partymember")
public class RedPaper {

	private int rp_Id;
	private int paperTypeId;//文章类别的id
	private String paperType;//作为一个辅助字段

	private String title;//标题
	private String content;//文章内容
	private int readNum;//阅读次数
	private int rp_tag;//文章状态
	private String author;//作者
	private String source;//来源  来源那个网站 
	private String releaseDate;//发布日期



	public RedPaper(String title, String content, int readNum, int rp_tag, String author, String source,
			String releaseDate) {
		super();
		this.title = title;
		this.content = content;
		this.readNum = readNum;
		this.rp_tag = rp_tag;
		this.author = author;
		this.source = source;
		this.releaseDate = releaseDate;
	}



	public RedPaper(String title, String content, int readNum, String author, String source, String releaseDate) {
		super();
		this.title = title;
		this.content = content;
		this.readNum = readNum;
		this.author = author;
		this.source = source;
		this.releaseDate = releaseDate;
	}



	public RedPaper(){
		
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
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	@Column(name="release_date")
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	@Column(name="paper_type_id")
	public int getPaperTypeId() {
		return paperTypeId;
	}
	public void setPaperTypeId(int paperTypeId) {
		this.paperTypeId = paperTypeId;
	}
	
	@Column(name="paper_type")
	public String getPaperType() {
		return paperType;
	}
	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}
	
	
	@Transient
	public String getStrTag(){
		switch(this.rp_tag){
		case 0:
			return "未发布";
		case 1:
			return "已发布";
		default :
			return "未定义"; 
		}
	}
	

	@Override
	public String toString() {
		return "RedPaper [rp_Id=" + rp_Id + ", paperTypeId=" + paperTypeId + ", paperType=" + paperType + ", title="
				+ title + ", content=" + content + ", readNum=" + readNum + ", rp_tag=" + rp_tag + ", author=" + author
				+ ", source=" + source + ", releaseDate=" + releaseDate + "]";
	}
}
