<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${rootPath }css/bootstrap.css" />
<link rel="stylesheet" href="${rootPath }css/manage/button.css">
<title>Insert title here</title>
<style type="text/css">
.content {
	background-image: url("${rootPath }images/star.png");
}
</style>
</head>
<body>
<ol class="breadcrumb">
	<li>书记管理</li>
	<li class="active">增加书记</li>
</ol>
	<div class="content">
		<form class="form-horizontal" role="form" method="post"
			action="${rootPath }manage/partSecretary_addDo">
			<h1>${remind }</h1>
			<table>
				<tr>
					<td>账号</td>
					<td><input type="text" name="partySecretaryInfo.account" value="${partySecretaryInfo.account }"></td>
					<td>密码</td>
					<td><input type="password" name="partySecretaryInfo.password" value="${partySecretaryInfo.password  }"></td>
				</tr>
				<tr>
					<td>身份证号码</td>
					<td><input type="text" name="partySecretaryInfo.idCard" value="${partySecretaryInfo.idCard }"></td>
					<td>手机号</td>
					<td><input type="tel" name="partySecretaryInfo.phoneNo" value="${partySecretaryInfo.phoneNo }"></td>
				</tr>
				<tr>
				
					<td>姓名</td>
					<td><input type="text" name="partySecretaryInfo.username" value="${partySecretaryInfo.username }"></td>
				</tr>

				<tr>

					<td>民族</td>
					<td><input type="text" name="partySecretaryInfo.nation" value="${partySecretaryInfo.nation }"></td>
					<td>籍贯</td>
					<td><input type="text" name="partySecretaryInfo.nativePlace" value="${partySecretaryInfo.nativePlace }"></td>

				</tr>
				
				<tr>
					
					<td>所在党支部</td>
					<td><input type="text" name="partySecretaryInfo.partyBranch" value="${partySecretaryInfo.partyBranch }"></td>
					<td>职务</td>
					<td><input type="text" name="partySecretaryInfo.duties" value="${partySecretaryInfo.duties }"></td>

				</tr>
				<tr>
					
					<td>入党日期</td>
					<td><input type="text" name="joinPartyDate" value="${dateStr }"></td>
					<td><label>修改日期请填写数字：如20160101</label></td>

				</tr>
				<tr>
					<td class="button-one"><input type="reset" value="重置"></td>
					<td class="button-two"><input type="submit" value="确认修改"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>