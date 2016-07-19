package com.deal.common;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.deal.cliente.bean.Cliente;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    
    static {
        try {
//        	sessionFactory = new AnnotationConfiguration().
//                    configure().
//                    //addPackage("com.xyz") //add package if used.
//                    addAnnotatedClass(Cliente.class).
//                    buildSessionFactory();
        	
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure(new File("src/hibernate.cfg.xml"))
                    .buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}