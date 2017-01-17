<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${rootPath}css/bootstrap.css">
<style>
.row{
width:100%;
margin-top:2%;
}
</style>
</head>
<body>
<ol class="breadcrumb">
	<li>试题管理</li>
	<li class="active">修改试题</li>
</ol>
	<h2 style="margin-left:5%;color:red;">${questionMag }</h2>
			<form action="${rootPath }manage/testManage_updateDo" method="post">
				<input type="hidden" name="question.qt_Id" value="${question.qt_Id }">
				<input type="hidden" name="question.paperName" value="${question.paperName }">
				<div class="row">
					<div class="col-lg-5 col-lg-offset-2 col-md-5 col-md-offset-2 col-xs-5 col-xs-offset-2">
						
						<label class="lable_1">所属试卷名称：${question.paperName}</label>
						
						
					</div>
					<div class="col-lg-5 col-md-5  col-xs-5 ">
						<label class="lable_1">题干：</label>
						<input required="required" type="text" style="width:40%;" name="question.questions_stems" value="${question.questions_stems }"> 
					</div>
				</div>
				<div class="row">
					<div class="col-lg-5 col-lg-offset-2 col-md-5 col-md-offset-2 col-xs-5 col-xs-offset-2">
						<label class="lable_1" style="margin-left:12%;">A选项：</label>
						<input required="required" style="width:40%;" type="text" name="question.a"  value="${question.a }">
					</div>
					<div class="col-lg-5 col-md-5  col-xs-5 ">
						<label style="margin-left:-2.5%;" class="lable_1">B选项：</label>
						<input required="required" style="width:40%;" type="text"name="question.b"  value="${question.b }">
					</div>
				</div>
				<div class="row">
					<div class="col-lg-5 col-lg-offset-2 col-md-5 col-md-offset-2 col-xs-5 col-xs-offset-2">
						<label class="lable_1" style="margin-left:12%;">C选项：</label>
						<input  style="width:40%;" type="text" name="question.c"  value="${question.c }">
					</div>
					<div class="col-lg-5 col-md-5  col-xs-5 ">
						<label style="margin-left:-2.5%;" class="lable_1">D选项：</label>
						<input style="width:40%;" type="text"name="question.d"  value="${question.d }">
					</div>
				</div><div class="row">
					<div class="col-lg-5 col-lg-offset-2 col-md-5 col-md-offset-2 col-xs-5 col-xs-offset-2">
						<label class="lable_1" style="margin-left:14%;">答案：</label>
						<select required="required"  style="width:40%;" type="text" name="question.answer"  value="${question.answer }">
							<c:if test="${question.answer == 'A' }">
								<option value="A" selected="selected">A</option>
								<option value="B">B</option>
								<option value="C">C</option>
								<option value="D">D</option>
							
							</c:if>
							
							<c:if test="${question.answer == 'B' }">
								<option value="A">A</option>
								<option value="B" selected="selected">B</option>
								<option value="C">C</option>
								<option value="D">D</option>
							
							</c:if>
							
							<c:if test="${question.answer == 'C' }">
								<option value="A" selected="selected">A</option>
								<option value="B">B</option>
								<option value="C" selected="selected">C</option>
								<option value="D">D</option>
							
							</c:if>
							
							<c:if test="${question.answer == 'D' }">
								<option value="A" selected="selected">A</option>
								<option value="B">B</option>
								<option value="C">C</option>
								<option value="D" selected="selected">D</option>
							
							</c:if>
							
						</select>
						
					</div>
					<div class="col-lg-5 col-md-5  col-xs-5 ">
						<label style="margin-left:-0.5%;" class="lable_1">解析：</label>
						<input style="width:40%;" type="text"name="question.analysis"  value="${question.analysis }">
					</div>
				</div>
				</div><div class="row">
					<div class="col-lg-5 col-lg-offset-2 col-md-5 col-md-offset-2 col-xs-5 col-xs-offset-2">
						<label class="lable_1" style="margin-left:14%;">分数：</label>
						<input required="required"  style="width:40%;" type="number" name="question.question_socre"  value="${question.question_socre }">
					</div>
					<div class="col-lg-5 col-md-5  col-xs-5 ">
						  <input type="reset" value="重置"  style="margin-left:11%;border-radius:0px;" class="btn btn-primary"> 
			    		  <input type="submit"  style="margin-left:14%;border-radius:0px;" value="添加" class="btn btn-primary">	
					</div>
				</div>
			</form>
			
</body>
</html>