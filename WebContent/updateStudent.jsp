<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if (request.getSession().getAttribute("user") == null) {
		System.out.print("yes");
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	if(request.getParameter("number") == null)
	{
		System.out.print("yes");
		RequestDispatcher dispatcher = request.getRequestDispatcher("queryStudent.jsp");
		dispatcher.forward(request, response);
	}

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body {
	background-image: url("image/bg.png");
	background-repeat: no-repeat;
	background-position: center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新学生信息</title>
</head>
<body>


	<center>
		<div style="margin-top: 150px;">
			<h3>更新信息</h3>
			<br /> <a href="addStudent.jsp">添加学生</a> <a href="queryStudent.jsp">学生列表</a>
			<a href="/StudentMS/Logout">退出</a>

			<form action="/StudentMS/UpdateStudent" method="post">
				<table border="0" width="238" height="252">
					<tr>
						<td>number</td>
						<td><input type="text" name="number"
							value="<%=request.getParameter("number")%>" /><br /></td>
					</tr>

					<tr>
						<td>name</td>
						<td><input type="text" name="name"
							value="<%=request.getParameter("name")%>" /><br /></td>
					</tr>
					<tr>
						<td>sex</td>
						<td><input type="text" name="sex"
							value="<%=request.getParameter("sex")%>" /><br /></td>
					</tr>
					<tr>
						<td>age</td>
						<td><input type="text" name="age"
							value="<%=request.getParameter("age")%>" /><br /></td>
					</tr>
					<tr>
						<td>address</td>
						<td><input type="text" name="address"
							value="<%=request.getParameter("address")%>" /></td>
					</tr>
					<tr>
						<td><input type="hidden" name="id"
							value="<%=request.getParameter("id")%>" /></td>
					</tr>
				</table>
				<input type="submit" value="update" /> 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="reset" />
			</form>
		</div>
	</center>
</body>
</html>