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
	    mysql = hiber.createEntityManager();// ACCES A LA CONSOLE SQL
	    
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
	 
	 
	 
	 
	 //&&&&&&&&&&&&& Petit method et fonction &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	 

	 public static void deletex(Object o)// delete un element dans la bdd
	 {
	
	  EntityTransaction transaction = mysql.getTransaction();
	  transaction.begin();
	  mysql.remove(o);
	  transaction.commit();
	  transaction = null;
	  
	 }
	
	 

	 
	 
	 public static void savex(Object o)// sauvegarde un element dans la bdd
	 {
		
		 EntityTransaction transaction = mysql.getTransaction();
		 transaction.begin();
		 mysql.persist(o);
		 transaction.commit();
		 transaction = null;
	
	
	 }
	//&&&&&&&&&&&&& FIN Petit method et fonction &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	 
	 /*
	 public static void comparePersonne(Personne findguy) {// NE SERT A RIEN c'etait pour ne pas avoir 2 element identique dans la bdd
			init();
			 List<Personne> personnes  =  mysql.createQuery("from Personne").getResultList();
			 close();
			 if(personnes.isEmpty()) {
				 savex(findguy);
			 }else {
				for (Personne pers : personnes) {
					System.out.println(pers.getNom() + " personne list");
					System.out.println(findguy.getNom() + " personne ");
					if (pers.getNom() == findguy.getNom()) {
						System.out.println("compare yes");
					}else {
						savex(findguy);
						System.out.println("compare no");
					}
				}
			 }
		 }
	 */
	 
	
	 //&&&&&&&&&&&&& PULL de donnee &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	 public static Inscriptions Selectquery(inscriptions.Inscriptions inscri) {// FAIT LA REQUETE QUI MONTRE A L'UTILISATEURS TOUS LES ELEMENTS DU LA BDD
		init();
		 Passerelle.SelectPers(inscri);
		 Passerelle.SelectComp(inscri);
		 Passerelle.SelectEquipe(inscri);
		
			return inscri;
			
	 }
	 
	 public static Inscriptions SelectPers(inscriptions.Inscriptions inscri) {// FAIT LA REQUETE QUI MONTRE A L'UTILISATEURS TOUS LES ELEMENTS DU LA BDD
	
		 List<Personne> personnes  =  mysql.createQuery("from Personne").getResultList();//requete dans la bdd prend tous les elements de la liste personne
	
		 for (Personne personne : personnes) 
				inscri.createPersonne(personne.getNom(), personne.getPrenom(), personne.getMail());
			
		
			return inscri;
	 }
	 
	 
	 
	 public static Inscriptions SelectComp(inscriptions.Inscriptions inscri) {// FAIT LA REQUETE QUI MONTRE A L'UTILISATEURS TOUS LES ELEMENTS DU LA BDD
	
		 List<Competition> Compets  =  mysql.createQuery("from Competition").getResultList();//requete dans la bdd prend tous les elements de la liste personne
	
			for (Competition Compet : Compets) 
				inscri.createCompetition(Compet.getNom(),Compet.getDateCloture(),Compet.estEnEquipe());
			
		
			return inscri;
	 }
	 
	 
	 public static Inscriptions SelectEquipe(inscriptions.Inscriptions inscri) {// FAIT LA REQUETE QUI MONTRE A L'UTILISATEURS TOUS LES ELEMENTS DU LA BDD
		
		 List<Equipe> Equipes  =  mysql.createQuery("from Equipe").getResultList();//requete dans la bdd prend tous les elements de la liste personne
		
			for (Equipe Equipe : Equipes)
				 inscri.createEquipe(Equipe.getNom());	
		
			return inscri;
	 }
	//&&&&&&&&&&&&& FIN PULL de donnee  &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	 
	 
	 
	 
	 
	//&&&&&&&&&&&&& SAVE de donnee &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	 public static void Saving(inscriptions.Inscriptions inscri) {
		
	Passerelle.SaveCompet(inscri);// sauvegarde tous les elements d'inscriptions en plus de se qu'il y a dans la base
	Passerelle.SavePersonne(inscri);
	Passerelle.SaveEquipe(inscri);

	Passerelle.close();
	 }
	 
	 
	 public static void SavePersonne(inscriptions.Inscriptions inscri) {// sauvegarde tous les elements d'inscriptions en plus de se qu'il y a dans la base
		
			 List<Personne> personnes  =  mysql.createQuery("from Personne").getResultList();
		
				for (Personne personne : inscri.getPersonnes()) {
				if(!personnes.contains(personne)) {
						savex(personne);
					}
		 		}
			
		 }
	 
	 public static void SaveCompet(inscriptions.Inscriptions inscri) {// sauvegarde tous les elements d'inscriptions en plus de se qu'il y a dans la base
		
			 List<Competition> Compets  =  mysql.createQuery("from Competition").getResultList();
		
			for (Competition Compet : inscri.getCompetitions()) {
				if(!Compets.contains(Compet)) {
					savex(Compet);
				}
	 		}
	
		 }
	 
	 public static void SaveEquipe(inscriptions.Inscriptions inscri) {// sauvegarde tous les elements d'inscriptions en plus de se qu'il y a dans la base
	
			 List<Equipe> Equipes  =  mysql.createQuery("from Equipe").getResultList();
		
			for (Equipe Equipe : inscri.getEquipes()) {
				if(!Equipes.contains(Equipe)) {
					savex(Equipe);
				}
	 		}
			
		 }
	 
	//&&&&&&&&&&&&& FIN SAVE de donnee  &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	 

}