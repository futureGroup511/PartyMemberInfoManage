<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	<tbody>
		<tr>
			<td>视频编号</td>
			<td>视频名字</td>
			<td>播放次数</td>
			<td>删除</td>
		</tr>
		<c:forEach var="video" items="${videoList }">
			
		</c:forEach>
	</tbody>
	</table>
</body>
</html>