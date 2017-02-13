<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<script src="${rootPath }js/mui.min.js"></script>
<link href="${rootPath }css/mui.min.css" rel="stylesheet" />
<script type="text/javascript" charset="utf-8">
			mui.init();
		</script>
		<style>
		*{
			font-size: 20px;
			font-family: "仿宋";
		}
		.tou{
				opacity: 0.8;
			}
		.mui-content{
				background: rgba(252,252,252,0);
				margin: 0px 30px;
			}
		.biaoge{
			width: 80%;
			margin: 60px auto;
		}
		.biaoge tr{
			width: 100%;
		}
		.left{
			width: 50%;
			text-align: right;
		}
		.right{
			width: 50%;
			float: left;
		}
		.xinxi{
			text-align: center;
			margin: 40px auto;
			width: 50%;
		}
		table{
			/*表格行间距*/
			border-collapse:separate;
            border-spacing:10px;
		}
		</style>
	</head>
	<body background="images/bei22.png">
		<header class="mui-bar mui-bar-nav tou">
			<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
			<h1 class="mui-title">个人信息</h1>
		</header>
		<div class="mui-content">
			<!--<h3 class="xinxi">个人信息</h3>-->
				 <table class="biaoge">
				 	  <tr>
				 	  	<td class="left">账号 ：</td>
				 	  	<td >${userInfo.account }</td>
				 	  </tr>
				 	  <tr>
				 	  	<td class="left">姓名 ：</td>
				 	  	<td>${userInfo.username }</td>
				 	  </tr>
				 	  <tr>
				 	  	<td class="left">性别 ：</td>
				 	  	<td>${userInfo.sex }</td>
				 	  </tr>
				 	  <tr>
				 	  	<td class="left">年龄 ：</td>
				 	  	<td>${userInfo.age }</td>
				 	  </tr>
				 	  <tr>
				 	  	<td class="left">民族 ：</td>
				 	  	<td>${userInfo.nation }</td>
				 	  </tr>
				 	  <tr>
				 	  	<td class="left">出生日期 ：</td>
				 	  	<td>${userInfo.birthdate }</td>
				 	  </tr>
				 	  <tr>
				 	  	<td class="left">籍贯 ：</td>
				 	  	<td>${userInfo.nativePlace }</td>
				 	  </tr>
				 	  <tr>
				 	  	<td class="left">身份证号 ：</td>
				 	  	<td>${userInfo.idCard }</td>
				 	  </tr>
				 	  <tr>
				 	  	<td class="left">入党日期 ：</td>
				 	  	<td>${userInfo.joinPartyDate }</td>
				 	  </tr>
				 	  <tr>
				 	  	<td class="left">职务 ：</td>
				 	  	<td>${userInfo.duties }</td>
				 	  </tr>
				 	  <c:if test="${userSort==0 }">
				 	  	<tr>
				 	  		<td class="left">介绍人 ：</td>
				 	  		<td>${userInfo.introducer }</td>
				 	 	 </tr>
				 	  </c:if>				 	 
				 	  <tr>
				 	  	<td class="left">所在党支部 ：</td>
				 	  	<td>${userInfo.partyBranch }</td>
				 	  </tr>
				 	  <tr>
				 	  	<td class="left">学习时间 ：</td>
				 	  	<td>${userInfo.learnTime }</td>
				 	  </tr>
				 	  <tr>
				 	  	<td class="left">手机号 ：</td>
				 	  	<td>${userInfo.phoneNo }</td>
				 	  </tr>
				 	  <tr>
				 	  	<td class="left">注册日期 ：</td>
				 	  	<td>${userInfo.loginDate }</td>
				 	  </tr>
				 </table>			    			    			    			 			    
		</div>
	</body>
</html>