package com.gmm.fooWebProject.mail.test;

import java.util.Properties;

import javax.mail.Quota;
import javax.mail.Session;
import javax.mail.Store;

import com.gmm.fooWebProject.util.Constantes;
import com.sun.mail.imap.IMAPStore;

/**
 * 
 * @author GMM
 * 
 * 
 *         A quota in JavaMail is a limited or fixed number or amount of
 *         messages in a email store. Each Mail service request counts toward
 *         the JavaMail API Calls quota. An email service can apply following
 *         quota criterion:
 * 
 *         Maximum size of outgoing mail messages, including attachments.
 * 
 *         Maximum size of incoming mail messages, including attachments.
 * 
 *         Maximum size of message when an administrator is a recipient
 * 
 *         For Quota management JavaMail has following classes:
 * 
 *         Class: public class Quota
 * 
 *         Description: This class represents a set of quotas for a given quota
 *         root. Each quota root has a set of resources, represented by the
 *         Quota.Resource class. Each resource has a name (for example,
 *         "STORAGE"), a current usage, and a usage limit. This has only one
 *         method setResourceLimit(String name, long limit).
 * 
 * 
 *         Class: public static class Quota.Resource
 * 
 *         Description: Represents an individual resource in a quota root.
 * 
 *         Class: public interface QuotaAwareStore
 * 
 *         Description: An interface implemented by Stores that support quotas.
 *         The getQuota and setQuota methods support the quota model defined by
 *         the IMAP QUOTA extension. GmailSSLStore, GmailStore, IMAPSSLStore,
 *         IMAPStore are the known implementing classes of this interface. Let
 *         us see and example in the following sections which checks for mail
 *         storage name, limit and its usage.
 *
 */
public class QuotaExample {
	
	public static void main(String[] args) {
		
		final String username = "g.manzano.merida@gmail.com"; 																 
		final String password = "Turrican__2018";

		
		try {
			Properties properties = new Properties();
			properties.put(Constantes.MAIL_STORE_PROTOCOL, Constantes.IMAPS);
			properties.put(Constantes.MAIL_IMAPS_PORT, "993");
			properties.put(Constantes.MAIL_IMAPS_STARTTLS_ENABLE, Constantes.TRUE);
			Session emailSession = Session.getDefaultInstance(properties);
			// emailSession.setDebug(true);

			// create the IMAP3 store object and connect with the pop server
			Store store = emailSession.getStore(Constantes.IMAPS);

			// change the user and password accordingly
			store.connect(Constantes.IMAP_GMAIL_COM, username, password);
			IMAPStore imapStore = (IMAPStore) store;
			System.out.println("imapStore ---" + imapStore);

			// get quota
			Quota[] quotas = imapStore.getQuota(Constantes.INBOX);
			// Iterate through the Quotas
			for (Quota quota : quotas) {
				System.out.println(String.format("quotaRoot:'%s'", quota.quotaRoot));
				// Iterate through the Quota Resource
				for (Quota.Resource resource : quota.resources) {
					System.out.println(String.format("name:'%s', limit:'%s', usage:'%s'", resource.name, resource.limit, resource.usage));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
