<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>红色视频列表</title>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css" />
</head>
<body>
	<c:forEach items="${pc.data}" var="v" varStatus="status">
		<c:choose>
			<c:when test="${(status.index)%4==0}">
			<div style="clear: both;"></div>			
				<div style="width: 150px;float: left;">
					<div>
						<img src="${rootPath}${v.imgUrl}"
							style="height: 180px; width: 120px;">
					</div>
					<div style="height:25px;">
						<a href="${rootPath }secretary/partySecretary_lookVideo?rv_Id=${v.rv_Id}">${v.name }</a>
					</div>
					
				</div>
			</c:when>
			<c:otherwise>
				
				<div style="float: left; width: 150px;">
					<div>
						<img src="${rootPath}${v.imgUrl}"
							style="height: 180px; width: 120px;">
					</div>
					<div>
						<a href="${rootPath }secretary/partySecretary_lookVideo?rv_Id=${v.rv_Id}">${v.name }</a>
					</div>
					
				</div>
			</c:otherwise>
		</c:choose>

	</c:forEach>
	
	
		<div id="pagecut" style="margin-right:100px;text-align:right;">
		<ul class="pagination">
			<li><a href="${rootPath }secretary/partySecretary_videoList?page=${pc.prePage}">上一页</a></li>
			<c:if test="${1 < pc.currentPage -3}">
				<li><a href="${rootPath }secretary/partySecretary_videoList?page=1">1</a></li>
			</c:if>
			
			<c:forEach var="i" begin="${pc.currentPage-3>0?pc.currentPage-3:1 }" end="${pc.currentPage+3>pc.pageNum?pc.pageNum:pc.currentPage+3  }">
				<c:choose>
					<c:when test="${i>0 && i == pc.currentPage }">
						<li class="active"><a href="${rootPath }secretary/partySecretary_videoList?page=${i }">${i}</a></li>
					</c:when>

					<c:when test="${i>0 && i != postPS.currentPage }">
						<li><a href="${rootPath }secretary/partySecretary_videoList?page=${i }">${i}</a></li>
					</c:when>
				</c:choose>
			</c:forEach>
			<li><a href="${rootPath }secretary/partySecretary_videoList?page=${pc.nextPage}">下一页</a></li>
		</ul>

	</div>
</body>
</html>