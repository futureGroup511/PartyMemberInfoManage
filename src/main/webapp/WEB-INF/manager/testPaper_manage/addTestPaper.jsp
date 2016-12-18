<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${rootPath}/manage/import_addTestPaper" method="post">
		<table>
			<tr>
				<td>试卷名称</td>
				<td><input type="text" name="testPap.paperName"></td>
			</tr>
			<tr>
				<td>试卷的说明</td>
				<td><input type="text" name="testPap.description"></td>
			</tr>			
		</table>
		<input type="reset" value="重置">
		<input type="submit" value="添加">
		<h3>${testPapMeg }</h3>
	</form>
	
</body>
</html>