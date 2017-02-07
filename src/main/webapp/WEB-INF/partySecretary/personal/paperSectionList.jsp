<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${paper.paperType}</title>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css">
<link rel="stylesheet" href="${rootPath }css/partySecretary/the party.css">
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
   <p><img src="${rootPath }images/topimg.png"> <span>您的位置：
   <a href="${rootPath }secretary/pSForward_fIndex">首页</a>&nbsp;&nbsp;>&nbsp;&nbsp;
   <a href="${rootPath }secretary/pSForward_paperList">时事新闻</a>&nbsp;&nbsp;>&nbsp;&nbsp;
   ${paper.paperType }</span></p>
 </div>
 <div id="body-two">
 		<c:forEach items="${pc.data }"  var="paper">
		 	<p><a href="${rootPath }secretary/partySecretary_lookPaper?rp_Id=${paper.rp_Id}">
		 	${paper.title }<span>${ paper.releaseDate}</span></a></p>
		</c:forEach>
 </div>
</div>

	
	
		<div id="pagecut" style="margin-right:100px;text-align:right;">
		<ul class="pagination">
			<li><a href="${rootPath }secretary/partySecretary_paperSection?page=${pc.prePage}&&paperTypeId=${paper.paperTypeId}">上一页</a></li>
			<c:if test="${1 < pc.currentPage -3}">
				<li><a href="${rootPath }secretary/partySecretary_paperSection?page=1&&paperTypeId=${paper.paperTypeId}">1</a></li>
			</c:if>
			
			<c:forEach var="i" begin="${pc.currentPage-3>0?pc.currentPage-3:1 }" end="${pc.currentPage+3>pc.pageNum?pc.pageNum:pc.currentPage+3  }">
				<c:choose>
					<c:when test="${i>0 && i == pc.currentPage }">
						<li class="active"><a href="${rootPath }secretary/partySecretary_paperSection?page=${i }&&paperTypeId=${paper.paperTypeId}">${i}</a></li>
					</c:when>

					<c:when test="${i>0 && i != postPS.currentPage }">
						<li><a href="${rootPath }secretary/partySecretary_paperSection?page=${i }&&paperTypeId=${paper.paperTypeId}">${i}</a></li>
					</c:when>
				</c:choose>
			</c:forEach>
			<li><a href="${rootPath }secretary/partySecretary_paperSection?page=${pc.nextPage}&&paperTypeId=${paper.paperTypeId}">下一页</a></li>
		</ul>

	</div>
	
	
<footer id="footer-warp"><!--页脚开始-->
		<p class="footer"><a href="">网站声明</a> &nbsp; &nbsp;<span>|</span> &nbsp; &nbsp;<a href="">关于我们 &nbsp; &nbsp;</a><span>|</span> &nbsp; &nbsp;<a href="">联系我们</a></p>
		<p>Copyright @ 2016 All rights reserved.　　版权所有：河南科技学院党委</p>
</footer><!--页脚结束-->	
<script type="text/javascript">
	var notice = "${notice}";
	if(notice===""){
		
	}else{
		alert(notice);
	}
	
</script>
</body>
</html>