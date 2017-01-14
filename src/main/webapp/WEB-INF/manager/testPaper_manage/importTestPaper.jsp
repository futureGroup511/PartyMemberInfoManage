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
		<h3>根据Excel导入试卷</h3>
		<div class="main">
			<form action="${rootPath }manage/import_importTest" method="post"
				enctype="multipart/form-data">
				试卷：<input type="file" name="testPaper"
					accept="application/vnd.ms-excel, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
				<button type="submit">上传</button>
			</form>
			${reminder}
		</div>

		<h3>添加试卷</h3>
		<div>
			<form action="${rootPath}/manage/import_addTestPaper" method="post">
				<table>
					<tr>
						<td>试卷名称</td>
						<td><input type="text" name="testPap.paperName"></td>
					</tr>
					<tr>
						<td>试卷的说明</td>
						<td><input type="text" name="testPap.description"></td>
					</tr>
				</table>
				<input type="reset" value="重置"> <input type="submit"
					value="添加">
				<h3>${testPapMeg }</h3>
			</form>
		</div>
	</div>

</body>
</html>