<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>后台首页</title>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css">
<link rel="stylesheet" href="${rootPath }css/index.css">

</head>

<body>
	<div class="container">
		<div class="header">
			<img src="${rootPath }images/header-logo.png">
			<p style="margin-left:80px;">河南科技学院信息工程学院星火在线功能后台系统</p>
		</div>
		<div class="body">
			<div class="box">
				<form class="form-inline"
					action="${rootPath }manage/index_loginDo" method="POST" onsubmit="return md5()">
					<h2>${remind }</h2>
					<div class="input-one">
						<label for="account">账号</label> <input type="text" name="account"
							class="form-control" placeholder="请输入账号">
					</div>
					<div class="input-two">
						<label for="password">密码</label> 
						<input id="password-in" type="password" name="password"
							class="form-control" placeholder="请输入密码">
					</div>
					<div class="input-three" class="form-control">
						<label>验证码</label>
						
						<input type="text" class="form-control" name="randStr" placeholder="请输入验证码"> 

						<a href="javascript:void(0)"
							onclick="refresh()"><img style="margin-top:-12px;" alt="点击刷新" src="${rootPath }validation"
							id="yan" /></a> <span id="code_error">环境异常</span>
					</div>

					<div class="input-four">
						<button class="btn  btn-primary one" type="submit" target="_top">登录</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script src="${rootPath }js/jquery-2.2.3.min.js"></script>
	<script src="${rootPath }js/bootstrap.js"></script>
	<script src="${rootPath }js/sha1.js"></script>
	
</body>
<script type="text/javascript">
	function refresh() {
		document.getElementById("yan").src = "${rootPath}validation?s="
				+ new Date();
	}
	
	function md5(){
		
		var sha = hex_sha1($('#password-in').val());
		$('#password-in').val(sha);
		return true;
	}

</script>
</html>