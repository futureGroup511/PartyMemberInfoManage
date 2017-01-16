<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css" />
<style type="text/css">

.remind{
	font-size:1.4em;
	color:red;
}
</style>
</head>
<body>
<ol class="breadcrumb">
	<li>书记管理</li>
	<li class="active">修改书记信息</li>
</ol>
	<div class="container">
	
	<form class="form-horizontal" role="form"  method="post"
			action="${rootPath }manage/partSecretary_updateDo">
		<div class="row">
			<span class="remind">${remind }</span>
		</div>
		<div class="row">
				<input type="hidden" name="partySecretaryInfo.pst_Id" value="${partySecretaryInfo.pst_Id }">
				<div class="col-xs-12 col-sm-5">
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height:50px;">账号</label>							
						</div>
						<div class="col-xs-8">
							<input type="text" class="form-control"  required="required" name="partySecretaryInfo.account" value="${partySecretaryInfo.account }" placeholder="请输入账号">
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height:50px;">身份证号</label>
						</div>
						<div class="col-xs-8">
							<input type="number" class="form-control" required="required" name="partySecretaryInfo.idCard" value="${partySecretaryInfo.idCard }" placeholder="请输入身份证号">
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height:50px;">姓名</label>							
						</div>
						<div class="col-xs-8">
							<input type="text" class="form-control" required="required" name="partySecretaryInfo.username" value="${partySecretaryInfo.username }" placeholder="请输入姓名">
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height:50px;">籍贯</label>							
						</div>
						<div class="col-xs-8">
							<input type="text" class="form-control" required="required" name="partySecretaryInfo.nativePlace" value="${partySecretaryInfo.nativePlace }" placeholder="请输入籍贯">
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height:50px;">在党职务</label>							
						</div>
						<div class="col-xs-8">
							<input type="text" class="form-control" name="partySecretaryInfo.duties" value="${partySecretaryInfo.duties }" placeholder="在党职务">
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
							<input class="form-control" type="password" required="required" name="partySecretaryInfo.password" value="${partySecretaryInfo.password  }" placeholder="请输入密码">
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height:50px;">手机号</label>							
						</div>
						<div class="col-xs-8">
							<input class="form-control" type="number"  name="partySecretaryInfo.phoneNo" value="${partySecretaryInfo.phoneNo }" placeholder="请输入手机号">
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height:50px;">民族</label>							
						</div>
						<div class="col-xs-8"> 
							<input type="text" required="required" class="form-control" name="partySecretaryInfo.nation" value="${partySecretaryInfo.nation }" placeholder="请输入民族">
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height:50px;">所在党支部</label>							
						</div>
						<div class="col-xs-8">
							<input type="text" class="form-control" required="required" name="partySecretaryInfo.partyBranch" value="${partySecretaryInfo.partyBranch }" placeholder="所在党支部">
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height:50px;">入党日期</label>							
						</div>
						<div class="col-xs-8">
							<input class="form-control"  type="date" required="required" name="joinPartyDate" value="${partySecretaryInfo.joinPartyDate }"">
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