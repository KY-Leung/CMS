package com.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangeUserSettings
 */
@WebServlet("/ChangeUserSettings")
public class ChangeUserSettingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeUserSettingsServlet() {
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
		System.out.println("In NewInfoServlet doPost"); 
		Enumeration<String> paramNames = request.getParameterNames();
		// for testing
	   while(paramNames.hasMoreElements()) {
		   String paramName = (String)paramNames.nextElement();
		   System.out.println("paramName: " + paramName); 
		   String paramValue = request.getParameter(paramName);
		   System.out.println("paramValue: " + paramValue);
	   }
		
		
		doGet(request, response);
	}

}
