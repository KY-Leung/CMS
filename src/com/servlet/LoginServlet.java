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
 * Servlet that does initial parsing for requests related to users logging into the system
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
	 * Called by the server (via the service method) to allow a servlet to handle a GET request.
	 * 
	 * @param request	object that contains the request the client has made of the servlet
	 * @param response 	object that contains the response the servlet sends to the client
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * Called by the server (via the service method) to allow a servlet to handle a POST request. 
	 * The HTTP POST method allows the client to send data of unlimited length to the Web server 
	 * a single time and is useful when posting information such as credit card numbers.
	 * 
	 * @param request	object that contains the request the client has made of the servlet
	 * @param response 	object that contains the response the servlet sends to the client
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   String username = request.getParameter("username"); 
	   String password = request.getParameter("password"); 
	   
	   // login method to check login
	   if(authenticate_login(username, password)) {
		   HttpSession session = request.getSession();
		   System.out.println("session id: " + session.getId()); 
		   System.out.println("username: " + username);
		   
		   session.setAttribute("username", username);	
		   request.setAttribute("username", username);
		   request.getRequestDispatcher("./index.jsp").forward(request, response);;
	   } else {
		   request.setAttribute("login_attempt", false);
		   request.getRequestDispatcher("./login.jsp").forward(request, response);;
	   }
	}

	/**
	 * Convenience method to check whether a username-password pair input is authentic
	 * @param username	username submitted by user
	 * @param password	password submitted by user		
	 * @return			true if username-password is authentic
	 */
	private boolean authenticate_login(String username, String password) {
		// TODO Auto-generated method stub
		UserController user_controller = new UserController();
		
		return user_controller.isAuthenticated(username, password); 
	}

}
