<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改个人信息</title>
</head>
<body>

	<form action="partySecretary_updataPerson"  method="post">
			<span>新手机号：</span><input type="text"  value="${secretary.phoneNo}"  name="partySecretaryInfo.phoneNo"><br>
			<span>旧密码：</span><input type="password"  name="oldPassword"><br>
			<span>新密码：</span><input type="password"   name="password1"><br>
			<span>请再输入一遍密码：</span><input type="password"   name="partySecretaryInfo.password"><br>
			<input type="submit"  value="确定">
	</form>


</body>
</html>