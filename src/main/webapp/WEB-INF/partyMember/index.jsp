<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网站首页</title>
<link rel="stylesheet" href="${rootPath}css/partyMember/bootstrap.css">
<link rel="stylesheet" href="${rootPath}css/partyMember/index-two.css">
<link rel="stylesheet" href="${rootPath}css/partyMember/head1.css">
<script src="${rootPath}js/jquery-2.2.3.min.js"></script>
<script src="${rootPath}js/bootstrap.js"></script>
</head>

<body>
	<%@ include file="head.jsp" %>

<%-- <div id="header">
     <div class="header-left">
          <img src="${rootPath}images/header-logo.png">
      </div>
      <div class="header-center">
              <p class="top"><b><strong>河南科技学院信息工程学院党委主办</strong></b></p>
              <p class="bottom"><b><strong>河南科技学院党员在线</strong></b></p>
       </div>
       <div class="header-right">
             <div>
             	<form action="${rootPath}party/partyMemberAction_select.action" method="post">
    		     	<select name="type">
							<option value="news">时事新闻</option>
							<option value="video">学习园地</option>
				 	</select>
                  	<input type="text" name="search"  placeholder=" 请输入您要搜索的内容">
                   	<button class="btn"><img src="${rootPath }images/sousuo.png" width="22" height="22"></button>
             	</form>    		    
             </div>
       </div>
</div>

<div class="nav">
     <div class="row">
       <div class="col-lg-9 col-lg-offset-3 col-md-9 col-md-offset-3 col-xs-9 col-xs-offset-3">
         <ul class="nav navbar-nav">
              <li><a href="${rootPath}party/partyLogin.action">网站首页</a></li>
              <li><a href="${rootPath }party/partyMemberAction_getResPaper.action">时事新闻</a></li>
              <li><a href="${rootPath}party/partyMemberAction_viewVideos.action">学习园地</a></li>
              <li><a href="${rootPath}party/partyMemberAction_startTest.action">在线考试</a></li>             
              <li><a href="${rootPath}party/partyMemberAction_onlineSelfTest.action">在线自测</a></li>
              <li class="dropdown"><a href="#" data-toggle="dropdown" class="dropdown-toggle">个人中心<span class="caret"></span></a>
                   <ul class="dropdown-menu">
                         <li><a href="${rootPath}party/partyMemberAction_seekPartyMemberInfo.action">个人信息</a></li>
                         <li><a href="${rootPath}party/partyMemberAction_getInfoBeforeUpdate.action">修改信息</a></li>
                         <li><a href="${rootPath}party/partyMemberAction_getMyExamLog.action">考试报告</a></li>
                         <li><a href="${rootPath}login_logout">退出登录</a></li>
                   </ul>
               </li>
              <li><a href="${rootPath}party/partyMemberAction_informList.action">通知公告</a></li>
              <li><a href="${rootPath}party/partyMemberAction_connectUs.action">联系我们</a></li>

         </ul>
        </div>
     </div>
</div> --%>
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
<div id="banner-one">
   <div class="row">
       <div class="col-lg-9 col-lg-offset-1 col-md-9 col-md-offset-1 col-xs-9 col-xs-offset-1">
       	<img src="${rootPath}images/tongzhi.png"> 通知公告 
       		<c:forEach items="${informList}" var="inform">
       			<img src="${rootPath}images/jiantou.png"><a href="${rootPath }party/partyMemberAction_lookInform?inform.info_Id=${inform.info_Id}"> ${inform.title}  ${inform.sendDate}</a> 
       		</c:forEach>
         
       </div>
   </div>
</div>
<div id="paper-warp"><!--文章区开始-->
			   <div class="paper-one">
                    <img src="${rootPath}images/zxbt.png">
                    <span class="paper-img">最新文章</span>
					<ol> 
						<c:forEach items="${newPaperList }" var="newPaper">
							<li><a href="${rootPath}party/partyMemberAction_lookPaper?rp_Id=${newPaper.rp_Id}"><span>${newPaper.title }</span><span>${newPaper.releaseDate}</span></a></li>
						</c:forEach>						
                     </ol>
               </div>
				<div class="paper-two">
                    <img src="${rootPath}images/zxbt.png">
					<span class="paper-img" id="pager-img-two">热门文章</span> 
					<ol> 
						<c:forEach items="${newPaperList}" var="hotPaper">
							<li><a href="${rootPath}party/partyMemberAction_lookPaper?rp_Id=${hotPaper.rp_Id}"><span>${hotPaper.title }</span><span>${hotPaper.releaseDate}</span></a></li>
						</c:forEach>						
					</ol>
				</div>
</div><!--文章区结束-->
<div id="video-warp"><!--视频列表区开始-->
	<div class="picScroll-left">
		<span class="ma">推荐课程</span>
		<div class="hd">
		   <a class="prev" href="javascript:void(0)"><p><</p></a>
		</div>
		<div class="bd">
             <div class="tempWrap" style="overflow:hidden; position:relative; width: 90%; margin-left:4.5%;">
                 <ul class="picList" style="width:100%; position: relative; overflow: hidden; padding: 0px; margin: 0px;">
                 	
                 	<c:forEach items="${recommendVideosList}" var="new_video">
                     		<li style="float: left; width: 25%;">
							 	<div class="pic"><a href="${rootPath }party/partyMemberAction_viewing?rv_Id=${new_video.rv_Id}"><img src="${rootPath}${new_video.imgUrl}"></a></div>
							 	<div class="title"><a href="${rootPath }party/partyMemberAction_viewing?rv_Id=${new_video.rv_Id}">${new_video.name}</a></div>
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
			<span>最新课程</span>
			<div class="hd">
				<a class="prev" href="javascript:void(0)"><p><</p></a>
			</div>
			<div class="bd">
                 <div class="tempWrap" style="overflow:hidden; position:relative; width: 90%; margin-left:4.5%;">
                     <ul class="picList" style="width:100%; position: relative; overflow: hidden; padding: 0px; margin: 0px;">
                     	 <c:forEach items="${newVideosList}" var="new_video">
                     		<li style="float: left; width: 25%;">
							 	<div class="pic"><a href="${rootPath }party/partyMemberAction_viewing?rv_Id=${new_video.rv_Id}"><img src="${rootPath}${new_video.imgUrl}"></a></div>
							 	<div class="title"><a href="${rootPath }party/partyMemberAction_viewing?rv_Id=${new_video.rv_Id}">${new_video.name}</a></div>
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
<script src="${rootPath}js/jquery1.42.min.js"></script>
<script src="${rootPath}js/jquery.SuperSlide.2.1.1.js"></script>
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
