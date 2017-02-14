<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${rootPath }css/bootstrap.css" />
<title>视频管理</title>
<style type="text/css">
.search{
	color:red;
	font-size:1.4em;
}

</style>
</head>
<body>
<ol class="breadcrumb">
	 <li>当前位置：</li>
	<li>视频管理</li>
	<li class="active">视频管理</li>
</ol>
	

	<div class="container">
	
		<div class="row">
			<div class="col-xs-12">
				<span style="font-size:1.4em;color:red;">${remind }</span>
			</div>
		</div>
	
		<div class="row" style="margin-bottom:30px;">
			<form action="" method="post">
			<div class="col-xs-6">
				
				<input type="text" name="search" class="form-control" value="${search }" placeholder="请输入视频名字搜索"> 
				 
			</div>
			<div class="col-xs-6">
				<button type="submit" class="btn btn-success">搜索</button>
			</div>
			</form>	
		</div>
		
		<div class="row">
			<div class="col-xs-12">
				共找到 &nbsp; <span style="color:red;">${pc.count }</span> &nbsp; 条数据
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<table class="table table-striped table-bordered table-hover">
					<tbody>
						<tr>
							<td>视频编号</td>
							<td>视频名字</td>
							<td>播放次数</td>
							<td>删除</td>
						</tr>
						<c:forEach var="video" items="${pc.data }">
							<tr>
								<td>${video.rv_Id }</td>
								<td>${video.name }</td>
								<td>${video.watchNum }</td>
								<td><a href="javascript:isdelete('manageVideo_delete?id=${video.rv_Id }')">删除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<div id="pagecut" style="margin-right: 100px; text-align: right;">
			<ul class="pagination">
				<li><a
					href="${rootPath }manage/manageVideo?page=${pc.prePage}&search=${search }">上一页</a></li>
				<c:if test="${1 < pc.currentPage -3}">
					<li><a href="#">1</a></li>
				</c:if>

				<c:forEach var="i" begin="${pc.currentPage-3>0?pc.currentPage-3:1 }"
					end="${pc.currentPage+3>pc.pageNum?pc.pageNum:pc.currentPage+3  }">
					<c:choose>
						<c:when test="${i>0 && i == pc.currentPage }">
							<li class="active"><a
								href="${rootPath }manage/manageVideo?page=${i }&search=${search }">${i}</a></li>
						</c:when>

						<c:when test="${i>0 && i != postPS.currentPage }">
							<li><a href="${rootPath }manage/manageVideo?page=${i }&search=${search }">${i}</a></li>
						</c:when>
					</c:choose>
				</c:forEach>
				<li><a
					href="${rootPath }manage/manageVideo?page=${pc.nextPage}&search=${search }">下一页</a></li>
			</ul>

		</div>
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