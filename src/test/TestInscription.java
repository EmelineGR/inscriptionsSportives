package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

class TestInscription {
	Inscriptions inscriptions = Inscriptions.getInscriptions();
	Competition testcompetition = inscriptions.createCompetition("Competition", null, false);
	Personne test = inscriptions.createPersonne("nom", "prenom", "mail");
	Equipe testEquipe = inscriptions.createEquipe("Les Manouches");
	Competition testcompetition2 = inscriptions.createCompetition("Competition", null, false);
	
	
	
	
	
	
	
	@Test
	public void getInscription() {
		assertTrue(inscriptions.getPersonnes().contains(test));
		

	}
	
	
	@Test
	public void getCandidats() {
		assertTrue(inscriptions.getCandidats().contains(testEquipe));
		

	}
	
	
	@Test
	public void getCompetition() {
		assertTrue(inscriptions.getCompetitions().contains(testcompetition));
		

	}

	@Test
	public void getEquipes() {
		assertTrue(inscriptions.getEquipes().contains(testEquipe));
		

	}

	
	
	@Test
	public void createCompetition() {
		Competition alex = inscriptions.createCompetition("alex",null,true);
		assertTrue(inscriptions.getCompetitions().contains(alex));
		

	}
	
	
	@Test
	public void createPersonne() {
		Personne testp = inscriptions.createPersonne("nom", "prenom", "mail");
		assertTrue(inscriptions.getPersonnes().contains(testp));
		

	}
	
	@Test
	public void createEquipes() {
		Equipe testp = inscriptions.createEquipe("Les Manouches");
		assertTrue(inscriptions.getEquipes().contains(testp));
		

	}
	

	
	@Test
	public void deleteCandidat() {

	
		test.delete();
		testEquipe.delete();
		assertFalse(inscriptions.getPersonnes().contains(test));
		assertFalse(inscriptions.getEquipes().contains(testEquipe));
	}
	
	@Test
	public void deleteCompetition() {

	
		testcompetition.delete();
		assertFalse(inscriptions.getCompetitions().contains(testcompetition));
	}
	@Test
	public void reinitialiser() {


	inscriptions = inscriptions.reinitialiser();
		assertTrue(inscriptions.getCompetitions().isEmpty());
		
	}
	
	@Test
	public void recharger() {
	
		Personne test2 = inscriptions.createPersonne("jo", "prenom", "mail");
		assertTrue(inscriptions.getPersonnes().contains(test2));
	inscriptions = inscriptions.recharger();
	System.out.println(inscriptions);
	assertFalse(inscriptions.getPersonnes().contains(test2));

		
	}
	@Test
	public void sauvegarder() {
		Personne josiace = inscriptions.createPersonne("jo", "prenom", "mail");
		assertTrue(inscriptions.getPersonnes().contains(josiace));

		try
		{
		inscriptions.sauvegarder();
		} 
		catch (IOException e){
			
		}
		
		assertTrue(inscriptions.getPersonnes().contains(josiace));
josiace.delete();



try
{
inscriptions.sauvegarder();
} 
catch (IOException e){
	
}
inscriptions = inscriptions.recharger();
assertFalse(inscriptions.getPersonnes().contains(josiace));	
	}
	
	
}
