<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${rootPath }css/bootstrap.css" />
<title>Insert title here</title>
</head>
<body>
	<form class="form-horizontal" role="form" method="post"
		action="${rootPath }manage/partMember_addDo">
		<h1>${remind }</h1>
		<table>
			<tr>
				<td>账号</td>
				<td><input type="text" name="partyMember.account"></td>
			</tr>
			<tr>
				<td>用户类别</td>
				<td>
				<input type="text" name="partyMember.sort">
				<input type="hidden"
					name="partyMemberInfo.ptm_Id" value="${partyMemberInfo.ptm_Id }">
				</td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="partyMemberInfo.username"
					value="${partyMember.username}"></td>
			</tr>
			<tr>
				<c:choose>
					<c:when test="${partyMember.sex=='男'}">
						<td>性&nbsp;&nbsp;别：</td>
						<td><input type="radio" name="partyMemberInfo.sex" value='男'
							checked>男&nbsp; <input type="radio"
							name="partyMemberInfo.sex" value='女'>女</td>
					</c:when>
					<c:otherwise>
						<td>性&nbsp;&nbsp;别：</td>
						<td><input type="radio" name="partyMemberInfo.sex" value='男'>男&nbsp;
							<input type="radio" name="partyMemberInfo.sex" value='女' checked>女</td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input type="number" name="partyMemberInfo.age"
					value="${partyMember.age}"></td>
			</tr>
			<tr>
				<td>民族</td>
				<td><input type="text" name="partyMemberInfo.nation"
					value="${partyMember.nation}"></td>
			</tr>

			<tr>
				<td>身份证号码</td>
				<td><input type="text" name="partyMemberInfo.idCard"
					value="${partyMember.idCard}"></td>
			</tr>
			<tr>
				<td>籍贯</td>
				<td><input type="text" name="partyMemberInfo.nativePlace"
					></td>
			</tr>
			<tr>
				<td>职务</td>
				<td><input type="text" name="partyMemberInfo.duties"></td>
			</tr>
			<tr>
				<td>介绍人</td>
				<td><input type="text" name="partyMemberInfo.introducer"></td>
			</tr>
			<tr>
				<td>所在党支部</td>
				<td><input type="text" name="partyMemberInfo.partyBranch"></td>
			</tr>
			<tr>
				<td>手机号</td>
				<td><input type="tel" name="partyMemberInfo.phoneNo"
					value="${partyMember.phoneNo}"></td>
			</tr>
			<tr>
				<td>新密码</td>
				<td><input type="password" value="******"></td>
			</tr>
			<tr>
				<td>确认新密码</td>
				<td><input type="password" name="partyMemberInfo.password"
					value="******"></td>
			</tr>
			<tr>
				<td><input type="submit" value="确认修改"></td>
			</tr>
		</table>

	</form>
</body>
</html>