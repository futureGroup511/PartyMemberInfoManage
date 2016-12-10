<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${rootPath }css/bootstrap.css" />
<title>Insert title here</title>
</head>
<body>
	<h1>${remind }</h1>

	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<table class="table table-striped table-bordered table-hover">
					<tbody>
						<tr>
							<td>视频编号</td>
							<td>视频名字</td>
							<td>播放次数</td>
							<td>删除</td>
						</tr>
						<c:forEach var="video" items="${videoList }">
							<tr>
								<td>${video.rv_Id }</td>
								<td>${video.name }</td>
								<td>${video.watchNum }</td>
								<td><a href="manageVideo_delete?id=${video.rv_Id }">删除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>

</body>
</html>