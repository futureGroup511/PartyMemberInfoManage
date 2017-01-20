<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考试记录详情</title>
<link rel="stylesheet" href="${rootPath}css/partyMember/bootstrap.css">
<link rel="stylesheet"
	href="${rootPath}css/partyMember/the questionnaire results.css">
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
				<img src="${rootPath}images/topimg.png"> <span>您的位置：<a href="${rootPath}party/partyLogin.action">首页</a>>个人中心><a href="${rootPath}party/partyMemberAction_getMyExamLog.action"">考试报告</a>>考试详情</span>
			</p>
		</div>
		<div id="body-big">
			<div id="body-two">
				<p>${examLog.paperName}</p>
			</div>
			<div id="body-three">
				<p>前言</p>
			</div>
			<div id="body-four">
				<p>考试结束，请查看你的成绩</p>
			</div>
			<div id="body-five">
				<p>成绩单</p>
			</div>
			<div id="body-six">
				<table class="table table-bordered table-hover">
					<tbody>
						<tr>
							<td>测试题数：${examLog.testNum } 题</td>
							<td>问卷满分：${examLog.testTotalScore} 分</td>
							<td>您的得分：${examLog.totalScore} 分</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div id="body-seven">
				<p>答案辨析</p>
			</div>
			<div id="body-eight">
				<p>单选题</p>
			</div>
			<c:forEach items="${questionsList}" var="q" varStatus="status">
				<div id="body-nine">
					<p>${status.index+1}.${q.questions_stems}(分值:${q.question_socre})
						得分：${q.myScore}</p>
					<p class="six">A. ${q.a}.</p>
					<p class="six">B. ${q.b}.</p>
					<p class="six">C. ${q.c}.</p>
					<p class="six">D. ${q.d}.</p>

					<c:choose>
						<c:when test="${q.myAnswer!=null}">
							<p class="three">
								您的回答为：${q.myAnswer}.<img src="${rootPath}images/cuohao.png">
							</p>
							<P class="four">正确答案为：${q.answer}.</P>
							<p class="four">解析：${q.analysis}</p>					
						</c:when>
						<c:otherwise>
							<p class="five">
								您的回答为：${q.answer}.<img src="${rootPath}images/duihao.png"><span>&nbsp;&nbsp;&nbsp;(得分：2)</span>
							</p>							
							<p class="four">解析：${q.analysis}</p>						
						</c:otherwise>
					</c:choose>					
				</div>
			</c:forEach>					
		</div>
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