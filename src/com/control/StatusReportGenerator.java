package com.control;

import java.util.Date;

public class StatusReportGenerator {
	
	String report;
	Date date;
	public StatusReportGenerator(){
		generateReport();
		date=new Date();
	}
	
	private void generateReport(){
		//code to generate report
		//get hazeinfo??
		//get number of unclosed incidents and display them??
		report="<html><body>Status report</body></html>";
	}
	
	public String getTimestamp(){
		return date.toString();
	}
	
	public String getReport(){
		return report;
	}
	
}
