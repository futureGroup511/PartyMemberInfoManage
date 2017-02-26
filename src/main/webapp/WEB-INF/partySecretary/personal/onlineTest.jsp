
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线考试</title>

<link rel="stylesheet" href="${rootPath}css/partyMember/bootstrap.css">
<link rel="stylesheet" href="${rootPath }css/partySecretary/red_tou.css">
<link rel="stylesheet" href="${rootPath}css/partySecretary/online learning.css">
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

</script >
</head>
<body onload="timer()">

<%@ include file="../head.jsp"%>
<!--以上为头部-->
	<div id="body">
		<div id="body-one">
			<p>
				<img src="${rootPath}images/topimg.png"> <span>您的位置：
				<a href="${rootPath }secretary/pSForward_fIndex">首页</a>>在线考试</span>
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
				<form action="${rootPath}secretary/partySecretary_getExamRecord">				
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
