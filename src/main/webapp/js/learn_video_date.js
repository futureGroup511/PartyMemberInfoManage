
var count=0;//计数器
var start; //用来储存视频开始观看时间
var end; // 视频结束时间
var duration; //学习时长
alert("载入成功");

function startVideo() {

	$.ajax({
		url: "ajax_validateTheme",
		type: 'POST',
		dataType: 'json',
		
		data:{"theme":theme},
		success: function(data){
			//请求成功时执行操作
			var d=eval("("+data+")");
			if("true"==d.msg){
				$("#tip-addTheme").text("该主题已经存在");
			}else{
				if(confirm("确认添加")){
					location.href="admin_addTheme?theme="+theme;
				}
			}
		}
	});

}

function stopPlay(){
	end = new Date();
	duration = end.getTime()-start.getTime();//观看时长 以秒计
	document.write("Hello World!")
	window.location.href="${rootPath}secretary/partySecretary_lookMyself";
	alert("观看时长"+duration);
	return "dheudhe";
}
/*	if (count==0) {
		start = new Date();
		count=count+1;
	}*/