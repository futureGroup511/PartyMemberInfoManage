<%@ page language="java" contentType="text/html; charset=UTF-8"
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
			<img src="${rootPath}images/header-logo.png">
			<p>河南科技学院党员信息管理系统</p>
		</div>
	</div>
	<div class="body">
		<div class="header-one">
			<img src="${rootPath}images/header-one.jpg">
		</div>
		<div class="header-two">
			<img src="${rootPath}images/header-two.jpg">
		</div>
		<div class="header-three">
			<p id="headline" class="demo-text one">河南科技学院党员信息管理</p>
			<p class="two">河南科技学院党委主办</p>
		</div>
	</div>
	<div class="nav navbar-top">
		<div class="row">
			<div
				class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-xs-8 col-xs-offset-2">
				<ul class=" nav navbar-nav">
					<li class="active"><a href="partyLogin.action">首页</a></li>
					<li><a href="partyMemberAction_viewVideos.action">红色视频</a></li>
					<li class="dropdown"><a href="##" data-toggle="dropdown"
						class="dropdown-toggle">个人信息<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="partyMemberAction_seekPartyMemberInfo.action">查看个人信息</a></li>
							<li><a href="partyMemberAction_getInfoBeforeUpdate.action">修改个人信息</a></li>
						</ul></li>
					<!-- <li><a href="partyMemberAction_seekPartyMemberInfo.action">查看个人信息</a></li>
					<li><a href="partyMemberAction_getInfoBeforeUpdate.action">修改个人信息</a></li> -->
					<!-- <li><a href="##">军事</a></li> -->
					<!-- <li><a href="##">生活</a></li> -->
				</ul>
			</div>
			<div class="col-lg-2 col-md-2 col-xs-2">
				<span class="one"><!-- <a href="##">登录</a></span> <span class="two"> --><a
					href="##">退出</a></span>
			</div>
		</div>
	</div>
	<div class="body-five">
		<img src="${rootPath}images/footer-one.png">
	</div>
	
	<!-- 修改个人信息-->
	<div style="padding-left: 500px;">
		<form action="partyMemberAction_updatePartyMemberInfo.action"
			method="post">
			<table>
				<tr>
					<td>账号</td>
					<td>${partyMember.account}</td>
				</tr>
				<tr>
					<td>用户类别</td>
					<td>${partyMember.sort}</td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input type="text" name="partyMemberInfo.username"
						value="${partyMember.username}"></td>
				</tr>
				<tr>
					<c:choose>
						<c:when test="${partyMember.sex=='男'}">
							<td>性&nbsp;&nbsp;别：</td>
							<td><input type="radio" name="partyMemberInfo.sex" value='男' checked>男&nbsp; 
								<input type="radio" name="partyMemberInfo.sex" value='女'>女</td>
						</c:when>
						<c:otherwise>
							<td>性&nbsp;&nbsp;别：</td>
							<td><input type="radio" name="partyMemberInfo.sex" value='男'>男&nbsp;
								<input type="radio" name="partyMemberInfo.sex" value='女' checked>女</td>
						</c:otherwise>
					</c:choose>
				</tr>
				<tr>
					<td>年龄</td>
					<td><input type="number" name="partyMemberInfo.age"
						value="${partyMember.age}"></td>
				</tr>
				<tr>
					<td>民族</td>
					<td><input type="text" name="partyMemberInfo.nation"
						value="${partyMember.nation}"></td>
				</tr>
				<tr>
					<td>出生日期</td>
					<td><input type="datetime" name="partyMemberInfo.birthdate"
						value="${partyMember.birthdate}"></td>
				</tr>
				<tr>
					<td>身份证号码</td>
					<td><input type="text" name="partyMemberInfo.idCard"
						value="${partyMember.idCard}"></td>
				</tr>
				<tr>
					<td>籍贯</td>
					<td><input type="text" name="partyMemberInfo.nativePlace"
						value="${partyMember.nativePlace}"></td>
				</tr>
				<tr>
					<td>入党日期</td>
					<td>${partyMember.joinPartyDate}</td>
				</tr>
				<tr>
					<td>职务</td>
					<td>${partyMember.duties}</td>
				</tr>
				<tr>
					<td>介绍人</td>
					<td>${partyMember.introducer}</td>
				</tr>
				<tr>
					<td>所在党支部</td>
					<td>${partyMember.partyBranch}</td>
				</tr>
				<tr>
					<td>学习时间</td>
					<td>${partyMember.learnTime}</td>
				</tr>
				<tr>
					<td>手机号</td>
					<td><input type="tel" name="partyMemberInfo.phoneNo"
						value="${partyMember.phoneNo}"></td>
				</tr>
				<tr>
					<td>注册时间</td>
					<td>${partyMember.loginDate}</td>
				</tr>
				<tr>
					<td>新密码</td>
					<td><input type="password" value="******"></td>
				</tr>
				<tr>
					<td>确认新密码</td>
					<td><input type="password" name="partyMemberInfo.password"
						value="******"></td>
				</tr>
				<tr>
					<td><input type="reset" value="重      置"> <input
						type="submit" value="确认修改"></td>
				</tr>
			</table>
			<label>${updateMsg}</label>
		</form>
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

	
