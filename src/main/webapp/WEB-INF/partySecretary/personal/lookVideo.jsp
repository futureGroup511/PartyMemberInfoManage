<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书记观看视频</title>
</head>
<body>
	${video.name }	
		<video id="videos"  width="320" height="240" controls onplay="startVideo()" >
		  <source src="/PartyMemberInfoManage/upload/video/2.mp4"  type="video/mp4">
		  您的浏览器不支持 HTML5 video 标签。
		</video>
		<!-- 两个隐藏的表单域 -->
		<input type="hidden" value="${video.rv_Id}" id="videoId" />
		<input type="hidden" value="${currentTime}" id="oldcurrentTime" />
		
		<section class="pre-next">
			<p><span>上一部：<a href="${rootPath }secretary/partySecretary_lookVideo?rv_Id=${prev.rv_Id}">${prev.name }</a></span>
			<span>下一部：<a href="${rootPath }secretary/partySecretary_lookVideo?rv_Id=${next.rv_Id}">${next.name}</a></span></p>
		</section>
</body>
<script type="text/javascript" src="${rootPath }js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${rootPath }js/partSecretary_learn_time.js"></script>
<script type="text/javascript">
	var notice = "${notice}";
	if(notice===""){
		
	}else{
		alert(notice);
	}
	
</script>
</html>