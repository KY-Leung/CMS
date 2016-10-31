package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.IncidentManager;
import com.control.SettingsManager;
import com.control.SmsDispatcher;
import com.entity.EmergencyServicesInfo;
import com.entity.Incident;
import com.entity.User;

/**
 * Servlet implementation class NewCaseServlet
 */
@WebServlet("/NewCaseServlet")
public class NewCaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewCaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Do Nothing
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// System.out.println("In NewCaseServlet doPost"); 
//		Enumeration<String> paramNames = request.getParameterNames();
//		// for testing
//	   while(paramNames.hasMoreElements()) {
//		   String paramName = (String)paramNames.nextElement();
//		   System.out.println("paramName: " + paramName); 
//		   String paramValue = request.getParameter(paramName);
//		   System.out.println("paramValue: " + paramValue);
//	   }
	   
	   IncidentManager incident_manager = new IncidentManager(); 
	   
	   String type_of_case = request.getParameter("case"); 
//	   String paramValue = request.getParameter("payment[]");
//	   System.out.println("paramValue: " + paramValue);
	   String reporter_name = request.getParameter("fullname"); 
	   int reporter_phone_number = Integer.parseInt(request.getParameter("phone")); 
	   String[] assistance_requested = request.getParameterValues("request[]"); 
	   String services = ""; 
	   if (assistance_requested != null) {
		   for(String s : assistance_requested) {
			   int key = Integer.parseInt(s); 
			   if(!services.isEmpty()) {
				   services = services + ", "; 
			   }
			   services = services + EmergencyServicesInfo.services[key - 1]; 
		   }
	   }
	   String location = request.getParameter("postal_code"); 
	   String description = request.getParameter("remarks"); 
	   String operator_name = "operator 1"; // to use from session after logging in
	   int incident_key = -1; 
	   switch(type_of_case) {
		   	case "fire": 
			   incident_key = incident_manager.createIncident(
					   reporter_name,
					   reporter_phone_number, 
					   services, 
					   Incident.FIRE_INCIDENT, 
					   location,
					   description, 
					   operator_name // to use from session after logging in 
					   ); 
			   incident_manager.createFireIncident(incident_key, -1, -1);
			   String message = "Case Number: " + incident_key + "\nNew Fire Case in " + location + "." ; 
			   dispatch_fire_info(message);
			   break; 
			   
		   case "haze": 
			   incident_key = incident_manager.createIncident(
					   reporter_name,
					   reporter_phone_number, 
					   services, 
					   Incident.HAZE_INFO, 
					   location,
					   description, 
					   operator_name // to use from session after logging in 
					   ); 
			   incident_manager.createHazeInfo(incident_key, 
					   Integer.parseInt(request.getParameter("central_psi")), 
					   Integer.parseInt(request.getParameter("north_psi")),
					   Integer.parseInt(request.getParameter("south_psi")), 
					   Integer.parseInt(request.getParameter("east_psi")), 
					   Integer.parseInt(request.getParameter("west_psi"))
					   );
			   break; 
	   }					
	    
	   request.setAttribute("new_case_id", incident_key);
	   request.getRequestDispatcher("./index.jsp").forward(request, response);;
	   
	   return; 
	}



	private void dispatch_fire_info(String message) {
		// TODO Auto-generated method stub
		SettingsManager sm = new SettingsManager(""); 
		ArrayList<User> users = sm.getFireInfoUsers(); 
		ArrayList<String> phone_numbers = new ArrayList<String>(); 
		
		for (User user : users) {
			phone_numbers.add(String.valueOf(user.getPhoneNumber())); 
		}
		
		if(!phone_numbers.isEmpty()) {
			SmsDispatcher.broadcastAllMessages(message, phone_numbers);
		}
	}

}
