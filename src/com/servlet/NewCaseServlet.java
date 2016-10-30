package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.IncidentManager;
import com.entity.Incident;

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
		System.out.println("In NewCaseServlet doPost"); 
		Enumeration<String> paramNames = request.getParameterNames();
		// for testing
	   while(paramNames.hasMoreElements()) {
		   String paramName = (String)paramNames.nextElement();
		   System.out.println("paramName: " + paramName); 
		   String paramValue = request.getParameter(paramName);
		   System.out.println("paramValue: " + paramValue);
	   }
	   
	   IncidentManager incident_manager = new IncidentManager(); 
	   
	   String type_of_case = request.getParameter("case"); 
//	   String paramValue = request.getParameter("payment[]");
//	   System.out.println("paramValue: " + paramValue);
	   String reporter_name = request.getParameter("fullname"); 
	   int reporter_phone_number = Integer.parseInt(request.getParameter("phone")); 
	   String assistance_requested = "to do services"; 
	   String location = request.getParameter("location"); 
	   String description = request.getParameter("remarks"); 
	   String operator_name = "operator 1"; // to use from session after logging in
	   
	   
	   
	   switch(type_of_case) {
	   case "fire": 
		   int fire_key = incident_manager.createIncident(
				   reporter_name,
				   reporter_phone_number, 
				   assistance_requested, 
				   Incident.FIRE_INCIDENT, 
				   location,
				   description, 
				   operator_name // to use from session after logging in 
				   ); 
		   incident_manager.createFireIncident(fire_key, -1, -1);
		   break; 
		   
	   case "haze": 
		   int haze_key = incident_manager.createIncident(
				   reporter_name,
				   reporter_phone_number, 
				   assistance_requested, 
				   Incident.HAZE_INFO, 
				   location,
				   description, 
				   operator_name // to use from session after logging in 
				   ); 
		   incident_manager.createHazeInfo(haze_key, 
				   Integer.parseInt(request.getParameter("central_psi")), 
				   Integer.parseInt(request.getParameter("north_psi")),
				   Integer.parseInt(request.getParameter("south_psi")), 
				   Integer.parseInt(request.getParameter("east_psi")), 
				   Integer.parseInt(request.getParameter("west_psi"))
				   );
		   break; 
	   }
	   
	}

}
