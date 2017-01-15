<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试优酷视频</title>
</head>
<body>


<div id="youkuplayer" style="width:480px;height:400px"></div>


</body>
<script type="text/javascript" src="//player.youku.com/jsapi"></script>

<script type="text/javascript">

	player = new YKU.Player('youkuplayer',{
	
	styleid: '0',
	
	client_id: 'cffe27a3c30bac41',//应用id
	
	vid: 'XMjI4NzE0MjA1Ng',//视频id
	
	newPlayer: true,
	events:{

		onPlayStart: function(){//视频开始播放时触发此事件
			
		}

	}

});

function seekTo(s){//设置当前播放时间
		player.seekTo(s);
}

function currentTime(){//得到当前时间
		return player.currentTime();
}
</script>

</html>