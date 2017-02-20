<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>视频列表</title>
		<link href="${rootPath }css/mui.min.css" rel="stylesheet" />
		<script src="${rootPath }js/mui.min.js"></script>
		
		<script type="text/javascript" charset="utf-8">
			mui.init();
		</script>
		<style>
			img{
				width: 500px;
				height: 200px;
			}
			.left{
				float: left;
				width: 50%;
				padding-top: 10px;
				padding-left: 10px;
			}
			.right{
				float: left;
				width: 50%;
				padding-top: 10px;
				padding-left: 10px;
				padding-right: 10px;
			}
			.mui-card{
				margin: 0px;
			}
		</style>
	</head>
	<body>
		<header class="mui-bar mui-bar-nav">
			<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
			<h1 class="mui-title">经典视频</h1>
		</header>
		
		<div class="mui-content">
			<div id="slider" class="mui-slider">
				<div class="mui-slider-group mui-slider-loop">
					<!-- 额外增加的一个节点(循环轮播：第一个节点是最后一张轮播) -->
					<!--这个额外增加的节点和第五个一样，相当于前后两个不算在轮播里面-->
					<div class="mui-slider-item mui-slider-item-duplicate">
						<a href="${rootPath}phone_lookVideo?rv_Id=${phoneHotLastVideo.rv_Id}">
							<img src="${rootPath }${phoneHotLastVideo.imgUrl}"></img>
							<p class="mui-slider-title">${phoneHotLastVideo.name }</p>
						</a>
					</div>
					<c:forEach var="video" items="${phoneHotVideoList}">
						<div class="mui-slider-item">
							<a href="${rootPath}phone_lookVideo?rv_Id=${phoneHotLastVideo.rv_Id}">
								<img src="${rootPath }${video.imgUrl}">
								<p class="mui-slider-title">${video.name }</p>
							</a>
						</div>
					</c:forEach>

					<!-- 额外增加的一个节点(循环轮播：最后一个节点是第一张轮播) -->
					<!--这个节点必须和第二个图片一样-->
					<div class="mui-slider-item mui-slider-item-duplicate">
						<a href="${rootPath}phone_lookVideo?rv_Id=${phoneHotFristVideo.rv_Id}">
							<img src="${rootPath }${phoneHotFristVideo.imgUrl}"></img>
							<p class="mui-slider-title">${phoneHotFristVideo.name }</p>
						</a>
					</div>
				</div>
				<div class="mui-slider-indicator mui-text-right">
					<div class="mui-indicator mui-active"></div>
					<div class="mui-indicator"></div>
					<div class="mui-indicator"></div>
					<div class="mui-indicator"></div>
				</div>
			</div>
			<!--轮播结束-->
			<div class="mui-card">
			
				<c:forEach var="video" items="${phoneNewVideoList}" varStatus="videoStatus">
					<c:if test="${videoStatus.index%2==0 }">
						<div class="left">
								<a href="${rootPath}phone_lookVideo?rv_Id=${video.rv_Id}">
								<div class="mui-card-header mui-card-media" 
									style="height:40vw;background-image:url(${rootPath }${video.imgUrl})">
								</div>
								</a>
									<div class="mui-card-content">
									<div class="mui-card-content-inner">
									<a href="${rootPath}phone_lookVideo?rv_Id=${video.rv_Id}">
										<center><p>${video.name }</p><center>
									</a>
									</div>
								</div>
						</div>
					</c:if>
					<c:if test="${videoStatus.index%2==1 }">
					<div class="right">
					<a href="${rootPath}phone_lookVideo?rv_Id=${video.rv_Id}">
						<div class="mui-card-header mui-card-media" 
						style="height:40vw;background-image:url(${rootPath }${video.imgUrl})"></div>
					</a>
						<div class="mui-card-content">
						<div class="mui-card-content-inner">
							<a href="${rootPath}phone_lookVideo?rv_Id=${video.rv_Id}">
								<center><p>${video.name }</p></center>
							</a>
						</div>
					</div>
					</div>
					</c:if>
				</c:forEach>

				<!--分页注释掉了-->
				<!--<div class="mui-content-padded">
					<center>
				<ul class="mui-pagination mui-pagination-sm">
					<li class="mui-previous">
						<a href="#">
							&laquo;
						</a>
					</li>
					<li>
						<a href="#">
							1
						</a>
					</li>
					<li>
						<a href="#">
							2
						</a>
					</li>
					<li class="mui-active">
						<a href="#">
							3
						</a>
					</li>
					<li>
						<a href="#">
							4
						</a>
					</li>
					<li>
						<a href="#">
							5
						</a>
					</li>
					<li class="mui-next">
						<a href="#">
							&raquo;
						</a>
					</li>
				</ul>
				</center>
			</div>-->
				
				
			</div>
			<!--图文表格结束-->
			
		</div>
		<!--content结束-->
		<footer>
			<center><h6>视频以显示完毕，如需更多请进官网查看</h6></center>
		</footer>
		
		<script>
		mui.init({
			swipeBack:true //启用右滑关闭功能
		});
		var slider = mui("#slider");
		slider.slider({
			interval: 5000
		});
	</script>
	</body>
</html>
