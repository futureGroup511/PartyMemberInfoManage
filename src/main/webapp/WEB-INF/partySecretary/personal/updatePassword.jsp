<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改个人信息</title>
<link rel="stylesheet" href="${rootPath }css/bootstrap.css">
<link rel="stylesheet" href="${rootPath }css/partySecretary/changepassword.css">
<script src="${rootPath }js/jquery-2.2.3.min.js"></script>
<script src="${rootPath }js/bootstrap.js"></script>
</head>

<body>

<div id="header">
     <div class="header-left">
          <img src="${rootPath }images/header-logo.png">
      </div>
      <div class="header-center">
              <p class="top"><b><strong>河南科技学院信息工程学院党委主办</strong></b></p>
              <p class="bottom"><b><strong>河南科技学院党员在线</strong></b></p>
       </div>
       <div class="header-right">
             <div>
             	<form action="${rootPath }secretary/partySecretary_select" method="post">
    		     	<select name="type">
							<option value="news">时事新闻</option>
							<option value="video">学习园地</option>
				 	</select>
                  	<input type="text" name="search" placeholder="&nbsp;&nbsp;&nbsp;请输入您要搜索的内容">
                   	<button class="btn"><img src="${rootPath }images/sousuo.png" width="22" height="22"></button>
             	</form>
             </div>
       </div>
</div>
<div class="nav">
     <div class="row">
         <ul class="nav navbar-nav">
              <li><a href="${rootPath }secretary/pSForward_fIndex">网站首页</a></li>
              <li class="dropdown"><a href="#" data-toggle="dropdown" class="dropdown-toggle">通知消息<span class="caret"></span></a>
                   <ul class="dropdown-menu">
                   		<li><a href="${rootPath }secretary/partySecretary_informList">查看通知</a></li>
						<li><a href="${rootPath }secretary/pSForward_fAddInform">发布通知</a></li>
						<li><a href="${rootPath }secretary/pSForward_fManageInfom">管理通知</a></li>
                   </ul>
               </li>
              <li class="dropdown"><a href="#" data-toggle="dropdown" class="dropdown-toggle">党员管理<span class="caret"></span></a>
                   <ul class="dropdown-menu">
						<li><a href="${rootPath }secretary/partySecretary_lookOfPartyMember">查看所属党员个人信息</a></li>
						<li><a href="${rootPath }secretary/test_startTestLog">查看所属党员考试记录</a></li>
                   </ul>
               </li>
               				

              <li><a href="${rootPath }secretary/partySecretary_videoList">学习园地</a></li>
				<li><a href="${rootPath }secretary/pSForward_paperList">时事新闻</a></li>
				<li><a href="${rootPath }secretary/pSForward_startTest">在线考试</a></li>
               <li class="dropdown"><a href="#" data-toggle="dropdown" class="dropdown-toggle">个人中心<span class="caret"></span></a>
                   <ul class="dropdown-menu">
						<li><a href="${rootPath }secretary/partySecretary_lookMyself">个人信息</a></li>
						<li><a href="${rootPath }secretary/pSForward_fUpdataPerson">修改信息</a></li>
						<li><a href="${rootPath}secretary/partySecretary_getMyExamLog">考试报告</a></li>
						<li><a href="${rootPath}login_logout">退出登录</a></li>
                   </ul>
               </li>
              <li><a href="${rootPath}secretary/partySecretary_connectUs">联系我们</a></li>
         </ul>
     </div>
</div>

<!--以上为头部-->

<div id="body">
  <div id="body-one">
     <p><img src="${rootPath}images/topimg.png"> <span>您的位置：
     <a href="${rootPath }secretary/pSForward_fIndex">首页</a>&nbsp;&nbsp;>&nbsp;&nbsp;修改信息</span></p>
  </div>
  <div id="body-big">
   <div id="body-two">
     <p>提示：密码必须是字母和数字的组合长度为8到16位</p>
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
               		<p><input type="password" name="password1" id="password" class="form-control" placeholder="请输入新密码" required="required" autocomplete="off"/></p>
               		<p><input type="password" name="password2" id="newPassword" class="form-control" placeholder="请再次输入密码" required="required" autocomplete="off"/></p>
               		<button class="btn btn-primary sure" type="reset">重置</button>
               		<button class="btn btn-primary" type="submit" onclick="return judegePwd();">确认添加</button>
               </form>
            </div>
        </div>
       <div role="tabpanel" class="tab-pane" id="profile">
           <div id="body-three">
           		<form action="${rootPath}secretary/partySecretary_updatePhone" method="post">
              		<p><input type="text" name="phone" class="form-control" placeholder="请输入新的手机号" required="required" autocomplete="off" maxlength=""/></p>
               		<button class="btn btn-primary sure" type="reset">重置</button>
                	<button class="btn btn-primary" type="submit">确认添加</button>
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
		var pwd1=document.getElementById("password").value ;
		var pwd2=document.getElementById("newPassword").value ;
		if(pwd1==pwd2){
			return true;
		}else{
			alert("两次密码输入不一致，请重新输入");
			return false;
		}
	}

	
</script>
</html>