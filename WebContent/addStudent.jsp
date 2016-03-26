<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	if(request.getSession().getAttribute("user") == null)
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Student</title>
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
		<a href="addStudent.jsp">添加学生</a> <a href="queryStudent.jsp">学生列表</a>
		<a href="/StudentMS/Logout">退出</a>
		<form action="/StudentMS/AddStudent" method="post">
			<table border="0" width="238" height="252">

				<p>
				<tr>
					<td>number</td>
					<td><input type="text" name="number" /></td>
				</tr>

				</p>
				<p>
				<tr>
					<td>name</td>
					<td><input type="text" name="name" /></td>
				</tr>

				</p>
				<p>
				<tr>
					<td>sex</td>
					<td><input type="text" name="sex" /></td>
				</tr>
				</p>
				<p>
				<tr>
					<td>age</td>
					<td><input type="text" name="age" /></td>
				</tr>
				</p>
				<p>
				<tr>
					<td>address</td>
					<td><input type="text" name="address" /></td>
				</tr>
				</p>
				<p>
				<tr align="center">
					<td colspan="2"><input type="submit" value="save">&nbsp;&nbsp;
						<input type="submit" value="quit"></td>
				</tr>
				</p>
			</table>
		</form>
		</form>
	</center>
</body>
</html>