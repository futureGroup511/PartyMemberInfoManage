
	var count =0;//计数器
	var start ;//视频开始
	var end ;//视频结束
	var watchLength;//观看时长

$(document).ready(function() {
	startVideo();
	window.onbeforeunload = onbeforeunload_handler;  
});


function startVideo(){
	if (count==0) {
		start = new Date();
		count=count+1;
	}
}

function onbeforeunload_handler(){
	end = new Date();
	watchLength = end.getTime()-start.getTime();//这是毫秒
	
    $.ajax({
    	url: "/PartyMemberInfoManage/party/partyMemberAction_updateLearnTime",
    		
    	type: 'POST',
    	dataType: 'json',
    	data:{"time":watchLength},
    });   
}  


  
