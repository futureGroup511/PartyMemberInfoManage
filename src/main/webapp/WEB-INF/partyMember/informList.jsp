<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通知公告</title>
<link rel="stylesheet" href="${rootPath}css/partyMember/bootstrap.css">
<link rel="stylesheet"
	href="${rootPath}css/partyMember/notification message.css">
<script src="${rootPath}js/jquery-2.2.3.min.js"></script>
<script src="${rootPath}js/bootstrap.js"></script>
</head>

<body>
	<div id="header">
		<div class="header-left">
			<img src="${rootPath}images/header-logo.png">
		</div>
		<div class="header-center">
			<p class="top">
				<b><strong>河南科技学院信息工程学院党委主办</strong></b>
			</p>
			<p class="bottom">
				<b><strong>河南科技学院党员在线</strong></b>
			</p>
		</div>
		<div class="header-right">
			<div>
				<form action="${rootPath}party/partyMemberAction_select.action" method="post">
    		     	<select name="type">
							<option value="news">时事新闻</option>
							<option value="video">学习园地</option>
				 	</select>
                  	<input type="text" name="search" placeholder=" 请输入您要搜索的内容">
                   	<button class="btn"><img src="${rootPath }images/sousuo.png" width="22" height="22"></button>
             	</form>  
			</div>
		</div>
	</div>
	<div class="nav">
		<div class="row">
			<div
				class="col-lg-9 col-lg-offset-3 col-md-9 col-md-offset-3 col-xs-9 col-xs-offset-3">
				<ul class="nav navbar-nav">
					<li><a href="${rootPath}party/partyLogin.action">网站首页</a></li>
					<li><a
						href="${rootPath }party/partyMemberAction_getResPaper.action">时事新闻</a></li>
					<li><a
						href="${rootPath}party/partyMemberAction_viewVideos.action">学习园地</a></li>
					<%-- <li><a
						href="${rootPath}party/partyMemberAction_startTest.action">在线考试</a></li> --%>
						<li><a href="${rootPath}party/partyMemberAction_onlineSelfTest.action">在线自测</a></li>
					<li class="dropdown"><a href="#" data-toggle="dropdown"
						class="dropdown-toggle">个人中心<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a
								href="${rootPath}party/partyMemberAction_seekPartyMemberInfo.action">个人信息</a></li>
							<li><a
								href="${rootPath}party/partyMemberAction_getInfoBeforeUpdate.action">修改信息</a></li>
							<%-- <li><a
								href="${rootPath}party/partyMemberAction_getMyExamLog.action">考试报告</a></li> --%>
							<li><a href="${rootPath}login_logout">退出登录</a></li>
						</ul></li>
					<li><a
						href="${rootPath}party/partyMemberAction_informList.action">通知公告</a></li>
					<li><a
						href="${rootPath}party/partyMemberAction_connectUs.action">联系我们</a></li>

				</ul>
			</div>
		</div>
	</div>
	<div id="body">
		<div id="body-one">
			<p>
				<img src="${rootPath}images/topimg.png"> <span>您的位置：<a href="${rootPath}party/partyLogin.action">首页</a>&nbsp;&nbsp;>&nbsp;&nbsp;通知公告</span>
			</p>
		</div>
		<c:if test="${informMsg==null }">
			<div id="body-two">
				<c:forEach items="${pc.data }" var="i">
					<p>
						<a href="${rootPath }party/partyMemberAction_lookInform?inform.info_Id=${i.info_Id}">${i.title }<span>${i.sendDate}</span></a>
					</p>
				</c:forEach>
			</div>
			
			<div id="pagecut">
				<ul class="pagination">
					<li><a
						href="${rootPath }party/partyMemberAction_informList?page=${pc.prePage}">上一页</a></li>
					<c:if test="${1 < pc.currentPage -3}">
						<li><a
							href="${rootPath }party/partyMemberAction_informList?page=1">1</a></li>
					</c:if>

					<c:forEach var="i"
						begin="${pc.currentPage-3>0?pc.currentPage-3:1 }"
						end="${pc.currentPage+3>pc.pageNum?pc.pageNum:pc.currentPage+3  }">
						<c:choose>
							<c:when test="${i>0 && i == pc.currentPage }">
								<li class="active"><a
									href="${rootPath }party/partyMemberAction_informList?page=${i }">${i}</a></li>
							</c:when>

							<c:when test="${i>0 && i != postPS.currentPage }">
								<li><a
									href="${rootPath }party/partyMemberAction_informList?page=${i }">${i}</a></li>
							</c:when>
						</c:choose>
					</c:forEach>
					<li><a
						href="${rootPath }party/partyMemberAction_informList?page=${pc.nextPage}">下一页</a></li>
				</ul>

			</div>
			
		</c:if>
		
		<c:if test="${informMsg!=null}">
			<h3 style="height: 200px;margin-left: 550px;margin-top: 160px;color: #DB0B18;">暂时没有通知！</h3>
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
<script type="text/javascript">
	var notice = "${notice}";
	if (notice === "") {

	} else {
		alert(notice);
	}
</script>