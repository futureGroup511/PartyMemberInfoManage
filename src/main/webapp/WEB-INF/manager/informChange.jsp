<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改通知</title>
<script type="text/javascript"
	src="${rootPath }jQueryPlug/jPage/src/jquery.min.js"></script>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css" />
</head>
<body>
	<ol class="breadcrumb">
		<li>当前位置：</li>
		<li>通知管理</li>
		<li class="active">修改通知</li>
	</ol>
	<h2>${remind }</h2>

	<form class="form-horizontal" role="form" method="POST"
		action="${rootpath }manage/inform_changeDo"
		style="width: 80%; margin: 100px auto 0 auto;">
		<input type="hidden" name="inform.info_Id" value="${inform.info_Id }">
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">标题</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="firstname"
					name="inform.title" value="${inform.title }">
			</div>
		</div>
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">内容</label>
			<div class="col-sm-10">
				<textarea type="text" class="form-control" id="lastname"
					name="inform.content">${inform.content }</textarea>
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">选择阅读权限</label>
			<div class="col-sm-10">
				<select class="form-control" name="inform.info_tag"
					value="${inform.info_tag }">
					<c:if test="${inform.info_tag ==0 }">
						<option name="inform.info_tag" value="0" selected="selected">仅管理员</option>
						<option name="inform.info_tag" value="1">书记可看</option>
						<option name="inform.info_tag" value="2">党员可看</option>
						<option name="inform.info_tag" value="3">全体可看</option>
					</c:if>

					<c:if test="${inform.info_tag ==1 }">
						<option name="inform.info_tag" value="0">仅管理员</option>
						<option name="inform.info_tag" value="1" selected="selected">书记可看</option>
						<option name="inform.info_tag" value="2">党员可看</option>
						<option name="inform.info_tag" value="3">全体可看</option>
					</c:if>

					<c:if test="${inform.info_tag ==2 }">
						<option name="inform.info_tag" value="0">仅管理员</option>
						<option name="inform.info_tag" value="1">书记可看</option>
						<option name="inform.info_tag" value="2" selected="selected">党员可看</option>
						<option name="inform.info_tag" value="3">全体可看</option>
					</c:if>

					<c:if test="${inform.info_tag ==3 }">
						<option name="inform.info_tag" value="0">仅管理员</option>
						<option name="inform.info_tag" value="1">书记可看</option>
						<option name="inform.info_tag" value="2">党员可看</option>
						<option name="inform.info_tag" value="3" selected="selected">全体可看</option>
					</c:if>

				</select>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">更改</button>
			</div>
		</div>
	</form>
	<div class="background navbar-fixed-top"
		style="position: absolute; z-index: -1; width: 100%; height: 100%; opacity: 0.1;">
		<img class="img-responsive" width="100%;"
			src="${rootPath }images/577a4c594718d_610.jpg" />
	</div>
</body>
</html>