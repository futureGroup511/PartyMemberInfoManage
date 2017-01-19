<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>阅读文章</title>
</head>
<body>
		<section class="paper">
				<header class="title">
					${paper.title }
				</header>
				<div class="jieshou">
					<span>作者：${paper.author }</span>
					<span>来源：${paper.source }</span>
					<span>日期：${paper.releaseDate }</span>
					<span>点击：${paper.readNum}</span>
				</div>
				<div class="main-body">
					${paper.content }
				</div>
			</section>
			<span></span></li>
			<section class="pre-next">
				<p><span>上一篇：<a href="${rootPath }party/partyMemberAction_lookPaper?rp_Id=${prev.rp_Id}">${prev.title }</a></span>
				<span>下一篇：<a href="${rootPath }party/partyMemberAction_lookPaper?rp_Id=${next.rp_Id}">${next.title}</a></span></p>
			</section>
</body>
<script type="text/javascript">
	var notice = "${notice}";
	if(notice===""){
		
	}else{
		alert(notice);
	}
	
</script>
</html>