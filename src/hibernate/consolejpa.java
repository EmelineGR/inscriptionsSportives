package hibernate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Transaction;

import hibernate.Competition;

public class consolejpa {



	    public static void main(String[] args) throws Exception {
	        EntityManagerFactory entityManagerFactory = null;
	        EntityManager entityManager = null;
	        try {
	        	
	        	entityManagerFactory = Persistence.createEntityManagerFactory("WebStore");
	        	entityManager = entityManagerFactory.createEntityManager();
	        	
	        	Competition art = entityManager.find(Competition.class,1);
	        	System.out.println(art);
	        	
	        } finally {
	            if ( entityManager != null ) entityManager.close();
	            if ( entityManagerFactory != null ) entityManagerFactory.close();
	        }
	        
}
	    

}