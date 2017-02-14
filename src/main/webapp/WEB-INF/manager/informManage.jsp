<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通知管理</title>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css" />

</head>
<body>
<ol class="breadcrumb">
	 <li>当前位置：</li>
	<li>通知管理</li>
	<li class="active">管理通知</li>
</ol>
<h1>${remind }</h1>
	<table class="table table-bordered" style="width:80%;margin:100px auto 0 auto;">


		<tbody>
			<tr>
				<td>通知编号</td>
				<td>通知标题</td>
				<td>发布时间</td>
				<td>管理</td>
				<td>删除</td>
			</tr>
			<c:forEach var="inform" items="${pc.data }">
				<tr>
					<td>${inform.info_Id }</td>
					<td>${inform.title }</td>
					<td>${inform.sendDate }</td>
					<td><a href="${rootPath }manage/inform_change?inform.info_Id=${inform.info_Id}">管理</a></td>
					<td><a href="javascript:isdelete('${rootPath }manage/inform_delete?page=${pc.currentPage }&inform.info_Id=${inform.info_Id}')">删除</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<div id="pagecut" style="margin-right:100px;text-align:right;">
		<ul class="pagination">
			<li><a href="${rootPath }manage/inform?page=${pc.prePage}&search=${search }">上一页</a></li>
			<c:if test="${1 < pc.currentPage -3}">
				<li><a href="${rootPath }manage/inform">1</a></li>
			</c:if>
			
			<c:forEach var="i" begin="${pc.currentPage-3>0?pc.currentPage-3:1 }" end="${pc.currentPage+3>pc.pageNum?pc.pageNum:pc.currentPage+3  }">
				<c:choose>
					<c:when test="${i>0 && i == pc.currentPage }">
						<li class="active"><a href="${rootPath }manage/inform?page=${i }&search=${search }">${i}</a></li>
					</c:when>

					<c:when test="${i>0 && i != postPS.currentPage }">
						<li><a href="${rootPath }manage/inform?page=${i }&search=${search }">${i}</a></li>
					</c:when>
				</c:choose>
			</c:forEach>
			<li><a href="${rootPath }manage/inform?page=${pc.nextPage}&search=${search }">下一页</a></li>
		</ul>

	</div>
	<div class="background navbar-fixed-top"  style="position:absolute; z-index:-1;width:100%;height:100%;opacity:0.1;">
    	<img  class="img-responsive" width="100%;" src="${rootPath }images/577a4c594718d_610.jpg" />
    </div>

</body>
<script type="text/javascript">
	function isdelete(url){
		if(confirm("确定吗？")){
			window.location.href = url;
		}else{
			
		}
	}

</script>
</html>