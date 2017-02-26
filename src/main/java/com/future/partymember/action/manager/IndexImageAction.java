package com.future.partymember.action.manager;

import java.io.File;

import com.future.partymember.base.BaseAction;

public class IndexImageAction extends BaseAction{
	
	private File img;
	private String url;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return "add";
	}
	public String add(){
		// TODO Auto-generated method stub
		return "add";
	}
	public String addDo(){
		
		return "add";
	}
	public File getImg() {
		return img;
	}
	public void setImg(File img) {
		this.img = img;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
