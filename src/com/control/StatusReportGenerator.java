package com.control;

import java.util.ArrayList;
import java.util.Date;

import com.entity.HazeInfo;
import com.entity.Incident;

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
		IncidentManager im=new IncidentManager();
		HazeInfo haze=im.retrieveLatestHazeInfo();
		ArrayList<Incident> iList=im.retrieveIncidents();
		report="<h2>Status report</h2><h4>Haze info timestamp: "+haze.getCreationTimestamp()+"</h4>";
		report+="<table border=\"1\" width=\"50%\"><tr><td>Region</td><td>PSI</td></tr><tr><td>North</td><td>";
		report+=haze.getNorthPsi();
		report+="</td></tr><tr><td>South</td><td>";
		report+=haze.getSouthPsi();
		report+="</td></tr><tr><td>East</td><td>";
		report+=haze.getEastPsi();
		report+="</td></tr><tr><td>West</td><td>";
		report+=haze.getWestPsi();
		report+="</td></tr><tr><td>Central</td><td>";
		report+=haze.getCentralPsi();
		report+="</td></tr></table><br><h4>Number of unclosed incidents: "+iList.size()+"</h4>";
		report+="<table border=\"1\" width=\"50%\"><tr><td>IncidentID</td><td>Location</td><td>IncidentType</td><td>Timestamp</td></tr>";
		for(Incident i:iList){
			if(i.isClosed())
				continue;
			report+="<tr><td>"+i.getIncidentID()+"</td>";
			report+="<td>"+i.getLocation()+"</td>";
			report+="<td>"+i.getIncidentType()+"</td>";
			report+="<td>"+i.getCreationTimestamp()+"</td>";
			report+="</tr>";
		}
		report+="</table>";
	}
	
	public String getTimestamp(){
		return date.toString();
	}
	
	public String getReport(){
		return report;
	}
	public static void main(String[] args){
		StatusReportGenerator s=new StatusReportGenerator();
		System.out.println(s.getTimestamp());
		System.out.println(s.getReport());
	}
}
