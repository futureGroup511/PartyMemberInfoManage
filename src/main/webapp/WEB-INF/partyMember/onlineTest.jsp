<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线测试</title>
</head>
<body>
	<c:choose>
		<c:when test="${NoTest!=null}">
			<h4>${NoTest}</h4>
		</c:when>
		<c:otherwise>
			<div>
				<form action="${rootPath}party/partyMemberAction_getExamRecord.action">
					<h3>${startTest.paperName}(${startTest.testTime})</h3>
					<c:forEach items="${questionsList}" var="q" varStatus="status">
						<div>${status.index+1}.${q.questions_stems} (分数:${q.question_socre})</div>
						<div>
							<ul style="list-style-type: none;list-style-position: outside;">						
								<li><input type="radio" name="answer${status.index}" value="A${q.qt_Id}" >A:${q.a}</li>
								<li><input type="radio" name="answer${status.index}" value="B${q.qt_Id}">B:${q.b}</li>
								<li><input type="radio" name="answer${status.index}" value="C${q.qt_Id}">C:${q.c}</li>
								<li><input type="radio" name="answer${status.index}" value="D${q.qt_Id}">D:${q.d}</li>
							</ul> 						 	
						</div>
																					
					</c:forEach>					
					<input type="submit" value="提交">
				</form>
			</div>
		</c:otherwise>
	</c:choose>
	${addExamLogMsg}
</body>
</html>