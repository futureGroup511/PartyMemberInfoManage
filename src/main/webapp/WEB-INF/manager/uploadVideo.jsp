<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>上传视频</title>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css" />
<style type="text/css">
.row{
	margin:20px 0;
}
</style>
</head>
<body>
	<ol class="breadcrumb">
		<li>当前位置：</li>
		<li>视频管理</li>
		<li class="active">上传视频</li>
	</ol>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<h3 style="margin:2px;">${remind }</h3>
			</div>
		</div>
		
		<div class="row">
			<div class="col-xs-12">
				<h3 style="margin:0;">上传本地视频</h3>
			</div>
		</div>
		<form action="${rootPath }manage/uploadVideo_upload" method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="col-xs-2">
					<label>视频：</label>
				</div>
				<div class="col-xs-10">
					<input class="form-control" type="file" name="video" required="required">
				</div>
			</div>
			
			<div class="row">
				<div class="col-xs-2">
					<label>视频缩略图：</label>
				</div>
				<div class="col-xs-10">
					<input class="form-control" type="file" name="img" required="required">
				</div>
			</div>
			
			<div class="row">
				<div class="col-xs-2">
					<label>视频描述：</label>
				</div>
				<div class="col-xs-10">
					<textarea class="form-control" name="videoDescription" placeholder="视频描述" rows="5" maxlength="255" required="required"></textarea>
				</div>
			</div>
			
			<div class="row">
				<div class="col-xs-6 col-xs-offset-3">
					<button type="submit" class="btn btn-primary" style="padding:5px 30px;">上传</button>
				</div>
			</div>
			
		</form>
		
		<div style="width:100%;height:1px;background:#CCC;"></div>
		
		
		<!-- 添加外部视频 -->
		
		<div style="margin:20px 0;"></div>
		<div class="row">
			<div class="col-xs-12">
				<h3>添加外部视频</h3>
			</div>
		</div>
		
		<form action="${rootPath }manage/uploadVideo_uploadOut" method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="col-xs-2">
					<label>视频名字：</label>
				</div>
				<div class="col-xs-10">
					<input class="form-control" type="text" name="redVideo.name" required="required" maxlength="20">
				</div>
			</div>
			
			<div class="row">
				<div class="col-xs-2">
					<label>视频链接：</label>
				</div>
				<div class="col-xs-10">
					<input class="form-control" type="text" name="redVideo.videoUrl" required="required" maxlength="200">
				</div>
			</div>
			
			<div class="row">
				<div class="col-xs-2">
					<label>视频缩略图：</label>
				</div>
				<div class="col-xs-10">
					<input type="file" class="form-control" name="img" required="required">
				</div>
			</div>
			
			<div class="row">
				<div class="col-xs-2">
					<label>视频描述：</label>
				</div>
				<div class="col-xs-10">
					<textarea class="form-control" name="redVideo.description" placeholder="视频描述" rows="5" maxlength="255" required="required"></textarea>
				</div>
			</div>
			
			
			
			<div class="row">
				<div class="col-xs-6 col-xs-offset-3">
					<button type="submit" class="btn btn-primary" style="padding:5px 30px;">上传</button>
				</div>
			</div>
			
		</form>
		
		<div style="width:100%;height:1px;background:#CCC;"></div>
	</div>
	
	
	<div class="background navbar-fixed-top"
		style="position: absolute; z-index: -1; width: 100%; height: 100%; opacity: 0.1;">
		<img class="img-responsive" width="100%;"
			src="${rootPath }images/577a4c594718d_610.jpg" />
	</div>
</body>
</html>