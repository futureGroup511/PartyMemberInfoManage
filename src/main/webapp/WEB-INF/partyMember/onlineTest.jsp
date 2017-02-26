<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线考试</title>
<link rel="stylesheet" href="${rootPath}css/partyMember/head2.css">
<link rel="stylesheet" href="${rootPath}css/partyMember/bootstrap.css">
<link rel="stylesheet" href="${rootPath}css/partyMember/online learning.css">
<script src="${rootPath}js/jquery-2.2.3.min.js"></script>
<script src="${rootPath}js/bootstrap.js"></script>
<script type="text/javascript">
function timer()  
{  	
	if("${NoTest}"==null){
		
	}
	else{
		var endtime="${time}";
		var nowtime=(new Date()).getTime();
		
	    var ts =endtime-nowtime;//计算剩余的毫秒数   	 	
	    var hh = parseInt((ts/1000/60/60), 10);//计算剩余的小时数  
	    var mm = parseInt((ts/1000/60%60), 10);//计算剩余的分钟数  
	    var ss = parseInt((ts/1000%60), 10);//计算剩余的秒数  
	      
	    hh = checkTime(hh);  
	    mm = checkTime(mm);  
	    ss = checkTime(ss);  
	    document.getElementById("timer").innerHTML =  hh + " 时 " + mm + " 分 " + ss + " 秒";  
	    var rootPath="${rootPath}";  
	    if(hh==00&&mm==01&&ss==00){	    	
	    	alert("还有一分钟考试结束，请尽快交卷！");	    	
	    } 
	    if(hh==00&&mm==00&&ss==00){     	
	     	alert("考试结束！");	     	
	     	window.location=rootPath+"party/partyMemberAction_startTest.action";	     	
	    } 
	    
	    setInterval("timer()",1000);
	}
}  
function checkTime( i)    
{    
   if (i < 10) {    
       i = "0" + i;    
    }    
   return i;    
}    

if('${addExamLogMsg}'!=null && '${addExamLogMsg}'!=""){   	
	alert('${addExamLogMsg}');
}

</script>
</head>

<body onload="timer()">
	<%@ include file="head.jsp" %>
	<%-- <div id="header">
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
	<div class="nav navbar-inverse">
		<div class="row">
			<div
				class="col-lg-9 col-lg-offset-3 col-md-9 col-md-offset-3 col-xs-9 col-xs-offset-3">
				<ul class="nav navbar-nav">
					<li><a href="${rootPath}party/partyLogin.action">网站首页</a></li>
					<li><a href="${rootPath }party/partyMemberAction_getResPaper.action">时事新闻</a></li>
					<li><a
						href="${rootPath}party/partyMemberAction_viewVideos.action">学习园地</a></li>
					<li><a
						href="${rootPath}party/partyMemberAction_startTest.action">在线考试</a></li>
						<li><a href="${rootPath}party/partyMemberAction_onlineSelfTest.action">在线自测</a></li>
					<li class="dropdown"><a href="#" data-toggle="dropdown"
						class="dropdown-toggle">个人中心<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a
								href="${rootPath}party/partyMemberAction_seekPartyMemberInfo.action">个人信息</a></li>
							<li><a
								href="${rootPath}party/partyMemberAction_getInfoBeforeUpdate.action">修改信息</a></li>
							<li><a
								href="${rootPath}party/partyMemberAction_getMyExamLog.action">考试报告</a></li>
							<li><a href="${rootPath}login_logout">退出登录</a></li>
						</ul></li>
					 <li><a href="${rootPath}party/partyMemberAction_informList.action">通知公告</a></li>
					<li><a href="${rootPath}party/partyMemberAction_connectUs.action">联系我们</a></li>
				</ul>
			</div>
		</div>
	</div> --%>
	<div id="body">
		<div id="body-one">
			<p>
				<img src="${rootPath}images/topimg.png"> <span>您的位置：<a href="${rootPath}party/partyLogin.action">首页</a>&nbsp;&nbsp;>&nbsp;&nbsp;在线考试</span>
			</p>
		</div>
		<c:choose>
			<c:when test="${NoTest!=null}">
				<div id="body-two1">
					<p>${NoTest}</p>
				</div>
			</c:when>
			<c:otherwise>
				<!-- 考试倒计时 -->
				<div class="up">
					<h5>剩余时间为：</h5>
					<div id="timer" class="timer"></div>
				</div>
				<!-- 倒计时结束 -->
				<div id="body-two">
					<p>${startTest.paperName}</p>
				</div>
				<div id="body-three">
					<p>共 ${startTest.testNum} 题，总分 ${startTest.totalScore} 分。考试时间 ${startTest.testTime}</p>
				</div>
				<div id="body-four">
					<p>单选题</p>
				</div>
				<form id="form1" action="${rootPath}party/partyMemberAction_getExamRecord.action">				
					<c:forEach items="${questionsList}" var="q" varStatus="status">
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
					<div class="submit">
						<input type="submit" value="交卷"  class="btn btn-primary">
						
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