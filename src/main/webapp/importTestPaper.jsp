<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>向数据库导入一套试卷  excel</title>
</head>
<body>
${reminder}
	<form action="${rootPath }manage/importTest" method="post" enctype="multipart/form-data">

         试卷：<input type="file" name="testPaper"  accept="application/vnd.ms-excel, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" >       
        <button type="submit" >确定</button> 
	</form>
</body>
</html>