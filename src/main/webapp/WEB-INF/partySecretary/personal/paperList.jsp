<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>时事新闻</title>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css">
<link rel="stylesheet" href="${rootPath }css/partySecretary/current news.css">
<script src="${rootPath }js/jquery-2.2.3.min.js"></script>
<script src="${rootPath }js/bootstrap.js"></script>
</head>

<body>

<div id="header">
     <div class="header-left">
          <img src="${rootPath }images/header-logo.png">
      </div>
      <div class="header-center">
              <p class="top"><b><strong>河南科技学院信息工程学院党委主办</strong></b></p>
              <p class="bottom"><b><strong>河南科技学院党员在线</strong></b></p>
       </div>
       <div class="header-right">
             <div>
             	<form action="${rootPath }secretary/partySecretary_select" method="post">
    		     	<select name="type">
							<option value="news">时事新闻</option>
							<option value="video">学习园地</option>
				 	</select>
                  	<input type="text" name="search" placeholder="&nbsp;&nbsp;&nbsp;请输入您要搜索的内容">
                   	<button class="btn"><img src="${rootPath }images/sousuo.png" width="22" height="22"></button>
             	</form>
             </div>
       </div>
</div>
<div class="nav">
     <div class="row">
         <ul class="nav navbar-nav">
              <li><a href="${rootPath }secretary/pSForward_fIndex">网站首页</a></li>
              <li class="dropdown"><a href="#" data-toggle="dropdown" class="dropdown-toggle">通知消息<span class="caret"></span></a>
                   <ul class="dropdown-menu">
                   		<li><a href="${rootPath }secretary/partySecretary_informList">查看通知</a></li>
						<li><a href="${rootPath }secretary/pSForward_fAddInform">发布通知</a></li>
						<li><a href="${rootPath }secretary/pSForward_fManageInfom">管理通知</a></li>
                   </ul>
               </li>
              <li class="dropdown"><a href="#" data-toggle="dropdown" class="dropdown-toggle">党员管理<span class="caret"></span></a>
                   <ul class="dropdown-menu">
						<li><a href="${rootPath }secretary/partySecretary_lookOfPartyMember">查看所属党员个人信息</a></li>
						<li><a href="${rootPath }secretary/test_startTestLog">查看所属党员考试记录</a></li>
                   </ul>
               </li>
               				

              <li><a href="${rootPath }secretary/partySecretary_videoList">学习园地</a></li>
				<li><a href="${rootPath }secretary/pSForward_paperList">时事新闻</a></li>
				<li><a href="${rootPath }secretary/pSForward_startTest">在线考试</a></li>
               <li class="dropdown"><a href="#" data-toggle="dropdown" class="dropdown-toggle">个人中心<span class="caret"></span></a>
                   <ul class="dropdown-menu">
						<li><a href="${rootPath }secretary/partySecretary_lookMyself">个人信息</a></li>
						<li><a href="${rootPath }secretary/pSForward_fUpdataPerson">修改信息</a></li>
						<li><a href="${rootPath}secretary/partySecretary_getMyExamLog">考试报告</a></li>
						<li><a href="${rootPath}secretary/partySecretary_logout">退出登陆</a></li>
                   </ul>
               </li>
              <li><a href="${rootPath}secretary/partySecretary_connectUs">联系我们</a></li>
         </ul>
     </div>
</div>

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






<div id="body">
 <div id="body-one">
   <p><img src="${rootPath}images/topimg.png"> <span>您的位置：
   <a href="${rootPath }secretary/pSForward_fIndex">首页</a>&nbsp;&nbsp;>&nbsp;&nbsp;时事新闻</span></p>
 </div>
 <div id="body-two">
   <div class="body-two-left">
       <p><span>党建</span> 巡礼</p>
       <p><a href="${rootPath }secretary/partySecretary_paperSection?paperTypeId=1">更多</a></p>
   </div>  
   <div class="body-two-center">
       <p><span>高校</span> 咨询</p>
       <p><a href="${rootPath }secretary/partySecretary_paperSection?paperTypeId=2">更多</a></p>
   </div>  
   <div class="body-two-right">
       <p><span>新乡</span> 风貌</p>
       <p><a href="${rootPath }secretary/partySecretary_paperSection?paperTypeId=3">更多</a></p>
   </div>  
 </div>
 <div id="body-three">
    <div class="body-three-left">
    	<c:forEach var="paper" items="${paperList}" begin="0" end="4">
					<p>					
						<a href="${rootPath }secretary/partySecretary_lookPaper?rp_Id=${paper.rp_Id}"><span>》&nbsp;&nbsp;&nbsp;${paper.title }</span><span>${paper.releaseDate}</span></a>
					</p>
		</c:forEach>     
    </div>
    <div class="body-three-center">
       <c:forEach var="paper" items="${paperList}" begin="5" end="9">
					<p>					
						<a href="${rootPath }secretary/partySecretary_lookPaper?rp_Id=${paper.rp_Id}"><span>》&nbsp;&nbsp;&nbsp;${paper.title }</span><span>${paper.releaseDate}</span></a>
					</p>
		</c:forEach> 
    </div>
    <div class="body-three-right">
       <c:forEach var="paper" items="${paperList}" begin="10" end="14">
					<p>					
							<a href="${rootPath }secretary/partySecretary_lookPaper?rp_Id=${paper.rp_Id}"><span>》&nbsp;&nbsp;&nbsp;${paper.title }</span><span>${paper.releaseDate}</span></a>
					</p>
		</c:forEach> 
    </div>
 </div>
 <div id="body-four">
    <div class="body-four-left">
        <p><span>媒体头条</span><a href="${rootPath }secretary/partySecretary_paperSection?paperTypeId=4">
        <img src="${rootPath}images/jiahao.png"> 查看更多</a></p>
    </div>
    <div class="body-four-center">
        <p><span>神州大地</span><a href="${rootPath }secretary/partySecretary_paperSection?paperTypeId=5">
        <img src="${rootPath}images/jiahao.png"> 查看更多</a></p>
    </div>
    <div class="body-four-right">
        <p><span>环球动态</span><a href="${rootPath }secretary/partySecretary_paperSection?paperTypeId=6"><img src="${rootPath}images/jiahao.png"> 查看更多</a></p>
    </div>
 </div>
 <div id="body-five">
    <div class="body-five-left">
    	<c:forEach var="paper" items="${paperList}" begin="15" end="19">
    		<p ><span>${paper.releaseDate}</span>
    		<a href="${rootPath }secretary/partySecretary_lookPaper?rp_Id=${paper.rp_Id}">${paper.title }</a></p>					
		</c:forEach>      
    </div>
  <div class="body-five-center">
      <c:forEach var="paper" items="${paperList}" begin="20" end="24">
    		<p ><span>${paper.releaseDate}</span>
    		<a href="${rootPath }secretary/partySecretary_lookPaper?rp_Id=${paper.rp_Id}">${paper.title }</a></p>					
		</c:forEach>
    </div>
  <div class="body-five-right">
  		<c:forEach var="paper" items="${paperList}" begin="25" end="29">
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
</body>
</html>