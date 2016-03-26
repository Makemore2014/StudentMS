package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Impl.ImplStudent;
import pojo.Student;

/**
 * Servlet implementation class QueryStudent
 */
@WebServlet("/QueryStudent")
public class QueryStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置request 和 response 对象的编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Contet-type","text/html;charset=UTF-8");
		

		ImplStudent implStudent = new ImplStudent();

		String name = request.getParameter("name");

		ArrayList<Student> students = implStudent.queryStudent(name);
		// 如何把数据从servlet传递到视图页面

		if (students.size() > 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("queryStudent.jsp");
			request.setAttribute("students", students);
			request.getSession().setAttribute("studentId", students.get(0).getId());
			dispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			request.setAttribute("ErrMes", "查询失败！");
			request.setAttribute("page", "queryStudent.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
