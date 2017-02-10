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

<%@ include file="../head.jsp"%>

<!--以上为头部-->


<div id="body">
 <div id="body-one">
   <p><img src="${rootPath}images/topimg.png"> <span>您的位置：<a href="${rootPath }secretary/pSForward_fIndex">首页</a>>
   <a href="${rootPath }secretary/partySecretary_lookMyself">个人信息</a></span></p>
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