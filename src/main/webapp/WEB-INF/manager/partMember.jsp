<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="${rootPath }css/bootstrap.css" />
<link href="${rootPath }jQueryPlug/jPage/src/jquery.page.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${rootPath }jQueryPlug/jPage/src/jquery.min.js"></script>
<script type="text/javascript"
	src="${rootPath }jQueryPlug/jPage/src/jquery.page.js"></script>
<title>Insert title here</title>
<style type="text/css">

.container {
	margin: 0 auto;
}

#pageCut a:hover {
	text-decoration: none;
}

#pageCut {
	text-align: right;
}
</style>

</head>
<body>
<ol class="breadcrumb">
	<li>党员管理</li>
	<li class="active">党员管理</li>
</ol>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<table class="table table-striped table-bordered table-hover">
					<tbody>
						<tr>
							<td>账号</td>
							<td>姓名</td>
							<td>性别</td>
							<td>年龄</td>
							<td>民族</td>
							<td>出生日期：</td>
							<td>身份证号：</td>
							<td>籍贯：</td>
							<td>入党日期：</td>
							<td>在党职务：</td>
							<td>介绍人</td>
							<td>所属党支部：</td>
							<td>手机号</td>
							<td>注册时间</td>
							<td>管理</td>
							<td>删除</td>


						</tr>
						<c:forEach var="pm" items="${pc.data}">
							<tr>
								<td>${pm.account }</td>
								<td>${pm.username }</td>
								<td>${pm.sex }</td>
								<td>${pm.age }</td>
								<td>${pm.nation }</td>
								<td>${pm.birthdate }</td>
								<td>${pm.idCard }</td>
								<td>${pm.nativePlace }</td>
								<td>${pm.joinPartyDate }</td>
								<td>${pm.duties }</td>
								<td>${pm.introducer }</td>
								<td>${pm.partyBranch}</td>
								<td>${pm.phoneNo }</td>
								<td>${pm.loginDate}</td>
								<td><a
									href="${rootPath }manage/partMember_update?id=${pm.ptm_Id}">管理</a></td>
								<td><a
									href="${rootPath }manage/partMember_delete?id=${pm.ptm_Id}">删除</a></td>
							</tr>
						</c:forEach>


					</tbody>
				</table>
				<div id="pagecut" style="margin-right: 100px; text-align: right;">
					<ul class="pagination">
						<li><a
							href="${rootPath }manage/partMember?page=${pc.prePage}">上一页</a></li>
						<c:if test="${1 < pc.currentPage -3}">
							<li><a href="#">1</a></li>
						</c:if>

						<c:forEach var="i"
							begin="${pc.currentPage-3>0?pc.currentPage-3:1 }"
							end="${pc.currentPage+3>pc.pageNum?pc.pageNum:pc.currentPage+3  }">
							<c:choose>
								<c:when test="${i>0 && i == pc.currentPage }">
									<li class="active"><a
										href="${rootPath }manage/partMember?page=${i }">${i}</a></li>
								</c:when>

								<c:when test="${i>0 && i != postPS.currentPage }">
									<li><a href="${rootPath }manage/partMember?page=${i }">${i}</a></li>
								</c:when>
							</c:choose>
						</c:forEach>
						<li><a
							href="${rootPath }manage/partMember?page=${pc.nextPage}">下一页</a></li>
					</ul>

				</div>
			</div>
		</div>
	</div>

</body>



<script type="text/javascript">
	
</script>
</html>