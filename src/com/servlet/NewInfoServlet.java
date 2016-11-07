package com.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.InfoManager;

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
		// TODO Auto-generated method stub
		 System.out.println("In NewInfoServlet doPost"); 
		Enumeration<String> paramNames = request.getParameterNames();
		// for testing
	   while(paramNames.hasMoreElements()) {
		   String paramName = (String)paramNames.nextElement();
		   System.out.println("paramName: " + paramName); 
		   String paramValue = request.getParameter(paramName);
		   System.out.println("paramValue: " + paramValue);
	   }
	   
	   InfoManager info_manager = new InfoManager(); 
	   String info_type = request.getParameter("case"); 
	   String mask_type = request.getParameter("mask_type"); 
	   String location = request.getParameter("postal_code");
	   String full_name = request.getParameter("fullname"); 
	   int reporter_phone_number = Integer.parseInt(request.getParameter("phone"));
	   String operator_name = (String) request.getSession().getAttribute("username");
	   
	    
	   switch(info_type) {
	   case "shelter": 
		   info_manager.createBombshelterInfo(location); break; 
	   case "mask":
		   info_manager.createMaskInfo(location, mask_type); break; 
	   }
	   
	   request.setAttribute("new_info_message", info_type + " at location " + location + " created");
	   request.getRequestDispatcher("./index.jsp").forward(request, response);;
	   
	   return;
	}

}
