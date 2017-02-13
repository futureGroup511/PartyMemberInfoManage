<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<!--手机端页面必须在meta里面加这一行-->
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>党员登录界面</title>
		<link href="${rootPath }css/mui.min.css" rel="stylesheet" />
		<script src="${rootPath }js/mui.min.js"></script>
		<script src="${rootPath }js/sha1.js"></script>
		<script type="text/javascript" charset="utf-8">
			mui.init();
		</script>
		<style>
			.tou{
				opacity: 0.8;
			}
			.mui-content{
				background: rgba(252,252,252,0.8);
				box-shadow: 2px 1px 1px #AAAAAA;
				margin: 150px 15px;
			}
			.mui-bar-nav ~ .mui-content{
				padding-top: 0;
			}
			.mui-input-group{
				background: rgba(252,252,252,0);
				padding: 10px;
			}
			.mui-input-row label{
			    width:30%;
			}
			#yanzheng{
				width: 45%!important;
				float: left;
			}
			.mui-input-row .yanzhengma{
				width: 25%;
				float: right;
				display: block;
				
			}
			.anniu{
				margin-top: 30px;
			}
			.anniu button{
				width: 100px;
			}
		</style>
	</head>

	<body background="${rootPath }images/beijing.png" >
		<header class="mui-bar mui-bar-nav tou">
			<!--后退键-->
			<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
			<h1 class="mui-title">河南科技学院党员在线</h1>
		</header>
		<!--主体-->
		<div class="mui-content">
			<form class="mui-input-group" action="login_phoneLogin"  method="POST" onsubmit="md5()">
				<div class="mui-input-row">
					<label>用户名</label>
					<input style="width:45%!important;float:left;" type="text" name="userInfo.account" required="required" pattern="^.{6,10}$" class="mui-input-clear" placeholder="请输入用户名">
				</div>
				<div class="mui-input-row">
					<label>密码</label>
					<input style="width:50%!important;float:left;" type="password"  name="userInfo.password"  required="required"  pattern="^.{8,}$" class="mui-input-password" placeholder="请输入密码">
				</div>
				<div class="mui-input-row">
					<label>验证码</label>
					<input type="text" id="yanzheng" name="randStr" placeholder="请输入验证码">
					<label class="yanzhengma">
					     <a href="javascript:void(0)"onclick="refresh()">
           				<img alt="点击刷新" src="${rootPath }validation" id="yan" /></a>
					</label>
				</div>
				
				<div class="mui-button-row anniu">
					<button type="submit" class="mui-btn mui-btn-primary">登录</button>
					<!--<button type="button" class="mui-btn mui-btn-danger">取消</button>-->
				</div>
			</form>
		</div>
	</body>
<script type="text/javascript">
var notice = "${notice}";
if(notice==""){
	
}else{
	alert(notice);
}
function refresh() {
	document.getElementById("yan").src = "${rootPath}validation?s="
			+ new Date();
}
function md5(){
	var list=document.getElementsByTagName("input");
	var pwd=list[1].value;
	var sha = hex_sha1(pwd);
	list[1].value=sha;
	
}
</script>