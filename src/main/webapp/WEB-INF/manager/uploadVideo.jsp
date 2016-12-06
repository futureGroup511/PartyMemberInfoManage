<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	上传视频
	<form action="${rootPath }manage/uploadVideo_upload" method="post" enctype="multipart/form-data">
	<h3 style="color:red;">${remind }</h3>
	<input type="file" name="video">
	视频描述：<textarea name="videoDescription" rows="5" cols="30"></textarea>
	
	<button type="submit">上传</button>
	</form>
	
</body>
</html>