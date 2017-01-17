<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${rootPath}css/bootstrap.css">
<style>
.{
font-size:25px;
}
.search{
	color:red;
	font-size:1.4em;
}
</style>
</head>
<body>
	<ol class="breadcrumb">
		<li>考试管理</li>
		<li class="active">管理试卷</li>
	</ol>


	<div class="table-responsive">
		<div class="container">
			<div class="row" style="margin-bottom: 30px;">
				<form action="" method="post">
					<div class="col-xs-6">

						<input type="text" name="search" class="form-control"
							value="${search }"
							placeholder="请输入试卷名称搜索">

					</div>
					<div class="col-xs-6">
						<button type="submit" class="btn btn-success">搜索</button>
					</div>
				</form>
			</div>
			
			<div class="row">
				<div class="col-xs-12">
					共找到 &nbsp; <span style="color:red;">${pc.count }</span> &nbsp; 条数据
				</div>
			</div>
			
			<div class="row">
				<div class="col-xs-12">
					<table class="table table-bordered table-hover">
						<tr>
							<td>试卷名称</td>
							<td>试卷说明</td>
							<td>创建时间</td>
							<td>删 除</td>
						</tr>
						<c:forEach items="${pc.data}" var="t">
							<tr>
								<td>${t.paperName}</td>
								<td>${t.description}</td>
								<td>${t.createDate }</td>
								<td><a
									href="${rootPath }manage/testManage_delete?id=${t.tp_Id}">刪除</a></td>
							</tr>
						</c:forEach>
					</table>

				</div>

			</div>

		</div>

	</div>
	<nav style="margin-left: 42%;">
		<ul class="pagination">
			<li><a
				href="${rootPath }manage/testManage_getTestPaper?page=${pc.prePage}">上一页</a>
			</li>
			<li><a href="#">${pc.currentPage}/${pc.pageNum}</a></li>
			<li><a
				href="${rootPath }manage/testManage_getTestPaper?page=${pc.nextPage}">下一页</a></li>
		</ul>
	</nav>
	<h3>${delectTpMsg}</h3>
</body>
</html>