<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${rootPath }js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${rootPath }js/vector.js"></script>
<style type="text/css">
*{margin: 0;padding: 0;}
#container {
	position: absolute;
	height: 100%;
	width: 100%;
	z-index:100;
}
#output {
	width: 100%;
	height: 100%;
}
.color{
	width: 120px;
	height: 20px;
	margin: 0 auto;
	position: fixed;
	left: 50%;
	margin-left: -60px;
	bottom: 20px;
}
.color li{
	float: left;
	margin: 0 5px;
	width: 20px;
	height: 20px;
	background: #ccc;
	box-shadow: 0 0 4px #FFF;
	list-style: none;
	cursor: pointer;
}
.color li:nth-child(1){
	background: #002c4a;
}
.color li:nth-child(2){
	background: #35ac03;
}
.color li:nth-child(3){
	background: #ac0908;
}
.color li:nth-child(4){
	background: #18bbff;
}

</style>
<script type="text/javascript">
$(function(){
	// 初始化 传入dom id
	var victor = new Victor("container", "output");
	var theme = [
			["#002c4a", "#005584"],
			["#35ac03", "#3f4303"],
			["#ac0908", "#cd5726"],
			["#18bbff", "#00486b"]
		]
	$(".color li").each(function(index, val) {
		var color = theme[index];
		 $(this).mouseover(function(){
			victor(color).set();
		 })
	});
});
</script>
</head>
<body>
<div id="container"><div id="output"></div></div>
</body>
</html>