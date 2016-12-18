<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<table>
			<tr>
				<td>试卷名称</td>
				<td>试卷说明</td>
				<td>创建时间</td>
							
			</tr>
			<c:forEach items="${pc.data}" var="t">
				<tr>
					<td>${t.paperName}</td>
					<td>${t.description}</td>
					<td>${t.createDate }</td>					
					<td><a href="${rootPath }manage/testManage_delete?id=${t.tp_Id}">刪除</a></td>
				</tr>
			</c:forEach>
		</table>
		<h3>${delectQtMsg}</h3>
	</div>
	<div>
		<a href="${rootPath }manage/testManage_getTestPaper?page=${pc.prePage}">上一页</a> 
		<a href="#">${pc.currentPage}/${pc.pageNum}</a> 
		<a href="${rootPath }manage/testManage_getTestPaper?page=${pc.nextPage}">下一页</a>
	</div>
</body>
</html>