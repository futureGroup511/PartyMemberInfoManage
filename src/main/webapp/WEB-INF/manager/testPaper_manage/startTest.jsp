<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${rootPath}css/bootstrap.css">
<style type="text/css">
.row{
width:100%;
margin-top:2%;
}
</style>
</head>
<body>
	<form action="${rootPath}manage/testManage_startTest" method="post">
		<div class="row">
					<div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-xs-8 col-xs-offset-2">
						<label class="lable_1">试卷名称：</label>
						<select style="width:60%;height:25px;" name="startTest.paperName">
							<c:forEach items="${testPaperNameList}" var="n">
							   <option >${n.paperName}</option>
							</c:forEach>
						</select>
					</div>
	    </div>
	    <div class="row">
					<div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-xs-8 col-xs-offset-2">
						<label class="lable_1">开考时间：</label>
						<input  style="width:60%;height:25px;"  type="datetime-local" name="startTest.startTime">
					</div>
	    </div>
	    <div class="row">
					<div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-xs-8 col-xs-offset-2">
						<label class="lable_1">结束时间：</label>
						<input   style="width:60%;height:25px;" type="datetime-local" name="startTest.endTime">
					</div>
	    </div>
	     <div class="row" style="margin-top:5%;">
					<div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-xs-8 col-xs-offset-2">
						<input style="margin-left:18%;" type="reset" value="重  置">
						<input  style="margin-left:18%;"  type="submit" value="开启考试">
					</div>
	    </div>
		
	</form>
	<h3>${startMeg}</h3>
</body>
</html>