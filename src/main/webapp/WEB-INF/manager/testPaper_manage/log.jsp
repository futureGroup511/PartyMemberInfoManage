<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${rootPath }css/bootstrap.css" />
<title>成绩记录</title>

<style type="text/css">
.search {
	color: red;
	font-size: 1.2em;
}
</style>

</head>
<body>
	<ol class="breadcrumb">
		<li>当前位置：</li>
		<li>考试记录</li>
		<li class="active">成绩记录</li>
	</ol>

	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<span style="font-size: 1.4em; color: red;">${remind }</span>
			</div>
		</div>
		<div class="row" style="margin-bottom: 30px;">
			<form action="${rootPath }manage/testManage_log" method="post">
				<div class="col-xs-6"> 

					<input type="text" name="search" class="form-control"
						value="${search }"
						placeholder="请输入考试名称或者党员姓名搜索">

				</div>
				<div class="col-xs-3">
					<button type="submit" class="btn btn-success">搜索</button>
				</div>
				<%-- 
				<div class="col-xs-3">
					<a class="btn  btn-danger" href="${rootPath }manage/testManage_logDelAll">删除所有记录</a>
				</div>
				 --%>
			</form>
		</div>

		<div class="row">
			<div class="col-xs-12">
				共找到 &nbsp; <span style="color: red;">${pc.count }</span> &nbsp; 条数据
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<table class="table table-striped table-bordered table-hover">
					<tbody>

						<tr>
							<td>试卷名称</td>
							<td>姓名</td>
							<td>党员身份</td>
							<td>试卷总分</td>
							<td>考试成绩</td>
							<td>考试时间</td>
							<td>查看详细记录</td>
							<td>删除</td>
						</tr>

						<c:forEach var="e" items="${pc.data }">
							<tr>
								<td>${e.paperName }</td>
								<td>${e.partyMemberName }</td>
								<c:if test="${e.partySort == 0 }">
									<td>党员</td>
								</c:if>
								
								<c:if test="${e.partySort == 1 }">
									<td>书记</td>
								</c:if>
								
								<c:if test="${e.partySort < 0 || e.partySort > 2 }">
									<td>未知</td>
								</c:if>
								
								<td>${e.testTotalScore }</td>
								<td>${e.totalScore }</td>
						

								<td>${e.examTime }</td>
								
								<td><a
									href="${rootPath }manage/testManage_info?id=${e.el_Id}">查看详细信息</a></td>
								
								<td><a
									href="${rootPath }manage/testManage_logDel?id=${e.el_Id}">删除</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>

		<div id="pagecut" style="margin-right: 100px; text-align: right;">
			<ul class="pagination">
				<li><a
					href="${rootPath }manage/testManage_log?page=${pc.prePage}&search=${search}">上一页</a></li>
				<c:if test="${1 < pc.currentPage -3}">
					<li><a href="#">1</a></li>
				</c:if>

				<c:forEach var="i" begin="${pc.currentPage-3>0?pc.currentPage-3:1 }"
					end="${pc.currentPage+3>pc.pageNum?pc.pageNum:pc.currentPage+3  }">
					<c:choose>
						<c:when test="${i>0 && i == pc.currentPage }">
							<li class="active"><a
								href="${rootPath }manage/testManage_log?page=${i }&search=${search}">${i}</a></li>
						</c:when>

						<c:when test="${i>0 && i != postPS.currentPage }">
							<li><a href="${rootPath }manage/testManage_log?page=${i }&search=${search}">${i}</a></li>
						</c:when>
					</c:choose>
				</c:forEach>
				<li><a
					href="${rootPath }manage/testManage_log?page=${pc.nextPage}&search=${search}">下一页</a></li>
			</ul>

		</div>
	</div>
	
	<div class="background navbar-fixed-top"  style="position:absolute; z-index:-1;width:100%;height:100%;opacity:0.1;">
    	<img  class="img-responsive" width="100%;" src="${rootPath }images/577a4c594718d_610.jpg" />
    </div>
    
</body>
</html>