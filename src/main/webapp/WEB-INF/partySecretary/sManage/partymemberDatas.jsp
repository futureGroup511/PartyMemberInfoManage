<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看所属党员信息</title>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css">
<link rel="stylesheet" href="${rootPath }css/partySecretary/partyinformation.css">
<script src="${rootPath }js/jquery-2.2.3.min.js"></script>
<script src="${rootPath }js/bootstrap.js"></script>
</head>

<body>

<%@ include file="../head.jsp"%>

<!--以上为头部-->

		
<div id="body">
 <div id="body-one">
   <p><img src="${rootPath }images/topimg.png"> <span>您的位置：
   <a href="${rootPath }secretary/pSForward_fIndex">首页</a>&nbsp;&nbsp;>&nbsp;&nbsp;
   <a href="${rootPath }secretary/partySecretary_lookOfPartyMember">党员管理</a>&nbsp;&nbsp;>&nbsp;&nbsp;党员信息详细</span></p>
 </div>
 <div id="body-two">
 	<form action="${rootPath }secretary/partySecretary_lookOfPartyMember" method="post">
    	<input type="text" name="search" class="form-control" placeholder="您可以通过/姓名/民族/籍贯/手机号/搜索" autocomplete="off"/>
     	<button class="btn btn-primary sure" type="button">搜索</button>
     </form>
 </div>
	<div class="container">
			<div class="row">
				<span class="remind">${remind }</span>
			</div>
			<div class="row">
				<input type="hidden" name="partySecretaryInfo.pst_Id"
					value="${partySecretaryInfo.pst_Id }">
				<div class="col-xs-12 col-sm-5">
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height: 50px;">账号</label>
						</div>
						<div class="col-xs-8">
							<input type="text" class="form-control" required="required"
								name="partySecretaryInfo.account"
								value="${partySecretaryInfo.account }" placeholder="请输入账号">
						</div>
					</div>

					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height: 50px;">身份证号</label>
						</div>
						<div class="col-xs-8">
							<input type="number" class="form-control" required="required"
								name="partySecretaryInfo.idCard"
								value="${partySecretaryInfo.idCard }" placeholder="请输入身份证号">
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height: 50px;">姓名</label>
						</div>
						<div class="col-xs-8">
							<input type="text" class="form-control" required="required"
								name="partySecretaryInfo.username"
								value="${partySecretaryInfo.username }" placeholder="请输入姓名">
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height: 50px;">籍贯</label>
						</div>
						<div class="col-xs-8">
							<input type="text" class="form-control" required="required"
								name="partySecretaryInfo.nativePlace"
								value="${partySecretaryInfo.nativePlace }" placeholder="请输入籍贯">
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height: 50px;">在党职务</label>
						</div>
						<div class="col-xs-8">
							<input type="text" class="form-control"
								name="partySecretaryInfo.duties"
								value="${partySecretaryInfo.duties }" placeholder="在党职务">
						</div>
					</div>

				</div>
				<div class="hidden-xs col-sm-1"></div>
				<div class="col-xs-12 col-sm-5">
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height: 50px;">密码</label>
						</div>
						<div class="col-xs-8">
							<input class="form-control" type="password" required="required"
								name="partySecretaryInfo.password"
								value="" placeholder="请输入密码,8-16位,为空则不修改" maxlength="16">
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height: 50px;">手机号</label>
						</div>
						<div class="col-xs-8">
							<input class="form-control" type="number"
								name="partySecretaryInfo.phoneNo"
								value="${partySecretaryInfo.phoneNo }" placeholder="请输入手机号">
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height: 50px;">民族</label>
						</div>
						<div class="col-xs-8">
							<input type="text" required="required" class="form-control"
								name="partySecretaryInfo.nation"
								value="${partySecretaryInfo.nation }" placeholder="请输入民族">
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height: 50px;">所在党支部</label>
						</div>
						<div class="col-xs-8">
							<input type="text" class="form-control" required="required"
								name="partySecretaryInfo.partyBranch"
								value="${partySecretaryInfo.partyBranch }" placeholder="所在党支部">
						</div>
					</div>

					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height: 50px;">入党日期</label>
						</div>
						<div class="col-xs-8">
							<input class="form-control" type="date" required="required"
								name="joinPartyDate"
								value="${partySecretaryInfo.joinPartyDate }">
						</div>
					</div>

				</div>
			</div>
 </div>
		
	 <footer id="footer-warp"><!--页脚开始-->
		<p class="footer"><a href="">网站声明</a> &nbsp; &nbsp;<span>|</span> &nbsp; &nbsp;<a href="">关于我们 &nbsp; &nbsp;</a><span>|</span> &nbsp; &nbsp;<a href="">联系我们</a></p>
		<p>Copyright @ 2016 All rights reserved.　　版权所有：河南科技学院党委</p>
</footer><!--页脚结束-->		
</body>
</html>