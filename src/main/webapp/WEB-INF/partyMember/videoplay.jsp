<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${video.name}</title>
<link rel="stylesheet" href="${rootPath}css/partyMember/head2.css">
<link rel="stylesheet"
	href="${rootPath}css/partyMember/bootstrap.css">
<link rel="stylesheet" href="${rootPath}css/partyMember/video.css">
<script src="${rootPath}js/jquery-2.2.3.min.js"></script>
<script src="${rootPath}js/bootstrap.js"></script>
<script type="text/javascript" src="${rootPath}js/learn_video_date.js"></script>
</head>

<body>
	<%@ include file="head.jsp" %>
	<div id="body">
		<div id="body-one">
			<p>
				<img src="${rootPath}images/topimg.png"> <span>您的位置：<a href="${rootPath}party/partyLogin.action">首页</a>&nbsp;&nbsp;>&nbsp;&nbsp;<a href="${rootPath}party/partyMemberAction_viewVideos.action">影音资料</a>&nbsp;&nbsp;>&nbsp;&nbsp;${video.name}</span>
			</p>
		</div>
		<div id="body-two">
			<p>${video.name}</p>
		</div>
		<div id="body-three">
			<input type="hidden" value="${video.rv_Id}" name="videoId" id="videoId" />
			<input type="hidden" value="${currentTime}" name="oldcurrentTime" id="oldcurrentTime" />
			<input type="hidden" value="${rootPath}" id="rootPath" />
			<video id="videos" width="320" height="240" controls
				onplay="startVideo()">
			<source src="${rootPath }${video.videoUrl}" type="video/mp4">
			<h3>您的浏览器不支持 HTML5 video 标签。</h3>
	</video>
		</div>
		<div id="body-four">
			<p>
				<span>上一部：<a href="${rootPath}party/partyMemberAction_viewing?rv_Id=${prev.rv_Id}">${prev.name }</a></span>
				<span>下一部：<a href="${rootPath}party/partyMemberAction_viewing?rv_Id=${next.rv_Id}">${next.name}</a></span>			
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
</html>