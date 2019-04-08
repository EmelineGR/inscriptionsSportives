package hibernate;
import java.util.ArrayList; // import the ArrayList class

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.SortedSet;

import inscriptions.Inscriptions;
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
	   throw new RuntimeException("Probleme de configuration : "
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
	
	 public static void InitSave(Inscriptions inscri)
	 {
		Passerelle.init();
		 InitCompetition(inscri);
		 
		Passerelle.close();
	 }
	 
	 public static void InitCompetition(Inscriptions inscri)
	 {
		 SortedSet<inscriptions.Competition> list = inscri.getCompetitions();
		 for (inscriptions.Competition item : list) {	
			 System.out.println(item);
		 savex(new hibernate.Competition(item.getNom(), item.getDateCloture()));
		 }
		 
	 }
	 
	 public static void InitEquipes(Inscriptions inscri)
	 {
		 SortedSet<inscriptions.Competition> list = inscri.getCompetitions();
		 for (inscriptions.Competition item : list) {	
			 System.out.println(item);
		 savex(new hibernate.Competition(item.getNom(), item.getDateCloture()));
		 }
		 
	 }
	 
	 public static void InitPersonnes(Inscriptions inscri)
	 {
		 SortedSet<inscriptions.Personne> list = inscri.getPersonnes();
		 for (inscriptions.Personne item : list) {	
			 System.out.println(item);
		 savex(new hibernate.Competition(item.);
		 }
		 
	 }
	 
	 
	 public static void savex(Object o)
	 {
		 EntityTransaction transaction = mysql.getTransaction();
		 transaction.begin();
		 mysql.persist(o);
		 transaction.commit();
		 transaction = null;
	
	 }
}