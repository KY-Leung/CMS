package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.SettingsManager;
import com.control.UserController;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		UserController uc=new UserController();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		int phoneNumber=0;
		if(!request.getParameter("phoneNumber").equals(""))
			phoneNumber=Integer.parseInt(request.getParameter("phoneNumber"));
		System.out.println(username+password+name+phoneNumber);
		if(!uc.usernameExists(username)){
			uc.createUser(username, password, name, phoneNumber,UserController.PUBLIC_USER);
			SettingsManager sm=new SettingsManager(username);
			sm.createSettings(false, false, false, false, false);
			out.println("<html><body>Successfully registered account<br>You will be redirected to the login page shortly</body></html>");
			response.setHeader("Refresh", "3; URL=mainpage.html");
		}
		else{
			RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
			request.setAttribute("check", "exists");
			rd.forward(request, response);
		}

	}

}
