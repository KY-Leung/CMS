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
 * Servlet that does initial parsing for requests related to adding new information to the system
 */
@WebServlet("/NewInfoServlet")
public class NewInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Constructor
     * @see HttpServlet#HttpServlet()
     */
    public NewInfoServlet() {
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

	/**
	 * Convenience method to dispatch information to social media
	 * @param subject	subject of message	
	 * @param message	content of message
	 */
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
