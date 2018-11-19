package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

class testCandidats {
	Inscriptions inscriptions = Inscriptions.getInscriptions();
	Competition testcompetition = inscriptions.createCompetition("Competition", null, false);
	Personne test = inscriptions.createPersonne("nom", "prenom", "mail");
	Equipe testEquipe = inscriptions.createEquipe("Les Manouches");
	Competition testcompetition2 = inscriptions.createCompetition("Competition", null, false);
	
	@Test
	public void getCompetitions() {
		//assertTrue(inscriptions.getPersonnes().contains(test));
	}
	
	@Test
	public void getNom() {
		//assertTrue(inscriptions.getPersonnes().contains(test));
	}
	
	@Test
	public void setNom() {
		//assertTrue(inscriptions.getPersonnes().contains(test));
	}
	
	@Test
	public void delete() {
//		testcompetition.createCompetition("test", localDate, 1);
		testcompetition.delete();
		assertTrue(inscriptions.getCompetitions().isEmpty());
	}
}
