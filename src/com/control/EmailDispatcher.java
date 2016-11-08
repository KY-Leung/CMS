package com.control;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailDispatcher implements InfoDispatcher{
	final String username = "cz3003softwareanalysis@gmail.com";
	final String password = "backstreetboys";
	
    public static EmailDispatcher email_dispatcher = null; 
	
	private String emailMessage;
	private String subject;
	private String recipientEmail;
	
    
    public EmailDispatcher(String recipientEmail){
		this.recipientEmail=recipientEmail;
	}
	
    public EmailDispatcher() {}
	
	
    public void setMessage(String message){
		emailMessage=message;
	}
	
    public void setSubject(String subject){
		this.subject=subject;
	}
	
    
    
    public void dispatchInformation(){
		
		// Sends a periodic report to PMO

		// Variables to change

		// Interval units: ms, default: 30 mins
		long interval = 1000*60*30;
		recipientEmail = "kw01sg@gmail.com";
		emailMessage = "This is a periodic update message sent by the SRS. "; 
		subject = "Periodic Report to PMO";
		
		
		// Periodic Sending Logic
		TimerTask task = new TimerTask(){
			@Override
			public void run(){
				// send email to PMO
				email_dispatcher = new EmailDispatcher("kw01sg@gmail.com");
				StatusReportGenerator srg=new StatusReportGenerator();
				email_dispatcher.setMessage(srg.getReport());
				email_dispatcher.setSubject("Status report -"+srg.getTimestamp());
				email_dispatcher.sendEmail();
			}
		};
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(task, 0, interval);
	}

	private void sendEmail() {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from-email-test123@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(recipientEmail));
			message.setSubject(subject);
			message.setContent(emailMessage,"text/html");

			Transport.send(message);

			System.out.println("" + subject + " Sent");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	public static void main(String[] args) {
		
		InfoDispatcher ed = new EmailDispatcher();
		ed.dispatchInformation();
		
	}
		

}