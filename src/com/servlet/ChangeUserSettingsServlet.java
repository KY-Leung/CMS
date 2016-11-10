package com.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.SettingsManager;

/**
 * Servlet that does initial parsing for requests related to changing user's settings
 */
@WebServlet("/ChangeUserSettings")
public class ChangeUserSettingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Constructor
     * @see HttpServlet#HttpServlet()
     */
    public ChangeUserSettingsServlet() {
        super();
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
		System.out.println("In NewInfoServlet doPost"); 
//		Enumeration<String> paramNames = request.getParameterNames();
//		// for testing
//	   while(paramNames.hasMoreElements()) {
//		   String paramName = (String)paramNames.nextElement();
//		   System.out.println("paramName: " + paramName); 
//		   String paramValue = request.getParameter(paramName);
//		   System.out.println("paramValue: " + paramValue);
//	   }
	   
	   boolean fire_notification = request.getParameter("fire") != null; 
	   boolean haze_notification = request.getParameter("haze") != null; 
	   boolean shelter_notification = request.getParameter("shelter") != null; 
	   boolean mask_notification = request.getParameter("mask") != null; 
	   boolean sms_notification = request.getParameter("sms") != null; 
	   boolean email_notification = request.getParameter("email") != null; 
	   String user_name = (String) request.getSession().getAttribute("username"); 
	   
	   if(user_name != null) {
		   SettingsManager settings_manager = new SettingsManager(user_name); 
		   settings_manager.updateFireInfo(fire_notification);
		   settings_manager.updateHazeInfo(shelter_notification);
		   settings_manager.updateBombshelterinfo(shelter_notification);
		   settings_manager.updateMaskInfo(mask_notification);
		   settings_manager.updateSms(sms_notification);
	   }
	   
	   request.setAttribute("settings_changed", true);
	   request.getRequestDispatcher("./index.jsp").forward(request, response);;
	}

}
