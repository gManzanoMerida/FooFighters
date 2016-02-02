package com.gmm.fooWebProject.mail.test;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 
 * @author GMM
 * 
 *         In all previous chapters we used JangoSMPT server to send emails. In
 *         this chapter we will learn about SMPT server provided by Gmail. Gmail
 *         (among others) offers use of their public SMTP server free of charge.
 * 
 *         Gmail SMTP server details can be found here. As you can see in the
 *         details, we can use either TLS or SSL connection to send email via
 *         Gmail SMTP server.
 * 
 *         The procedure to send email using Gmail SMTP server is similar as
 *         explained in chapter Sending Emails, except that we would change the
 *         host server. As a pre-requisite the sender email address should be an
 *         active gmail account. Let us try an example.
 *
 * 
 * 
 */
public class SendEmailUsingGMailSMTP {
	public static void main(String[] args) {
		// Recipient's email ID needs to be mentioned.
		String to = "g.manzano.merida@gmail.com"; 

		// Sender's email ID needs to be mentioned
		String from = "g.manzano.merida@gmail.com"; 
		final String username = "g.manzano.merida@gmail.com"; 																 
		final String password = "";

		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);		// Create a default // MimeMessage object.
			message.setFrom(new InternetAddress(from));		// Set From: header field  of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));// Set To: header field of  the header.
			message.setSubject("Testing Subject");			// Set Subject: header field
			message.setText("Hello, this is sample for to check send " + "email using JavaMailAPI ");// Now  set  the actual message
			Transport.send(message);// Send message

			System.out.println("Sent message successfully....");

		} catch (MessagingException e) {
			System.out.println("---> SendEmailUsingGMailSMTP: " + e);
			throw new RuntimeException(e);
		}
	}
}
