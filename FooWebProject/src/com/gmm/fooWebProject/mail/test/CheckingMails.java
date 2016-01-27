package com.gmm.fooWebProject.mail.test;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import com.gmm.fooWebProject.util.Constantes;

/**
 * 
 * @author GMM There are two aspects to which needs to understood before
 *         proceeding with this chapter. They are Check and Fetch.
 * 
 *         Checking an email in JavaMail is a process where we open the
 *         respective folder in the mailbox and get each message. Here we only
 *         check the header of each message i.e the From, To, subject. Content
 *         is not read.
 * 
 *         Fetching an email in JavaMail is a process where we open the
 *         respective folder in the mailbox and get each message. Alongwith the
 *         header we also read the content by recognizing the content-type.
 * 
 *         To check or fetch an email using JavaMail API, we would need POP or
 *         IMAP servers. To check and fetch the emails, Folder and Store classes
 *         are needed. Here we have used GMAIL's POP3 server (pop.gmail.com). In
 *         this chapter will learn how to check emails using JavaMail API.
 *         Fetching shall be covered in the subsequent chapters. To check
 *         emails:
 * 
 *         Get a Session
 * 
 *         Create pop3 Store object and connect with pop server.
 * 
 *         Create folder object. Open the appropriate folder in your mailbox.
 * 
 *         Get your messages.
 * 
 *         Close the Store and Folder objects.
 *
 * 
 * 
 */
public class CheckingMails {

	private static final String PASS = "Turrican__2018";
	private static final String USER = "g.manzano.merida@gmail.com";
	

	public static void check(String host, String storeType, String user, String password) {
		try {

			// create properties field
			Properties properties = new Properties();

			properties.put(Constantes.MAIL_POP3_HOST, host);
			properties.put(Constantes.MAIL_POP3_PORT, "995");
			properties.put(Constantes.MAIL_POP3_STARTTLS_ENABLE, Constantes.TRUE);
			Session emailSession = Session.getDefaultInstance(properties);

			// create the POP3 store object and connect with the pop server
			Store store = emailSession.getStore(Constantes.POP3S);

			store.connect(host, user, password);

			// create the folder object and open it
			Folder emailFolder = store.getFolder(Constantes.INBOX);
			emailFolder.open(Folder.READ_ONLY);

			// retrieve the messages from the folder in an array and print it
			Message[] messages = emailFolder.getMessages();
			System.out.println("messages.length---" + messages.length);

			for (int i = 0, n = messages.length; i < n; i++) {
				Message message = messages[i];
				System.out.println("---------------------------------");
				System.out.println("Email Number " + (i + 1));
				System.out.println("Subject: " + message.getSubject());
				System.out.println("From: " + message.getFrom()[0]);
				System.out.println("Text: " + message.getContent().toString());

			}

			// close the store and folder objects
			emailFolder.close(false);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		String host = Constantes.POP_GMAIL_COM;// change accordingly
		String mailStoreType = Constantes.POP3;
		String username = USER;// change accordingly
		String password = PASS;// change accordingly

		check(host, mailStoreType, username, password);

	}

}
