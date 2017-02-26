package com.future.partymember.action.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.IndexImage;

public class IndexImageAction extends BaseAction{
	
	private File img;
	private String url;
	private int id;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return "add";
	}
	public String add(){
		// TODO Auto-generated method stub
		return "add";
	}
	public String addDo() throws IOException{
		String name = img.getName();
		name = new Date().getTime() +".jpg";
		FileInputStream fileInputStream = new FileInputStream(img);
		String path = this.getContext().getRealPath("/upload/indexImage/");
		FileOutputStream fileOutputStream = new FileOutputStream(new File(path,name));
		byte[] buff = new byte[1024];
		int len=0;
		while ((len=fileInputStream.read(buff)) > 0) {
			fileOutputStream.write(buff,0,len);
		}
		fileInputStream.close();
		fileOutputStream.close();
		IndexImage indexImage = new IndexImage();
		indexImage.setImgUrl("upload/indexImage/"+name);
		if(url == null){
			url="";
		}else{
			url=url.trim();
			if(!url.startsWith("http")){
				url="http://"+url;
			}
		}
		
		indexImage.setUrl(url);
		indexImage.setCreateTime(new Date());
		indexImageService.addIndexImg(indexImage);
		this.getRequest().setAttribute("remind","上传成功！");
		return "add";
	}
	
	public String manage(){
		
		this.getRequest().setAttribute("indexImages", indexImageService.getByNew(4));
		
		return "manage";
	}
	
	public String delete(){
		if(id<1){
			this.getRequest().setAttribute("indexImages", indexImageService.getByNew(4));
			return "manage";
		}
		boolean b =indexImageService.deleteById(id);
		if(b){
			this.getRequest().setAttribute("remind", "删除成功 ！");
		}
		this.getRequest().setAttribute("indexImages", indexImageService.getByNew(4));
		return "manage";
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
}
