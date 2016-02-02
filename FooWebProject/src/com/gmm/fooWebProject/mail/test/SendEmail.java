package com.gmm.fooWebProject.mail.test;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.gmm.fooWebProject.util.Constantes;

/**
 * 
 * @author GMM
 * 
 *         A message can be bounced for several reasons. This problem is
 *         discussed in depth at rfc1211. Only a server can determine the
 *         existence of a particular mailbox or user name. When the server
 *         detects an error, it will return a message indicating the reason for
 *         the failure to the sender of the original message.
 * 
 *         There are many Internet standards covering Delivery Status
 *         Notifications but a large number of servers don't support these new
 *         standards, instead using ad hoc techniques for returning such failure
 *         messages. Hence it get very difficult to correlate the bounced
 *         message with the original message that caused the problem.
 * 
 *         JavaMail includes support for parsing Delivery Status Notifications.
 *         There are a number of techniques and heuristics for dealing with this
 *         problem. One of the techniques being Variable Envelope Return Paths.
 *         You can set the return path in the enveloper as shown in the example
 *         below. This is the address where bounce mails are sent to. You may
 *         want to set this to a generic address, different than the From:
 *         header, so you can process remote bounces. This done by setting
 *         mail.smtp.from property in JavaMail.
 *
 */
public class SendEmail {
  
 
public static void main(String[] args) throws Exception {
      String smtpServer = Constantes.SMTP_GMAIL_COM;
      int port = 587;
      final String userid = "g.manzano.merida@gmail.com"; 
      final String password = ""; 
      String contentType = "text/html";
      String subject = "test: bounce an email to a different address  from the sender";
      String from = "g.manzano.merida@gmail.com";
      String to = "bouncer@fauxmail.com";//some invalid address
      String bounceAddr = "g.manzano.merida@gmail.com";//change accordingly
      String body = "Test: get message to bounce to a separate email address";

      Properties props = new Properties();

      props.put(Constantes.MAIL_SMTP_AUTH, Constantes.TRUE);
      props.put(Constantes.MAIL_SMTP_STARTTLS_ENABLE, Constantes.TRUE);
      props.put(Constantes.MAIL_SMTP_HOST, smtpServer);
      props.put(Constantes.MAIL_SMTP_PORT, "587");
      props.put(Constantes.MAIL_TRANSPORT_PROTOCOL, Constantes.SMTP);
      props.put(Constantes.MAIL_SMTP_FROM, bounceAddr);

      Session mailSession = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(userid, password);
            }
         });

      MimeMessage message = new MimeMessage(mailSession);
      message.addFrom(InternetAddress.parse(from));
      message.setRecipients(Message.RecipientType.TO, to);
      message.setSubject(subject);
      message.setContent(body, contentType);

      Transport transport = mailSession.getTransport();
      try {
         System.out.println("Sending ....");
         transport.connect(smtpServer, port, userid, password);
         transport.sendMessage(message,
            message.getRecipients(Message.RecipientType.TO));
         System.out.println("Sending done ...");
      } catch (Exception e) {
         System.err.println("Error Sending: ");
         e.printStackTrace();

      }
      transport.close();
   }// end function main()
}
