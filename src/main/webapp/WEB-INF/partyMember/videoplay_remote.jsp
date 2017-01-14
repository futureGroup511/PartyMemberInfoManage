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
		<div id="playvideo" typeid="${video.videoHome }" sid="${video.xid }" pic="${video.imgUrl }"></div>
		<%-- 
		<video id="videos" width="320" height="240" controls onplay="startVideo()" >
		  <source src="${rootPath }${video.videoUrl}"  type="video/mp4">
		         您的浏览器不支持 HTML5 video 标签。
		</video>
		 --%>
</body>

<script type="text/javascript" src="${rootPath }js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${rootPath }js/play-video.1.0.6.min.js"></script>
<script type="text/javascript" src="${rootPath }js/learn_video_date.js"></script>

<script type="text/javascript">
window.onload=function(){
	createVideo({id:"playvideo",autoplay:false,qqchannel:true});//单个直接调用。autoplay为false时可省略autoplay:false	
}

</script>
</html>