<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页轮播图管理</title>
<script type="text/javascript"
	src="${rootPath }jQueryPlug/jPage/src/jquery.min.js"></script>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css" />
</head>

<body>
	<div class="container">
		<div style="height:20px;"></div>
		<div class="row">
			<span class="text-danger">${remind }</span>
		</div>
		<div class="row">
			<span class="text-primary">由于前台只显示最新的4个轮播图，所以这里一直显示最新的4个轮播图，方便管理。</span>
		</div>
		<div style="height:20px;"></div>
		<div class="row">
			<table class="table table-striped">
				<tr>
					<td>图片对应网址</td>
					
					<td>对应的图片</td>
					<td>删除</td>
				</tr>
				<c:forEach var="indexImage" items="${indexImages }">
					<tr>
						<td>${indexImage.url }</td>
						<td><img style="width:300px;" src="${rootPath }${indexImage.imgUrl }"></td>
						<td><a href="${rootPath }manage/indexImage_delete?id=${ indexImage.id}">删除</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>

</html>