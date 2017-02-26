<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>观看视频</title>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css">
<link rel="stylesheet" href="${rootPath }css/partySecretary/red_tou.css">
<link rel="stylesheet" href="${rootPath }css/partySecretary/video.css">
<script src="${rootPath }js/jquery-2.2.3.min.js"></script>
<script src="${rootPath }js/bootstrap.js"></script>
</head>

<body>

<%@ include file="../head.jsp"%>
<!--以上为头部-->
		
		
		
	<div id="body">
		<div id="body-one">
			<p>
				<img src="${rootPath}images/topimg.png"> <span>您的位置：
				<a href="${rootPath }secretary/pSForward_fIndex">首页</a>>
				<a href="${rootPath }secretary/partySecretary_videoList">影音资料</a>>
				视频</span>
			</p>
		</div>
		<div id="body-two">
			<p>${video.name}</p>
		</div>
		<div id="body-three">
			<input type="hidden" value="${video.rv_Id}" id="videoId" />
			<input type="hidden" value="${currentTime}" id="oldcurrentTime" />
			<video id="videos" width="520" height="440" controls
				onplay="startVideo()">
			<source src="${rootPath }${video.videoUrl}" type="video/mp4">
			<h3>您的浏览器不支持 HTML5 video 标签。</h3>
	</video>
		</div>
		<div id="body-four">
			<p>
				<span>上一部：<a href="${rootPath }secretary/partySecretary_lookVideo?rv_Id=${prev.rv_Id}">${prev.name }</a></span>
				<span>下一部：<a href="${rootPath }secretary/partySecretary_lookVideo?rv_Id=${next.rv_Id}">${next.name}</a></span>
			</p>
		</div>
	</div>
	<footer id="footer-warp">
		<!--页脚开始-->
		<p class="footer">
			<a href="">网站声明</a> &nbsp; &nbsp;<span>|</span> &nbsp; &nbsp;<a
				href="">关于我们 &nbsp; &nbsp;</a><span>|</span> &nbsp; &nbsp;<a href="">联系我们</a>
		</p>
		<p>Copyright @ 2016 All rights reserved. 版权所有：河南科技学院党委</p>
	</footer>
	<!--页脚结束-->
</body>
<script type="text/javascript" src="${rootPath }js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${rootPath }js/partSecretary_learn_time.js"></script>
<script type="text/javascript">
	var notice = "${notice}";
	if(notice===""){
		
	}else{
		alert(notice);
	}
	
</script>
</html>