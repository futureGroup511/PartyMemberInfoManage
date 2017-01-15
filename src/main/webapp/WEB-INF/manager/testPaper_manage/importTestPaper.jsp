<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传试卷</title>
<style type="text/css">
.content {
	margin-left: 20%;
	border: 2px solid orange;
	width: 50%;
	margin-top: 6%;
	padding-left: 10%;
	padding-bottom:3%;
}

.main input {
	margin-top: 3%;
}

.lable_1 {
	display: inline-block;
	width: 130px;
}
</style>
</head>
<body>
	<div class="content">
	<h4 style="color:red;">温馨提示：导入试卷文件之前，必须先添加试卷名称和描述；也可以只添加试卷名称和描述，不导入试卷文件</h4>
	<h3 style="margin-top:-5px;">添加试卷</h3>
		<div>
			<form action="${rootPath}/manage/import_addTestPaper" method="post">
				<table style="margin-top:-20px;">
					<tr>
						<td>试卷名称</td>
						<td><input type="text" style="width:125%;" name="testPap.paperName"></td>
					</tr>
					<tr>
						<td>试卷的说明</td>
						<td><input type="text" style="width:125%;" name="testPap.description"></td>
					</tr>
				</table>
				<input style="margin-top:15px;margin-left:17%;" type="reset" value="重置"> <input style="margin-left:18%;"type="submit"
					value="添加">
				<h3 style="color:red;margin-left:27%;" >${testPapMeg }</h3>
			</form>
		</div>
		<h3>根据Excel导入试卷</h3>
		<div class="main" style="margin-top:-20px;">
			<form action="${rootPath }manage/import_importTest" method="post"
				enctype="multipart/form-data">
				试卷：<input type="file" name="testPaper"
					accept="application/vnd.ms-excel, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
				<button type="submit" style="margin-left:-10%;" >上传</button>
			</form>
			<h3 style="color:red;margin-left:27%;">${reminder}</h3>
		</div>

		
	</div>

</body>
</html>