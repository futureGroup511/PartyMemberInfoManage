<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看个人信息</title>
<link rel="stylesheet" href="${rootPath}css/partyMember/bootstrap.css">
<link rel="stylesheet" href="${rootPath}css/partyMember/getPartyMemberInfo.css">
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
       <div class="col-lg-9 col-lg-offset-3 col-md-9 col-md-offset-3 col-xs-9 col-xs-offset-3">
         <ul class="nav navbar-nav">
              <li><a href="${rootPath}party/partyLogin.action">网站首页</a></li>
              <li><a href="${rootPath }party/partyMemberAction_getResPaper.action">时事新闻</a></li>
              <li><a href="${rootPath}party/partyMemberAction_viewVideos.action">学习园地</a></li>
              <li><a href="${rootPath}party/partyMemberAction_startTest.action">在线考试</a></li>
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
</div>
<div id="body">
 <div id="body-one">
   <p><img src="${rootPath}images/topimg.png"> <span>您的位置：<a href="${rootPath}party/partyLogin.action">首页</a>&nbsp;&nbsp;>&nbsp;&nbsp;个人中心&nbsp;&nbsp;>&nbsp;&nbsp;个人信息</span></p>
 </div>
 <div id="body-three">
   <p><strong>个人信息</strong></p>
    <ol>
      <li class="one"><li><span>账   号：</span><span>${partyMember.account}</span></li>
	 <li><span>姓   名：</span><span>${partyMember.username}</span></li>
	 <li><span>性   别：</span><span>${partyMember.sex}</span></li>
	 <li><span>年   龄：</span><span>${partyMember.age}</span></li>
	 <li><span>民   族：</span><span>${partyMember.nation}</span></li>
	 <li><span>出生日期：</span><span>${partyMember.birthdate}</span></li>
	 <li><span>籍   贯：</span><span>${partyMember.nativePlace}</span></li>
	 <li><span>身份证号：</span><span>${partyMember.idCard}</span></li>
	 <li><span>入党日期：</span><span>${partyMember.joinPartyDate}</span></li>
	 <li><span>职   务：</span><span>${partyMember.duties}</span></li>
	 <li><span>介 绍 人：</span><span>${partyMember.introducer}</span></li>
	 <li><span>所在党支部：</span><span>${partyMember.partyBranch}</span></li>
	 <li><span>学习时间：</span><span>${partyMember.strLearnTime}</span></li>
	 <li><span>手 机 号：</span><span>${partyMember.phoneNo}</span></li>
	 <li><span>注册时间：</span><span>${partyMember.loginDate}</span></li>	
    </ol>
 </div>
 <footer id="footer-warp"><!-- 页脚开始 -->
		<p class="footer"><a href="">网站声明</a> &nbsp; &nbsp;<span>|</span> &nbsp; &nbsp;<a href="">关于我们 &nbsp; &nbsp;</a><span>|</span> &nbsp; &nbsp;<a href="">联系我们</a></p>
		<p>Copyright @ 2016 All rights reserved.　　版权所有：河南科技学院党委</p>
</footer><!-- 页脚结束	 -->
</body>
</html>