<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书记观看视频</title>
</head>
<body>
		<video width="320" height="240" controls onplay="startVideo()" >
		  <source src="/PartyMemberInfoManage/upload/video/1.mp4"  type="video/mp4">
		  您的浏览器不支持 HTML5 video 标签。
		</video>
		
		<section class="pre-next">
			<p><span>上一部：<a href="${rootPath }secretary/partySecretary_lookVideo?rv_Id=${prev.rp_Id}">${v.name }</a></span>
			<span>下一部：<a href="${rootPath }secretary/partySecretary_lookVideo?rv_Id=${next.rp_Id}">${v.name}</a></span></p>
		</section>
</body>
</html>