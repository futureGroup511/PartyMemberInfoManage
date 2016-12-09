<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${remind }</h1>
	<form action="partMember_updateDo" method="post">
		<input type="hidden" name="partMemberInfo.ptm_Id" value="${id }">
		<span>新手机号：</span>
		<input type="text" value="${secretary.phoneNo}" name="partMemberInfo.phoneNo"><br>
		<span>新密码：</span>
		<input type="password" name="partMemberInfo.password"><br>
		<span>请再输入一遍密码：</span>
		<input type="password" ><br>
		<input type="submit" value="确定">
	</form>
</body>
</html>