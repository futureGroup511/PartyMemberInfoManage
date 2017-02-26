<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>影音资料</title>
<link rel="stylesheet" href="${rootPath}css/partyMember/head1.css">
<link rel="stylesheet" href="${rootPath}css/partyMember/bootstrap.css">
<link rel="stylesheet"
	href="${rootPath}css/partyMember/learning world.css">
<script src="${rootPath}js/jquery-2.2.3.min.js"></script>
<script src="${rootPath}js/bootstrap.js"></script>
</head>

<body>
	<%@ include file="head.jsp" %>
	
	<div id="banner">
		<div class="col-lg-12 col-md-12 col-xs-12">
			<div id="slidershow" class="carousel slide" data-ride="carousel">
				<!--设置图片轮番的顺序-->
				<ol class="carousel-indicators">
					<li class="active" data-target="#slidershow" data-slide-to="0"></li>
					<li data-target="#slidershow" data-slide-to="1"></li>
					<li data-target="#slidershow" data-slide-to="2"></li>
					<li data-target="#slidershow" data-slide-to="3"></li>
				</ol>
				<!--设置轮播图片-->
				<div class="carousel-inner">
					<c:forEach items="${indexImages}" var="indexImage" varStatus="status">
    		<c:choose>
    			<c:when test="${status.index==0}">
    				<div class="item active">
            			<a href="${indexImage.url }"><img src="${rootPath}${indexImage.imgUrl }" width="100%" height="300"></a>
     				 </div>
    			</c:when>
    			<c:otherwise>
    				<div class="item ">
            			<a href="${indexImage.url }"><img src="${rootPath}${indexImage.imgUrl }" width="100%" height="300"></a>
     				 </div>
    			</c:otherwise>
    		</c:choose>   	   		
    	</c:forEach>   
					<a class="left carousel-control" href="#slidershow" role="button"
						data-slide="prev"> <span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#slidershow" role="button"
						data-slide="next"> <span class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</div>
	</div>
	<div id="body">
		<div id="body-one">
			<p>
				<img src="${rootPath}images/topimg.png"> <span>您的位置：<a href="${rootPath}party/partyLogin.action">首页</a>&nbsp;&nbsp;>&nbsp;&nbsp;影音资料</span>
			</p>
		</div>
		<div id="body-two">
			<p>党建课程</p>
		</div>
		<c:if test="${NoVideo!=null}">
			<div id="body-three1">
				<h2>${NoVideo }</h2>
			</div>
		</c:if>
		<c:if test="${NoVideo==null}">
			<div id="body-three">
			<c:forEach items="${pc.data}" var="v" begin="0" end="15">
				<div>
					<li><a href="${rootPath }party/partyMemberAction_viewing?rv_Id=${v.rv_Id}"><img
							src="${rootPath}${v.imgUrl}"></a></li> <span>${v.name}</span>
					<img src="${rootPath}images/play.png" id="img1">
				</div>
			</c:forEach>			
		</div>
		<div style="clear: both;"></div>
		<div id="pagecut" style="margin-left:70%;">
			<ul class="pagination">
				<li><a href="${rootPath }party/partyMemberAction_viewVideos?page=${pc.prePage}&search=${search}">上一页</a></li>
				<c:if test="${1 < pc.currentPage -3}">
				<li><a href="${rootPath }party/partyMemberAction_viewVideos?page=1&search=${search}">1</a></li>
				</c:if>			
				<c:forEach var="i" begin="${pc.currentPage-3>0?pc.currentPage-3:1 }" end="${pc.currentPage+3>pc.pageNum?pc.pageNum:pc.currentPage+3  }">
				<c:choose>
					<c:when test="${i>0 && i == pc.currentPage }">
						<li class="active"><a href="${rootPath }party/partyMemberAction_viewVideos?page=${i }&search=${search}">${i}</a></li>
					</c:when>

					<c:when test="${i>0 && i != postPS.currentPage }">
						<li><a href="${rootPath }party/partyMemberAction_viewVideos?page=${i }&search=${search}">${i}</a></li>
					</c:when>
				</c:choose>
				</c:forEach>
				<li><a href="${rootPath }party/partyMemberAction_viewVideos?page=${pc.nextPage}&search=${search}">下一页</a></li>
			</ul>
		</div>	
		</c:if>	
	</div>
	
	<footer id="footer-warp">
		<!--页脚开始-->
		<p class="footer">
			<a href="">网站声明</a> &nbsp; &nbsp;<span>|</span> &nbsp; &nbsp;<a
				href="">关于我们 &nbsp; &nbsp;</a><span>|</span> &nbsp; &nbsp;<a href="">联系我们</a>
		</p>
		<p>Copyright @ 2016 All rights reserved. 版权所有：河南科技学院党委</p>
	</footer>
	<!--页脚结束-->
</body>
</html>