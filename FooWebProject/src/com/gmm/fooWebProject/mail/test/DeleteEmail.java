package com.gmm.fooWebProject.mail.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

/**
 * 
 * @author GMM
 * 
 *         In this chapter we will see how to delete an email using JavaMail
 *         API. Deleting messages involves working with the Flags associated
 *         with the messages. There are different flags for different states,
 *         some system-defined and some user-defined. The predefined flags are
 *         defined in the inner class Flags.Flag and are listed below:
 * 
 *         Flags.Flag.ANSWERED
 * 
 *         Flags.Flag.DELETED
 * 
 *         Flags.Flag.DRAFT
 * 
 *         Flags.Flag.FLAGGED
 * 
 *         Flags.Flag.RECENT
 * 
 *         Flags.Flag.SEEN
 * 
 *         Flags.Flag.USER
 * 
 *         POP protocol supports only deleting of the messages.
 * 
 *         Basic steps followed in the delete program are:
 * 
 *         Get the Session object with POP and SMPT server details in the
 *         properties. We would need POP details to retrieve messages and SMPT
 *         details to send messages.
 * 
 *         Create POP3 store object and connect to the store.
 * 
 *         Create Folder object and open the appropriate folder in your mailbox
 *         in READ_WRITE mode.
 * 
 *         Retrieves messages from inbox folder.
 * 
 *         Iterate through the messages and type "Y" or "y" if you want to
 *         delete the message by invoking the method setFlag(Flags.Flag.DELETED,
 *         true) on the Message object.
 * 
 *         The messages marked DELETED are not actually deleted, until we call
 *         the expunge() method on the Folder object, or close the folder with
 *         expunge set to true.
 * 
 *         Close the store object.
 *
 */
public class DeleteEmail {

   public static void delete(String pop3Host, String storeType, String user,
      String password) 
   {
      try 
      {
         // get the session object
         Properties properties = new Properties();
         properties.put("mail.store.protocol", "pop3");
         properties.put("mail.pop3s.host", pop3Host);
         properties.put("mail.pop3s.port", "995");
         properties.put("mail.pop3.starttls.enable", "true");
         Session emailSession = Session.getDefaultInstance(properties);
         // emailSession.setDebug(true);

         // create the POP3 store object and connect with the pop server
         Store store = emailSession.getStore("pop3s");

         store.connect(pop3Host, user, password);

         // create the folder object and open it
         Folder emailFolder = store.getFolder("INBOX");
         emailFolder.open(Folder.READ_WRITE);

         BufferedReader reader = new BufferedReader(new InputStreamReader(
            System.in));
         // retrieve the messages from the folder in an array and print it
         Message[] messages = emailFolder.getMessages();
         System.out.println("messages.length---" + messages.length);
         for (int i = 0; i < messages.length; i++) {
            Message message = messages[i];
            System.out.println("---------------------------------");
            System.out.println("Email Number " + (i + 1));
            System.out.println("Subject: " + message.getSubject());
            System.out.println("From: " + message.getFrom()[0]);

            String subject = message.getSubject();
            System.out.print("Do you want to delete this message [y/n] ? ");
            String ans = reader.readLine();
            if ("Y".equals(ans) || "y".equals(ans)) {
	       // set the DELETE flag to true
	       message.setFlag(Flags.Flag.DELETED, true);
	       System.out.println("Marked DELETE for message: " + subject);
            } else if ("n".equals(ans)) {
	       break;
            }
         }
         // expunges the folder to remove messages which are marked deleted
         emailFolder.close(true);
         store.close();

      } catch (NoSuchProviderException e) {
         e.printStackTrace();
      } catch (MessagingException e) {
         e.printStackTrace();
      } catch (IOException io) {
         io.printStackTrace();
      }
   }

   public static void main(String[] args) {

      String host = "pop.gmail.com";// change accordingly
      String mailStoreType = "pop3";
      String username = "abc@gmail.com";// change accordingly
      String password = "*****";// change accordingly

      delete(host, mailStoreType, username, password);

   }

}

