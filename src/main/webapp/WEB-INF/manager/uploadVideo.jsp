<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	上传本地视频
	<form action="${rootPath }manage/uploadVideo_upload" method="post" enctype="multipart/form-data">
	<h3 style="color:red;">${remind }</h3>
	视频：<input type="file" name="video">
	视频缩略图：<input type="file" name="img">
	视频描述：<textarea name="videoDescription" rows="5" cols="30"></textarea>
	
	<button type="submit">上传</button>
	</form>
	<hr>
	添加外部视频
	<form action="${rootPath }manage/uploadVideo_uploadOut" method="post" enctype="multipart/form-data">
		<input type="text" name="redVideo.name" placeholder="视频名字">
		<input type="text" name="redVideo.videoUrl" placeholder="视频地址">
		<input type="file" name="img" placeholder="视频缩略图">
		<textarea rows="5" cols="20" name="redVideo.description"  placeholder="视频描述"></textarea>
		<button type="submit">添加</button>
	</form>
</body>
</html>