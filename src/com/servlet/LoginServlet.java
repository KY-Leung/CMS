package com.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.UserController;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		// System.out.println("In NewCaseServlet doPost"); 
//		Enumeration<String> paramNames = request.getParameterNames();
//		// for testing
//	   while(paramNames.hasMoreElements()) {
//		   String paramName = (String)paramNames.nextElement();
//		   System.out.println("paramName: " + paramName); 
//		   String paramValue = request.getParameter(paramName);
//		   System.out.println("paramValue: " + paramValue);
//	   }
		
	   String username = request.getParameter("username"); 
	   String password = request.getParameter("password"); 
	   
	   // login method to check login
	   if(authenticate_login(username, password)) {
		   HttpSession session = request.getSession();
		   System.out.println("session id: " + session.getId()); 
		   
		   session.setAttribute("username", username);	
		   
		   request.setAttribute("username", username);
		   request.getRequestDispatcher("./index.jsp").forward(request, response);;
	   } else {
		   request.setAttribute("login_attempt", false);
		   request.getRequestDispatcher("./login.jsp").forward(request, response);;
	   }
	   
	    
	   
	}

	private boolean authenticate_login(String username, String password) {
		// TODO Auto-generated method stub
		UserController user_controller = new UserController();
		
		return user_controller.isAuthenticated(username, password); 
	}

}
