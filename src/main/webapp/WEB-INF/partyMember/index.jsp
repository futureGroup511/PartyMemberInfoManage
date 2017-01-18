<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>党员首页</title>
<link rel="stylesheet" href="${rootPath}css/partyMember/bootstrap.css">
<link rel="stylesheet" href="${rootPath}css/partyMember/index-two.css">
<script src="${rootPath}js/jquery-2.2.3.min.js"></script>
<script src="${rootPath}js/bootstrap.js"></script>
</head>

<body>
<div id="header">
     <div class="header-left">
          <img src="${rootPath}images/header-logo.png">
      </div>
      <div class="header-center">
              <p class="top"><b><strong>河南科技学院信息工程学院党委主办</strong></b></p>
              <p class="bottom"><b><strong>河南科技学院党员在线</strong></b></p>
       </div>
       <div class="header-right">
             <div>
    		     <select>
						<option>时事新闻</option>
						<option>生活百科</option>
						<option>新闻动态</option>
						<option>通知公告</option>
				 </select>
                  <input type="text" name="select" placeholder="请输入您要搜索的内容">
                   <button class="btn"><img src="${rootPath}images/sousuo.png" width="22" height="22"></button>
             </div>
       </div>
</div>

<div class="nav">
     <div class="row">
       <div class="col-lg-8 col-lg-offset-3 col-md-8 col-md-offset-3 col-xs-8 col-xs-offset-3">
         <ul class="nav navbar-nav">
              <li><a href="${rootPath}party/partyLogin.action">网站首页</a></li>
              <li><a href="${rootPath }secretary/pSForward_paperList.action">红色文章</a></li>
              <li><a href="${rootPath}party/partyMemberAction_viewVideos.action">红色视频</a></li>
              <li><a href="${rootPath}party/partyMemberAction_startTest.action">在线考试</a></li>
              <li class="dropdown"><a href="#" data-toggle="dropdown" class="dropdown-toggle">个人中心<span class="caret"></span></a>
                   <ul class="dropdown-menu">
                         <li><a href="${rootPath}party/partyMemberAction_seekPartyMemberInfo.action">个人信息</a></li>
                         <li><a href="${rootPath}party/partyMemberAction_getInfoBeforeUpdate.action">修改信息</a></li>
                         <li><a href="${rootPath}party/partyMemberAction_getMyExamLog.action">考试报告</a></li>
                   </ul>
               </li>
              <li><a href="information.jsp">通知公告</a></li>
              <li><a href="${rootPath}connect_us.jsp">联系我们</a></li>
         </ul>
        </div>
     </div>
</div>
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
            <a href="#"><img src="${rootPath}images/banner-one.jpg" width="100%" height="300"></a>
      </div>
      <div class="item">
           <a href="#"><img src="${rootPath}images/banner-two.jpg" width="100%" height="300"></a> 
      </div>
      <div class="item">
           <a href="#"><img src="${rootPath}images/banner-three.jpg" width="100%" height="300"></a>
      </div>
      <div class="item">
           <a href="#"><img src="${rootPath}images/banner-four.jpg" width="100%" height="300"></a>
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
<div id="banner-one">
   <div class="row">
       <div class="col-lg-9 col-lg-offset-1 col-md-9 col-md-offset-1 col-xs-9 col-xs-offset-1">
          <img src="${rootPath}images/tongzhi.png"> 通知公告 <img src="${rootPath}images/jiantou.png"> “学党章” 系列微课上线通知2016-09-13  <img src="${rootPath}images/jiantou.png"> 河南高校“两学一做”专题精品党课、微课...2016-07-13
       </div>
   </div>
