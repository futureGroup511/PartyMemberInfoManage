<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${rootPath }css/bootstrap.css" />
<link rel="stylesheet" href="${rootPath }css/manage/button.css">
<title>Insert title here</title>
<style type="text/css">
.content{
    background-image:url("${rootPath }images/star.png");
}
.remind{
	font-size:1.4em;
	color:red;
}
</style>
</head>
<body>
<ol class="breadcrumb">
	<li>党员管理</li>
	<li class="active">增加党员</li>
</ol>
<div class="content">

	<form class="form-horizontal" role="form"  method="post"
			action="${rootPath }manage/partMember_addDo">
		<div class="row">
			<span class="remind">${remind }</span>
		</div>
		<div class="row">
				
				<div class="col-xs-12 col-sm-5">
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height:50px;">账号</label>							
						</div>
						<div class="col-xs-8">
							<input type="text" class="form-control"  required="required" name="partyMemberInfo.account" value="${partyMemberInfo.account }" placeholder="请输入账号">
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height:50px;">身份证号</label>
						</div>
						<div class="col-xs-8">
							<input type="number" class="form-control" required="required" name="partyMemberInfo.idCard" value="${partyMemberInfo.idCard }" placeholder="请输入身份证号">
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height:50px;">姓名</label>							
						</div>
						<div class="col-xs-8">
							<input type="text" class="form-control" required="required" name="partyMemberInfo.username" value="${partyMemberInfo.username }" placeholder="请输入姓名">
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height:50px;">籍贯</label>							
						</div>
						<div class="col-xs-8">
							<input type="text" class="form-control" required="required" name="partyMemberInfo.nativePlace" value="${partyMemberInfo.nativePlace }" placeholder="请输入籍贯">
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height:50px;">在党职务</label>							
						</div>
						<div class="col-xs-8">
							<input type="text" class="form-control" name="partyMemberInfo.duties" value="${partyMemberInfo.duties }" placeholder="在党职务">
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height:50px;">介绍人</label>							
						</div>
						<div class="col-xs-8">
							<input type="text" class="form-control" required="required" name="partyMemberInfo.introducer" value="${partyMemberInfo.introducer }" placeholder="请输入介绍人">
						</div>
					</div>
					
				</div>
				<div class="hidden-xs col-sm-1"></div>
				<div class="col-xs-12 col-sm-5">
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height:50px;">密码</label>							
						</div>
						<div class="col-xs-8">
							<input class="form-control" type="password" required="required" name="partyMemberInfo.password" value="${partyMemberInfo.password  }" placeholder="请输入密码">
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height:50px;">手机号</label>							
						</div>
						<div class="col-xs-8">
							<input class="form-control" type="number"  name="partyMemberInfo.phoneNo" value="${partyMemberInfo.phoneNo }" placeholder="请输入手机号">
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height:50px;">民族</label>							
						</div>
						<div class="col-xs-8"> 
							<input type="text" required="required" class="form-control" name="partyMemberInfo.nation" value="${partyMemberInfo.nation }" placeholder="请输入民族">
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height:50px;">所在党支部</label>							
						</div>
						<div class="col-xs-8">
							<input type="text" class="form-control" required="required" name="partyMemberInfo.partyBranch" value="${partyMemberInfo.partyBranch }" placeholder="所在党支部">
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height:50px;">入党日期</label>							
						</div>
						<div class="col-xs-8">
							<input class="form-control"  type="date" required="required" name="joinPartyDate" value="${dateStr }">
						</div>
					</div>
					
				</div>
			</div>
			
			<div class="row">
				<div class="col-xs-2">
					<button class="btn btn-default" type="reset">重新填写</button>
				
				</div>
				<div class="col-xs-6">
					<button class="btn btn-success" type="submit"> &nbsp; 提交 &nbsp; </button>
				</div>
				
			</div>
			
		</form>
	
	</div>
</body>
</html>