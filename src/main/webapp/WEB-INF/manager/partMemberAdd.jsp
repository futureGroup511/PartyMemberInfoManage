<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${rootPath }css/bootstrap.css" />
<link rel="stylesheet" href="${rootPath }css/manage/button.css">
<title>添加党员</title>
<script src="${rootPath }js/pccs.js" type="text/javascript"></script>
<style type="text/css">
.remind {
	font-size: 1.4em;
	color: red;
}
.col-xs-4{
	text-align:right;
}
.col-xs-8{
	margin:0;
	padding:0;
}
</style>
</head>
<body>
	<ol class="breadcrumb">
		<li>当前位置：</li>
		<li>党员管理</li>
		<li class="active">增加党员</li>
	</ol>
	<div class="content">

		<form class="form-horizontal" role="form" method="post"
			action="${rootPath }manage/partMember_addDo"
			onsubmit="return subAdd()">
			<div class="row">
				<span class="remind">${remind }</span>
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-5">
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height: 50px;">账号</label>
						</div>
						<div class="col-xs-8">
							<input type="text" maxlength="10" class="form-control"
								required="required" name="partyMemberInfo.account"
								value="${partyMemberInfo.account }" placeholder="8-10位">
						</div>
					</div>

					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height: 50px;">身份证号</label>
						</div>
						<div class="col-xs-8">
							<input type="number" class="form-control" required="required"
								name="partyMemberInfo.idCard" value="${partyMemberInfo.idCard }"
								placeholder="请输入身份证号">
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height: 50px;">姓名</label>
						</div>
						<div class="col-xs-8">
							<input type="text" class="form-control" required="required"
								name="partyMemberInfo.username"
								value="${partyMemberInfo.username }" placeholder="请输入姓名">
						</div>
					</div>

					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height: 50px;">在党职务</label>
						</div>
						<div class="col-xs-8">
							<input type="text" class="form-control"
								name="partyMemberInfo.duties" value="${partyMemberInfo.duties }"
								placeholder="在党职务">
						</div>
					</div>

					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height: 50px;">介绍人</label>
						</div>
						<div class="col-xs-8">
							<input type="text" class="form-control" required="required"
								name="partyMemberInfo.introducer"
								value="${partyMemberInfo.introducer }" placeholder="请输入介绍人">
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
							<label style="line-height: 50px;">a123456789</label>
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height: 50px;">手机号</label>
						</div>
						<div class="col-xs-8">
							<input class="form-control" type="number"
								name="partyMemberInfo.phoneNo"
								value="${partyMemberInfo.phoneNo }" placeholder="请输入手机号">
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height: 50px;">民族</label>
						</div>
						<div class="col-xs-8">
							<select name="partyMemberInfo.nation" class="form-control">
								<option value="汉族" selected="selected">汉族</option>
								<option value="蒙古族">蒙古族</option>
								<option value="回族">回族</option>
								<option value="藏族">藏族</option>
								<option value="维吾尔族">维吾尔族</option>
								<option value="苗族">苗族</option>
								<option value="彝族">彝族</option>
								<option value="壮族">壮族</option>
								<option value="布依族">布依族</option>
								<option value="朝鲜族">朝鲜族</option>
								<option value="满族">满族</option>
								<option value="侗族">侗族</option>
								<option value="瑶族">瑶族</option>
								<option value="白族">白族</option>
								<option value="土家族">土家族</option>
								<option value="哈尼族">哈尼族</option>
								<option value="哈萨克族">哈萨克族</option>
								<option value="傣族">傣族</option>
								<option value="黎族">黎族</option>
								<option value="傈僳族">傈僳族</option>
								<option value="佤族">佤族</option>
								<option value="畲族">畲族</option>
								<option value="高山族">高山族</option>
								<option value="拉祜族">拉祜族</option>
								<option value="水族">水族</option>
								<option value="东乡族">东乡族</option>
								<option value="纳西族">纳西族</option>
								<option value="景颇族">景颇族</option>
								<option value="柯尔克孜族">柯尔克孜族</option>
								<option value="土族">土族</option>
								<option value="达斡尔族">达斡尔族</option>
								<option value="仫佬族">仫佬族</option>
								<option value="羌族">羌族</option>
								<option value="布朗族">布朗族</option>
								<option value="撒拉族">撒拉族</option>
								<option value="毛南族">毛南族</option>
								<option value="仡佬族">仡佬族</option>
								<option value="锡伯族">锡伯族</option>
								<option value="阿昌族">阿昌族</option>
								<option value="普米族">普米族</option>
								<option value="塔吉克族">塔吉克族</option>
								<option value="怒族">怒族</option>
								<option value="乌孜别克族">乌孜别克族</option>
								<option value="俄罗斯族">俄罗斯族</option>
								<option value="鄂温克族">鄂温克族</option>
								<option value="德昂族">德昂族</option>
								<option value="保安族">保安族</option>
								<option value="裕固族">裕固族</option>
								<option value="京族">京族</option>
								<option value="塔塔尔族">塔塔尔族</option>
								<option value="独龙族">独龙族</option>
								<option value="鄂伦春族">鄂伦春族</option>
								<option value="赫哲族">赫哲族</option>
								<option value="门巴族">门巴族</option>
								<option value="珞巴族">珞巴族</option>
								<option value="基诺族">基诺族</option>
							</select>

						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height: 50px;">所在党支部</label>
						</div>
						<div class="col-xs-8">
							<select name="partyMemberInfo.partyBranch" class="form-control">
								<option value="第一党支部">第一党支部</option>
								<option value="第二党支部">第二党支部</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<div class="col-xs-4">
							<label style="line-height: 50px;">入党日期</label>
						</div>
						<div class="col-xs-8">
							<input class="form-control" type="date" required="required"
								name="joinPartyDate" value="${dateStr }">
						</div>
					</div>

				</div>
			</div>

			<div class="row">
				<div class="col-xs-1"></div>
				<div class="col-xs-8">
					<label>籍贯</label>
				</div>
				
			</div>
			<div style="height: 20px;"></div>

			<div class="row">
				<div class="col-xs-1"></div>
				<div class="col-xs-3">
					<select name="province" class="form-control" id="province">
					</select>
				</div>
				<div class="col-xs-3">
					<select name="city" class="form-control" id="city">
					</select>
				</div>
				<div class="col-xs-3">
					<select name="county" class="form-control" id="county">
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-1"></div>
				<div class="col-xs-9">
					<input id="nativeInfo" name="partyMemberInfo.nativePlace"
						class="form-control" placeholder="详细籍贯信息">
				</div>

			</div>
			<div style="height: 20px;"></div>
			<div class="row">
				<div class="col-xs-2"></div>
				<div class="col-xs-2">
					<button class="btn btn-default" type="reset">重新填写</button>

				</div>
				<div class="col-xs-6">
					<button class="btn btn-success" type="submit" style="padding:5px 50px;">&nbsp; 提交
						&nbsp;</button>
				</div>

			</div>

		</form>

	</div>
	<div class="background navbar-fixed-top"
		style="position: absolute; z-index: -1; width: 100%; height: 100%; opacity: 0.1;">
		<img class="img-responsive" width="100%;"
			src="${rootPath }images/577a4c594718d_610.jpg" />
	</div>
</body>
<script type="text/javascript">
	setup();
	function subAdd() {
		var province = document.getElementById('province').value;
		var city = document.getElementById('city').value;
		var county = document.getElementById('county').value;
		var nativeInfo = document.getElementById('nativeInfo');
		nativeInfo.value = province + city + county + nativeInfo.value;
		return true;
	}
</script>
</html>