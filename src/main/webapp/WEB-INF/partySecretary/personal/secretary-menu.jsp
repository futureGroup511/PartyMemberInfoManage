<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书记的主菜单</title>
</head>
<body>
	<div>
		<div>
			<ol>
				<li>
					个人中心
					<ol>
						<li><a href="${rootPath }secretary/partySecretary_lookMyself">查看个人信息</a></li>
						<li><a href="${rootPath }secretary/pSForward_fUpdataPerson">修改个人信息</a></li>
					</ol>
				</li>
				<li><a href="${rootPath }secretary/partySecretary_lookOfPartyMember">查看所管理的党员信息</a></li>
				<li><a href="${rootPath }secretary/pSForward_videoList">在线视频</a></li>
				<li><a href="">在线文章</a></li>
				<li><a href="">在线测试</a></li>
				<li><a href="">在线考试</a></li>
			</ol>
		</div>
	</div>
</body>
</html>