package com.control;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterDispatcher implements InfoDispatcher{
	private String tweetmessage;
	private String subject;

	public void setMessage(String message){
		tweetmessage=message;
	}
	public void setSubject(String subject){
		this.subject=subject;
	}
	public void dispatchInformation(){
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("9Ji4zKuvru54NMokN74cz4J9g")
		  .setOAuthConsumerSecret("Ee6cfAb8xBy9NmFr9IrKn7NVuJgd82YOiMBdYwN3iXIJCptJdu")
		  .setOAuthAccessToken("787887151098626048-bciUQAhntS55YMiEDJeGoNKNPKlIXb2")
		  .setOAuthAccessTokenSecret("YHHOlCvAoJN6vhFeDewwh0ZxIauSg8x9ruRo1USKHGk2Y");

		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
	    
		String latestStatus = tweetmessage;	    
		Status status = null;
		
		try {
			status = twitter.updateStatus(latestStatus);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	    System.out.println("Successfully updated the status to [" + status.getText() + "].");

	}

		
	
	public static void main(String[] args) {
		
		// Twitter account
		// @Cz3003_SRS
		// cz3003softwareanalysis@gmail.com
		// Backstreetboys1
		
		String tweetmessage = "This is an awesome tweet";
		String subject="new bombshelterInfo";
		InfoDispatcher td = new TwitterDispatcher();
		td.setMessage(tweetmessage);
		td.setSubject(subject);
		td.dispatchInformation();
		
	}	
}
