<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
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
				<td>${partyMember.getUsername()}</td>
			</tr>						
			<tr>
				<td>性别</td>
				<td>${partyMember.getSex()}</td>
			</tr>
			<tr>
				<td>年龄</td>
				<td>${partyMember.getAge()}</td>
			</tr>
			<tr>
				<td>民族</td>
				<td>${partyMember.getNation()}</td>
			</tr>
			<tr>
				<td>出生日期</td>
				<td>${partyMember.getBirthdate()}</td>
			</tr>
			<tr>
				<td>身份证号码</td>
				<td>${partyMember.getIdCard()}</td>
			</tr>
			<tr>
				<td>籍贯</td>
				<td>${partyMember.getNativePlace()}</td>
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
				<td>${partyMember.getPhoneNo()}</td>
			</tr>
			<tr>
				<td>注册时间</td>
				<td>${partyMember.getLoginDate()}</td>
			</tr>
		</table>
	</div>
</body>
</html>