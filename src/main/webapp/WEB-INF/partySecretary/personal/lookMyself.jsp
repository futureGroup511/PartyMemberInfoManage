<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css">
<link rel="stylesheet" href="${rootPath }css/partySecretary/my space.css">
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
    		     <select>
						<option>时事新闻</option>
						<option>生活百科</option>
						<option>新闻动态</option>
						<option>通知公告</option>
				 </select>
                  <input type="text" name="select" placeholder="&nbsp;&nbsp;&nbsp;请输入您要搜索的内容">
                   <button class="btn"><img src="${rootPath }images/sousuo.png" width="22" height="22"></button>
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
               				

              <li><a href="${rootPath }secretary/partySecretary_videoList">在线视频</a></li>
				<li><a href="${rootPath }secretary/pSForward_paperList">在线文章</a></li>
				<li><a href="${rootPath }secretary/pSForward_startTest">在线考试</a></li>
               <li class="dropdown"><a href="#" data-toggle="dropdown" class="dropdown-toggle">个人中心<span class="caret"></span></a>
                   <ul class="dropdown-menu">
						<li><a href="${rootPath }secretary/partySecretary_lookMyself">个人信息</a></li>
						<li><a href="${rootPath }secretary/pSForward_fUpdataPerson">修改信息</a></li>
						<li><a href="${rootPath}secretary/partySecretary_getMyExamLog">考试报告</a></li>
                   </ul>
               </li>
              <li><a href="connect us.html">联系我们</a></li>
         </ul>
     </div>
</div>

<!--以上为头部-->


<div id="body">
 <div id="body-one">
   <p><img src="${rootPath}images/topimg.png"> <span>您的位置：<a href="${rootPath}party/partyLogin.action">首页</a>>个人中心>个人信息</span></p>
 </div>
 <div id="body-three">
   <p><strong>个人信息</strong></p>
    <ol>
      <li class="one"><li><span>账   号：</span><span>${secretary.account}</span></li>
	 <li><span>姓   名：</span><span>${secretary.username}</span></li>
	 <li><span>性   别：</span><span>${secretary.sex}</span></li>
	 <li><span>年   龄：</span><span>${secretary.age}</span></li>
	 <li><span>民   族：</span><span>${secretary.nation}</span></li>
	 <li><span>出生日期：</span><span>${secretary.birthdate}</span></li>
	 <li><span>籍   贯：</span><span>${secretary.nativePlace}</span></li>
	 <li><span>身份证号：</span><span>${secretary.idCard}</span></li>
	 <li><span>入党日期：</span><span>${secretary.joinPartyDate}</span></li>
	 <li><span>职   务：</span><span>${secretary.duties}</span></li>
	 <li><span>所在党支部：</span><span>${secretary.partyBranch}</span></li>
	 <li><span>学习时间：</span><span>${secretary.strLearnTime }</span></li>
	 <li><span>手 机 号：</span><span>${secretary.phoneNo}</span></li>
	 <li><span>注册日期：</span><span>${secretary.loginDate}</span></li>	
    </ol>
 </div>
 </div>
 
 <footer id="footer-warp"><!--页脚开始-->
		<p class="footer"><a href="">网站声明</a> &nbsp; &nbsp;<span>|</span> &nbsp; &nbsp;<a href="">关于我们 &nbsp; &nbsp;</a><span>|</span> &nbsp; &nbsp;<a href="">联系我们</a></p>
		<p>Copyright @ 2016 All rights reserved.　　版权所有：河南科技学院党委</p>
</footer><!--页脚结束-->	
</body>
</html>