<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考试记录</title>
<link rel="stylesheet" href="${rootPath}css/partyMember/bootstrap.css">
<link rel="stylesheet" href="${rootPath}css/partyMember/myExamLog.css">
<script src="${rootPath}js/jquery-2.2.3.min.js"></script>
<script src="${rootPath}js/bootstrap.js"></script>
</head>

<body>
	<div id="header">
		<div class="header-left">
			<img src="${rootPath}images/header-logo.png">
		</div>
		<div class="header-center">
			<p class="top">
				<b><strong>河南科技学院信息工程学院党委主办</strong></b>
			</p>
			<p class="bottom">
				<b><strong>河南科技学院党员在线</strong></b>
			</p>
		</div>
		<div class="header-right">
			<div>
				<select>
					<option>时事新闻</option>
					<option>生活百科</option>
					<option>新闻动态</option>
					<option>通知公告</option>
				</select> <input type="text" name="select" placeholder="请输入您要搜索的内容">
				<button class="btn">
					<img src="${rootPath}images/sousuo.png" width="22" height="22">
				</button>
			</div>
		</div>
	</div>
	<div class="nav">
		<div class="row">
			<div
				class="col-lg-8 col-lg-offset-3 col-md-8 col-md-offset-3 col-xs-8 col-xs-offset-3">
				<ul class="nav navbar-nav">
					<li><a href="${rootPath}party/partyLogin.action">网站首页</a></li>
					<li><a href="${rootPath }party/partyMemberAction_getResPaper.action">红色文章</a></li>
					<li><a
						href="${rootPath}party/partyMemberAction_viewVideos.action">红色视频</a></li>
					<li><a
						href="${rootPath}party/partyMemberAction_startTest.action">在线考试</a></li>
					<li class="dropdown"><a href="#" data-toggle="dropdown"
						class="dropdown-toggle">个人中心<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a
								href="${rootPath}party/partyMemberAction_seekPartyMemberInfo.action">个人信息</a></li>
							<li><a
								href="${rootPath}party/partyMemberAction_getInfoBeforeUpdate.action">修改信息</a></li>
							<li><a
								href="${rootPath}party/partyMemberAction_getMyExamLog.action">考试报告</a></li>
						</ul></li>
					<li><a href="information.jsp">通知公告</a></li>
					<li><a href="${rootPath}connect_us.jsp">联系我们</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div id="body">
		<div id="body-one">
			<p>
				<img src="${rootPath}images/topimg.png"> <span>您的位置：首页>个人中心>考试报告</span>
			</p>
		</div>
		<c:choose>
			<c:when test="${myExamLogMsg!=null }">
				<h4></h4>
				<div id="body-two">
					<p>${myExamLogMsg}</p>
				</div>
			</c:when>
			<c:otherwise>
				<div id="body-three">
					<div class="table-responsive">
						<table class="table table-bordered table-hover table-striped">
							<thead>
								<tr class="two">
									<th>试卷名称</th>
									<th>试卷题数</th>
									<th>考试时长</th>
									<th>考试时间</th>
									<th>试卷总分</th>
									<th>考试成绩</th>
									<th>考试详情</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${examLogList}" var="e">
									<tr>
										<td>${e.paperName}</td>
										<td>${e.testNum}</td>
										<td>${e.testTime}</td>
										<td>${e.examTime}</td>
										<td>${e.testTotalScore}</td>
										<td>${e.totalScore}</td>
										<td><a
											href="partyMemberAction_getExamDetails.action?tp_Id=${e.paper_Id}">详情</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

				<div class="container">
					<p class="xixnxi">每页显示10条，总记录数4条</p>
					<nav>
						<ul class="pagination">
							</li>
							<li><a href="#">首页</a></li>
							<li><a href="#">上一页</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">下一页</a></li>
							<li><a href="#">尾页</a></li>
							</li>
						</ul>
					</nav>
				</div>
			</c:otherwise>
		</c:choose>
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

<%-- </head>
<body>
	<c:choose>
		<c:when test="${myExamLogMsg!=null }">
			<h4>${myExamLogMsg}</h4>
		</c:when>
		<c:otherwise>
			<table>
				<tr>
					<td>试卷名称</td>
					<td>试卷题数</td>					
					<td>考试时长</td>
					<td>考试时间</td>
					<td>试卷总分</td>
					<td>考试成绩</td>
					<td>考试详情</td>					
				</tr>
				
				<c:forEach items="${examLogList}" var="e">
					<tr>
						<td>${e.paperName}</td>
						<td>${e.testNum}</td>										
						<td>${e.testTime}</td>
						<td>${e.examTime}</td>
						<td>${e.testTotalScore}</td>
						<td>${e.totalScore}</td>
						<td><a href="partyMemberAction_getExamDetails.action?tp_Id=${e.paper_Id}">详情</a></td>	
					</tr>					
				</c:forEach>
				
			</table>
			
		</c:otherwise>
	</c:choose>
</body>
</html> --%>