<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>网站首页</title>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css">
<link rel="stylesheet" href="${rootPath }css/partySecretary/index-two.css">
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
      <div class="item active">
            <a href="#"><img src="${rootPath }images/banner-one.jpg" width="100%" height="300"></a>
      </div>
      <div class="item">
           <a href="#"><img src="${rootPath }images/banner-two.jpg" width="100%" height="300"></a> 
      </div>
      <div class="item">
           <a href="#"><img src="${rootPath }images/banner-three.jpg" width="100%" height="300"></a>
      </div>
      <div class="item">
           <a href="#"><img src="${rootPath }images/banner-four.jpg" width="100%" height="300"></a>
      </div>
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

<div id="banner-one">
   <div class="row">
       <div class="col-lg-9 col-lg-offset-1 col-md-9 col-md-offset-1 col-xs-9 col-xs-offset-1">
          <img src="${rootPath }images/tongzhi.png"><a href="${rootPath }secretary/partySecretary_informList">查看通知</a>
         	<!-- 两条最新的通知 -->
         <c:forEach var="inform"  items="${newInform}">
         		<img src="${rootPath }images/jiantou.png">
          		<a href="${rootPath }secretary/partySecretary_lookInform?inform.info_Id=${inform.info_Id}">
          		${inform.title }&nbsp;&nbsp;&nbsp;&nbsp;${inform.sendDate}</a>
         </c:forEach>
       </div>
   </div>
</div>
<div id="paper-warp"><!--文章区开始-->
			   <div class="paper-one">
                    <img src="${rootPath }images/zxbt.png">
                    <span class="paper-img">最新文章</span>
					<ol>
						<c:forEach var="paper" items="${ newPaper}">
							<li><a href="${rootPath }secretary/partySecretary_lookPaper?rp_Id=${paper.rp_Id}"><span>${paper.title }</span>
									<span>${paper.releaseDate }</span></a>
							</li>
						</c:forEach> 

                     </ol>
               </div>
				<div class="paper-two">
                    <img src="${rootPath }images/zxbt.png">
					<span class="paper-img" id="pager-img-two">热门文章</span> 
					<ol> 
						<c:forEach var="paper" items="${hotPaper}">
							<li><a href="${rootPath }secretary/partySecretary_lookPaper?rp_Id=${paper.rp_Id}"><span>${paper.title }</span>
									<span>${paper.releaseDate }</span></a>
							</li>
						</c:forEach>
					</ol>
				</div>
</div><!--文章区结束-->
<div id="video-warp"><!--视频列表区开始-->
	<div class="picScroll-left">
		<span class="ma">热门课程</span>
		<div class="hd">
		   <a class="prev" href="javascript:void(0)"><p><</p></a>
		</div>
		<div class="bd">
             <div class="tempWrap" style="overflow:hidden; position:relative; width: 90%; margin-left:4.5%;">
                 	<ul class="picList" style="width:100%; position: relative; overflow: hidden; padding: 0px; margin: 0px;">
                 		<c:forEach var="video" items="${ hotVideo}">
                 			 <li style="float: left; width: 25%;">
							 	<div class="pic"><a href="html/video.html"><img src="${rootPath}${video.imgUrl}"></a></div>
							 	<div class="title"><a href="${rootPath }secretary/partySecretary_lookVideo?rv_Id=${video.rv_Id}">${video.name}</a></div>
						 	</li>
                 		</c:forEach>
					</ul>
                 </div>
             </div>
			 <div class="hd">
			       <a class="next" href="javascript:void(0)"><p>></p></a>
			</div>
	  </div>
      <div class="picScroll-left second">
			<span>学习课程</span>
			<div class="hd">
				<a class="prev" href="javascript:void(0)"><p><</p></a>
			</div>
			<div class="bd">
                 <div class="tempWrap" style="overflow:hidden; position:relative; width: 90%; margin-left:4.5%;">
                     <ul class="picList" style="width:100%; position: relative; overflow: hidden; padding: 0px; margin: 0px;">
                 		<c:forEach var="video" items="${ newVideo}">
                 			 <li style="float: left; width: 25%;">
							 	<div class="pic"><a href="${rootPath }secretary/partySecretary_lookVideo?rv_Id=${video.rv_Id}"><img src="${rootPath}${video.imgUrl}"></a></div>
							 	<div class="title"><a href="${rootPath }secretary/partySecretary_lookVideo?rv_Id=${video.rv_Id}">${video.name}</a></div>
						 	</li>
                 		</c:forEach>
					</ul>
                 </div>
             </div>
				 <div class="hd">
			         <a class="next" href="javascript:void(0)"><p>></p></a>
				 </div>
	 </div>

</div><!--视频列表区结束-->
<footer id="footer-warp"><!--页脚开始-->
		<p class="footer"><a href="">网站声明</a> &nbsp; &nbsp;<span>|</span> &nbsp; &nbsp;<a href="">关于我们 &nbsp; &nbsp;</a><span>|</span> &nbsp; &nbsp;<a href="">联系我们</a></p>
		<p>Copyright @ 2016 All rights reserved.　　版权所有：河南科技学院党委</p>
</footer><!--页脚结束-->	
<script src="${rootPath }js/jquery1.42.min.js"></script>
<script src="${rootPath }js/jquery.SuperSlide.2.1.1.js"></script>
<script type="text/javascript">
   jQuery(".picScroll-left").slide({
    	titCell:".hd ul",
    	mainCell:".bd ul",
    	autoPage:true,
    	effect:"left",
    	autoPlay:true,
    	vis:4,
    	trigger:"click"
    });

    jQuery(".picScroll-two").slide({
    	titCell:".hd ul",
    	mainCell:".bd ul",
    	autoPage:true,
    	effect:"left",
    	autoPlay:true,
    	vis:4,
    	trigger:"click"
    });
</script>
</body>
</html>