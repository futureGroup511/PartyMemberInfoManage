<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css" />
</head>
<body>
<ol class="breadcrumb">
	<li>党员管理</li>
	<li class="active">修改党员信息</li>
</ol>
  <div class="content">
	<form class="form-horizontal" role="form" method="post"
			action="${rootPath }manage/partMember_updateDo">
			
			<h1>${remind }</h1>
			<input type="hidden" name="partyMemberInfo.ptm_Id" value="${partyMemberInfo.ptm_Id }">
			<table>
			
				<tr>
					<td>账号</td>
					<td><input type="text" name="partyMemberInfo.account" value="${partyMemberInfo.account }"></td>
					<td>密码</td>
					<td><input type="password" name="partyMemberInfo.password" value="${partyMemberInfo.password }"></td>
				</tr>
				<tr>
					<td>身份证号码</td>
					<td><input type="text" name="partyMemberInfo.idCard" value="${partyMemberInfo.idCard }"></td>
					<td>手机号</td>
					<td><input type="tel" name="partyMemberInfo.phoneNo" value="${partyMemberInfo.phoneNo }"></td>
				</tr>
				<tr>
				
					<td>姓名</td>
					<td><input type="text" name="partyMemberInfo.username" value="${partyMemberInfo.username }"></td>
					<td>介绍人</td>
					<td><input type="text" name="partyMemberInfo.introducer" value="${partyMemberInfo.introducer }"></td>
				</tr>

				<tr>

					<td>民族</td>
					<td><input type="text" name="partyMemberInfo.nation" value="${ partyMemberInfo.nation}"></td>
					<td>籍贯</td>
					<td><input type="text" name="partyMemberInfo.nativePlace" value="${partyMemberInfo.nativePlace }"></td>

				</tr>
				
				<tr>
					
					<td>所在党支部</td>
					<td><input type="text" name="partyMemberInfo.partyBranch" value="${partyMemberInfo.partyBranch }"></td>
					<td>职务</td>
					<td><input type="text" name="partyMemberInfo.duties" value="${partyMemberInfo.duties }"></td>

				</tr>
				<tr>
					
					<td>入党日期</td>
					<td><input type="text" name="joinPartyDate" value="${ partyMemberInfo.joinPartyDate}"></td>
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