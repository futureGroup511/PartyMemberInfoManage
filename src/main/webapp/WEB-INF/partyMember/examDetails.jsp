<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考试记录详情</title>
</head>
<body>
	<div>
		<h4>试卷名称：${examLog.paperName }</h4>
		<div>
			试卷题数：${examLog.testNum }试卷总分：${examLog.testTotalScore}你的得分：${examLog.totalScore}
		</div>
		<c:forEach items="${questionsList}" var="q" varStatus="status">
		<span>${status.index+1}.${q.questions_stems} (分值:${q.question_socre}) 得分：${q.myScore}</span>
		<div>
			<c:choose>
				<c:when test="${q.myAnswer!=null}">
					
					A:${q.a}<br>
					B:${q.b}<br>
					C:${q.c}<br>
					D:${q.d}<br>
					<div>你的答案：${q.myAnswer} <img src="${rootPath}images/cross.gif" style="height: 20px;width: 20px;"></div>					
					<div>正确答案${q.answer}</div>
					<div>解析：${q.analysis}</div>
				</c:when>
				<c:otherwise>
					A:${q.a}<br>
					B:${q.b}<br>
					C:${q.c}<br>
					D:${q.d}<br>
					<div>你的答案：${q.answer} <img src="${rootPath}images/complete.gif" style="height: 20px;width: 20px;"></div>									
					<div>解析：${q.analysis}</div>
				</c:otherwise>
			</c:choose>		
		</div>
		</c:forEach>
	</div>
	
</body>
</html>