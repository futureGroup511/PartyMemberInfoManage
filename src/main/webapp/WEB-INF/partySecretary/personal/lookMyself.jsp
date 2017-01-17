<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
</head>
<body>
	<div>
		<div>
				<span>姓名：</span><span>${secretary.username}</span><br>
				<span>性别：</span><span>${secretary.sex}</span><br>
				<span>年龄：</span><span>${secretary.age}</span><br>
				<span>民族：</span><span>${secretary.nation}</span><br>
				<span>籍贯：</span><span>${secretary.nativePlace}</span><br>
				<span>手机号：</span><span id="phone">${secretary.phoneNo}</span><input type="button"  value="修改" onclick="updatePhone()"><br>
				<span>学习时长：</span><span>${secretary.strLearnTime }</span>
				<span>注册日期：</span><span>${secretary.loginDate}</span><br>
				<span>出生日期：</span><span>${secretary.birthdate}</span><br>
				<span>身份证号：</span><span>${secretary.idCard}</span><br>
				<span>入党日期：</span><span>${secretary.joinPartyDate}</span><br>
				<span>在党职务：</span><span>${secretary.duties}</span><br>
				<span>所属党支部：</span><span>${secretary.partyBranch}</span><br>
		</div>
	</div>
</body>
<script type="text/javascript" src="${rootPath }js/updatePhone.js"></script>
<script type="text/javascript">
	var notice = "${notice}";
	if(notice===""){
		
	}else{
		alert(notice);
	}
	
</script>
</html>