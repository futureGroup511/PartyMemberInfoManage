<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tbody>
			<tr>
				<td>账号</td>
				<td>姓名</td>
				<td>性别</td>
				<td>年龄</td>
				<td>民族</td>
				<td>出生日期：</td>
				<td>身份证号：</td>
				<td>籍贯：</td>
				<td>入党日期：</td>
				<td>在党职务：</td>
				<td>介绍人</td>
				<td>所属党支部：</td>
				<td>手机号</td>
				<td>注册时间</td>
				<td>管理</td>
				<td>删除</td>
			</tr>
			<c:forEach var="pm" items="${pc.data}">                                      
			<tr>
				<td>${pm.account }</td>
				<td>${pm.username }</td>
				<td>${pm.sex }</td>
				<td>${pm.age }</td>
				<td>${pm.nation }</td>
				<td>${pm.birthdate }</td>
				<td>${pm.idCard }</td>
				<td>${pm.nativePlace }</td>
				<td>${pm.joinPartyDate }</td>
				<td>${pm.duties }</td>
				<td>${pm.introducer }</td>
				<td>${pm.partyBranch}</td>
				<td>${pm.phoneNo }</td>
				<td>${pm.loginDate}</td>
				<td><a href="${rootPath }manage/partMember_update?id=${pm.ptm_Id}">管理</a></td>
				<td><a href="${rootPath }manage/partMember_delete?id=${pm.ptm_Id}">删除</a></td>
			</tr>
			</c:forEach>
			

		</tbody>
	</table>
</body>
</html>