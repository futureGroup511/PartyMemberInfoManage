<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通知管理</title>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css">
<link rel="stylesheet" href="${rootPath }css/partySecretary/red_tou.css">
<link rel="stylesheet" href="${rootPath }css/partySecretary/managementnotice.css">
<script src="${rootPath }js/jquery-2.2.3.min.js"></script>
<script src="${rootPath }js/bootstrap.js"></script>
</head>

<body>

<%@ include file="../head.jsp"%>

<!--以上为头部-->









<div id="body">
 <div id="body-one">
   <p><img src="${rootPath }images/topimg.png"> <span>您的位置：
   <a href="${rootPath }secretary/pSForward_fIndex">首页</a>&nbsp;&nbsp;>&nbsp;&nbsp;
   通知管理</span></p>
 </div>
 <div id="body-three">
     <div class="table-responsive">
     <c:if test="${empty pc.data }">
     	<h4>暂时无任何记录</h4>
     </c:if>
     <c:if test="${not empty pc.data }">
    <table class="table table-bordered table-hover table-striped">
    <thead>
      <tr class="two">
         <th>通知编号</th>
         <th>通知标题</th>
         <th>发布时间</th>
         <th>管理</th>
         <th>删除</th>
       </tr>
      </thead>
      <tbody>
			<c:forEach var="inform" items="${pc.data }">
				<tr>
					<td>${inform.info_Id }</td>
					<td>${inform.title }</td>
					<td>${inform.sendDate }</td>
					<td><a href="${rootPath }secretary/pSForward_fUpdateInform?inform.info_Id=${inform.info_Id}">管理</a></td>
					<td><a href="${rootPath }secretary/partySecretary_deleteInform?page=${pc.currentPage }&inform.info_Id=${inform.info_Id}">删除</a></td>
				</tr>
			</c:forEach>
      </tbody>
    </table>
    </c:if>
 </div>
 </div>
 </div>



<c:if test="${not empty pc.data }">
	<div id="pagecut" style="text-align:center;">
		<ul class="pagination">
			<li><a href="${rootPath }secretary/partySecretary_paperInform?page=${pc.prePage}">上一页</a></li>
			<c:if test="${1 < pc.currentPage -3}">
				<li><a href="${rootPath }secretary/partySecretary_paperInform?page=1">1</a></li>
			</c:if>
			
			<c:forEach var="i" begin="${pc.currentPage-3>0?pc.currentPage-3:1 }" end="${pc.currentPage+3>pc.pageNum?pc.pageNum:pc.currentPage+3  }">
				<c:choose>
					<c:when test="${i>0 && i == pc.currentPage }">
						<li class="active"><a href="${rootPath }secretary/partySecretary_paperInform?page=${i }">${i}</a></li>
					</c:when>

					<c:when test="${i>0 && i != postPS.currentPage }">
						<li><a href="${rootPath }secretary/partySecretary_paperInform?page=${i }">${i}</a></li>
					</c:when>
				</c:choose>
			</c:forEach>
			<li><a href="${rootPath }secretary/partySecretary_paperInform?page=${pc.nextPage}">下一页</a></li>
		</ul>

	</div>
	
</c:if>
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