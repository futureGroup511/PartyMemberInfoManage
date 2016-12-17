<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传试卷</title>
</head>
<body>
    <h3>根据Excel导入试卷</h3>
	<form action="${rootPath }manage/import_importTest" method="post" enctype="multipart/form-data">

         试卷：<input type="file" name="testPaper"  accept="application/vnd.ms-excel, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" >       
        <button type="submit" >上传</button> 
	</form>
	${reminder}
	
	<h3>上传试题</h3>
	<form action="${rootPath }manage/import_question" method="post">
		<!-- private int  qt_Id;//试题id 具有唯一性
	private int paperId;//试卷id  用来标志 试题是否属于一套试卷
	private String questions_stems;//题干
	private String answer;//答案
	private String analysis;//解析
	private int question_socre;//该试题的分数 -->
		所属试卷名称：<input type="text" name="paperName"><br>
		题干：<input type="text" name="question.questions_stems" ><br>
		A选项：<input type="text" name="question.A" ><br>
		B选项：<input type="text" name="question.B" ><br>
		C选项：<input type="text" name="question.C" ><br>
		D选项：<input type="text" name="question.D" ><br>		
		答案：<input type="text" name="question.answer" ><br>
		解析：<input type="text" name="question.analysis" ><br>
		分数：<input type="number" name="question.question_socre" ><br>
		<input type="reset" value="重置">
		<input type="submit" value="上传">
	</form>
</body>
</html>