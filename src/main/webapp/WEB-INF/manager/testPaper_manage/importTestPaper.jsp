<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传试卷</title>
<link rel="stylesheet" href="${rootPath}css/bootstrap.css">
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
<ol class="breadcrumb">
 	<li>当前位置：</li>
	<li>考试管理</li>
	<li class="active">上传试卷</li>
</ol>
	<div class="content">
	<h4 style="color:red;">直接选择符合规范的Excel 文件上传即可</h4>
	
		<%-- 
		<h3 style="margin-bottom:30px;">添加试卷</h3>
		<div>
			<form action="${rootPath}/manage/import_addTestPaper" method="post">
				<table style="margin-top:-20px;">
					<tr>
						<td>试卷名称&nbsp;</td>
						<td><input class="form-control" required="required" type="text" name="testPap.paperName" placeholder="试卷名称"></td>
					</tr>
					<tr><td> &nbsp;</td></tr>
					<tr>
						<td>试卷的说明&nbsp;</td>
						<td><input class="form-control" type="text" name="testPap.description" placeholder="试卷描述"></td>
					</tr>
				</table>
				<br>
				<button class="btn btn-danger" style="margin-left:17%;" type="reset">重置</button> 
				<button class="btn btn-success" style="margin-left:18%;"type="submit">添加</button>
				<h3 style="color:red;margin-left:27%;" >${testPapMeg }</h3>
			</form>
		</div>
		 --%>
		<h3>根据Excel导入试题</h3>
		
		<div class="main" style="">
			<form action="${rootPath }manage/import_importTest" method="post"
				enctype="multipart/form-data">
				Excel文件：<a href="${rootPath }file/example.xlsx">下载试卷样例</a>
				<input required="required" type="file" name="testPaper"
					accept="application/vnd.ms-excel, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
					<br>
				<button type="submit" class="btn btn-success" style="padding:7px 150px;">上&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;传</button>
			</form>
			<h3 style="color:red;">${reminder}</h3>
			
		</div>

		
	</div>
<div class="background navbar-fixed-top"  style="position:absolute; z-index:-1;width:100%;height:100%;opacity:0.1;">
    	<img  class="img-responsive" width="100%;" src="${rootPath }images/577a4c594718d_610.jpg" />
</div>
</body>
</html>