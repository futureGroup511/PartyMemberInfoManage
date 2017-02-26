<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css" />
<style>
*{
	padding:0;
	margin:0;
}
.background img{
	width:100%;
}
.row{
	width:100%;
	margin-top:18%;
}
h2{
	font-size:2.5vw;
	margin-left:10%;
	margin-right:10%;
	color:#D3111A;
	
}

</style>
</head>

<body>
	<div class="row">
    	<div class="col-lg-12  col-md-12  col-xs-12 ">
        	<h2><marquee behavior="scroll">欢迎登录河南科技学院信息工程学院星火在线功能后台系统</marquee></h2>
        </div>
    </div>
	<div class="background navbar-fixed-top"  style="position:absolute; z-index:-1;width:100%;opacity:0.3;">
    	<img  class="img-responsive" width="100%;" src="${rootPath }images/577a4c594718d_610.jpg"/>
    </div>
   
    <script type="text/javascript">
	$(function(){
		$('#background').height($(window).height());
		$('#background').width($(window).width());
	});
	</script>
</body>
</html>
