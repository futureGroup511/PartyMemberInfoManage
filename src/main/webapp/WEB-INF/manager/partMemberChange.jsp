<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改党员信息</title>
<script type="text/javascript" src="${rootPath }js/jquery-3.1.1.min.js"></script>
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
	 <li>当前位置：</li>
	<li>党员管理</li>
	<li class="active">修改党员信息</li>
</ol>
  <div class="container">
	<form class="form-horizontal" role="form"  method="post"
			action="${rootPath }manage/partMember_updateDo" onsubmit="return md5()">
		<div class="row">
			<span class="remind">${remind }</span>
		</div>
		<div class="row">
				<input type="hidden" name="partyMemberInfo.ptm_Id" value="${partyMemberInfo.ptm_Id }">
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
							<input id="password-in" class="form-control" type="password" required="required" name="partyMemberInfo.password" value="" placeholder="请输入密码,8-16位,为空则不修改">
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
							<input class="form-control"  type="date" required="required" name="joinPartyDate" value="${partyMemberInfo.joinPartyDate }">
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
	<div class="background navbar-fixed-top"  style="position:absolute; z-index:-1;width:100%;height:100%;opacity:0.1;">
    	<img  class="img-responsive" width="100%;" src="${rootPath }images/577a4c594718d_610.jpg" />
    </div>
<script src="${rootPath }js/sha1.js"></script>
<script type="text/javascript">
	function md5() {
		
		if($('#password-in').val().length<8){
			return true;
		}
		var sha = hex_sha1($('#password-in').val());
		$('#password-in').val(sha);
		return true;
	}
</script>
</body>
</html>