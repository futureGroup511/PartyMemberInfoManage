<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学习园地</title>
<link rel="stylesheet" href="${rootPath}css/partyMember/head2.css">
<link rel="stylesheet" href="${rootPath}css/partyMember/bootstrap.css">
<link rel="stylesheet" href="${rootPath}css/partyMember/the party.css">
<script src="${rootPath}js/jquery-2.2.3.min.js"></script>
<script src="${rootPath}js/bootstrap.js"></script>
</head>
<body>
	<%@ include file="head.jsp" %>
	<div id="body">
		<div id="body-one">
			<p>
				<img src="${rootPath}images/topimg.png"> <span>您的位置：<a href="${rootPath}party/partyLogin.action">首页</a>&nbsp;&nbsp;>&nbsp;&nbsp;<a href="${rootPath }party/partyMemberAction_getResPaper.action">学习园地</a>&nbsp;&nbsp;>&nbsp;&nbsp;搜索结果</span>
			</p>
		</div>
		
		<c:if test="${NoSearch!=null}">
			<div id="body-two1">
				<h2>${NoSearch}</h2>
			</div>			
		</c:if>
		<c:if test="${NoSearch==null}">			
			<div id="body-two">	
 				<c:forEach items="${pc.data }"  var="paper">
		 			<p><a href="${rootPath}party/partyMemberAction_lookPaperByTag?rp_Id=${paper.rp_Id}&search=${search}">
		 			${paper.title }<span>${ paper.releaseDate}</span></a></p>
				</c:forEach>
 			</div>
 			
 			<div id="pagecut" style="margin-right:200px;text-align:right;">
				<ul class="pagination">
				<li><a href="${rootPath}party/partyMemberAction_paperList?page=${pc.prePage}&search=${search}">上一页</a></li>
					<c:if test="${1 < pc.currentPage -3}">
						<li><a href="${rootPath}party/partyMemberAction_paperList?page=1&search=${search}">1</a></li>
					</c:if>
			
				<c:forEach var="i" begin="${pc.currentPage-3>0?pc.currentPage-3:1 }" end="${pc.currentPage+3>pc.pageNum?pc.pageNum:pc.currentPage+3  }">
					<c:choose>
						<c:when test="${i>0 && i == pc.currentPage }">
							<li class="active"><a href="${rootPath}party/partyMemberAction_paperList?page=${i}&search=${search}">${i}</a></li>
						</c:when>

						<c:when test="${i>0 && i != postPS.currentPage }">
							<li><a href="${rootPath}party/partyMemberAction_paperList?page=${i }&search=${search}">${i}</a></li>
						</c:when>
					</c:choose>
				</c:forEach>
				<li><a href="${rootPath}party/partyMemberAction_paperList?page=${pc.nextPage}&search=${search}">下一页</a></li>
				</ul>
			</div>
		</c:if>
			
	</div>		
	
	
	
<footer id="footer-warp"><!--页脚开始-->
		<p class="footer"><a href="">网站声明</a> &nbsp; &nbsp;<span>|</span> &nbsp; &nbsp;<a href="">关于我们 &nbsp; &nbsp;</a><span>|</span> &nbsp; &nbsp;<a href="">联系我们</a></p>
		<p>Copyright @ 2016 All rights reserved.　　版权所有：河南科技学院党委</p>
</footer><!--页脚结束-->	
<script type="text/javascript">
	var notice = "${notice}";
	if(notice===""){
		
	}else{
		alert(notice);
	}
	
</script>
</body>
</html>