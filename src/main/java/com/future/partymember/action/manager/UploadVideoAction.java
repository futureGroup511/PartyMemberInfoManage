package com.future.partymember.action.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.future.partymember.base.BaseAction;

public class UploadVideoAction extends BaseAction {

	private File video;
	private String videoFileName;
	private String videoContentType;

	public String upload() throws IOException {
		String path = this.getContext().getRealPath("/WEB-INF/upload/video/");
		File file = new File(path, videoFileName);
		if (file.exists()) {
			this.getRequest().setAttribute("remind", "文件已经存在，请勿重复上传");
			return SUCCESS;
		}else{
			file.createNewFile();
		}
		FileOutputStream out = new FileOutputStream(file);
		FileInputStream in = new FileInputStream(video);
		byte[] buff = new byte[1024];
		int len=0;
		while ((len=in.read(buff)) > 0) {
			out.write(buff,0,len);
		}
		in.close();
		out.close();
		this.getRequest().setAttribute("remind", videoFileName+"上传成功");
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

}
