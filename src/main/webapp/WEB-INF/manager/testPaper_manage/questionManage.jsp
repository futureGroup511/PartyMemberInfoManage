<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${rootPath}css/bootstrap.css">
<title>Insert title here</title>
</head>
<body>
	<div class="table-responsive">
		<table class="table table-bordered table-hover" style="text-align:center;width:70%;margin-left:15%;margin-top:5%;">
			<tr>
				<td>所属试卷名称</td>
				<td>题干</td>
				<td>答案</td>
				<td>解析</td>
				<td>分数</td>
				<td>A</td>
				<td>B</td>
				<td>C</td>
				<td>D</td>	
				<td>删除</td>			
			</tr>
			<c:forEach items="${pc.data}" var="q">
				<tr>
					<td>${q.paperName}</td>
					<td>${q.questions_stems}</td>
					<td>${q.answer}</td>
					<td>${q.analysis}</td>
					<td>${q.question_socre}</td>
					<td>${q.a}</td>
					<td>${q.b}</td>
					<td>${q.c}</td>
					<td>${q.d}</td>
					<td><a href="${rootPath }manage/testManage_deleteQuestion?id=${q.qt_Id}">刪除</a></td>
				</tr>
			</c:forEach>
		</table>
		
	</div>
	<div style="margin-left:42%;">
		<ul class="pagination">
			<li><a href="${rootPath }manage/testManage_getQuestion?page=${pc.prePage}">上一页</a></li> 
			<li><a href="#">${pc.currentPage}/${pc.pageNum}</a> </li>
			<li><a href="${rootPath }manage/testManage_getQuestion?page=${pc.nextPage}">下一页</a></li>
		</ul>
	</div>
	<h3>${delectQtMsg}</h3>
</body>
</html>