</div>
<div id="paper-warp"><!--文章区开始-->
			<div class="row">
              <div class="col-lg-4 col-md-4 col-xs-4">
				<div class="paper-one">
                    <img src="${rootPath}images/zxbt.png">
                    <span class="paper-img">最新文章</span>
					<ol> 
						<li><span><a href="#">房产商一房二卖被判退一赔一 法官：遏制其他违约</a></span></li>
						<li><span><a href="#">杨东升任鸡年央视春晚总导演：希望不被大家吐槽</a></span></li>
						<li><span><a href="#">空姐面试官欲“潜规则”女考生？海航回应：已被开除</a></span></li>
						<li><span><a href="#">手游公司员工偷为玩家充值 涉案价值3亿8千万</a></span></li>
						<li><span><a href="#">捅杀广外女生嫌犯自供：没钱吃饭 想干坏事被抓</a></span></li>
					</ol>
				</div>
               </div>
               <div class="col-lg-1 col-md-1 col-xs-1" style="font-size:12px;">
                   <li><span>2016-12-22</span></li>
				   <li><span>2016-12-22</span></li>
				   <li><span>2016-12-22</span></li>
				   <li><span>2016-12-22</span></li>
				   <li><span>2016-12-22</span></li>  
               </div>
               <div class="col-lg-4 col-lg-offset-1 col-md-4 col-md-offset-1 col-xs-4 col-xs-offset-1">
				<div class="paper-two">
                    <img src="${rootPath}images/zxbt.png">
					<span class="paper-img" id="pager-img-two">热门文章</span> 
					<ol> 
						<li><span><a href="#">鸡年春晚语言类节目预计约10个 堪称近年之最</a></span></li>
						<li><span><a href="#">中国尊明年主体完工 500米高度能冲破雾霾吗?</a></span></li>
						<li><span><a href="#">十八大以来，湖北已为万余名受错告诬告干部还清白</a></span></li>
						<li><span><a href="#">河北磁县城管无证执法车上路8年 交警令限期整改</a></span></li>
						<li><span><a href="#">台籍女子竞选澳议员 叫嚣：亚裔分两种 好的支持我</a></span></li>
					</ol>
				</div>
               </div>
               <div class="col-lg-1 col-md-1 col-xs-1" style="font-size:12px;">
                   <li><span>2016-12-22</span></li>
				   <li><span>2016-12-22</span></li>
				   <li><span>2016-12-22</span></li>
				   <li><span>2016-12-22</span></li>
				   <li><span>2016-12-22</span></li>  
              </div>
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
							 	<div class="pic"><a href="html/video.html"><img src="${rootPath}${new_video.imgUrl}"></a></div>
							 	<div class="title"><a href="#">${new_video.name}</a></div>
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
							 	<div class="pic"><a href="html/video.html"><img src="${rootPath}${new_video.imgUrl}"></a></div>
							 	<div class="title"><a href="#">${new_video.name}</a></div>
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



<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>党员首页</title>
<link rel="stylesheet" href="${rootPath}css/bootstrap.css">
<link rel="stylesheet" href="${rootPath}css/index-one.css">
<script src="${rootPath}js/jquery-2.2.3.min.js"></script>
<script src="${rootPath}js/bootstrap.js"></script>
</head>

