<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<script type="text/javascript" src="${rootPath }js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css" />
<style type="text/css">
.remind {
	color: red;
	font-size: 1.4em;
}
</style>
</head>
<body>
	<ol class="breadcrumb">
		<li>当前位置：</li>
		<li>个人中心</li>
		<li class="active">个人信息</li>
	</ol>
	<div class="content">

		<span class="remind">${remind }</span>

		<form class="form-horizontal" role="form" method="POST"
			action="${rootPath}manage/change_info" onsubmit="return md5()">
			<%-- 
			<input type="hidden" name="user.account" value="${user.account }">
			<input type="hidden" name="user.id" value="${user.id }">
			 --%>
			<div class="form-group">
				<label class="col-sm-2 control-label">账号</label>
				<div class="col-sm-10">
					<p class="form-control-static">${user.account }</p>
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">身份</label>
				<div class="col-sm-10">
					<p class="form-control-static">管理员</p>
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">用户名：</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="user.username"
						value="${user.username}" placeholder="请输入姓">
				</div>
			</div>

			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">密码：</label>
				<div class="col-sm-10">
					<input id="password-in" type="password" class="form-control"
						value="" name="user.password" placeholder="输入密码修改,8-16位，不输入或者位数不对则不修改。">
				</div>
			</div>

			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">手机号：</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="user.phoneNo"
						value="${user.phoneNo}" placeholder="请输入姓">
				</div>
			</div>

			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">年龄：</label>
				<div class="col-sm-10">
					<input type="number" required="required" class="form-control"
						name="user.age" value="${user.age}">
				</div>
			</div>

			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">性别：</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="user.sex"
						value="${user.sex}" placeholder="请输入姓">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">修改</button>
				</div>
			</div>
		</form>

	</div>
	<div class="background navbar-fixed-top"
		style="position: absolute; z-index: -1; width: 100%; height: 100%; opacity: 0.1;">
		<img class="img-responsive" width="100%;"
			src="${rootPath }images/577a4c594718d_610.jpg" />
	</div>
</body>
<script src="${rootPath }js/sha1.js"></script>
<script type="text/javascript">
	function md5() {
		
		if($('#password-in').val().length<8){
			return true;
		}
		
		var sha = hex_sha1($('#password-in').val());
		$('#password-in').val(sha);
		return true;
	}
</script>
</html>