<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>红色视频</title>
</head>
<body>
  <c:forEach items="${videosList}" var="v">
  	  <div style="float:left;">
  	    <div>
  	    	<img  src="${rootPath}${v.imgUrl}" style="height:180px; width:120px;">
  	    </div>
  	  	<div><a href="${rootPath}/video_${v.rv_Id}.action" target="_blank">${v.name}</a> </div>	
  	  	<%-- <div>${v.watchNum}</div> --%>
  	  	<div>${v.description} </div>	
  	  </div> 			 		
  </c:forEach>
</body>
</html>