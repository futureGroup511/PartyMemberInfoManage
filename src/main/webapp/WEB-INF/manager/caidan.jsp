<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>caidan</title>
<link rel="stylesheet" href="${rootPath}css/manage/caidan.css">
</head>
<body id="bg">
<div class="container" >
    <div class="leftsidebar_box">
        <div class="line"></div>
           <dl class="system_log">
                <dt onClick="changeImage()"><img src="${rootPath }images/select_xl01.png">书记管理</dt>
                <dd><a target="main" href="${rootPath }manage/partSecretary_add">增加书记</a></dd>
                <dd><a target="main" href="${rootPath }manage/partSecretary">管理书记</a></dd>
            </dl>
        
            <dl class="custom">
                <dt onClick="changeImage()"><img src="${rootPath }images/select_xl01.png">党员管理</dt>
                <dd><a target="main" href="${rootPath }manage/partMember_add">增加党员</a></dd>
                <dd><a target="main" href="${rootPath }manage/partMember">管理党员</a></dd>
            </dl>
        
            <dl class="channel">
                <dt>视频管理<img src="${rootPath }images/select_xl01.png"></dt>
                <dd><a target="main" href="${rootPath }manage/uploadVideo">上传视频</a></dd>
                <dd><a target="main" href="${rootPath }manage/manageVideo">管理视频</a></dd>
                
            </dl>
            
			<dl class="channel">
				<dt>
					文章管理<img src="images/select_xl01.png">
				</dt>
				<dd>
					<a target="_blank" href="${rootPath }manage/fPaper_addPaper">添加文章</a>
				</dd>
				<dd>
					<a target="main" href="${rootPath }manage/fPaper_fManagePaper">管理文章</a>
				</dd>
			</dl>
            
             <dl class="channel">
                <dt>考试管理<img src="images/select_xl01.png"></dt>
                <dd><a target="main" href="${rootPath}manage/import_linking">上传试卷</a></dd>
                 <dd><a target="main" href="${rootPath}manage/import_toAddQuestion">添加试题</a></dd>
                <dd><a target="main" href="${rootPath}manage/testManage_getTestPaper">管理试卷</a></dd>
                 <dd><a target="main" href="${rootPath}manage/testManage_getQuestion">管理试题</a></dd>
                  <dd><a target="main" href="${rootPath}manage/testManage_toStartTest">开启考试</a></dd>
            </dl>


			<dl class="channel">
				<dt>
					通知管理<img src="images/select_xl01.png">
				</dt>
				<dd>
					<a target="main" href="${rootPath }manage/inform_add">增加通知</a>
				</dd>
				<dd>
					<a target="main" href="${rootPath }manage/inform">管理通知</a>
				</dd>
			</dl>

			<dl class="channel">
				<dt>
					个人中心<img src="${rootPath }images/select_xl01.png">
				</dt>
				<dd>
					<a target="main" href="${rootPath }manage/info">个人信息</a>
				</dd>
				<dd>
					<a target="_top" href="${rootPath }manage/info_logout">退出登录</a>
				</dd>
			</dl>

		</div>

	</div>

	<script type="text/javascript" src="${rootPath }js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript">
		$(".leftsidebar_box dt").css({
			"background-color" : "#003C60"
		});
		$(".leftsidebar_box dt img").attr("src",
				"${rootPath }images/select_xl01.png");
		$(function() {
			$(".leftsidebar_box dd").hide();
			$(".leftsidebar_box dt").click(
					function() {
						$(".leftsidebar_box dt").css({
							"background-color" : "#003C60"
						})
						$(this).css({
							"background-color" : "#006EAE"
						});
						$(this).parent().find('dd').removeClass(
								("menu_chioce"), 6000);
						$(".leftsidebar_box dt img").attr("src",
								"${rootPath }images/select_xl01.png");
						$(this).parent().find('img').attr("src",
								"${rootPath }images/select_xl01.png");
						$(".menu_chioce").slideUp();
						$(this).parent().find('dd').slideToggle();
						$(this).parent().find('dd').addClass("menu_chioce");
					})
		})
	</script>
</body>
</html>