<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="partyMemberAction_updatePartyMemberInfo.action"
			method="post">
			<table>
				<tr>
					<td>账号</td>
					<td>${partyMember.getAccount()}</td>
				</tr>
				<tr>
					<td>用户类别</td>
					<td>${partyMember.getSort()}</td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input type="text" name="partyMemberInfo.username"
						value="${partyMember.getUsername()}"></td>
				</tr>
				<tr>
					<c:choose>
						<c:when test="${partyMember.getSex()=='男'}">
							<td>性&nbsp;&nbsp;别：</td>
							<td><input type="radio" name="partyMemberInfo.sex" value='男' checked>男&nbsp; 
								<input type="radio" name="partyMemberInfo.sex" value='女'>女</td>
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
						value="${partyMember.getAge()}"></td>
				</tr>
				<tr>
					<td>民族</td>
					<td><input type="text" name="partyMemberInfo.nation"
						value="${partyMember.getNation()}"></td>
				</tr>
				<tr>
					<td>出生日期</td>
					<td><input type="datetime" name="partyMemberInfo.birthdate"
						value="${partyMember.getBirthdate()}"></td>
				</tr>
				<tr>
					<td>身份证号码</td>
					<td><input type="text" name="partyMemberInfo.idCard"
						value="${partyMember.getIdCard()}"></td>
				</tr>
				<tr>
					<td>籍贯</td>
					<td><input type="text" name="partyMemberInfo.nativePlace"
						value="${partyMember.getNativePlace()}"></td>
				</tr>
				<tr>
					<td>入党日期</td>
					<td>${partyMember.getJoinPartyDate()}</td>
				</tr>
				<tr>
					<td>职务</td>
					<td>${partyMember.getDuties()}</td>
				</tr>
				<tr>
					<td>介绍人</td>
					<td>${partyMember.getIntroducer()}</td>
				</tr>
				<tr>
					<td>所在党支部</td>
					<td>${partyMember.getPartyBranch()}</td>
				</tr>
				<tr>
					<td>学习时间</td>
					<td>${partyMember.getLearnTime()}</td>
				</tr>
				<tr>
					<td>手机号</td>
					<td><input type="tel" name="partyMemberInfo.phoneNo"
						value="${partyMember.getPhoneNo()}"></td>
				</tr>
				<tr>
					<td>注册时间</td>
					<td>${partyMember.getLoginDate()}</td>
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
					<td><input type="reset" value="重      置"> <input
						type="submit" value="确认修改"></td>
				</tr>
			</table>
			<label>${updateMsg}</label>
		</form>
	</div>
</body>
</html>