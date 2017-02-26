<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${rootPath }css/bootstrap.css">
<link rel="stylesheet" href="${rootPath }css/partySecretary/red_tou.css">
<link rel="stylesheet" href="${rootPath }css/partySecretary/table-one.css">
<script src="${rootPath }js/jquery-2.2.3.min.js"></script>
<script src="${rootPath }js/bootstrap.js"></script>
<title>考试记录</title>

<style type="text/css">
.search {
	color: red;
	font-size: 1.2em;
}
</style>

</head>
<body>


<%@ include file="../head.jsp"%>

<!--以上为头部-->

<div id="body">
 <div id="body-one">
   <p><img src="${rootPath }images/topimg.png"> 
   <span>您的位置：<a href="${rootPath }secretary/pSForward_fIndex">首页</a>&nbsp;&nbsp;>&nbsp;&nbsp;党员管理&nbsp;&nbsp;>&nbsp;&nbsp;考试记录</span></p>
 </div>
 <div id="body-two">
 <form action="${rootPath }secretary/test_startTestLog" method="post">
    <input type="text" name="search" class="form-control"
						 autocomplete="off"   placeholder="请输入考试名称"/>
     <button class="btn btn-primary sure" type="submit">搜索</button>
 </form>
 </div>
 <div id="body-three">
    <p>共找到 &nbsp; <span style="color: red;">${pc.count }</span> &nbsp; 条数据</p>
     <div class="table-responsive">
    <table class="table table-bordered table-hover table-striped">
    <thead>
      <tr class="two">
         <th>试卷名称</th>
         <th>开始时间</th>
         <th>结束时间</th>
         <th>考试时长</th>
         <th>查看参加此次考试的成员</th>
       </tr>
      </thead>
      <tbody>
			<c:forEach var="st" items="${pc.data }">
					<tr>
						<td>${st.paperName }</td>
						<td>${st.startTime }</td>
						<td>${st.endTime }</td>
						<td>${st.testTime }</td>		
						<td><a href="${rootPath }secretary/test_log?search=${st.paperName }&encode=1">查看参加此次考试的成员</a></td>				
					</tr>
				</c:forEach>
      </tbody>
    </table>
 </div>
 </div>
 </div>


		<div id="pagecut" style="margin-right: 100px; text-align: right;">
			<ul class="pagination">
				<li><a
					href="${rootPath }secretary/test_startTestLog?page=${pc.prePage}">上一页</a></li>
				<c:if test="${1 < pc.currentPage -3}">
					<li><a href="#">1</a></li>
				</c:if>

				<c:forEach var="i" begin="${pc.currentPage-3>0?pc.currentPage-3:1 }"
					end="${pc.currentPage+3>pc.pageNum?pc.pageNum:pc.currentPage+3  }">
					<c:choose>
						<c:when test="${i>0 && i == pc.currentPage }">
							<li class="active"><a
								href="${rootPath }secretary/test_startTestLog?page=${i }">${i}</a></li>
						</c:when>

						<c:when test="${i>0 && i != postPS.currentPage }">
							<li><a href="${rootPath }secretary/test_startTestLog?page=${i }">${i}</a></li>
						</c:when>
					</c:choose>
				</c:forEach>
				<li><a
					href="${rootPath }secretary/test_startTestLog?page=${pc.nextPage}">下一页</a></li>
			</ul>

		</div>
	
     <footer id="footer-warp"><!--页脚开始-->
		<p class="footer"><a href="">网站声明</a> &nbsp; &nbsp;<span>|</span> &nbsp; &nbsp;<a href="">关于我们 &nbsp; &nbsp;</a><span>|</span> &nbsp; &nbsp;<a href="">联系我们</a></p>
		<p>Copyright @ 2016 All rights reserved.　　版权所有：河南科技学院党委</p>
</footer><!--页脚结束-->	
</body>
</html>