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
	
	 

	 <h3 style="margin-left:5%;">添加试题</h3>
			<form action="${rootPath }manage/import_question" method="post">
				<div class="row">
					<div class="col-lg-5 col-lg-offset-2 col-md-5 col-md-offset-2 col-xs-5 col-xs-offset-2">
						<label class="lable_1">所属试卷名称：</label>
						<select style="width:40%;height:25px;" name="question.paperName">
						 	<c:forEach items="${testPaperNameList}" var="n">
						 		<option >${n.paperName}</option>
						 	</c:forEach>
							
						</select>
					</div>
					<div class="col-lg-5 col-md-5  col-xs-5 ">
						<label class="lable_1">题干：</label>
						<input type="text" style="width:40%;" name="question.questions_stems"> 
					</div>
				</div>
				<div class="row">
					<div class="col-lg-5 col-lg-offset-2 col-md-5 col-md-offset-2 col-xs-5 col-xs-offset-2">
						<label class="lable_1" style="margin-left:12%;">A选项：</label>
						<input  style="width:40%;" type="text" name="question.a">
					</div>
					<div class="col-lg-5 col-md-5  col-xs-5 ">
						<label style="margin-left:-2.5%;" class="lable_1">B选项：</label>
						<input style="width:40%;" type="text"name="question.b">
					</div>
				</div>
				<div class="row">
					<div class="col-lg-5 col-lg-offset-2 col-md-5 col-md-offset-2 col-xs-5 col-xs-offset-2">
						<label class="lable_1" style="margin-left:12%;">C选项：</label>
						<input  style="width:40%;" type="text" name="question.c">
					</div>
					<div class="col-lg-5 col-md-5  col-xs-5 ">
						<label style="margin-left:-2.5%;" class="lable_1">D选项：</label>
						<input style="width:40%;" type="text"name="question.d">
					</div>
				</div><div class="row">
					<div class="col-lg-5 col-lg-offset-2 col-md-5 col-md-offset-2 col-xs-5 col-xs-offset-2">
						<label class="lable_1" style="margin-left:14%;">答案：</label>
						<input  style="width:40%;" type="text" name="question.answer">
					</div>
					<div class="col-lg-5 col-md-5  col-xs-5 ">
						<label style="margin-left:-0.5%;" class="lable_1">解析：</label>
						<input style="width:40%;" type="text"name="question.analysis">
					</div>
				</div>
				</div><div class="row">
					<div class="col-lg-5 col-lg-offset-2 col-md-5 col-md-offset-2 col-xs-5 col-xs-offset-2">
						<label class="lable_1" style="margin-left:14%;">分数：</label>
						<input  style="width:40%;" type="text" name="question_socre">
					</div>
					<div class="col-lg-5 col-md-5  col-xs-5 ">
						  <input type="reset" value="重置"  style="margin-left:11%;border-radius:0px;" class="btn btn-primary"> 
			    		  <input type="submit"  style="margin-left:14%;border-radius:0px;" value="添加" class="btn btn-primary">	
					</div>
				</div>

			</form>
			<h4>${questionMag }</h4>


	
</body>
</html>