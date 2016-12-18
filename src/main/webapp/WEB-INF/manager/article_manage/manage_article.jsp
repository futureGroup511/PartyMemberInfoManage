<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理文章</title>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css" />

</head>
<body>
	<table class="table table-bordered" style="width:80%;margin:100px auto 0 auto;">

		<tbody>
			<tr>
				<td>文章标题</td>
				<td>作者</td>
				<td>来源</td>
				<td>版块</td>				
				<td>发布时间</td>
				<td>阅读次数</td>
				<td>文章状态</td>
				<td>文章内容</td>
				<td>管理</td>
				<td>删除</td>
			</tr>
			<c:forEach var="paper" items="${pc.data }">
				<tr>
					<td>${paper.title }</td>
					<td>${paper.author }</td>
					<td>${paper.source }</td>
					<td>${paper.paperType}</td>					
					<td>${paper.releaseDate}</td>
					<td>${paper.readNum }</td>
					<td>${paper.rp_tag}</td>
					<td><a>详细</a></td>
					<td><a href="${rootPath }manage/inform_change?inform.info_Id=${inform.info_Id}">管理</a></td>
					<td><a href="${rootPath }manage/inform_delete?page=${pc.currentPage }&inform.info_Id=${inform.info_Id}">删除</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<div id="pagecut" style="margin-right:100px;text-align:right;">
		<ul class="pagination">
			<li><a href="${rootPath }manage/inform?page=${pc.prePage}">上一页</a></li>
			<c:if test="${1 < pc.currentPage -3}">
				<li><a href="${rootPath }manage/inform">1</a></li>
			</c:if>
			
			<c:forEach var="i" begin="${pc.currentPage-3>0?pc.currentPage-3:1 }" end="${pc.currentPage+3>pc.pageNum?pc.pageNum:pc.currentPage+3  }">
				<c:choose>
					<c:when test="${i>0 && i == pc.currentPage }">
						<li class="active"><a href="${rootPath }manage/inform?page=${i }">${i}</a></li>
					</c:when>

					<c:when test="${i>0 && i != postPS.currentPage }">
						<li><a href="${rootPath }manage/inform?page=${i }">${i}</a></li>
					</c:when>
				</c:choose>
			</c:forEach>
			<li><a href="${rootPath }manage/inform?page=${pc.nextPage}">下一页</a></li>
		</ul>

	</div>

</body>
</html>