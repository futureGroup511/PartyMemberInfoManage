<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看所属党员信息</title>
<link href="${rootPath }jQueryPlug/jPage/src/jquery.page.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${rootPath }jQueryPlug/jPage/src/jquery.min.js"></script>
<script type="text/javascript" src="${rootPath }jQueryPlug/jPage/src/jquery.page.js"></script>
</head>
<body>
		<input type="text"  name="pm_name"  ><button>搜索</button>
		<table>
			<thead>
				<tr>
					<td>姓名</td>
					<td>年龄</td>
					<td>性别</td>
					<td>民族</td>
					<td>籍贯</td>
					<td>手机号</td>
					<td>学习时长</td>
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
						<td>${pmi.username}</td>
						<td>${pmi.age}</td>
						<td>${pmi.sex}</td>
						<td>${pmi.nation}</td>
						<td>${pmi.nativePlace}</td>
						<td>${pmi.phoneNo}</td>
						<td>${pmi.strLearnTime}</td>
						<td>${pmi.loginDate}</td>
						<td>${pmi.birthdate}</td>
						<td>${pmi.idCard}</td>
						<td>${pmi.joinPartyDate}</td>
						<td>${pmi.duties}</td>
						<td>${pmi.partyBranch}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
</body>
</html>