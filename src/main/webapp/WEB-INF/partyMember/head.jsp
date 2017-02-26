<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


</head>
<body>
	<div id="header">
     <div class="header-left">
          <img src="${rootPath}images/header-logo.png">
      </div>
      <div class="header-center">
              <p class="top"><b><strong>河南科技学院信息工程学院党委主办</strong></b></p>
              <p class="bottom"><b><strong>河南科技学院信息工程学院星火在线</strong></b></p>
       </div>
       <div class="header-right">
             <div>
             	<form action="${rootPath}party/partyMemberAction_select.action" method="post">
    		     	<select name="type">
							<option value="news">学习园地</option>
							<option value="video">影音资料</option>
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
              <li><a href="${rootPath }party/partyMemberAction_getResPaper.action">学习园地</a></li>
              <li><a href="${rootPath}party/partyMemberAction_viewVideos.action">影音资料</a></li>
              <%-- <li><a href="${rootPath}party/partyMemberAction_startTest.action">在线考试</a></li>    --%>          
              <li><a href="${rootPath}party/partyMemberAction_onlineSelfTest.action">在线测试</a></li>
              <li class="dropdown"><a href="#" data-toggle="dropdown" class="dropdown-toggle">个人中心<span class="caret"></span></a>
                   <ul class="dropdown-menu">
                         <li><a href="${rootPath}party/partyMemberAction_seekPartyMemberInfo.action">个人信息</a></li>
                         <li><a href="${rootPath}party/partyMemberAction_getInfoBeforeUpdate.action">修改密码</a></li>
                         <%-- <li><a href="${rootPath}party/partyMemberAction_getMyExamLog.action">考试报告</a></li> --%>
                         <li><a href="${rootPath}login_logout">退出登录</a></li>
                   </ul>
               </li>
              <li><a href="${rootPath}party/partyMemberAction_informList.action">通知公告</a></li>
              <li><a href="${rootPath}party/partyMemberAction_partyIntroduction.action">党委简介</a></li>

         </ul>
        </div>
     </div>
</div>
</body>
</html>