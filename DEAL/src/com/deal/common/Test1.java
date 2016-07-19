package com.deal.common;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.deal.cliente.bean.Cliente;

public class Test1 {

	// private final static Logger log = Logger.getLogger(Test1.class);
	 

	private Long createAndStoreCliente(String name, String lastname) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Cliente theCliente = new Cliente();
		theCliente.setNombre(name);
		theCliente.setApellidos(lastname);
		session.save(theCliente);
		session.getTransaction().commit();

		// log.info("Insertado: " + theCliente);
		System.out.println("Insertado: " + theCliente);
		return theCliente.getIdCliente();
	}

	private List<Cliente> listaClientes() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Cliente> result = (List<Cliente>) session.createQuery("from Cliente").list();
		session.getTransaction().commit();
		for (Cliente Clienteo : result) {
			// log.info("Leido: " + Clienteo);
			System.out.println("Leido: " + Clienteo);
		}
		return result;
	}

	/* Method to CREATE an Cliente in the database */
	public Integer addCliente(String fname, String lname) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		Integer ClienteID = null;
		try {
			tx = session.beginTransaction();
			Cliente Cliente = new Cliente();
			Cliente.setNombre(fname);
			Cliente.setApellidos(lname);
			ClienteID = (Integer) session.save(Cliente);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return ClienteID;
	}

	/* Method to READ all the Clientes */
	public void listClientes( ){
		  Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         List Clientes = session.createQuery("FROM Cliente").list(); 
	         for (Iterator iterator = 
	                           Clientes.iterator(); iterator.hasNext();){
	            Cliente Cliente = (Cliente) iterator.next(); 
	            System.out.print("First Name: " + Cliente.getNombre()); 
	            System.out.print("  Last Name: " + Cliente.getApellidos());  
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }

	/* Method to UPDATE salary for an Cliente */
	public void updateCliente(Integer ClienteID, String apellidos) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Cliente Cliente = (Cliente) session.get(Cliente.class, ClienteID);
			Cliente.setApellidos(apellidos);
			session.update(Cliente);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to DELETE an Cliente from the records */
	public void deleteCliente(Integer ClienteID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Cliente Cliente = (Cliente) session.get(Cliente.class, ClienteID);
			session.delete(Cliente);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// BasicConfigurator.configure();
		// Logger.getLogger("org.hibernate").setLevel(Level.WARN);
//		new Test1();
		SessionFactory session =  HibernateUtil.getSessionFactory();
		try{
			session = new AnnotationConfiguration().
	                   configure().
	                   //addPackage("com.xyz") //add package if used.
	                   addAnnotatedClass(Cliente.class).
	                   buildSessionFactory();
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		
		 Test1 test1 = new Test1();

	      /* Add few employee records in database */
	      Integer empID1 = test1.addCliente("Zara", "Ali");
	      Integer empID2 = test1.addCliente("Daisy", "Das");
	      Integer empID3 = test1.addCliente("John", "Paul");

	      /* List down all the customer */
	      test1.listClientes();

	      /* Update employee's records */
	      test1.updateCliente(empID1, "Doe");

	      /* Delete an employee from the database */
	      test1.deleteCliente(empID2);

	      /* List down new list of the customer */
	      test1.listClientes();

	}

	public Test1() {
		

//		createAndStoreCliente("John", "Doe");
//		listaClientes();
//		HibernateUtil.getSessionFactory().close();
	}
}