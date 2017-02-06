<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${rootPath }css/bootstrap.css">
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
						<li><a href="${rootPath}secretary/partySecretary_logout">退出登陆</a></li>
                   </ul>
               </li>
              <li><a href="${rootPath}secretary/partySecretary_connectUs">联系我们</a></li>
         </ul>
     </div>
</div>

<!--以上为头部-->

<div id="body">
 <div id="body-one">
   <p><img src="${rootPath }images/topimg.png"> <span>您的位置：首页&nbsp;&nbsp;>&nbsp;&nbsp;时事新闻&nbsp;&nbsp;>&nbsp;&nbsp;党建巡礼</span></p>
 </div>
 <div id="body-two">
 <form action="${rootPath }secretary/test_startTestLog" method="post">
    <input type="text" name="search" class="form-control"
						value="${search }" autocomplete="off"   placeholder="请输入考试名称"/>
     <button class="btn btn-primary sure" type="button">搜索</button>
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
	

</body>
</html>