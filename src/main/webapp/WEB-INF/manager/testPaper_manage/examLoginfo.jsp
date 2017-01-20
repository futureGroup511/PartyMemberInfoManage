<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${rootPath}css/bootstrap.css">
<title>查看试题详情-试题管理</title>
<style type="text/css">
.search {
	color: red;
	font-size: 1.4em;
}
</style>
</head>
<body>

	<ol class="breadcrumb">
		<li>当前位置：</li>
		<li>考试管理</li>
		<li class="active">查看试题详情</li>
	</ol>


	<div class="table-responsive">
		<div class="container">
		
			<h1 style="color:red;">${remind }</h1>
			
			<table class="table table-striped">
				<caption>条纹表格布局</caption>
				<tbody>
					<tr>
						<td>试卷名称</td>
						<td>试题题干</td>
						<td>试题答案</td>
						<td>考生姓名</td>
						<td>考生答案</td>
						<td>考生得分</td>
					</tr>
					<c:forEach var ="epr" items="${eprModels }">
						<tr>
							<td>${epr.testPaper.paperName }</td>
							<td>${epr.question.questions_stems }</td>
							<td>${epr.question.answer }</td>
							<td>${epr.personName }</td>
							<td>${epr.answer }</td>
							<td>${epr.examPerRecord.socre }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div class="table-responsive"></div>
	
	<h3>${delectQtMsg}</h3>
	<div class="background navbar-fixed-top"
		style="position: absolute; z-index: -1; width: 100%; height: 100%; opacity: 0.1;">
		<img class="img-responsive" width="100%;"
			src="${rootPath }images/577a4c594718d_610.jpg" />
	</div>
</body>
</html>