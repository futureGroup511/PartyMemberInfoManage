<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加首页轮播图</title>

<script type="text/javascript"
	src="${rootPath }jQueryPlug/jPage/src/jquery.min.js"></script>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css" />

<style>
* {
	margin: 0;
	padding: 0;
}

#container {
	position: absolute;
	height: 100%;
	width: 100%;
	z-index: -1;
}

#output {
	width: 100%;
	height: 100%;
}

.color {
	width: 120px;
	height: 20px;
	margin: 0 auto;
	position: fixed;
	left: 50%;
	margin-left: -60px;
	bottom: 20px;
}

.color li {
	float: left;
	margin: 0 5px;
	width: 20px;
	height: 20px;
	background: #ccc;
	box-shadow: 0 0 4px #FFF;
	list-style: none;
	cursor: pointer;
}

.color li:nth-child(1) {
	background: #002c4a;
}

.color li:nth-child(2) {
	background: #35ac03;
}

.color li:nth-child(3) {
	background: #ac0908;
}

.color li:nth-child(4) {
	background: #18bbff;
}
.control-label{
	color:#FFF;
}
</style>

</head>
<body>
<ol class="breadcrumb">
 	<li>当前位置：</li>
	<li>首页轮播图</li>
	<li class="active">添加</li>
</ol>
	<div id="container">
		<div id="output"></div>
	</div>
	<div style="width: 80%; margin: 0 auto;padding:100px;">
		
		<form class="form-horizontal" role="form" method="POST"
			action="${rootPath }manage/indexImage_addDo" enctype="multipart/form-data">
			<div class="form-group">
				<h2>${remind }</h2>
				<div class="col-sm-10">
					<input type="file" class="form-control"
						name="img" accept="image/png,image/jpeg">
				</div>
			</div>
			<div class="form-group">
				
				<div class="col-sm-10">
					<textarea type="text" class="form-control"
						name="url" placeholder="网址"></textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">增加</button>
				</div>
			</div>
		</form>
	</div>
	<div class="background navbar-fixed-top"  style="position:absolute; z-index:-1;width:100%;height:100%;opacity:0.1;">
    	<img  class="img-responsive" width="100%;" src="${rootPath }images/577a4c594718d_610.jpg" />
    </div>
</body>
</html>