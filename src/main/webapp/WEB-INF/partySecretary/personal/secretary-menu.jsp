<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书记的主页</title>
</head>
<body>
	<div>
		<div>
			<ol>
				<li>
					个人中心
					<ol>
						<li><a href="${rootPath }secretary/partySecretary_lookMyself">个人信息</a></li>
						<li><a href="${rootPath }secretary/pSForward_fUpdataPerson">修改信息</a></li>
						<li><a href="${rootPath}secretary/partySecretary_getMyExamLog">考试报告</a></li>
					</ol>
				</li>
				<li><a href="${rootPath }secretary/partySecretary_lookOfPartyMember">党员管理</a></li>
					<ol>
						<li><a href="${rootPath }secretary/partySecretary_lookOfPartyMember">查看所属党员个人信息</a></li>
						<li><a href="${rootPath }secretary/test_startTestLog">查看所属党员考试记录</a></li>
					</ol>
				
				<li><a href="${rootPath }secretary/partySecretary_videoList">在线视频</a></li>
				<li><a href="${rootPath }secretary/pSForward_paperList">在线文章</a></li>
				<li><a href="${rootPath }secretary/pSForward_startTest">在线考试</a></li>
				<li><a href="${rootPath }secretary/pSForward_paperList">通知消息</a>
					<ol>
						<li><a href="${rootPath }secretary/partySecretary_informList">查看通知</a></li>
						<li><a href="${rootPath }secretary/pSForward_fAddInform">发布通知</a></li>
						<li><a href="${rootPath }secretary/pSForward_fManageInfom">管理通知</a></li>
					</ol>
				</li>
				<li><a href="${rootPath }secretary/pSForward_paperList">联系我们</a></li>
			</ol>
		</div>
	</div>
</body>
</html>