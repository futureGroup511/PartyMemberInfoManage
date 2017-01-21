<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看所属党员信息</title>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css">
<link rel="stylesheet" href="${rootPath }css/partySecretary/partyinformation.css">
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
   <p><img src="${rootPath }images/topimg.png"> <span>您的位置：首页&nbsp;&nbsp;>&nbsp;&nbsp;时事新闻&nbsp;&nbsp;>&nbsp;&nbsp;党建巡礼</span></p>
 </div>
 <div id="body-two">
    <input type="text" name="username" class="form-control" placeholder="请输入考试名称" autocomplete="off"/></span>
     <button class="btn btn-primary sure" type="button">搜索</button>
 </div>
 <div id="body-three">
     <div class="table-responsive">
    <table class="table table-bordered table-hover table-striped">
    <thead>
      <tr class="two">
         <th>姓名</th>
         <th>年龄</th>
         <th>性别</th>
         <th>民族</th>
         <th>籍贯</th>
         <th>手机号</th>
         <th>学习时长</th>
         <th>注册日期</th>
         <th>出生日期</th>
         <th>身份证号</th>
         <th>入党日期</th>
         <th>在党职务</th>
          <th>所属党支部</th>
       </tr>
      </thead>
      <tbody>
      			<c:forEach items="${PMIlist}" var="pmi">
				  <tr>
						<td>${pmi.username}</td>
						<td>${pmi.age}</td>
						<td>${pmi.sex}</td>
						<td>${pmi.nation}</td>
						<td>${pmi.nativePlace}</td>
						<td>${pmi.phoneNo}</td>
						<td>${pmi.strLearnTime}</td>
						<td>${pmi.loginDate}</td>
						<td>${pmi.birthdate}</td>
						<td>${pmi.idCard}</td>
						<td>${pmi.joinPartyDate}</td>
						<td>${pmi.duties}</td>
						<td>${pmi.partyBranch}</td>
					</tr>
				</c:forEach>
      </tbody>
    </table>
 </div>
 </div>
 </div>
	
	
	 <div class="container">
      <p class="xixnxi">每页显示10条，总记录数4条</p>
         <nav>
          <ul class="pagination">
               </li>
               <li><a href="#">首页</a></li>
               <li><a href="#">上一页</a></li>
               <li><a href="#">3</a></li>
               <li><a href="#">下一页</a></li>
               <li><a href="#">尾页</a></li>
               </li>
          </ul>
        </nav>
</div>	
		
	 <footer id="footer-warp"><!--页脚开始-->
		<p class="footer"><a href="">网站声明</a> &nbsp; &nbsp;<span>|</span> &nbsp; &nbsp;<a href="">关于我们 &nbsp; &nbsp;</a><span>|</span> &nbsp; &nbsp;<a href="">联系我们</a></p>
		<p>Copyright @ 2016 All rights reserved.　　版权所有：河南科技学院党委</p>
</footer><!--页脚结束-->		
</body>
</html>