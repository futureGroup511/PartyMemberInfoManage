
var count =0;//计数器
var start ;//视频开始
var end ;//视频结束
var watchLength;//观看时长

$(document).ready(function() {
	/*startVideo();*/
	window.onbeforeunload = onbeforeunload_handler;  
});

//播放视频时触发的事件
function startVideo(){

	/*
		当党员进入这个页面时，他应该把他自身关于这个视频的访问记录也带过来
	*/
	
	
	/****************************/

	if (count==0) {		
		
		start = new Date();
		count=count+1;
		var oldcurrentTime=document.getElementById("oldcurrentTime").value;
		alert(oldcurrentTime);
		
		document.getElementById("videos").currentTime=oldcurrentTime;

	}
}

function onbeforeunload_handler(){
	end = new Date();
	watchLength = end.getTime()-start.getTime();//这是毫秒
	var currentTime = document.getElementById("videos").currentTime; 
	var videoId=document.getElementById("videoId").value;

    $.ajax({
    	url: "/PartyMemberInfoManage/party/partyMemberAction_updateLearnTime",
    	type: 'POST',
    	dataType: 'json',
    	data:{
    		"time":watchLength,
    		"currentTime":currentTime,
    		"videoId":videoId
    	},
    });   
}  


  
