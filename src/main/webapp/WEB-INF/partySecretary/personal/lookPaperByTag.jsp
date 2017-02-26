<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>阅读文章</title>
<link rel="stylesheet" href="${rootPath}css/bootstrap.css">
<link rel="stylesheet" href="${rootPath }css/partySecretary/red_tou.css">
<link rel="stylesheet" href="${rootPath}css/partySecretary/paper.css">
<script src="${rootPath }js/jquery-2.2.3.min.js"></script>
<script src="${rootPath }js/bootstrap.js"></script>
</head>

<body>

<%@ include file="../head.jsp"%>

<!--以上为头部-->

<div id="body">
 <div id="body-one">
   <p><img src="${rootPath}images/topimg.png"> <span>您的位置：
   <a href="${rootPath }secretary/pSForward_fIndex">首页</a>>
   <a href="${rootPath }secretary/pSForward_paperList">时事新闻</a>>
   正文</span></p>
 </div>
 <div id="body-two">
   <h4>${paper.title}</h4>
   <p>作者：${paper.author }&nbsp;&nbsp;&nbsp;&nbsp; 来源：${paper.source }&nbsp;&nbsp;&nbsp;&nbsp; 日期：2016-12-18&nbsp;&nbsp;&nbsp;&nbsp;日期：${paper.releaseDate }</p>
 </div>
 <div id="body-three">
 	${paper.content }
 </div>
</div>
<div id="body-four">
  <section class="pre-next">
				<p><span>上一篇：<a href="${rootPath }secretary/partySecretary_lookPaperByTag?rp_Id=${prev.rp_Id}&&search=${search}">${prev.title }</a></span>
				<span>下一篇：<a href="${rootPath }secretary/partySecretary_lookPaperByTag?rp_Id=${next.rp_Id}&&search=${search}">${next.title}</a></span></p>
  </section>
</div>
<footer id="footer-warp"><!--页脚开始-->
		<p class="footer"><a href="">网站声明</a> &nbsp; &nbsp;<span>|</span> &nbsp; &nbsp;<a href="">关于我们 &nbsp; &nbsp;</a><span>|</span> &nbsp; &nbsp;<a href="">联系我们</a></p>
		<p>Copyright @ 2016 All rights reserved.　　版权所有：河南科技学院党委</p>
</footer><!--页脚结束-->	

</body>
<script type="text/javascript">
	var notice = "${notice}";
	if(notice===""){
		
	}else{
		alert(notice);
	}
	
</script>
</html>