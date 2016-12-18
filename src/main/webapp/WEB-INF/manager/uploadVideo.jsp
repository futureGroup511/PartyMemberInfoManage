<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css" />
<link rel="stylesheet" href="${rootPath }css/manage/uploadvideo.css" />
</head>
<body>
	<div class="first">
		<div class="nameone">
			<div class="row">
				<div
					class="col-lg-2 col-lg-offset-1 col-md-2 col-md-offset-1 col-xs-3 col-xs-offset-1">
					上传本地视频</div>
			</div>
		</div>
		<form action="${rootPath }manage/uploadVideo_upload" method="post"
			enctype="multipart/form-data">
			<div class="partone">
				<div class="row">
					<div
						class="col-lg-2 col-lg-offset-1 col-md-2 col-md-offset-1 col-xs-3 col-xs-offset-1">
						<h3 style="color: red;">${remind }</h3>
					</div>
				</div>
				<div class="row">
					<div
						class="col-lg-2 col-lg-offset-1 col-md-2 col-md-offset-1 col-xs-4 col-xs-offset-1">
						<div class="row">视频：</div>
						<div class="row">视频缩略图：</div>
					</div>
					<div class="col-lg-1 col-md-1 col-xs-1">
						<div class="row">
							<input type="file" name="video">
						</div>
						<div class="row">
							<input type="file" name="img">
						</div>
					</div>
					<div
						class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-xs-3 col-xs-offset-2">
						视频描述：</div>
					<div class="col-lg-4 col-lg-offset-2  col-md-5 col-md-offset-2 col-xs-5 col-xs-offset-2">
						<textarea name="videoDescription" placeholder="视频描述" rows="5" cols="30"></textarea>
					</div>

				</div>

				<button type="submit" class="btn btn-primary btn-xs">上传</button>
			</div>
		</form>
	</div>
	<hr>
	<div class="second">
		<div class="nametwo">
			<div class="row">
				<div
					class="col-lg-2 col-lg-offset-1 col-md-2 col-md-offset-1 col-xs-3 col-xs-offset-1">
					添加外部视频</div>
			</div>
		</div>
		<form action="${rootPath }manage/uploadVideo_uploadOut" method="post"
			enctype="multipart/form-data">
			<div class="parttwo">
				<div class="row">
					<div
						class="col-lg-3 col-lg-offset-1 col-md-4 col-md-offset-1 col-xs-5 col-xs-offset-1">
						<div class="row">
							视频名字：<input name="redVideo.name" type="text" class="navbar-link">
						</div>
						<div class="row">
							视频链接：<input name="redVideo.videoUrl" type="text"
								class="navbar-link">
						</div>
					</div>
					<div
						class="col-lg-2 col-lg-offset-1 col-md-2 col-md-offset-1 col-xs-3 col-md-offset-1">
						视频描述：</div>
					<div class="col-lg-4 col-lg-offset-1  col-lg-offset-2 col-md-5 col-md-offset-1 col-xs-5">
						<textarea rows="5" cols="30" name="redVideo.description"
							placeholder="视频描述"></textarea>
					</div>
				</div>
				<div class="row">
					<div
						class="col-lg-2 col-lg-offset-1 col-md-2 col-md-offset-1 col-xs-3 col-xs-offset-1">
						视频缩略图：</div>
					<div class="col-lg-1 col-md-1 col-xs-1">
						<input type="file" name="img">
					</div>
				</div>
				<button type="submit" class="btn btn-primary btn-xs">添加</button>
			</div>
		</form>
	</div>
</body>
</html>