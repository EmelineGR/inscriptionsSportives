package hibernate;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import hibernate.Passerelle;
import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

public class consolejpa {



	 public static void main(String[] args) throws Exception {
			Inscriptions inscriptions = Inscriptions.getInscriptions();
			Competition testcompetition = inscriptions.createCompetition("Competition", null, false);
			Personne test = inscriptions.createPersonne("nom", "prenom", "mail");
			Equipe testEquipe = inscriptions.createEquipe("Les Manouches");
			Competition testcompetition2 = inscriptions.createCompetition("Competition", null, false);
			
		
			
			

}
	    

}