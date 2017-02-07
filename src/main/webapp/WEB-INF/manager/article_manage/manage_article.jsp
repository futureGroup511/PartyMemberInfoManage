<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理文章</title>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css" />
<style type="text/css">
.search{
	font-size:1.2em;
	color:red;
}

</style>
</head>
<body>

	<ol class="breadcrumb">
	 <li>当前位置：</li>
	    <li>文章管理</li>
	    <li class="active">管理文章</li>
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
				
				<input type="text" name="search" class="form-control" value="${search }" placeholder="请输入文章标题搜索"> 
				 
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
	
	<table class="table table-bordered">

		<tbody>
			<tr>
				<td>文章标题</td>
				<td>作者</td>
				<td>来源</td>
				<td>版块</td>				
				<td>发布时间</td>
				<td>阅读次数</td>
				<td>文章状态</td>
				<td>详细内容/管理</td>
				<td>删除</td>
			</tr>
			<c:forEach var="paper" items="${pc.data }">
				<tr>
					<td>${paper.title }</td>
					<td>${paper.author }</td>
					<td>${paper.source }</td>
					<td>${paper.paperType}</td>					
					<td>${paper.releaseDate}</td>
					<td>${paper.readNum }</td>
					<td>${paper.strTag}</td>
					<td><a href="${rootPath }manage/fPaper_fUpdatePaper?rp_Id=${paper.rp_Id}"  target="main">详细内容/管理</a></td>
					<td onClick="que_ren(${paper.rp_Id})">删除</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<div id="pagecut" style="margin-right:100px;text-align:right;">
		<ul class="pagination">
			<li><a href="${rootPath }manage/managePaper_paper?page=${pc.prePage}?&search=${search }">上一页</a></li>
			<c:if test="${1 < pc.currentPage -3}">
				<li><a href="${rootPath }manage/managePaper_paper?search=${search }">1</a></li>
			</c:if>
			
			<c:forEach var="i" begin="${pc.currentPage-3>0?pc.currentPage-3:1 }" end="${pc.currentPage+3>pc.pageNum?pc.pageNum:pc.currentPage+3  }">
				<c:choose>
					<c:when test="${i>0 && i == pc.currentPage }">
						<li class="active"><a href="${rootPath }manage/managePaper_paper?page=${i }&search=${search }">${i}</a></li>
					</c:when>

					<c:when test="${i>0 && i != postPS.currentPage }">
						<li><a href="${rootPath }manage/managePaper_paper?page=${i }&search=${search }">${i}</a></li>
					</c:when>
				</c:choose>
			</c:forEach>
			<li><a href="${rootPath }manage/managePaper_paper?page=${pc.nextPage}&search=${search }">下一页</a></li>
		</ul>
	</div>
	<div class="background navbar-fixed-top"  style="position:absolute; z-index:-1;width:100%;height:100%;opacity:0.1;">
    	<img  class="img-responsive" width="100%;" src="${rootPath }images/577a4c594718d_610.jpg" />
    </div>
    </div>  <!-- end container -->
</body>
<script type="text/javascript">
		var tag="${dTag}";
		if(tag===""){
			
		}else{
			alert(tag)
		}
		function que_ren(str,str1){
				if(confirm("确认删除")){
					location.href="managePaper_deletePaper?rp_Id="+str;
				}
		}

</script>
</html>