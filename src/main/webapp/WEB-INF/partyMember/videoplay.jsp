<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${video.name}</title>
</head>
<body>
		  <input type="hidden" value="${video.rv_Id}" id="videoId"/>
		   <input type="hidden" value="${currentTime}" id="oldcurrentTime"/>
		<video id="videos" width="320" height="240" controls onplay="startVideo()" >
		  <source src="${rootPath }${video.videoUrl}"  type="video/mp4">
		         您的浏览器不支持 HTML5 video 标签。
		</video>
		
</body>
<script type="text/javascript" src="${rootPath }js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${rootPath }js/learn_video_date.js"></script>
</html>