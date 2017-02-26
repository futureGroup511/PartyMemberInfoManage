<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线测试</title>
<link rel="stylesheet" href="${rootPath}css/partyMember/head2.css">
<link rel="stylesheet" href="${rootPath}css/partyMember/bootstrap.css">
<link rel="stylesheet" href="${rootPath}css/partyMember/online learning.css">
<script src="${rootPath}js/jquery-2.2.3.min.js"></script>
<script src="${rootPath}js/bootstrap.js"></script>

</head>

<body >
	<%@ include file="head.jsp" %>
	
	<div id="body">
		<div id="body-one">
			<p>
				<img src="${rootPath}images/topimg.png"> <span>您的位置：<a href="${rootPath}party/partyLogin.action">首页</a>&nbsp;&nbsp;>&nbsp;&nbsp;在线测试</span>
			</p>
		</div>
		<c:choose>
			<c:when test="${NoQuestion!=null}">
				<div id="body-two1">
					<p>${NoQuestion}</p>
				</div>
			</c:when>
			<c:otherwise>								
				<div id="body-three">
					<p>共 ${testNum} 题，总分 ${testScore} 分。</p>
				</div>
				<div id="body-four">
					<p>单选题</p>
				</div>
				<form id="form1" action="${rootPath}party/partyMemberAction_selfExamDetails.action">				
					<c:forEach items="${questionList}" var="q" varStatus="status">
						<div id="body-five">
							<p>
								${status.index+1}.${q.questions_stems}<span> * 分值:${q.question_socre}</span>
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
					<div class="submit">
						<input type="submit" value="交卷"  class="btn btn-primary">
						
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