package com.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.UserController;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		Enumeration<String> paramNames = request.getParameterNames();
//		// for testing
	   while(paramNames.hasMoreElements()) {
		   String paramName = (String)paramNames.nextElement();
		   System.out.println("paramName: " + paramName); 
		   String paramValue = request.getParameter(paramName);
		   System.out.println("paramValue: " + paramValue);
	   }
	    
	   String username = request.getParameter("username"); 
	   String password = request.getParameter("password"); 
	   
	   UserController user_controller = new UserController(); 
	   
	   // check to see whether username already exists
	   if (user_controller.usernameExists(username)) {
		   request.setAttribute("username exists", true);
		   request.getRequestDispatcher("./login.jsp").forward(request, response);;
	   } else {
		   String fullname = request.getParameter("fullname"); 
		   String email = request.getParameter("email"); 
		   int phone_number = Integer.parseInt(request.getParameter("phonenumber"));
		   user_controller.createUser(username, password, fullname, phone_number, 0);
		   request.setAttribute("account created", username);
		   request.getRequestDispatcher("./login.jsp").forward(request, response);;
	   }
	   
	}

}
