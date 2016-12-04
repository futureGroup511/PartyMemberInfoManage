<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看所属党员信息</title>
</head>
<body>
		<table>
			<thead>
				<tr>
					<td>姓名</td>
					<td>年龄</td>
					<td>性别</td>
					<td>民族</td>
					<td>籍贯</td>
					<td>手机号</td>
					<td>注册日期</td>
					<td>出生日期</td>
					<td>身份证号</td>
					<td>入党日期</td>
					<td>在党职务</td>
					<td>所属党支部</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${PMIlist}" var="pmi">
				  <tr>
						<td>${secretary.username}</td>
						<td>${secretary.age}</td>
						<td>${secretary.sex}</td>
						<td>${secretary.nation}</td>
						<td>${secretary.nativePlace}</td>
						<td>${secretary.phoneNo}</td>
						<td>${secretary.loginDate}</td>
						<td>${secretary.birthdate}</td>
						<td>${secretary.idCard}</td>
						<td>${secretary.joinPartyDate}</td>
						<td>${secretary.duties}</td>
						<td>${secretary.partyBranch}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>