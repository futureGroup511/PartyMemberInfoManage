<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传试卷</title>
<style type="text/css">
.content {
	margin-left: 20%;
	border: 2px solid orange;
	width: 50%;
	margin-top: 6%;
	padding-left: 10%;
}

.main input {
	margin-top: 3%;
}

.lable_1 {
	display: inline-block;
	width: 130px;
}
</style>
</head>
<body>
	<div class="content">
		<h3>根据Excel导入试卷</h3>
		<div class="main">
			<form action="${rootPath }manage/import_importTest" method="post" enctype="multipart/form-data">
				试卷：<input type="file" name="testPaper"
					accept="application/vnd.ms-excel, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
				<button type="submit">上传</button>
			</form>
			${reminder}
			
			<h3>上传试题</h3>
			<form action="${rootPath }manage/import_question" method="post">
				<label class="lable_1">所属试卷名称：</label>
				<input type="text" name="paperName"><br> 
				<label class="lable_1">题干：</label>
				<input type="text" name="question.questions_stems"><br> 
				<label class="lable_1">A选项：</label>
				<input type="text" name="question.a"><br>
				<label class="lable_1">B选项：</label>
				<input type="text"name="question.b"><br> 
				<label class="lable_1">C选项：</label>
				<input type="text" name="question.c"><br> 
				<label class="lable_1">D选项：</label>
				<input type="text" name="question.d"><br>
				<label class="lable_1">答案：</label>
				<input type="text"name="question.answer"><br> 
				<label class="lable_1">解析：</label>
				<input type="text" name="question.analysis"><br>
			    <label class="lable_1">分数：</label>
			    <input type="number" name="question_socre"><br>
			    <input type="reset" value="重置" style="margin-right: 250px;"> 
			    <input type="submit" value="上传">				
			</form>
		</div>
	</div>

</body>
</html>