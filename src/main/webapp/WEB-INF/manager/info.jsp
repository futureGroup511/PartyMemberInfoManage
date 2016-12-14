<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${rootPath }js/jquery-3.1.1.min.js"></script>

</head>
<body>
 <div class="content">
	<form action="${rootPath}manage/change_info" method="post">
	${remind }
		<table class="main">
			<tbody>
				<tr>
					<td>账号</td>
					<td>${user.account }</td>

				</tr>
				<tr>
					<td>身份</td>
					<td>${user.sort }</td>
				</tr>
				<tr>
					<td>用户名</td>
					<td><input name="user.username" value="${user.username}"></td>
					<td><button>修改</button></td>

				</tr>
				<tr>
					<td>密码</td>
					<td><input name="user.password" value="******"></td>
					<td><button>修改</button></td>
				</tr>
				<tr>
					<td>手机号</td>
					<td><input name="user.phoneNo" value="${user.phoneNo}"></td>
					<td><button>修改</button></td>
				</tr>

				<tr>
					<td>年龄</td>
					<td><input name="user.age" value="${user.age}"></td>
					<td><button>修改</button></td>
				</tr>
				<tr>
					<td>性别</td>
					<td><input name="user.sex" value="${user.sex}"></td>
					<td><button>修改</button></td>
				</tr>

			</tbody>

		</table>
		<input type="submit" value="修改">
		
		</form>
	</div>
</body>
<script type="text/javascript">
	var changeUrl = "${rootPath}manage/change_info";
	$("button").click(function() {
		var str = $(this).parent().prev().find("input").first();
		var name = str.attr('name');
		var val = str.val();
		
		$.post(changeUrl, {
			name : val
		}, function(result) {
			alert("修改成功");
		});
	});
</script>
</html>