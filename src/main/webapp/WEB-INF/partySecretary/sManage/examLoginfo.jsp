<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${rootPath }css/bootstrap.css">
<link rel="stylesheet" href="${rootPath }css/partySecretary/red_tou.css">
<link rel="stylesheet" href="${rootPath }css/partySecretary/table-three.css">
<script src="${rootPath }js/jquery-2.2.3.min.js"></script>
<script src="${rootPath }js/bootstrap.js"></script>
<title>查看试题详情</title>
<style type="text/css">
.search {
	color: red;
	font-size: 1.4em;
}
</style>
</head>
<body>





<%@ include file="../head.jsp"%>
<!--以上为头部-->


<div sid="body">
 <div id="body-one">
   <p><img src="${rootPath}images/topimg.png"> <span>您的位置：
   <a href="${rootPath }secretary/pSForward_fIndex">首页</a>&nbsp;&nbsp;>&nbsp;&nbsp;
   党员管理&nbsp;&nbsp;>&nbsp;&nbsp;所属党员详细考试记录</span></p>
 </div>
 <div id="body-three">
     <div class="table-responsive">
    <table class="table table-bordered table-hover table-striped">
    <thead>
      <tr class="two">
         <th>试卷名称</th>
         <th>试题题干</th>
         <th>试题答案</th>
         <th>考生姓名</th>
         <th>考生答案</th>
         <th>考生得分</th>
       </tr>
      </thead>
      <tbody>
						<c:forEach var ="epr" items="${eprModels }">
						<tr>
							<td>${epr.testPaper.paperName }</td>
							<td>${epr.question.questions_stems }</td>
							<td>${epr.question.answer }</td>
							<td>${epr.personName }</td>
							<td>${epr.answer }</td>
							<td>${epr.examPerRecord.socre }</td>
						</tr>
					</c:forEach>
      </tbody>
    </table>
    <h3>${remind}</h3>
 </div>
 </div>
 </div>


<footer id="footer-warp"><!--页脚开始-->
		<p class="footer"><a href="">网站声明</a> &nbsp; &nbsp;<span>|</span> &nbsp; &nbsp;<a href="">关于我们 &nbsp; &nbsp;</a><span>|</span> &nbsp; &nbsp;<a href="">联系我们</a></p>
		<p>Copyright @ 2016 All rights reserved.　　版权所有：河南科技学院党委</p>
</footer><!--页脚结束-->	
</body>
</html>