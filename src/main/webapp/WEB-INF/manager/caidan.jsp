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

<div class="container">
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
                <dt>文章管理<img src="images/select_xl01.png"></dt>
            </dl>
    </div>

</div>

<script type="text/javascript" src="${rootPath }js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
$(".leftsidebar_box dt").css({"background-color":"#33333D"});
$(".leftsidebar_box dt img").attr("src","${rootPath }images/select_xl01.png");
$(function(){
    $(".leftsidebar_box dd").hide();
    $(".leftsidebar_box dt").click(function(){
        $(".leftsidebar_box dt").css({"background-color":"#33333D"})
        $(this).css({"background-color": "#6C7F81"});
        $(this).parent().find('dd').removeClass(("menu_chioce"),6000);
        $(".leftsidebar_box dt img").attr("src","${rootPath }images/select_xl01.png");
        $(this).parent().find('img').attr("src","${rootPath }images/select_xl01.png");
        $(".menu_chioce").slideUp();
        $(this).parent().find('dd').slideToggle();
    $(this).parent().find('dd').addClass("menu_chioce");
})
})
</script>
</body>
</html>