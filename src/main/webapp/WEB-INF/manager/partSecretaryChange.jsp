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
	<form class="form-horizontal" role="form" method="post"
		action="${rootPath }manage/partSecretary_addDo">
		<h1>${remind }</h1>
		<table>
			<tr>
				<td>账号</td>
				<td>${ partyMember.account}</td>
			</tr>
			<tr>
				<td>用户类别</td>
				<td><input type="text" name="partyMember.sort" value="${partyMember.sort }"></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="partySecretaryInfo.username" value="${partySecretaryInfo.username }"></td>
			</tr>
			<tr>
				<c:choose>
					<c:when test="${partySecretaryInfo.sex=='男'}">
						<td>性&nbsp;&nbsp;别：</td>
						<td><input type="radio" name="partySecretaryInfo.sex"
							value='男' checked>男&nbsp; <input type="radio"
							name="partySecretaryInfo.sex" value='女'>女</td>
					</c:when>
					<c:otherwise>
						<td>性&nbsp;&nbsp;别：</td>
						<td><input type="radio" name="partySecretaryInfo.sex"
							value='男'>男&nbsp; <input type="radio"
							name="partySecretaryInfo.sex" value='女' checked>女</td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input type="number" name="partySecretaryInfo.age" value="${partySecretaryInfo.age }"></td>
			</tr>
			<tr>
				<td>民族</td>
				<td><input type="text" name="partySecretaryInfo.nation" value="${partySecretaryInfo.nation }"></td>
			</tr>

			<tr>
				<td>身份证号码</td>
				<td><input type="text" name="partySecretaryInfo.idCard" value="${partySecretaryInfo.idCard}"></td>
			</tr>
			<tr>
				<td>籍贯</td>
				<td><input type="text" name="partySecretaryInfo.nativePlace" value="${partySecretaryInfo.nativePlace }"></td>
			</tr>
			<tr>
				<td>职务</td>
				<td><input type="text" name="partySecretaryInfo.duties" value="${partySecretaryInfo.duties }"></td>
			</tr>
			<tr>
				<td>介绍人</td>
				<td><input type="text" name="partySecretaryInfo.introducer" value="${partySecretaryInfo.introducer }"></td>
			</tr>
			<tr>
				<td>所在党支部</td>
				<td><input type="text" name="partySecretaryInfo.partyBranch" value="${partySecretaryInfo.partyBranch }"></td>
			</tr>
			<tr>
				<td>手机号</td>
				<td><input type="tel" name="partySecretaryInfo.phoneNo" value="${ partySecretaryInfo.phoneNo}"></td>
			</tr>

			<tr>
				<td>密码</td>
				<td><input type="password" name="partySecretaryInfo.password"
					value="${partySecretaryInfo.password }"></td>
			</tr>
			<tr>
				<td><input type="submit" value="确认修改"></td>
			</tr>
		</table>

	</form>
</body>
</html>