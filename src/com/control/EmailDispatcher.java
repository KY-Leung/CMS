package com.control;
import java.util.Properties;

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
	
	private String emailMessage;
	private String subject;
	private String recipientEmail;
	public EmailDispatcher(String recipientEmail){
		this.recipientEmail=recipientEmail;
	}
	public void setMessage(String message){
		emailMessage=message;
	}
	public void setSubject(String subject){
		this.subject=subject;
	}
	public void dispatchInformation(){
		
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
			message.setText(emailMessage);

			Transport.send(message);

			System.out.println("Email Sent");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	
	public static void main(String[] args) {
		String recipientEmail = "nigelkong.92@gmail.com";
		InfoDispatcher ed = new EmailDispatcher(recipientEmail);
		StatusReportGenerator srg=new StatusReportGenerator();
		ed.setMessage(srg.getReport());
		ed.setSubject("Status report -"+srg.getTimestamp());
		ed.dispatchInformation();
		
	}
		

}