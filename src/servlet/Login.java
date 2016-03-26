package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.Name;

import Impl.ImplUser;
import pojo.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置request 和 response 对象的编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		User user = new User();
		user.setUserName(request.getParameter("userName"));
		user.setPassWord(request.getParameter("passWord"));
		
		System.out.println(user.getUserName());
		System.out.println(user.getPassWord());
		
		ImplUser implUser = new ImplUser();
		if(implUser.login(user)){
			request.setAttribute("name", user.getUserName());
			//登陆成功，把用户信息写入session
			request.getSession().setAttribute("user", user.getUserName());
			RequestDispatcher rd = request.getRequestDispatcher("queryStudent.jsp");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("Fail");
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			request.setAttribute("ErrMes", "登陆失败用户名或密码错误！");
			request.setAttribute("page", "index.jsp");
			
			rd.forward(request,response);
			
		}
	}

}
