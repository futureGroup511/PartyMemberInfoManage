<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${rootPath}css/bootstrap.css">
<title>试题管理</title>
<style type="text/css">
.search{
	color:red;
	font-size:1.4em;
}
td{
	text-align:center;
	vertical-align:bottom;
}
</style>
</head>
<body>

	<ol class="breadcrumb">
	 <li>当前位置：</li>
		<li>考试管理</li>
		<li class="active">管理试题</li>
	</ol>


	<div class="table-responsive">
		<div class="container">
			<div class="row" style="margin-bottom: 30px;">
				<form action="" method="get"> <!-- 方法必须为get -->
					<div class="col-xs-6">

						<input type="text" name="search" class="form-control"
							value="${search }"
							placeholder="请输入问题题干搜索">

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
				<div class="col-xs-12">
					<table class="table table-bordered table-hover" >
						<tr>
							<!-- 
							<td>所属试卷名称</td>
							 -->
							<td>题干</td>
							<td>答案</td>
							<td>解析</td>
							<td>分数</td>
							<td>A</td>
							<td>B</td>
							<td>C</td>
							<td>D</td>
							<td>修改</td>
							<td>删除</td>
						</tr>
						<c:forEach items="${pc.data}" var="q">
							<tr>
								<%-- 
								<td>${q.paperName}</td>
								 --%>
								<td>${q.questions_stems}</td>
								<td>${q.answer}</td>
								<td>${q.analysis}</td>
								<td>${q.question_socre}</td>
								<td>${q.a}</td>
								<td>${q.b}</td>
								<td>${q.c}</td>
								<td>${q.d}</td>
								<td><a href="${rootPath }manage/testManage_update?id=${q.qt_Id}">修改</a></td>
								<td><a
									href="javascript:isdelete(${q.qt_Id})">刪除</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>

			</div>

		</div>

	</div>



	<div class="table-responsive"></div>
	<div style="margin-left: 42%;">
		<ul class="pagination">
			<li><a
				href="${rootPath }manage/testManage_manageQuestion?page=${pc.prePage}&search=${search }">上一页</a></li>
			<li><a href="#">${pc.currentPage}/${pc.pageNum}</a></li>
			<li><a
				href="${rootPath }manage/testManage_manageQuestion?page=${pc.nextPage}&search=${search }">下一页</a></li>
		</ul>
	</div>
	<h3>${delectQtMsg}</h3>
<div class="background navbar-fixed-top"  style="position:absolute; z-index:-1;width:100%;height:100%;opacity:0.1;">
    	<img  class="img-responsive" width="100%;" src="${rootPath }images/577a4c594718d_610.jpg" />
</div>
<script type="text/javascript">
	function isdelete(id){
		if(confirm("确定吗？")){
			window.location.href = 'manage/testManage_deleteQuestion?id='+id;
		}else{
			
		}
	}

</script>
	
</body>
</html>