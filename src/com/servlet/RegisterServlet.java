package com.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.SettingsManager;
import com.control.UserController;

/**
 * Servlet that does initial parsing for requests related to registering new users
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Constructor
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		   
		   // create settings
		   SettingsManager settings_manager = new SettingsManager(username); 
		   settings_manager.createSettings(false, false, false, false, false);
		   
		   request.setAttribute("account created", username);
		   request.getRequestDispatcher("./login.jsp").forward(request, response);;
	   }
	   
	}

}
