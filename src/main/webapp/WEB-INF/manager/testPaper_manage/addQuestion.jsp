<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加问题</title>
<link rel="stylesheet" href="${rootPath}css/bootstrap.css">
<style>
.row {
	width: 100%;
	margin-top: 2%;
}
</style>
</head>
<body>
	<ol class="breadcrumb">
		<li>当前位置：</li>
		<li>试题管理</li>
		<li class="active">增加试题</li>
	</ol>

	<h3 style="margin-left: 5%;">添加试题</h3>
	<h2 style="margin-left: 5%; color: red;">${questionMag }</h2>

	<form action="${rootPath }manage/import_question" class="form-horizontal" role="form" style="margin-right:50px;">
		<%-- 
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">所属试卷名称：</label>
			<div class="col-sm-6">
				<select class="form-control" name="question.paperName">
					<c:forEach items="${testPaperNameList}" var="n">
						<option>${n.paperName}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		 --%>
		<input type="hidden" name="question.paperName" value="默认">
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">题干：</label>
			<div class="col-sm-10">
				<textarea required="required" rows="3" class="form-control" type="text" name="question.questions_stems"></textarea>
			</div>
		</div>
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">A选项：</label>
			<div class="col-sm-10">
				<input
					required="required" class="form-control" type="text"
					name="question.a">
			</div>
		</div>
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">B选项：</label>
			<div class="col-sm-10">
				<input required="required" class="form-control" type="text" name="question.b">
			</div>
		</div>
		
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">C选项：</label>
			<div class="col-sm-10">
				<input required="required" class="form-control" type="text" name="question.c">
			</div>
		</div>
		
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">D选项：</label>
			<div class="col-sm-10">
				<input required="required" class="form-control" type="text" name="question.d">
			</div>
		</div>
		
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">答案：</label>
			<div class="col-sm-4">
				<select class="form-control" required="required" name="question.answer">
					<option value="A">A</option>
					<option value="B">B</option>
					<option value="C">C</option>
					<option value="D">D</option>
				</select>
			</div>
		</div>
		<!-- 
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">分数：</label>
			<div class="col-sm-4">
				<input required="required" class="form-control" type="number"
					name="question.question_socre">
			</div>
		</div>
		 -->
		 <input type="hidden" value="5" name="question.question_socre">
		
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">解析：</label>
			<div class="col-sm-10">
				<textarea class="form-control" rows="3" name="question.analysis"></textarea>
			</div>
			
		</div>
		
		<div class="form-group">
			
			<div class="col-sm-offset-2 col-sm-2">
				<button style="width:100%;" type="reset" class="btn btn-default">重置</button>
			</div>
			
			<div class="col-sm-6">
				<button style="width:100%;" type="submit" class="btn btn-success">提交</button>
			</div>
			
		</div>
	</form>

	<div class="background navbar-fixed-top"
		style="position: absolute; z-index: -1; width: 100%; height: 100%; opacity: 0.1;">
		<img class="img-responsive" width="100%;"
			src="${rootPath }images/577a4c594718d_610.jpg" />
	</div>
</body>
</html>