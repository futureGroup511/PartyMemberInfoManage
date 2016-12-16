<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${remind }</h2>
	<form class="form-horizontal" role="form" method="POST"
		action="${rootpath }manage/inform_changeDo">
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
					name="inform.content"></textarea>
			</div>
		</div>
		<div class="form-group">
			<label for="name">选择阅读权限</label> <select class="form-control">
				<option name="inform.info_tag" value="0">仅管理员</option>
				<option name="inform.info_tag" value="1">书记可看</option>
				<option name="inform.info_tag" value="2">党员可看</option>
				<option name="inform.info_tag" value="3">全体可看</option>
			</select>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">更改</button>
			</div>
		</div>
	</form>
</body>
</html>