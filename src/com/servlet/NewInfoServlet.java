package com.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.FacebookDispatcher;
import com.control.InfoManager;
import com.control.TwitterDispatcher;

/**
 * Servlet implementation class NewInfoServlet
 */
@WebServlet("/NewInfoServlet")
public class NewInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewInfoServlet() {
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
//		System.out.println("In NewInfoServlet doPost"); 
//		Enumeration<String> paramNames = request.getParameterNames();
//		// for testing
//	   while(paramNames.hasMoreElements()) {
//		   String paramName = (String)paramNames.nextElement();
//		   System.out.println("paramName: " + paramName); 
//		   String paramValue = request.getParameter(paramName);
//		   System.out.println("paramValue: " + paramValue);
//	   }
	   
	   InfoManager info_manager = new InfoManager(); 
	   String info_type = request.getParameter("case"); 
	   String mask_type = request.getParameter("mask_type"); 
	   String location = request.getParameter("postal_code");
	   String full_name = request.getParameter("fullname"); 
	   int reporter_phone_number = Integer.parseInt(request.getParameter("phone"));
	   String operator_name = (String) request.getSession().getAttribute("username");
	    
	   switch(info_type) {
	   case "shelter": 
		   info_manager.createBombshelterInfo(location); 
		   dispatch_to_social_media("New Bomb Shelter", "New Bomb Shelter at postal code " + location); 
		   break; 
	   case "mask":
		   info_manager.createMaskInfo(location, mask_type); 
		   dispatch_to_social_media(mask_type + " Masks" , 
				   "Free " + mask_type +  " masks distributed at postal code " + location);
		   break; 
	   }
	   
	   request.setAttribute("new_info_message", info_type + " at location " + location + " created");
	   request.getRequestDispatcher("./index.jsp").forward(request, response);;
	   
	   return;
	}

	private void dispatch_to_social_media(String subject, String message) {
		Date date = new Date(); 
		
		TwitterDispatcher twitter_dispatcher = new TwitterDispatcher(); 
		twitter_dispatcher.setSubject(subject);
		twitter_dispatcher.setMessage(date.toString() + ": " + message);
		twitter_dispatcher.dispatchInformation();
		
		FacebookDispatcher facebook_dispatcher = new FacebookDispatcher(); 
		facebook_dispatcher.setSubject(subject);
		facebook_dispatcher.setMessage(message);
		facebook_dispatcher.dispatchInformation();
	}

}
