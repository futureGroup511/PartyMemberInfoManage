<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考试记录</title>
</head>
<body>
	<c:choose>
		<c:when test="${myExamLogMsg!=null }">
			<h4>${myExamLogMsg}</h4>
		</c:when>
		<c:otherwise>
			<table>
				<tr>
					<td>试卷名称</td>
					<td>考试总成绩</td>
					<td>考试时长</td>
					<td>考试时间</td>
					<td>考试详情</td>
				</tr>
				
				<c:forEach items="${examLogList}" var="e">
					<tr>
						<td>${e.paperName}</td>
						<td>${e.totalScore}</td>
						<td>${e.testTime}</td>
						<td>${e.examTime}</td>
						<td><a href="#">详情</a></td>	
					</tr>					
				</c:forEach>
				
			</table>
			
		</c:otherwise>
	</c:choose>
</body>
</html>