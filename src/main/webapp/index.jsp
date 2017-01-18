<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" href="/PartyMemberInfoManage/css/bootstrap.css">
<link rel="stylesheet" href="/PartyMemberInfoManage/css/denglu.css" />
</head>

<body>
<div class="container">
<div class="beijing"  style="position:absolute; z-index:-1;">
    	<img  class="img-responsive" width="100%;" src="images/denglubeijingyi.png">
</div>
<div class="title">
	<p>河南科技学院党员在线</p>
</div>
<form role="form"  action="login.action"  method="POST">
<!--用户名一栏-->
<div class="row">
 <div class="col-lg-4 col-lg-offset-4 col-md-8 col-md-offset-2 col-xs-8 col-xs-offset-2">
  <div class="row">
  <div class="form-group">
  	<div class="col-lg-3  col-md-3 col-xs-3">
    <label for="inputEmail3" class="control-label">账号:</label>
    </div>
    <div class="col-lg-8  col-md-8 col-xs-8">
      <input  type="text"  name="userInfo.account" class="form-control" id="inputEmail3">
    </div>
    </div>
  </div>
 </div>
</div>
<!--密码一栏-->
<div class="row">
 <div class="col-lg-4 col-lg-offset-4 col-md-8 col-md-offset-2 col-xs-8 col-xs-offset-2">
  <div class="row">
  <div class="form-group">
  	<div class="col-lg-3  col-md-3 col-xs-3">
    <label for="inputEmail3" class="control-label">密码:</label>
    </div>
    <div class="col-lg-8  col-md-8 col-xs-8">
      <input  type="password"   name="userInfo.password" class="form-control" id="inputEmail3" >
    </div>
    </div>
  </div>
 </div>
</div>
<!--验证码一栏-->
<div class="row">
 <div class="col-lg-4 col-lg-offset-4 col-md-8 col-md-offset-2 col-xs-8 col-xs-offset-2">
  <div class="row">
  <div class="form-group">
  	<div class="col-lg-3 col-md-3 col-xs-3">
    <label for="inputEmail3" class="control-label">验证码:</label>
    </div>
    <div class="col-lg-4 col-md-4 col-xs-4">
      <input  type="text" class="form-control" id="inputEmail3"  name="randStr"  placeholder="请输入验证码">
      <a href="javascript:void(0)"onclick="refresh()">
      <img alt="点击刷新" src="${rootPath }validation" id="yan" /></a> 
    </div>
    </div>
  </div>
 </div>
</div>
  <button type="submit" class="btn btn-default">登录</button>
</form>
<h4>${loginMeg}</h4>
</div>
<script type="text/javascript">
$(function(){
    $('#beijing').height($(window).height());
    $('#beijing').width($(window).width());
});
</script>
<script type="text/javascript">
	function refresh() {
		document.getElementById("yan").src = "${rootPath}validation?s="
				+ new Date();
	}
</script>
</body>
</html>


