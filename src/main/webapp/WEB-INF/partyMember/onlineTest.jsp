<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线考试</title>

<link rel="stylesheet" href="${rootPath}css/partyMember/bootstrap.css">
<link rel="stylesheet" href="${rootPath}css/partyMember/online learning.css">
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
	<div class="nav navbar-inverse">
		<div class="row">
			<div
				class="col-lg-8 col-lg-offset-3 col-md-8 col-md-offset-3 col-xs-8 col-xs-offset-3">
				<ul class="nav navbar-nav">
					<li><a href="${rootPath}party/partyLogin.action">网站首页</a></li>
					<li><a href="${rootPath }secretary/pSForward_paperList.action">红色文章</a></li>
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
				<img src="${rootPath}images/topimg.png"> <span>您的位置：首页>在线考试</span>
			</p>
		</div>
		<c:choose>
			<c:when test="${NoTest!=null}">
				<div id="body-two">
					<p>${NoTest}</p>
				</div>
			</c:when>
			<c:otherwise>
				<div id="body-two">
					<p>${startTest.paperName}</p>
				</div>
				<div id="body-three">
					<p>共 ${startTest.testNum} 题，总分 ${startTest.totalScore} 分。考试时间 ${startTest.testTime}</p>
				</div>
				<div id="body-four">
					<p>单选题</p>
				</div>
				<form action="${rootPath}party/partyMemberAction_getExamRecord.action">				
					<c:forEach items="${questionsList}" var="q" varStatus="status">
						<div id="body-five">
							<p>
								${status.index+1}.${q.questions_stems}<span> *  分值: ${q.question_socre}</span>
							</p>
							<div class="radio">
								<label> <input type="radio" name="answer${status.index}" required="required"
									id="optionsRadios1" value="A${q.qt_Id}"> A. ${q.a}
								</label>
							</div>
							<div class="radio">
								<label> <input type="radio" name="answer${status.index}" required="required"
									id="optionsRadios2" value="B${q.qt_Id}"> B. ${q.b}									
								</label>
							</div>
							<div class="radio">
								<label> <input type="radio" name="answer${status.index}" required="required"
									id="optionsRadios3" value="C${q.qt_Id}"> C. ${q.c}
								</label>
							</div>
							<div class="radio">
								<label> <input type="radio" name="answer${status.index}" required="required"
									id="optionsRadios4" value="D${q.qt_Id}"> D. ${q.d}
								</label>
							</div>
						</div>
					</c:forEach>
					<div style="margin-left: 500px;margin-top: 30px;">
						<input type="submit" value="交卷" style="margin-button: 10px;">
						<h4>${addExamLogMsg}</h4>
					</div>					
				</form>
			</c:otherwise>
		</c:choose>														
	</div>
	<footer id="footer-warp"><!--页脚开始-->
	<p class="footer">
		<a href="">网站声明</a> &nbsp; &nbsp;<span>|</span> &nbsp; &nbsp;<a
			href="">关于我们 &nbsp; &nbsp;</a><span>|</span> &nbsp; &nbsp;<a href="">联系我们</a>
	</p>
	<p>Copyright @ 2016 All rights reserved. 版权所有：河南科技学院党委</p>
	</footer>
	<!--页脚结束-->
</body>
</html>