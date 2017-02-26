<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改个人信息</title>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css">
<link rel="stylesheet" href="${rootPath }css/partySecretary/red_tou.css">
<link rel="stylesheet" href="${rootPath }css/partySecretary/changepassword.css">
<script src="${rootPath }js/jquery-2.2.3.min.js"></script>
<script src="${rootPath }js/bootstrap.js"></script>
<script src="${rootPath }js/sha1.js"></script>
</head>

<body>

<%@ include file="../head.jsp"%>

<!--以上为头部-->

<div id="body">
  <div id="body-one">
     <p><img src="${rootPath}images/topimg.png"> <span>您的位置：
     <a href="${rootPath }secretary/pSForward_fIndex">首页</a>&nbsp;&nbsp;>&nbsp;&nbsp;修改信息</span></p>
  </div>
  <div id="body-big">
   <div id="body-two">
     <p>提示：密码必须是字母和数字的组合,长度为8~16位</p>
   </div>
  <div id="body-four">
          <ul class="nav nav-tabs" role="tablist">
                  <li role="presentation" class="active"><a href="#home" role="tab" data-toggle="tab">修改密码</a></li>
                  <li role="presentation"><a href="#profile" role="tab" data-toggle="tab">修改手机号</a></li>
          </ul>
 <!-- Tab panes -->
     <div class="tab-content">
        <div role="tabpanel" class="tab-pane active" id="home">
           <div id="body-three">
           		<form action="${rootPath}secretary/partySecretary_updatePassword" method="post" >          			
               		<p><input type="password"  id="password" class="form-control" placeholder="请输入新密码" required="required" pattern="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$" autocomplete="off"/></p>
               		<p><input type="password" name="password2" id="newPassword" class="form-control" placeholder="请再次输入密码" required="required" pattern="^.{8,}$"  autocomplete="off"/></p>              		
               		<button class="btn btn-primary" type="submit" onclick="return judegePwd();">确认添加</button>
               		<button class="btn btn-primary sure" type="reset">重置</button>
               </form>
            </div>
        </div>
       <div role="tabpanel" class="tab-pane" id="profile">
           <div id="body-three">
           		<form action="${rootPath}secretary/partySecretary_updatePhone" method="post">
              		<p><input type="text" name="phone" class="form-control" placeholder="请输入新的手机号" required="required" pattern="^1\d{10}$" autocomplete="off"/></p>               		
                	<button class="btn btn-primary" type="submit">确认添加</button>
                	<button class="btn btn-primary sure" type="reset">重置</button>
                </form>
            </div>
       </div>
   </div>
 </div>
 </div>
</div>



</body>
<script type="text/javascript">
	var notice = "${notice}";
	if(notice===""){
		
	}else{
		alert(notice);
	}
	
	
	function judegePwd() {		
		var pwd1=document.getElementById("password");
		var pwd2=document.getElementById("newPassword");
		if(pwd1.value ==pwd2.value ){
			var sha = hex_sha1(pwd1.value );		
			pwd2.value=sha;			
			return true;
		}else{
			alert("两次密码输入不一致，请重新输入");
			return false;
		}
	}

	
</script>
</html>