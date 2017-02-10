<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考试记录详情</title>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css">
<link rel="stylesheet" href="${rootPath }css/partySecretary/the questionnaire results.css">
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
				<a href="${rootPath }secretary/pSForward_fIndex">首页</a>><a href="#" data-toggle="dropdown" class="dropdown-toggle">个人中心
				></a><a href="${rootPath}secretary/partySecretary_getMyExamLog">考试报告</a>>考试详情</span>
			</p>
		</div>
		<c:if test="${NotQusetionInfo!=null}">
			<div id="NotMsg">
				<h4>${NotQusetionInfo }</h4>
			</div>
		</c:if>
		<c:if test="${NotQusetionInfo==null}">
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
							<P class="four">正确答案为：B.</P>
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
		</c:if>
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