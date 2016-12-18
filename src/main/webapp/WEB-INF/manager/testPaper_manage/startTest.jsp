<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${rootPath}manage/testManage_startTest" method="post">
		试卷名称：
		<select name="startTest.paperName">
			<c:forEach items="${testPaperNameList}" var="n">
			   <option >${n.paperName}</option>
			</c:forEach>
		</select>
		<br>
		开考时间：<input type="datetime-local" name="startTest.startTime"><br>
		结束时间：<input type="datetime-local" name="startTest.endTime"><br>
		<input type="reset" value="重  置">
		<input type="submit" value="开启考试">
	</form>
	<h3>${startMeg}</h3>
</body>
</html>