<body>
	<div class="container">
		<div class="header">
		  <div class="row">
		    <div class="col-lg-1 col-lg-offset-3 col-md-1 col-md-offset-3 col-xs-1 col-xs-offset-3">
			   <img src="${rootPath}images/header-logo.png">
			</div>
			<div class="col-lg-8 col-md-8 col-xs-8">
			    <p>河南科技学院党员信息管理系统</p>
			</div>
		  </div>
		</div>
	</div>
	<div class="body">
		<div class="header-one">
			<img src="${rootPath}images/header-one.png">
		</div>
		<div class="header-two">
			<img src="${rootPath}images/header-two.png">
		</div>
		<div class="header-three">
			<p id="headline" class="demo-text one">河南科技学院党员信息管理</p>
			<p class="two">河南科技学院党委主办</p>
		</div>
	</div>
	<div class="nav navbar-top">
		<div class="row">
			<div
				class="col-lg-7 col-lg-offset-2 col-md-7 col-md-offset-2 col-xs-7 col-xs-offset-2">
				<ul class=" nav navbar-nav">
					
				</ul>
			</div>			
		</div>
	</div>
	<div class="body-one">
		<div class="col-lg-5 col-md-5 col-xs-5">
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
					<c:forEach items="${videosList}" var="v" varStatus="status">
						<c:choose>
							<c:when test="${status.index==0}">
								<div class="item active">
									<a href="${rootPath}/video_${v.rv_Id}.action"><img src="${rootPath}${v.imgUrl}"></a>
									<div class="carousel-caption">
										<h4>
											<a href="${rootPath}/video_${v.rv_Id}.action">${v.name}</a>
										</h4>
									</div>
								</div>
							</c:when>
							<c:otherwise>
								<c:if test="${status.index<=4}">
									<div class="item">
										<a href="${rootPath}/video_${v.rv_Id}.action"><img src="${rootPath}${v.imgUrl}"></a>
										<div class="carousel-caption">
											<h4>
												<a href="${rootPath}/video_${v.rv_Id}.action">${v.name}</a>
											</h4>
										</div>
									</div>
								</c:if>
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
				<div class="col-lg-6 col-md-6 col-xs-6">
					<div id="body-two">
						<p>习近平：把思想政治工作贯穿教育教学全过程</p>
						<ul class="content">
							<li><a href="#">习近平就巴基斯坦民航客机失事向巴总统侯赛因致慰问电</a></li>
							<li><a href="#">李克强张德江分别会见加蓬总统邦戈</a></li>
							<li><a href="#">人民日报一论学习贯彻习近平总书记高校思想政治工作会议讲话</a></li>
						</ul>
					</div>
					<div class="col-lg-7 col-md-7 col-xs-7">
						<h5>党史要闻</h5>
						<li>曲青山在纪念万里同志诞辰100周年座谈会…</li>
						<li>曲青山到陕西宣讲党的十八届六中全会精神</li>
						<li>吴德刚：保证宪法全面有效实施</li>
						<li>冯俊为中央办公厅处级以上干部作十八届六中…</li>
					</div>
					<div class="col-lg-5 col-md-5 col-xs-5">
						<h5>共同关注</h5>
						<li>习近平总书记系列重要讲话集</li>
						<li>习近平“四个全面”重要论述</li>
						<li>习近平关于党的历史的论述摘编</li>
						<li>八集历史纪录片《永远的长征》</li>
					</div>
				</div>
			</div>
			<br>
			<div class="body-five">
				<img src="${rootPath}images/footer-one.png">
			</div>

			<!-- 视频列表 -->
	<div class="text">
		<div style="padding-left: 190px; ">
			<h4>
				<a href="partyMemberAction_viewVideos.action">红色视频>></a>
			</h4>
			<c:forEach items="${videosList}" var="v" varStatus="status">
				<c:choose>
					<c:when test="${(status.index)%6==0}">
						<div style="clear: both;"></div>
						<div style="width: 158px; float: left;">
							<div>
								<img src="${rootPath}${v.imgUrl}"
									style="height: 180px; width: 120px;">
							</div>
							<div style="height: 25px;">
								<a href="${rootPath}/video_${v.rv_Id}.action" target="_blank">${v.name}</a>
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
								<a href="${rootPath}/video_${v.rv_Id}.action" target="_blank">${v.name}</a>
							</div>

						</div>
					</c:otherwise>
				</c:choose>

			</c:forEach>
		</div>

	</div>
	<div class="footer">
				<img src="${rootPath}images/footer.png">
				<div class="footer-one">
					<p>河南科技学院党员网站 京ICP备11032580号</p>
					<p>Copyright © 2012 by zgdsw.org.cn. all rights reserved</p>
				</div>
			</div>
</body>
</html>
 --%>