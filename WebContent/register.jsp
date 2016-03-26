<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<style type="text/css">
body {
	background-image: url("image/bg.png");
	background-repeat: no-repeat;
	background-position: center;
}
</style>
</head>
<body>
	<center>
		<div style="margin-top: 100px;">
			<h1>学生管理系统</h1>
			<p style="font-size: 20px;">注册 &nbsp;&nbsp;&nbsp;&nbsp;</a><a href="index.jsp">登录</a></p>
		</div>
		<div>
			<form action="/StudentMS/Register" method="post">
				<p>
					userName: <input maxlength="10" type="text" name="userName" /></br>
				</p>
				<p>
					passWord: <input maxlength="16" type="password" name="passWord" /></br>
				</p>
				<p>
					<input type="submit" value="register" />
					<input type="reset" value="reset" />
					
				</p>
			</form>
		</div>
	</center>
</body>
</html>