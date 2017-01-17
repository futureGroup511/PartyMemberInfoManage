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
		  <div class="row">
		    <div class="col-lg-1 col-lg-offset-3 col-md-1 col-md-offset-3 col-xs-1 col-xs-offset-3">
			   <img src="${rootPath}images/header-logo.png">
			</div>
			<div class="col-lg-8 col-md-8 col-xs-8">
			    <p>河南科技学院党员信息管理系统</p>
			</div>
		  </div>
		</div>
	</div>
	<div class="body">
		<div class="header-one">
			<img src="${rootPath}images/header-one.png">
		</div>
		<div class="header-two">
			<img src="${rootPath}images/header-two.png">
		</div>
		<div class="header-three">
			<p id="headline" class="demo-text one">河南科技学院党员信息管理</p>
			<p class="two">河南科技学院党委主办</p>
		</div>
	</div>
	<div class="nav navbar-top">
		<div class="row">
			<div
				class="col-lg-7 col-lg-offset-2 col-md-7 col-md-offset-2 col-xs-7 col-xs-offset-2">
				<ul class=" nav navbar-nav">
					<li class="active"><a href="${rootPath}party/partyLogin.action">首页</a></li>
					<li><a href="${rootPath}party/partyMemberAction_viewVideos.action">红色视频</a></li>
					<li class="dropdown"><a href="##" data-toggle="dropdown"
						class="dropdown-toggle">个人信息<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${rootPath}party/partyMemberAction_seekPartyMemberInfo.action">查看个人信息</a></li>
							<li><a href="${rootPath}party/partyMemberAction_getInfoBeforeUpdate.action">修改个人信息</a></li>
						</ul></li>
					<!-- <li><a href="partyMemberAction_seekPartyMemberInfo.action">查看个人信息</a></li>
					<li><a href="partyMemberAction_getInfoBeforeUpdate.action">修改个人信息</a></li> -->
					<li><a href="##">红色文章</a></li>
					<li><a href="${rootPath}party/partyMemberAction_startTest.action">在线考试</a></li>
				</ul>
			</div>
			<div class="col-lg-3 col-md-3 col-xs-3">
				<span class="one">
					<!-- <a href="##">登录</a></span> <span class="two"> -->
					<a href="##">退出</a>
				</span>
			</div>
		</div>
	</div>
	<%-- <div class="body-one">
		<div class="col-lg-5 col-md-5 col-xs-5">
			<div id="slidershow" class="carousel slide" data-ride="carousel">
				<!--设置图片轮番的顺序-->
				<ol class="carousel-indicators">
					<li class="active" data-target="#slidershow" data-slide-to="0"></li>
					<li data-target="#slidershow" data-slide-to="1"></li>
					<li data-target="#slidershow" data-slide-to="2"></li>
					<li data-target="#slidershow" data-slide-to="3"></li>
				</ol>
				<!--设置轮播图片-->
				<div class="carousel-inner">
					<c:forEach items="${videosList}" var="v" varStatus="status">
						<c:choose>
							<c:when test="${status.index==0}">
								<div class="item active">
									<a href="${rootPath}/video_${v.rv_Id}.action"><img src="${rootPath}${v.imgUrl}"></a>
									<div class="carousel-caption">
										<h4>
											<a href="${rootPath}/video_${v.rv_Id}.action">${v.name}</a>
										</h4>
									</div>
								</div>
							</c:when>
							<c:otherwise>
								<c:if test="${status.index<=4}">
									<div class="item">
										<a href="${rootPath}/video_${v.rv_Id}.action"><img src="${rootPath}${v.imgUrl}"></a>
										<div class="carousel-caption">
											<h4>
												<a href="${rootPath}/video_${v.rv_Id}.action">${v.name}</a>
											</h4>
										</div>
									</div>
								</c:if>
							</c:otherwise>
						</c:choose>

					</c:forEach>
					<a class="left carousel-control" href="#slidershow" role="button"
						data-slide="prev"> <span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#slidershow" role="button"
						data-slide="next"> <span class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</div>
				<div class="col-lg-6 col-md-6 col-xs-6">
					<div id="body-two">
						<p>习近平：把思想政治工作贯穿教育教学全过程</p>
						<ul class="content">
							<li><a href="#">习近平就巴基斯坦民航客机失事向巴总统侯赛因致慰问电</a></li>
							<li><a href="#">李克强张德江分别会见加蓬总统邦戈</a></li>
							<li><a href="#">人民日报一论学习贯彻习近平总书记高校思想政治工作会议讲话</a></li>
						</ul>
					</div>
					<div class="col-lg-7 col-md-7 col-xs-7">
						<h5>党史要闻</h5>
						<li>曲青山在纪念万里同志诞辰100周年座谈会…</li>
						<li>曲青山到陕西宣讲党的十八届六中全会精神</li>
						<li>吴德刚：保证宪法全面有效实施</li>
						<li>冯俊为中央办公厅处级以上干部作十八届六中…</li>
					</div>
					<div class="col-lg-5 col-md-5 col-xs-5">
						<h5>共同关注</h5>
						<li>习近平总书记系列重要讲话集</li>
						<li>习近平“四个全面”重要论述</li>
						<li>习近平关于党的历史的论述摘编</li>
						<li>八集历史纪录片《永远的长征》</li>
					</div>
				</div>
			</div>
			<br>
			<div class="body-five">
				<img src="${rootPath}images/footer-one.png">
			</div>

			<!-- 视频列表 -->
	<div class="text">
		<div style="padding-left: 190px; ">
			<h4>
				<a href="partyMemberAction_viewVideos.action">红色视频>></a>
			</h4>
			<c:forEach items="${videosList}" var="v" varStatus="status">
				<c:choose>
					<c:when test="${(status.index)%6==0}">
						<div style="clear: both;"></div>
						<div style="width: 158px; float: left;">
							<div>
								<img src="${rootPath}${v.imgUrl}"
									style="height: 180px; width: 120px;">
							</div>
							<div style="height: 25px;">
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
 --%>
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
