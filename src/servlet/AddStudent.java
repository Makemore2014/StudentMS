package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Impl.ImplStudent;
import pojo.Student;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudent() {
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

		System.out.println("DoPOST");
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		Student student = new Student();
		student.setNumber(request.getParameter("number"));
		student.setName(request.getParameter("name"));
		student.setSex(request.getParameter("sex"));
		student.setAge(request.getParameter("age"));
		student.setAddress(request.getParameter("address"));
		ImplStudent implStudent = new ImplStudent();

		if (implStudent.AddStudent(student)) {
			System.out.println("添加成功！！");
			RequestDispatcher rDispatcher = request.getRequestDispatcher("addStudent.jsp");
			rDispatcher.forward(request, response);

		}
		else
		{
			System.out.println("Fail");
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			request.setAttribute("ErrMes", "录入失败！");
			request.setAttribute("page", "addStudent.jsp");
			
			rd.forward(request,response);
			
		}
	}

}
