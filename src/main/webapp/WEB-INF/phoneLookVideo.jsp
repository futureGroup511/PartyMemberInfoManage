<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		
		<title>视频播放</title>
		<script src="${rootPath }js/mui.min.js"></script>
		<link href="${rootPath }css/mui.min.css" rel="stylesheet" />
		<script type="text/javascript" charset="utf-8">
			mui.init();
		</script>
		<style>
			.video-warp{
				margin-top: 100px;
			}
			.jianjie{
				
				width: 80%;
				margin: 10px auto;
				font-size: 16px;
				color: #AAAAAA;
			}
			p{
			   text-indent:2em;
			}
		</style>
	</head>
	<body>
	<div class="video-warp">
	
		<header class="mui-bar mui-bar-nav">
			<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
			<h1 class="mui-title">${video.name }</h1>
		</header>
			<input type="hidden" value="${video.rv_Id}" id="videoId" />
			<input type="hidden" value="${currentTime}" id="oldcurrentTime" />
		<div class="mui-content">
			<video id="videos" width="100%" height="200" controls
				onplay="startVideo()">
				<source src="${rootPath }${video.videoUrl}" type="video/mp4">
				<h3>您的浏览器不支持 HTML5 video 标签。</h3>
			</video>
			<div class="jianjie">
				<p>${video.description }
			    </p>
			</div>
		</div>
	</div>
	</body>
<script src="${rootPath}js/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
	
	var count =0;//计数器
	var start ;//视频开始
	var end ;//视频结束
	var watchLength;//观看时长
	var url="${rootPath}"+"phone_updateLearnTime";

	
	$(document).ready(function() {
		window.onbeforeunload = onbeforeunload_handler;  
	});

	//播放视频时触发的事件
	function startVideo(){

		if (count==0) {		
			start = new Date();
			count=count+1;
			var oldcurrentTime=document.getElementById("oldcurrentTime").value;
			document.getElementById("videos").currentTime=oldcurrentTime;
		}
	}

	function onbeforeunload_handler(){
		end = new Date();
		watchLength = end.getTime()-start.getTime();//这是毫秒
		var currentTime = document.getElementById("videos").currentTime; 
		var videoId=document.getElementById("videoId").value;
		alert(currentTime)
	    $.ajax({
	    	url: url,
	    	type: 'POST',
	    	dataType: 'json',
	    	data:{
	    		"time":watchLength,
	    		"currentTime":currentTime,
	    		"videoId":videoId
	    	},
	    });   
	}
	</script>
</html>