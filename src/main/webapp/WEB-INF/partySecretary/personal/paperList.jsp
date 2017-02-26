<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学习园地</title>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css">
<link rel="stylesheet" href="${rootPath }css/partySecretary/index_tou.css">
<link rel="stylesheet" href="${rootPath }css/partySecretary/current news.css">
<script src="${rootPath }js/jquery-2.2.3.min.js"></script>
<script src="${rootPath }js/bootstrap.js"></script>
</head>

<body>

<%@ include file="../head.jsp"%>

<!--以上为头部-->
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
<!--以上为头部-->






<div id="body">
 <div id="body-one">
   <p><img src="${rootPath}images/topimg.png"> <span>您的位置：
   <a href="${rootPath }secretary/pSForward_fIndex">首页</a>&nbsp;&nbsp;>&nbsp;&nbsp;学习园地</span></p>
 </div>
 <div id="body-two">
   <div class="body-two-left">
       <p><span>${fn:substring(partyBuilding[0].paperType, 0, 2)}</span> ${fn:substring(partyBuilding[0].paperType, 2, 4)}</p>
       <p><a href="${rootPath }secretary/partySecretary_paperSection?paperTypeId=${partyBuilding[0].paperTypeId}">更多</a></p>
   </div>  
   <div class="body-two-center">
       <p><span>${fn:substring(universityCounseling[0].paperType, 0, 2)}</span> ${fn:substring(universityCounseling[0].paperType, 2, 4)}</p>
       <p><a href="${rootPath }secretary/partySecretary_paperSection?paperTypeId=${universityCounseling[0].paperTypeId}">更多</a></p>
   </div>  
   <div class="body-two-right">
       <p><span>${fn:substring(xinxiangStyle[0].paperType, 0, 2)}</span> ${fn:substring(xinxiangStyle[0].paperType, 2, 4)}</p>
       <p><a href="${rootPath }secretary/partySecretary_paperSection?paperTypeId=${partyBuilding[0].paperTypeId}">更多</a></p>
   </div>  
 </div>
 <div id="body-three">
    <div class="body-three-left">
    	<c:forEach var="paper" items="${partyBuilding}">
					<p>					
						<a href="${rootPath }secretary/partySecretary_lookPaper?rp_Id=${paper.rp_Id}"><span>》&nbsp;&nbsp;&nbsp;${paper.title }</span><span>${paper.releaseDate}</span></a>
					</p>
		</c:forEach>     
    </div>
    <div class="body-three-center">
       <c:forEach var="paper" items="${universityCounseling}">
					<p>					
						<a href="${rootPath }secretary/partySecretary_lookPaper?rp_Id=${paper.rp_Id}"><span>》&nbsp;&nbsp;&nbsp;${paper.title }</span><span>${paper.releaseDate}</span></a>
					</p>
		</c:forEach> 
    </div>
    <div class="body-three-right">
       <c:forEach var="paper" items="${xinxiangStyle}">
					<p>					
							<a href="${rootPath }secretary/partySecretary_lookPaper?rp_Id=${paper.rp_Id}"><span>》&nbsp;&nbsp;&nbsp;${paper.title }</span><span>${paper.releaseDate}</span></a>
					</p>
		</c:forEach> 
    </div>
 </div>
 <div id="body-four">
    <div class="body-four-left">
        <p><span>${divineLand[0].paperType }</span><a href="${rootPath }secretary/partySecretary_paperSection?paperTypeId=${divineLand[0].paperTypeId }">
        <img src="${rootPath}images/jiahao.png"> 查看更多</a></p>
    </div>
    <div class="body-four-center">
        <p><span>${globalDynamics[0].paperType }</span><a href="${rootPath }secretary/partySecretary_paperSection?paperTypeId=${divineLand[0].paperTypeId }">
        <img src="${rootPath}images/jiahao.png"> 查看更多</a></p>
    </div>
    <div class="body-four-right">
        <p><span>${mediaHeadlines[0].paperType }</span><a href="${rootPath }secretary/partySecretary_paperSection?paperTypeId=${divineLand[0].paperTypeId }">
        <img src="${rootPath}images/jiahao.png"> 查看更多</a></p>
    </div>
 </div>
 <div id="body-five">
    <div class="body-five-left">
    	<c:forEach var="paper" items="${divineLand}">
    		<p ><span>${paper.releaseDate}</span>
    		<a href="${rootPath }secretary/partySecretary_lookPaper?rp_Id=${paper.rp_Id}">${paper.title }</a></p>					
		</c:forEach>      
    </div>
  <div class="body-five-center">
      <c:forEach var="paper" items="${globalDynamics}">
    		<p ><span>${paper.releaseDate}</span>
    		<a href="${rootPath }secretary/partySecretary_lookPaper?rp_Id=${paper.rp_Id}">${paper.title }</a></p>					
		</c:forEach>
    </div>
  <div class="body-five-right">
  		<c:forEach var="paper" items="${mediaHeadlines}" >
    		<p ><span>${paper.releaseDate}</span>
    		<a href="${rootPath }secretary/partySecretary_lookPaper?rp_Id=${paper.rp_Id}">${paper.title }</a></p>					
		</c:forEach>
    </div>
 </div>
</div>


<footer id="footer-warp"><!--页脚开始-->
		<p class="footer"><a href="">网站声明</a> &nbsp; &nbsp;<span>|</span> &nbsp; &nbsp;<a href="">关于我们 &nbsp; &nbsp;</a><span>|</span> &nbsp; &nbsp;<a href="">联系我们</a></p>
		<p>Copyright @ 2016 All rights reserved.　　版权所有：河南科技学院党委</p>
</footer><!--页脚结束-->	

<c:forEach var="paper" items="${paperList}" varStatus="status">
			${status.count }
    		<p ><span>${paper.releaseDate}</span>
    		${paper.rp_Id }
    		<a href="${rootPath }secretary/partySecretary_lookPaper?rp_Id=${paper.rp_Id}">${paper.title }</a></p>					
</c:forEach>

</body>
</html>