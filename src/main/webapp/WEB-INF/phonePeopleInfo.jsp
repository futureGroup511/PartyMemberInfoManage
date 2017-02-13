<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>个人信息</title>
<script src="${rootPath }js/mui.min.js"></script>
<link href="${rootPath }css/mui.min.css" rel="stylesheet" />
<script type="text/javascript" charset="utf-8">
			mui.init();
		</script>
		<style>
		
		.tou{
				opacity: 0.8;
			}
		.mui-content{
		    background: rgba(252,252,252,0);
		}	
		.biaoge{
			width: 100%;
			margin: 40px auto;
		}
		.biaoge tr{
			width: 100%;
		}
		.left{
			font-size: 1.2rem;
			width: 50%;
			text-align: right;
		}
		.right{
			font-size: 1.0rem;
			width: 100%;
			float: left;
		}
		table{
			/*表格行间距*/
			border-collapse:separate;
            border-spacing:10px;
            /*防止自动换行*/
           table-layout: fixed;
		}
		/*td{
			word-break: keep-all;
			white-space:nowrap;
		}*/
		
		</style>
	</head>
	<body background="images/bei22.png">
		<div class="mui-content">
			<!--<h3 class="xinxi">个人信息</h3>-->
				 <table class="biaoge">
				 	  <tr>
				 	  	<td class="left">账号 ：</td>
				 	  	<td class="right">${userInfo.account }</td>
				 	  </tr>
				 	  <tr>
				 	  	<td class="left">姓名 ：</td>
				 	  	<td class="right">${userInfo.username }</td>
				 	  </tr>
				 	  <tr>
				 	  	<td class="left">性别 ：</td>
				 	  	<td class="right">${userInfo.sex }</td>
				 	  </tr>
				 	  <tr>
				 	  	<td class="left">年龄 ：</td>
				 	  	<td class="right">${userInfo.age }</td>
				 	  </tr>
				 	  <tr>
				 	  	<td class="left">民族 ：</td>
				 	  	<td class="right">${userInfo.nation }</td>
				 	  </tr>
				 	  <tr>
				 	  	<td class="left">职务 ：</td>
				 	  	<td class="right">${userInfo.duties }</td>
				 	  </tr>
				 	  <tr>
				 	  	<td class="left">籍贯 ：</td>
				 	  	<td class="right">${userInfo.nativePlace }</td>
				 	  </tr>
				 	  <tr>
				 	  	<td class="left">身份证号 ：</td>
				 	  	<td class="right">${userInfo.idCard }</td>
				 	  </tr>
				 	  <tr>
				 	  	<td class="left">出生日期 ：</td>
				 	  	<td class="right">${userInfo.birthdate }</td>
				 	  </tr>				 	  
				 	  <tr>
				 	  	<td class="left">入党日期 ：</td>
				 	  	<td class="right">${userInfo.joinPartyDate }</td>
				 	  </tr>
				 	  <c:if test="${userSort==0 }">
				 	  	<tr>
				 	  		<td class="left">介绍人 ：</td>
				 	  		<td class="right">${userInfo.introducer }</td>
				 	 	 </tr>
				 	  </c:if>				 	 
				 	  <tr>
				 	  	<td class="left">所在党支部 ：</td>
				 	  	<td class="right">${userInfo.partyBranch }</td>
				 	  </tr>
				 	  <tr>
				 	  	<td class="left">学习时间 ：</td>
				 	  	<td class="right">${userInfo.strLearnTime }</td>
				 	  </tr>
				 	  <tr>
				 	  	<td class="left">手机号 ：</td>
				 	  	<td class="right">${userInfo.phoneNo }</td>
				 	  </tr>
				 	  <tr>
				 	  	<td class="left">注册日期 ：</td>
				 	  	<td class="right">${userInfo.loginDate }</td>
				 	  </tr>
				 </table>			    			    			    			 			    
		</div>
	</body>
</html>