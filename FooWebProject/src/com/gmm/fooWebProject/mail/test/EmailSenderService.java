package com.gmm.fooWebProject.mail.test; 

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.gmm.fooWebProject.util.Constantes;

public class EmailSenderService {
	
	private static final String TRUE = "true";

	private final Properties properties = new Properties();
	
	private String username = "g.manzano.merida@gmail.com"; 
	private String password = "";
	private String host =  "smtp.gmail.com";
	private String emailTo = "g.manzano.merida@gmail.com";
	private String emailFrom = "g.manzano.merida@gmail.com";
	private int port = 587; 
	private Session session;

	private void init() {

		properties.put(Constantes.MAIL_SMTP_HOST,this.host);
		properties.put(Constantes.MAIL_SMTP_STARTTLS_ENABLE, TRUE);
		properties.put(Constantes.MAIL_SMTP_PORT, this.port);
		properties.put(Constantes.MAIL_SMTP_MAIL_SENDER, this.username);
		properties.put(Constantes.MAIL_SMTP_AUTH, TRUE);

//		session = Session.getDefaultInstance(properties);
		
		session = Session.getInstance(properties,
			      new javax.mail.Authenticator() {
			         protected PasswordAuthentication getPasswordAuthentication() {
			            return new PasswordAuthentication(username, password);
			         }
			      });
	}

	public boolean sendEmail(String emailTo, String subject, String text){
		boolean ok = false;
		init();
		try{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress((String)properties.get(Constantes.MAIL_SMTP_MAIL_SENDER)));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
			message.setSubject(subject);
			message.setText(text);
			Transport t = session.getTransport(Constantes.SMTP);
			t.connect((String)properties.get(Constantes.MAIL_SMTP_USER), this.password);
			t.sendMessage(message, message.getAllRecipients());
			t.close();
			
			
			
			 

	         System.out.println("Sent message successfully....");
			
			ok=true;
		}catch (MessagingException me){
			System.out.println("-->EmailSenderService: "+me);
                        //Aqui se deberia o mostrar un mensaje de error o en lugar
                        //de no hacer nada con la excepcion, lanzarla para que el modulo
                        //superior la capture y avise al usuario con un popup, por ejemplo.
//			return;
		}
	
		return ok;
	}
	
	public static void main(String[] args) {
		
		EmailSenderService emailSenderService = new EmailSenderService();
		emailSenderService.sendEmail("g.manzano.merida@gmail.com", "First javaxMail", "Hola!!!!");
		
	}

}