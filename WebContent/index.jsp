<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body {
	background-image: url("image/11.jpg");
	background-size:cover;
	height: 400px;
	text-align: center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<div style="margin-top: 250px;">
		<div>
			<h1 style="color:white;font-size: 50px">学生管理系统</h1>
			<p style="font-size: 20px;">
				登陆 &nbsp;&nbsp;&nbsp;&nbsp;</a><a href="register.jsp">注册</a>
			</p>
		</div>
		<div>
			<form action="/StudentMS/Login" method="post">
				<p>
					userName: <input type="text" maxlength="10" name="userName" /></br>
				</p>
				<p>
					passWord: <input type="password" maxlength="16" name="passWord" /></br>
				</p>
				<p>
				<input type="submit" value="Login" />
					&nbsp;&nbsp;&nbsp;
					<input type="reset" value="reset" />
				</p>
			</form>
		</div>
</div>
</body>
</html>