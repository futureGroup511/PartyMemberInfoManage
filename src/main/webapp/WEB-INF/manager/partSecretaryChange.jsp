<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改书记信息</title>
<script type="text/javascript" src="${rootPath }js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css" />
<style type="text/css">
.remind {
	font-size: 1.4em;
	color: red;
}
</style>
</head>
<body>
	<ol class="breadcrumb">
		<li>当前位置：</li>
		<li>书记管理</li>
		<li class="active">修改书记信息</li>
	</ol>
	<div class="container">
		<form class="form-horizontal" role="form" method="post" action="${rootPath }manage/partSecretary_updateDo" onsubmit="return md5()">
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
							<input id="password-in" class="form-control" type="password" required="required"
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

			<div class="row">
				<div class="col-xs-2">
					<button class="btn btn-default" type="reset">重新填写</button>

				</div>
				<div class="col-xs-6">
					<button class="btn btn-success" type="submit">&nbsp; 提交
						&nbsp;</button>
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