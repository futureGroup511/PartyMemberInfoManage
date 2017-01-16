<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
	<form action="login.action">
		账号：<input type="text" name="userInfo.account"><br> 
		密码：<input type="text" name="userInfo.password"><br> 
		<input type="button" value="注 册" width="120px"><br>
		<input type="submit" value="登  录" width="120px">
	</form>
	<h4>${loginMeg}</h4>
</body>
</html>