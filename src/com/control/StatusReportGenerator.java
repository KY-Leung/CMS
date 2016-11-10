package com.control;

import java.util.ArrayList;
import java.util.Date;

import com.entity.HazeInfo;
import com.entity.Incident;

// TODO: Auto-generated Javadoc
/**
 * The Class StatusReportGenerator.
 */
public class StatusReportGenerator {
	
	/** The report. */
	String report;
	
	/** The date. */
	Date date;
	
	/**
	 * Instantiates a new status report generator.
	 */
	public StatusReportGenerator(){
		generateReport();
		date=new Date();
	}
	
	/**
	 * Generate report as a html string. It will display the latest haze info in a tabular form.It will display the list of unclosed incidents in tabular form.
	 */
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
	
	/**
	 * Gets the timestamp that the report was generated.
	 *
	 * @return the timestamp
	 */
	public String getTimestamp(){
		return date.toString();
	}
	
	/**
	 * Gets the status report as a HTML strings.
	 *
	 * @return the report
	 */
	public String getReport(){
		return report;
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		StatusReportGenerator s=new StatusReportGenerator();
		System.out.println(s.getTimestamp());
		System.out.println(s.getReport());
	}
}
