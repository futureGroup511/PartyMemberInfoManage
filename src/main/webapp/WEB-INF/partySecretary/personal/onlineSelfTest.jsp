<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线考试</title>

<link rel="stylesheet" href="${rootPath}css/partyMember/bootstrap.css">
<link rel="stylesheet" href="${rootPath}css/partySecretary/online learning.css">
<script src="${rootPath}js/jquery-2.2.3.min.js"></script>
<script src="${rootPath}js/bootstrap.js"></script>

</head>
<body >
<div id="header" >
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
						<li><a href="${rootPath}login_logout">退出登录</a></li>
                   </ul>
               </li>
              <li><a href="${rootPath}secretary/partySecretary_connectUs">联系我们</a></li>
         </ul>
     </div>
</div>

<!--以上为头部-->
	<div id="body">
		<div id="body-one">
			<p>
				<img src="${rootPath}images/topimg.png"> <span>您的位置：
				<a href="${rootPath }secretary/pSForward_fIndex">首页</a>>在线测试</span>
			</p>
		</div>
		<c:choose>
			<c:when test="${NoQuestion!=null}">
				<div id="body-two1">
					<p>${NoQuestion}</p>
				</div>
			</c:when>
			<c:otherwise>				
				<div id="body-three">
					<p>共 ${testNum} 题，总分 ${testScore} 分。</p>
				</div>
				<div id="body-four">
					<p>单选题</p>
				</div>
				<form action="${rootPath}secretary/partySecretary_selfExamDetails" method="post">				
					<c:forEach items="${questionList}" var="q" varStatus="status">
						<div id="body-five">
							<p>
								${status.index+1}.${q.questions_stems}<span> *  分值: ${q.question_socre}</span>
							</p>
							<div class="radio">
								<label> <input type="radio" name="answer${status.index}" required="required"
									id="optionsRadios1" value="A${q.qt_Id}"> A. ${q.a}
								</label>
							</div>
							<div class="radio">
								<label> <input type="radio" name="answer${status.index}" required="required"
									id="optionsRadios2" value="B${q.qt_Id}"> B. ${q.b}									
								</label>
							</div>
							<div class="radio">
								<label> <input type="radio" name="answer${status.index}" required="required"
									id="optionsRadios3" value="C${q.qt_Id}"> C. ${q.c}
								</label>
							</div>
							<div class="radio">
								<label> <input type="radio" name="answer${status.index}" required="required"
									id="optionsRadios4" value="D${q.qt_Id}"> D. ${q.d}
								</label>
							</div>
						</div>
					</c:forEach>
					<div style="margin-top: 30px;padding:0  20%;">
						<button style="width:100%;" class="btn btn-success" type="submit">交卷</button>
						<h4>${addExamLogMsg}</h4>
					</div>					
				</form>
			</c:otherwise>
		</c:choose>														
	</div>
	<footer id="footer-warp"><!--页脚开始-->
	<p class="footer">
		<a href="">网站声明</a> &nbsp; &nbsp;<span>|</span> &nbsp; &nbsp;<a
			href="">关于我们 &nbsp; &nbsp;</a><span>|</span> &nbsp; &nbsp;<a href="">联系我们</a>
	</p>
	<p>Copyright @ 2016 All rights reserved. 版权所有：河南科技学院党委</p>
	</footer>
	<!--页脚结束-->
</body>
</html>
