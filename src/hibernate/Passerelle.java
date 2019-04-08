package hibernate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;
public abstract class Passerelle
{
	 private static EntityManagerFactory hiber = null;
	 private static EntityManager mysql = null;
	
	 public static void init()
	 {
		 
	  try
	  {
		hiber = Persistence.createEntityManagerFactory("WebStore");// UTILISATION DE LA PERSISTENCE XML DANS LE META INF POUR SE CONNECTER A LA BDD
	    mysql = hiber.createEntityManager();
	  }
	  catch (HibernateException ex)
	  {
	   throw new RuntimeException("Problmysqle de configuration : "
	     + ex.getMessage(), ex);
	  }
	 }
	
	 public static void open()
	 {
	  if (mysql == null)
	   init();
	 }
	
	 public static void close()
	 {
	  if (hiber != null && mysql != null )
	   mysql.close();
	   hiber.close();
	 }
	
	 public static void delete(Object o)
	 {
	  EntityTransaction transaction = mysql.getTransaction();
	  transaction.begin();
	  mysql.remove(o);
	  transaction.commit();
	  transaction = null;
	 }
	
	 public static void save(Object o)
	 {
		 EntityTransaction transaction = mysql.getTransaction();
		 transaction.begin();
		 mysql.persist(o);
		 transaction.commit();
		 transaction = null;
	
	 }
}