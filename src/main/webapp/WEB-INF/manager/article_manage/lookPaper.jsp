<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看文章</title>
<style type="text/css">

</style>
</head>
<body>
<div class="dangqian">
	<div class="row">
    	<div class="col-lg-3 col-lg-offset-1 col-md-3 col-md-offset-1 col-xs-4 col-xs-offset-1">
        	<h3><img src="images/t012af2de4c0f6db4db.png" />&nbsp;&nbsp;&nbsp;你的位置：首页>时事新闻</h3>
        </div>
    </div>
</div>
<ol class="breadcrumb">
	    <li>当前位置：</li>
	    <li>文章</li>
	    <li class="active">添加文章</li>
	</ol>
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
</body>
</html>