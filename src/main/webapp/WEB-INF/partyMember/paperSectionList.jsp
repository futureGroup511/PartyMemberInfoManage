<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${paper.paperType}</title>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css" />
</head>
<body>
	<ol>
		<c:forEach items="${pc.data }"  var="paper">
			<li><span><a href="${rootPath }party/partyMemberAction_lookPaper?rp_Id=${paper.rp_Id}">${paper.title }</a></span><span>${ paper.releaseDate}</span></li>
		</c:forEach>
	</ol>
	
	
		<div id="pagecut" style="margin-right:100px;text-align:right;">
		<ul class="pagination">
			<li><a href="${rootPath }party/partyMemberAction_paperSection?page=${pc.prePage}&&paperTypeId=${paper.paperTypeId}">上一页</a></li>
			<c:if test="${1 < pc.currentPage -3}">
				<li><a href="${rootPath }party/partyMemberAction_paperSection?page=1&&paperTypeId=${paper.paperTypeId}">1</a></li>
			</c:if>
			
			<c:forEach var="i" begin="${pc.currentPage-3>0?pc.currentPage-3:1 }" end="${pc.currentPage+3>pc.pageNum?pc.pageNum:pc.currentPage+3  }">
				<c:choose>
					<c:when test="${i>0 && i == pc.currentPage }">
						<li class="active"><a href="${rootPath }party/partyMemberAction_paperSection?page=${i }&&paperTypeId=${paper.paperTypeId}">${i}</a></li>
					</c:when>

					<c:when test="${i>0 && i != postPS.currentPage }">
						<li><a href="${rootPath }party/partyMemberAction_paperSection?page=${i }&&paperTypeId=${paper.paperTypeId}">${i}</a></li>
					</c:when>
				</c:choose>
			</c:forEach>
			<li><a href="${rootPath }party/partyMemberAction_paperSection?page=${pc.nextPage}&&paperTypeId=${paper.paperTypeId}">下一页</a></li>
		</ul>

	</div>
<script type="text/javascript">
	var notice = "${notice}";
	if(notice===""){
		
	}else{
		alert(notice);
	}
	
</script>
</body>
</html>