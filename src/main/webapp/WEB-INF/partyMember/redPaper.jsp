<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学习园地</title>
<link rel="stylesheet" href="${rootPath}css/partyMember/head1.css">
<link rel="stylesheet" href="${rootPath}css/partyMember/bootstrap.css">
<link rel="stylesheet"
	href="${rootPath}css/partyMember/current news.css">
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
      <a class="left carousel-control" href="#slidershow" role="button" data-slide="prev">
           <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#slidershow" role="button" data-slide="next">
         <span class="sr-only">Next</span>
      </a>
    </div>
  </div>
 </div>
</div>
<div id="body">
 <div id="body-one">
   <p><img src="${rootPath}images/topimg.png"> <span>您的位置：<a href="${rootPath}party/partyLogin.action">首页</a>&nbsp;&nbsp;>&nbsp;&nbsp;学习园地</span></p>
 </div>
 <div id="body-two">
   <div class="body-two-left">
       <p><span>${fn:substring(partyBuilding[0].paperType, 0, 2)}</span> ${fn:substring(partyBuilding[0].paperType, 2, 4)}</p>
       <p><a href="${rootPath }party/partyMemberAction_paperSection?paperTypeId=1">更多</a></p>
   </div>  
   <div class="body-two-center">
       <p><span>${fn:substring(universityCounseling[0].paperType, 0, 2)}</span> ${fn:substring(universityCounseling[0].paperType, 2, 4)}</p>
       <p><a href="${rootPath }party/partyMemberAction_paperSection?paperTypeId=2">更多</a></p>
   </div>  
   <div class="body-two-right">
       <p><span>${fn:substring(xinxiangStyle[0].paperType, 0, 2)}</span> ${fn:substring(xinxiangStyle[0].paperType, 2, 4)}</p>
       <p><a href="${rootPath }party/partyMemberAction_paperSection?paperTypeId=3">更多</a></p>
   </div>  
 </div>
 <div id="body-three">
    <div class="body-three-left">
    	<c:forEach var="paper" items="${partyBuilding}">
					<p>					
						<a
							href="${rootPath}party/partyMemberAction_lookPaper?rp_Id=${paper.rp_Id}"><span>》&nbsp;&nbsp;&nbsp;${paper.title }</span><span>${paper.releaseDate}</span></a>
					</p>
		</c:forEach>     
    </div>
    <div class="body-three-center">
       <c:forEach var="paper" items="${universityCounseling}" >
					<p>					
						<a
							href="${rootPath}party/partyMemberAction_lookPaper?rp_Id=${paper.rp_Id}"><span>》&nbsp;&nbsp;&nbsp;${paper.title }</span><span>${paper.releaseDate}</span></a>
					</p>
		</c:forEach> 
    </div>
    <div class="body-three-right">
       <c:forEach var="paper" items="${xinxiangStyle}" >
					<p>					
						<a
							href="${rootPath}party/partyMemberAction_lookPaper?rp_Id=${paper.rp_Id}"><span>》&nbsp;&nbsp;&nbsp;${paper.title }</span><span>${paper.releaseDate}</span></a>
					</p>
		</c:forEach> 
    </div>
 </div>
 <div id="body-four">
    <div class="body-four-left">
        <p><span>${mediaHeadlines[0].paperType}</span><a href="${rootPath }party/partyMemberAction_paperSection?paperTypeId=4"><img src="${rootPath}images/jiahao.png"> 查看更多</a></p>
    </div>
    <div class="body-four-center">
        <p><span>${globalDynamics[0].paperType}</span><a href="${rootPath }party/partyMemberAction_paperSection?paperTypeId=5"><img src="${rootPath}images/jiahao.png"> 查看更多</a></p>
    </div>
    <div class="body-four-right">
        <p><span>${divineLand[0].paperType}</span><a href="${rootPath }party/partyMemberAction_paperSection?paperTypeId=6"><img src="${rootPath}images/jiahao.png"> 查看更多</a></p>
    </div>
 </div>
 <div id="body-five">
    <div class="body-five-left">
    	<c:forEach var="paper" items="${divineLand}" >   		
    		<p ><span>${paper.releaseDate}</span><span><a href="${rootPath}party/partyMemberAction_lookPaper?rp_Id=${paper.rp_Id}">${paper.title }</a></span></p>					
		</c:forEach>     
    </div>
  <div class="body-five-center">
  <c:forEach var="paper" items="${globalDynamics}" >   		
    		<p ><span>${paper.releaseDate}</span><span><a href="${rootPath}party/partyMemberAction_lookPaper?rp_Id=${paper.rp_Id}">${paper.title }</a></span></p>					
		</c:forEach>      
    </div>
  <div class="body-five-right">
  <c:forEach var="paper" items="${mediaHeadlines}" >   		
    		<p ><span>${paper.releaseDate}</span><span><a href="${rootPath}party/partyMemberAction_lookPaper?rp_Id=${paper.rp_Id}">${paper.title }</a></span></p>					
		</c:forEach>     
    </div>
 </div>
 
</div>
<footer id="footer-warp"><!--页脚开始-->
		<p class="footer"><a href="">网站声明</a> &nbsp; &nbsp;<span>|</span> &nbsp; &nbsp;<a href="">关于我们 &nbsp; &nbsp;</a><span>|</span> &nbsp; &nbsp;<a href="">联系我们</a></p>
		<p>Copyright @ 2016 All rights reserved.　　版权所有：河南科技学院党委</p>
</footer><!--页脚结束-->	
</body>
</html>