<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>党员首页</title>
<link rel="stylesheet" href="${rootPath}css/bootstrap.css">
<link rel="stylesheet" href="${rootPath}css/index-one.css">
<script src="${rootPath}js/jquery-2.2.3.min.js"></script>
<script src="${rootPath}js/bootstrap.js"></script>
</head>

<body>
	<div class="container">
		<div class="header">
			<img src="${rootPath}images/header-logo.png">
			<p>河南科技学院党员信息管理系统</p>
		</div>
	</div>
	<div class="body">
		<div class="header-one">
			<img src="${rootPath}images/header-one.jpg">
		</div>
		<div class="header-two">
			<img src="${rootPath}images/header-two.jpg">
		</div>
		<div class="header-three">
			<p id="headline" class="demo-text one">河南科技学院党员信息管理</p>
			<p class="two">河南科技学院党委主办</p>
		</div>
	</div>
	<div class="nav navbar-top">
		<div class="row">
			<div
				class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-xs-8 col-xs-offset-2">
				<ul class=" nav navbar-nav">
					<li class="active"><a href="partyLogin.action">首页</a></li>
					<li><a href="partyMemberAction_viewVideos.action">红色视频</a></li>
					<li class="dropdown"><a href="##" data-toggle="dropdown"
						class="dropdown-toggle">个人信息<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="partyMemberAction_seekPartyMemberInfo.action">查看个人信息</a></li>
							<li><a href="partyMemberAction_getInfoBeforeUpdate.action">修改个人信息</a></li>
						</ul></li>
					<!-- <li><a href="partyMemberAction_seekPartyMemberInfo.action">查看个人信息</a></li>
					<li><a href="partyMemberAction_getInfoBeforeUpdate.action">修改个人信息</a></li> -->
					<!-- <li><a href="##">军事</a></li> -->
					<!-- <li><a href="##">生活</a></li> -->
				</ul>
			</div>
			<div class="col-lg-2 col-md-2 col-xs-2">
				<span class="one"><!-- <a href="##">登录</a></span> <span class="two"> --><a
					href="##">退出</a></span>
			</div>
		</div>
	</div>
	<div class="body-five">
		<img src="${rootPath}images/footer-one.png">
	</div>
	
	<!-- 视频列表 -->
	<div style="/* height:500px; */padding-left: 190px;">	 
		<c:forEach items="${videosList}" var="v" varStatus="status">
		<c:choose>
			<c:when test="${(status.index)%6==0}">
			<div style="clear: both;"></div>			
				<div style="width: 158px;float: left;">
					<div>
						<img src="${rootPath}${v.imgUrl}"
							style="height: 180px; width: 120px;">
					</div>
					<div style="height:25px;">
						<a href="${rootPath}/video_${v.rv_Id}.action" target="_blank">${v.name}</a>
					</div>
					
				</div>
			</c:when>
			<c:otherwise>
				
				<div style="float: left; width: 150px;">
					<div>
						<img src="${rootPath}${v.imgUrl}"
							style="height: 180px; width: 120px;">
					</div>
					<div>
						<a href="${rootPath}/video_${v.rv_Id}.action" target="_blank">${v.name}</a>
					</div>
					
				</div>
			</c:otherwise>
		</c:choose>

	</c:forEach>
	</div>
	
	
	<div class="footer">
		<img src="${rootPath}images/footer.png">
		<div class="footer-one">
			<p>河南科技学院党员网站 京ICP备11032580号</p>
			<p>Copyright © 2012 by zgdsw.org.cn. all rights reserved</p>
		</div>
	</div>
	
</body>
</html>