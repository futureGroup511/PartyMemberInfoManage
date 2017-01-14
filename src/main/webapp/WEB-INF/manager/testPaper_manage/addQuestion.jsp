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
	
	 
	 <h3>添加试题</h3>
			<form action="${rootPath}manage/import_question" method="post">
				<label class="lable_1">所属试卷名称：</label>
				<select name="question.paperName">
				 	<c:forEach items="${testPaperNameList}" var="n">
				 		<option >${n.paperName}</option>
				 	</c:forEach>					
				</select>
				<br>
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
			    <input type="submit" value="添加">	
			    			
			</form>
			<h4>${questionMag }</h4>
</body>
</html>