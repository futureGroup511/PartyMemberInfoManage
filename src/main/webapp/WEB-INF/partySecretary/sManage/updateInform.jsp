<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${rootPath }css/bootstrap.css">
<link rel="stylesheet" href="${rootPath }css/partySecretary/red_tou.css">
<link rel="stylesheet" href="${rootPath }css/partySecretary/message.css">
<script src="${rootPath }js/jquery-2.2.3.min.js"></script>
<script src="${rootPath }js/bootstrap.js"></script>
<script type="text/javascript" charset="utf-8" src="${ rootPath}ueditor1_4_3/ueditor.config.js"></script>

<script type="text/javascript" charset="utf-8" src="${rootPath }ueditor1_4_3/ueditor.all.min.js"></script>

<script type="text/javascript" charset="utf-8" src="${rootPath}ueditor1_4_3/lang/zh-cn/zh-cn.js"></script>
<title>修改通知</title>
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

<%@ include file="../head.jsp"%>

<!--以上为头部-->


<div id="body">
 <div id="body-one">
   <p><img src="${rootPath }images/topimg.png"> <span>您的位置：
   <a href="${rootPath }secretary/pSForward_fIndex">首页</a>&nbsp;&nbsp;>&nbsp;&nbsp;通知消息&nbsp;&nbsp;>&nbsp;&nbsp;修改通知</span></p>
 </div>
 <form  method="POST" action="${rootpath }secretary/partySecretary_updateInform"  onsubmit="modifyContent()">
 <input type="hidden" name="inform.info_Id" value="${inform.info_Id }">
 <div id="body-two">
    <p>重要标题： <input type="text" name="inform.title" placeholder=""></p>
    <p>通知内容：</p>
 </div>
 <div id="body-three">
 		<script id="editor" type="text/plain" style="width: 1024px; height: 500px;"></script>
 </div>
 <textarea rows="20" cols="25" name="inform.content"  id="content"   style="display:none"></textarea>
 
 <div id="body-four">
   <button class="btn btn-primary">一键发布</button>
 </div>
   </form>
</div>


</body>

 <footer id="footer-warp"><!--页脚开始-->
		<p class="footer"><a href="">网站声明</a> &nbsp; &nbsp;<span>|</span> &nbsp; &nbsp;<a href="">关于我们 &nbsp; &nbsp;</a><span>|</span> &nbsp; &nbsp;<a href="">联系我们</a></p>
		<p>Copyright @ 2016 All rights reserved.　　版权所有：河南科技学院党委</p>
</footer><!--页脚结束-->	
<script type="text/javascript">
var notice = "${notice}";
if(notice!=""){
	alert(notice);
}else{
	
}
</script>
</html>