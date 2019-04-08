package hibernate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import inscriptions.Inscriptions;
import hibernate.consolejpa;
public class Passerelle
{
	private static Session session = null;

	static
	{
		SessionFactory sessionFactory = null;
		try
		{
			Configuration configuration = new Configuration()
					.configure("hibernate.cfg.xml");
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			session = sessionFactory.openSession();
		}
		catch (HibernateException ex)
		{
			throw new RuntimeException("Probleme de configuration : "
					+ ex.getMessage(), ex);
		}
	}

//	static void delete(Contact personne)
//	{
//		Transaction tx = session.beginTransaction();
//		session.delete(personne);
//		tx.commit();
//	}
//
	public static void save(Inscriptions inscri)
	{
		
	     EntityManagerFactory entityManagerFactory = null;
	        EntityManager entityManager = null;
	        try {
	        	
	        	entityManagerFactory = Persistence.createEntityManagerFactory("WebStore");
	        	entityManager = entityManagerFactory.createEntityManager();
	        	
	        	Competition art = entityManager.find(Competition.class,1);
	        	
	        	Transaction tx = session.beginTransaction();
	    		for ( Object Compet: inscri.getCompetitions().toArray()) {
	    			entityManager.persist(Compet);
	    		}
	    	
	    		
	    		
	    		tx.commit();
	        	
	        } finally {
	            if ( entityManager != null ) entityManager.close();
	            if ( entityManagerFactory != null ) entityManagerFactory.close();
	        }
	}
//		session.save(competition);
//	@SuppressWarnings("unchecked")
//	static java.util.List<Contact> refreshList()
//	{
//		Query query = session.createQuery("from Contact");
//		return query.list();
//	}


}
