package com.future.partymember.action.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.crypto.spec.RC2ParameterSpec;

import org.springframework.expression.spel.ast.IntLiteral;

import com.future.partymember.base.BaseAction;
import com.future.partymember.entity.RedVideo;

public class UploadVideoAction extends BaseAction {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File video;
	private String videoFileName;
	private String videoContentType;
	private String videoDescription;
	private File img;
	private String imgFileName;
	private RedVideo redVideo;
	
	public String upload() throws IOException {
	
		if(video==null||img==null){
			this.getRequest().setAttribute("remind","请按要求输入" );
			return SUCCESS;
		}
		
		String type=videoFileName.substring(videoFileName.lastIndexOf("."));
		String name = videoFileName.substring(0, videoFileName.lastIndexOf("."));
		if(name.length()>20){
			this.getRequest().setAttribute("remind","视频名字过长，要在20字内。" );
			return SUCCESS;
		}
		if(!type.equals(".mp4")){
			this.getRequest().setAttribute("remind","请上传MP4格式的视频");
			return SUCCESS;
		}
		String path = this.getContext().getRealPath("/upload/video/");
		Date date=new Date();
		String fileName=date.getTime()+type;
		FileOutputStream out = new FileOutputStream( new File(path, fileName));
		
		FileInputStream in = new FileInputStream(video);
		
		byte[] buff = new byte[1024];
		int len=0;
		while ((len=in.read(buff)) > 0) {
			out.write(buff,0,len);
		}
		in.close();
		out.close();
		String imgName=date.getTime()+imgFileName.substring(imgFileName.lastIndexOf("."));
		FileOutputStream outImg = new FileOutputStream( new File(path, imgName));
		
		FileInputStream inImg = new FileInputStream(img);
		while ((len=inImg.read(buff)) > 0) {
			outImg.write(buff,0,len);
		}
		inImg.close();
		outImg.close();
		
		RedVideo rv=new RedVideo( name,videoDescription,"upload/video/"+fileName,0,1);
		
		rv.setImgUrl("upload/video/"+imgName);
		rv.setCreateTime(new Date());
		redVideoService.addVideo(rv);
		this.getRequest().setAttribute("remind", videoFileName+"上传成功");
		return SUCCESS;
	}

	public String uploadOut() throws IOException{
		if (redVideo==null||redVideo.getVideoUrl().length()<2) {
			this.getRequest().setAttribute("remind", "请正确填写");
			return SUCCESS;
		}
		if(img==null){
			this.getRequest().setAttribute("remind","请上传缩略图" );
			return SUCCESS;
		}
		String path = this.getContext().getRealPath("/upload/video/");
		Date date=new Date();
		
		String imgName=date.getTime()+imgFileName.substring(imgFileName.lastIndexOf("."));
		FileOutputStream outImg = new FileOutputStream( new File(path, imgName));
		
		FileInputStream inImg = new FileInputStream(img);
		int len=0;
		byte[] buff = new byte[1024];
		while ((len=inImg.read(buff)) > 0) {
			outImg.write(buff,0,len);
		}
		inImg.close();
		outImg.close();
		redVideo.setImgUrl(imgName);
		redVideo.setCreateTime(new Date());
		redVideoService.addVideo(redVideo);
		
		this.getRequest().setAttribute("remind", "添加成功");
		return SUCCESS;
	}
	public File getVideo() {
		return video;
	}

	public void setVideo(File video) {
		this.video = video;
	}

	public String getVideoFileName() {
		return videoFileName;
	}

	public void setVideoFileName(String videoFileName) {
		this.videoFileName = videoFileName;
	}

	public String getVideoContentType() {
		return videoContentType;
	}

	public void setVideoContentType(String videoContentType) {
		this.videoContentType = videoContentType;
	}

	public String getVideoDescription() {
		return videoDescription;
	}

	public void setVideoDescription(String videoDescription) {
		this.videoDescription = videoDescription;
	}

	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public RedVideo getRedVideo() {
		return redVideo;
	}

	public void setRedVideo(RedVideo redVideo) {
		this.redVideo = redVideo;
	}


}
