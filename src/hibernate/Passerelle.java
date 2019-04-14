package hibernate;
import java.util.ArrayList;
import javax.persistence.*;
// import the ArrayList class

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;

import inscriptions.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.SortedSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Query;
import org.hibernate.Session;
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
	

	 public static void close()// si la connexion a la bdd est ouverte la ferme
	 {
	  if (hiber != null && mysql != null )
	   mysql.close();
	   hiber.close();
	 }
	
	 public static Inscriptions Selectquery(inscriptions.Inscriptions inscri) {// FAIT LA REQUETE QUI MONTRE A L'UTILISATEURS TOUS LES ELEMENTS DU LA BDD
		 init();
	
		 List<Personne> personnes  =  mysql.createQuery("from Personne").getResultList();//requete dans la bdd prend tous les elements de la liste personne
		 List<Competition> Compets  =  mysql.createQuery("from Competition").getResultList();
		 List<Equipe> Equipes  =  mysql.createQuery("from Equipe").getResultList();
		 close();
		 for (Personne personne : personnes) 
				inscri.createPersonne(personne.getNom(), personne.getPrenom(), personne.getMail());
			
			for (Competition Compet : Compets) 
					inscri.createCompetition(Compet.getNom(),Compet.getDateCloture(),Compet.estEnEquipe());
				
			for (Equipe Equipe : Equipes) {
					 inscri.createEquipe(Equipe.getNom());	
				}
			
			return inscri;
	 }

	 public static void Saving(inscriptions.Inscriptions inscri) {// sauvegarde tous les elements d'inscriptions en plus de se qu'il y a dans la base
		init();
		 List<Personne> personnes  =  mysql.createQuery("from Personne").getResultList();
		 List<Competition> Compets  =  mysql.createQuery("from Competition").getResultList();
		 List<Equipe> Equipes  =  mysql.createQuery("from Equipe").getResultList();
			
			for (Personne personne : inscri.getPersonnes()) {
				if(!personnes.contains(personne)) {
					System.out.println((personne.getNom()));
					savex(personne);
				}
	 		}
			for (Competition Compet : inscri.getCompetitions()) {
				if(!Compets.contains(Compet)) {
					savex(Compet);
				}
	 		}
			for (Equipe Equipe : inscri.getEquipes()) {
				if(!Equipes.contains(Equipe)) {
					savex(Equipe);
				}
	 		}

			close();
		
	 }
	 
	 
	 
	 
	 
	 public static void deletex(Object o)// delete un element dans la bdd
	 {
	Passerelle.init();
	  EntityTransaction transaction = mysql.getTransaction();
	  transaction.begin();
	  mysql.remove(o);
	  mysql.persist(o);
	  transaction.commit();
	  transaction = null;
	  Passerelle.close();
	 }
	
	 

	 
	 
	 public static void savex(Object o)// sauvegarde un element dans la bdd
	 {
		 init();
		 EntityTransaction transaction = mysql.getTransaction();
		 transaction.begin();
		 mysql.persist(o);
		 transaction.commit();
		 transaction = null;
	close();
	
	 }
}