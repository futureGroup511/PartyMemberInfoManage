<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" charset="utf-8" src="${ rootPath}ueditor1_4_3/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${rootPath }ued
itor1_4_3/ueditor.all.min.js"></script>
<script type="text/javascript" charset="utf-8" src="${rootPath}ueditor1_4_3/lang/zh-cn/zh-cn.js"></script>
<title>修改党委简介</title>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css" />
<style type="text/css">
.row{
	margin:10px 0;
}

</style>
<script type="text/javascript">
    function modifyContent() {
        var content = document.getElementById("content");

        var arr = [];

        arr.push(UE.getEditor('editor').getContent());

        content.value = arr;

    }
</script>

<script type="text/javascript">
var ue = UE.getEditor('editor', {
	toolbars: [
	           [
	               'undo', //撤销
	               'redo', //重做
	               'bold', //加粗
	               'indent', //首行缩进
	               'italic', //斜体
	               'formatmatch', //格式刷
	               'pasteplain', //纯文本粘贴模式
	               'selectall', //全选
	               'horizontal', //分隔线
	               'removeformat', //清除格式
	               'inserttitle', //插入标题
	               'cleardoc', //清空文档
	               'fontfamily', //字体
	               'fontsize', //字号
	               'paragraph', //段落格式
	               'simpleupload', //单图上传
	               'link', //超链接
	               'emotion', //表情
	               'spechars', //特殊字符
	               'searchreplace', //查询替换
	               'justifyleft', //居左对齐
	               'justifyright', //居右对齐
	               'justifycenter', //居中对齐
	               'justifyjustify', //两端对齐
	               'forecolor', //字体颜色
	               'backcolor', //背景色
	               'insertorderedlist', //有序列表
	               'insertunorderedlist', //无序列表
	               'fullscreen', //全屏
	               'rowspacingtop', //段前距
	               'rowspacingbottom', //段后距
	               'imagenone', //默认
	
	               'imagecenter', //居中
	               'lineheight', //行间距
	               'edittip ', //编辑提示
	               'customstyle', //自定义标题
	               'autotypeset', //自动排版
	               'background', //背景
	           ]
	       ],
    autoHeightEnabled: true,
    autoFloatEnabled: true
});
</script>
</head>


<body>
	<ol class="breadcrumb">
		 <li>当前位置：</li>
	    <li class="active">修改党委简介</li>
	</ol>
	<div class="container">
	
	
	
	<form action="${rootPath }manage/partyIntroduction_updateDo" method="post"   onsubmit="modifyContent()">

			<div class="row">
			
			<textarea rows="20" cols="25" name="introduction"  id="content"   style="display:none"></textarea><br>
			 <p>正文：</p>
             <script id="editor" type="text/plain" style="width:100%; height: 500px;">${partyIntroduction.introduction}</script>
			<button type="submit" class="btn btn-success" style="width:100%;margin-top:20px;">确认修改</button>
			</div>
		</form>

		<div class="background navbar-fixed-top"  style="position:absolute; z-index:-1;width:100%;height:100%;opacity:0.1;">
    		<img  class="img-responsive" width="100%;" src="${rootPath }images/577a4c594718d_610.jpg" />
    	</div>
    </div>
</body>
<script type="text/javascript"  src="${rootPath }js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	var remind="${notice}";
	if(remind===""){
	}else{
		alert(remind);
	}
});
</script>
</html>