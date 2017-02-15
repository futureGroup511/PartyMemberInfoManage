<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>试题修改</title>
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
 <li>当前位置：</li>
	<li>试题管理</li>
	<li class="active">修改试题</li>
</ol>

	<div class="container">
		<form action="${rootPath }manage/testManage_updateDo" method="post">
			<div class="row">
				<h2>${questionMag }</h2>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<input class="form-control" type="hidden" name="question.qt_Id" value="${question.qt_Id }">
				</div>
				
				<div class="col-xs-12">
					<input class="form-control" type="hidden" name="question.paperName" value="${question.paperName }">
				</div>
				
			</div>
			
			<div class="row">
				<div class="col-xs-2">
					<label>&nbsp;&nbsp;题干：</label>
				</div>
				<div class="col-xs-10">
					<input class="form-control" required="required" type="text" name="question.questions_stems" value="${question.questions_stems }">
				</div>
			</div>
			
			<div class="row">
				<div class="col-xs-2">
					<label>A选项：</label>
				</div>
				<div class="col-xs-10">
					<input class="form-control" required="required" type="text" name="question.a"  value="${question.a }">
				</div>
			</div>
			
			<div class="row">
				<div class="col-xs-2">
					<label>B选项：</label>
				</div>
				<div class="col-xs-10">
					<input class="form-control" required="required" type="text" name="question.b"  value="${question.b }">
				</div>
			</div>
			
			<div class="row">
				<div class="col-xs-2">
					<label>C选项：</label>
				</div>
				<div class="col-xs-10">
					<input class="form-control" required="required" type="text"name="question.c"  value="${question.c }">
				</div>
			</div>
			
			<div class="row">
				<div class="col-xs-2">
					<label class="lable_1">D选项：</label>
				</div>
				<div class="col-xs-10">
					<input class="form-control" required="required" type="text" name="question.d"  value="${question.d }">
				</div>
			</div>
			<div class="row">
				<div class="col-xs-2">
					<label class="lable_1">答案：</label>
				</div>
				<div class="col-xs-10">
					<select class="form-control" required="required" name="question.answer"  value="${question.answer }">
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
			
			</div>
			
			<div class="row">
				<div class="col-xs-2">
					<label>解析：</label>
				</div>
				<div class="col-xs-10">
					<textarea class="form-control" name="question.analysis"  value="${question.analysis }"></textarea>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
				
					<input type="reset" value="重置"  style="margin-left:11%;border-radius:0px;" class="btn btn-primary"> 
			    	<input type="submit"  style="margin-left:14%;border-radius:0px;" value="添加" class="btn btn-primary">	
			    	
				</div>
			</div>
		</form>
	</div>
	
				
				
					<%-- 
					<div class="col-lg-5 col-lg-offset-2 col-md-5 col-md-offset-2 col-xs-5 col-xs-offset-2">
						<label class="lable_1" style="margin-left:14%;">分数：</label>
						<input required="required"  style="width:40%;" type="number" name="question.question_socre"  value="${question.question_socre }">
					</div>
					 --%>
				
<div class="background navbar-fixed-top"  style="position:absolute; z-index:-1;width:100%;height:100%;opacity:0.1;">
    	<img  class="img-responsive" width="100%;" src="${rootPath }images/577a4c594718d_610.jpg" />
</div>			
</body>
</html>