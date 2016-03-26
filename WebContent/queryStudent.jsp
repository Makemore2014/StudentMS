<%@page import="pojo.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.ArrayList" pageEncoding="UTF-8"%>
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
<title>查询学生信息</title>
</head>
<body>
<%
	if(request.getSession().getAttribute("user") == null)
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
%>
	<center>
		<h1>Welcome to use my student Management system!!</h1>
	</center>

	<center></center>
	<center><%=new java.util.Date().toString()%></center>

	<center>
		<P>欢迎你 ： <%=request.getSession().getAttribute("user") %></P>
		<a href="addStudent.jsp">添加学生</a> <a href="queryStudent.jsp">学生列表</a>
		<a href="/StudentMS/Logout">退出</a>
		<form action="/StudentMS/QueryStudent" method="post">
			<p>
				关键字: <input type="text" name="name">
			</p>

			<p>
				<input type="submit" value="query">
			</p>
		</form>
		<table border="1">
			<tr>

				<td>Number</td>
				<td>Name</td>
				<td>Sex</td>
				<td>Age</td>
				<td>Address</td>
				<td>Update</td>
				<td>Delete</td>
			</tr>
			<%
				ArrayList<Student> students = (ArrayList) request.getAttribute("students");
				if (students != null) {
					for (int i = 0; i < students.size(); i++) {
			%>
			<tr>
				<td><%=students.get(i).getNumber()%></td>
				<td><%=students.get(i).getName()%></td>
				<td><%=students.get(i).getSex()%></td>
				<td><%=students.get(i).getAge()%></td>
				<td><%=students.get(i).getAddress()%></td>
				<td><a
					href="/StudentMS/updateStudent.jsp?
					number=<%=students.get(i).getNumber()%>
					&name=<%=students.get(i).getName()%>
					&sex=<%=students.get(i).getSex()%>
					&age=<%=students.get(i).getAge()%>
					&address=<%=students.get(i).getAddress()%>">Update</a>

				</td>
				<td>
					<form action="/StudentMS/DeleteStudent" method="post">
						<input type="submit" value="Delete"
							style="background: none; border: 0px;"> <input
							type="hidden" name="id" value="<%=students.get(i).getId()%>">
					</form>
				</td>
			</tr>
			<%
				}
				}
			%>
		</table>
	</center>
</body>
</html>