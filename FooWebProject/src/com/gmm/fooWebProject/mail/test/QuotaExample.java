package com.gmm.fooWebProject.mail.test;

import java.util.Properties;

import javax.mail.Quota;
import javax.mail.Session;
import javax.mail.Store;

import com.gmm.fooWebProject.util.Constantes;
import com.sun.mail.imap.IMAPStore;

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
