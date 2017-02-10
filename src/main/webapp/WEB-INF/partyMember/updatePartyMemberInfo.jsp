<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改个人信息</title>
<link rel="stylesheet" href="${rootPath}css/partyMember/bootstrap.css">
<link rel="stylesheet" href="${rootPath}css/partyMember/updatePartyMemberInfo.css">
<script src="${rootPath}js/jquery-2.2.3.min.js"></script>
<script src="${rootPath}js/bootstrap.js"></script>
<script src="${rootPath }js/sha1.js"></script>
<script type="text/javascript">
	function judegePwd() {		
		var pwd1=document.getElementById("password");
		var pwd2=document.getElementById("newPassword");
		if(pwd1.value ==pwd2.value ){
			var sha = hex_sha1(pwd1.value );		
			pwd2.value=sha;			
			return true;
		}else{
			alert("两次密码输入不一致，请重新输入");
			return false;
		}
	}
</script>
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
       <div class="col-lg-8 col-lg-offset-3 col-md-8 col-md-offset-3 col-xs-8 col-xs-offset-3">
         <ul class="nav navbar-nav">
              <li><a href="${rootPath}party/partyLogin.action">网站首页</a></li>
              <li><a href="${rootPath }party/partyMemberAction_getResPaper.action">时事新闻</a></li>
              <li><a href="${rootPath}party/partyMemberAction_viewVideos.action">学习园地</a></li>
              <%-- <li><a href="${rootPath}party/partyMemberAction_startTest.action">在线考试</a></li> --%>
              <li><a href="${rootPath}party/partyMemberAction_onlineSelfTest.action">在线自测</a></li>
              <li class="dropdown"><a href="#" data-toggle="dropdown" class="dropdown-toggle">个人中心<span class="caret"></span></a>
                   <ul class="dropdown-menu">
                         <li><a href="${rootPath}party/partyMemberAction_seekPartyMemberInfo.action">个人信息</a></li>
                         <li><a href="${rootPath}party/partyMemberAction_getInfoBeforeUpdate.action">修改信息</a></li>
                         <%-- <li><a href="${rootPath}party/partyMemberAction_getMyExamLog.action">考试报告</a></li> --%>
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
     <p><img src="${rootPath}images/topimg.png"> <span>您的位置：<a href="${rootPath}party/partyLogin.action">首页</a>&nbsp;&nbsp;>&nbsp;&nbsp;个人中心&nbsp;&nbsp;>&nbsp;&nbsp;修改信息</span></p>
  </div>
  <div id="body-big">
   <div id="body-two">
     <p>提示：密码必须是字母和数字的组合,长度为8~16位</p>
   </div>
  <div id="body-four">
          <ul class="nav nav-tabs" role="tablist">
                  <li role="presentation" class="active"><a href="#home" role="tab" data-toggle="tab">修改密码</a></li>
                  <li role="presentation"><a href="#profile" role="tab" data-toggle="tab">修改手机号</a></li>
          </ul>
 <!-- Tab panes -->
     <div class="tab-content">
        <div role="tabpanel" class="tab-pane active" id="home">
           <div id="body-three">
           		<form action="${rootPath}party/partyMemberAction_updatePartyMemberInfo?judge=1" method="post" >          			
               		<p><input type="password"  id="password" class="form-control" placeholder="请输入新密码" required="required" pattern="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$"  autocomplete="off"/></p>
               		<p><input type="password" name="newPassword" id="newPassword" class="form-control" placeholder="请再次输入密码" required="required" pattern="^.{8,}$" autocomplete="off"/></p>              		
               		<button class="btn btn-primary" type="submit" onclick="return judegePwd();">确认修改</button>
               		<button class="btn btn-primary sure" type="reset">重置</button>
               </form>
               <h4>${updateMsg}</h4>
            </div>
        </div>
       <div role="tabpanel" class="tab-pane" id="profile">
           <div id="body-three">
           		<form action="${rootPath}party/partyMemberAction_updatePartyMemberInfo?judge=2" method="post">
              		<p><input type="text" name="newPhoneNum" class="form-control" placeholder="请输入新的手机号" pattern="^1\d{10}$" required="required" autocomplete="off"/></p>              		
                	<button class="btn btn-primary" type="submit">确认修改</button>
                	<button class="btn btn-primary sure" type="reset">重置</button>
                </form>
                 <h4>${updateMsg}</h4>
            </div>
       </div>
   </div>
 </div>
 </div>
 
</div>
 <footer id="footer-warp"><!-- 页脚开始 -->
		<p class="footer"><a href="">网站声明</a> &nbsp; &nbsp;<span>|</span> &nbsp; &nbsp;<a href="">关于我们 &nbsp; &nbsp;</a><span>|</span> &nbsp; &nbsp;<a href="">联系我们</a></p>
		<p>Copyright @ 2016 All rights reserved.　　版权所有：河南科技学院党委</p>
</footer><!-- 页脚结束	 -->
</body>
</html>