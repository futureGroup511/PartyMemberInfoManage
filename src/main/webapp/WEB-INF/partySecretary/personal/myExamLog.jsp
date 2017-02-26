<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考试记录</title>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css">
<link rel="stylesheet" href="${rootPath }css/partySecretary/red_tou.css">
<link rel="stylesheet" href="${rootPath }css/partySecretary/list.css">
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
				个人中心>考试报告</span>
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
											href="${rootPath }secretary/partySecretary_getExamDetails?tp_Id=${e.paper_Id}&el_Id=${e.el_Id}&st_Id=${e.st_Id}">详情</a></td>
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