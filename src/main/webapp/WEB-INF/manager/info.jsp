<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${rootPath }js/jquery-3.1.1.min.js"></script>
</head>
<body>

	<table>
		<tbody>
			<tr>
				<td>账号</td>
				<td>${user.account }</td>

			</tr>
			<tr>
				<td>身份</td>
				<td>${user.sort }</td>
			</tr>
			<tr>
				<td>用户名</td>
				<td><input placeholder="${user.username }"></td>
				<td><a href="${rootPath }manage/changeinfo?username=?">修改</a></td>
				
			</tr>
			<tr>
				<td>密码</td>
				<td><input placeholder="******"></td>
				<td><a href="${rootPath }manage/changeinfo?username=?">修改</a></td>
				
			</tr>
			<tr>
				<td>手机号</td>
				<td><input placeholder="${user.phoneNo}"></td>
				<td><a href="${rootPath }manage/changeinfo?username=?">修改</a></td>
				
			</tr>
			
			<tr>
				<td>年龄</td>
				<td><input placeholder="${user.age }"></td>
				<td><a href="${rootPath }manage/changeinfo?username=?">修改</a></td>
				
			</tr>
			<tr>
				<td>性别</td>
				<td><input placeholder="${user.sex}"></td>
				<td><a href="${rootPath }manage/changeinfo?username=?">修改</a></td>
			</tr>
			
		</tbody>
	</table>
</body>
<script type="text/javascript">
	
	
</script>
</html>