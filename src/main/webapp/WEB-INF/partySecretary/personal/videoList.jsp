<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>红色视频列表</title>
</head>
<body>
	<c:forEach items="${videosList}" var="v" varStatus="status">
		<c:choose>
			<c:when test="${(status.index)%4==0}">
			<div style="clear: both;"></div>			
				<div style="width: 150px;float: left;">
					<div>
						<img src="${rootPath}${v.imgUrl}"
							style="height: 180px; width: 120px;">
					</div>
					<div style="height:25px;">
						<a href="${rootPath }secretary/partySecretary_lookVideo?rv_Id=${v.rv_Id}">${v.name }</a>
					</div>
					
				</div>
			</c:when>
			<c:otherwise>
				
				<div style="float: left; width: 150px;">
					<div>
						<img src="${rootPath}${v.imgUrl}"
							style="height: 180px; width: 120px;">
					</div>
					<div>
						<a href="${rootPath }secretary/partySecretary_lookVideo?rv_Id=${v.rv_Id}">${v.name }</a>
					</div>
					
				</div>
			</c:otherwise>
		</c:choose>

	</c:forEach>
</body>
</html>