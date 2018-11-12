package test;
import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

public class Array {


//PERSONNE-----------------------------------------------------------------------------

	@Test
	public void testGetSetPrenom() {
		/**
		 * personne get et set prenom
		 */
		Inscriptions inscriptions = Inscriptions.getInscriptions();
	Personne test = inscriptions.createPersonne("nom", "prenom", "mail");
	test.setPrenom("marche");
	assertEquals("marche", test.getPrenom());
	}

	@Test
	public void testGetSetMail() {
		/**
		 * personne get set mail
		 */
		Inscriptions inscriptions = Inscriptions.getInscriptions();
		Personne test = inscriptions.createPersonne("nom", "prenom", "mail");
		test.setMail("marche");
		assertEquals("marche", test.getMail());
	}
	@Test
	public void testGetSetNom() {
		Inscriptions inscriptions = Inscriptions.getInscriptions();
		Personne test = inscriptions.createPersonne("nom", "prenom", "mail");
		test.setNom("marche");
		assertEquals("marche", test.getNom());
	}


//EQUIPES------------------------------------------------------------------------------------

	@Test
	public void testAddRemoveEquipe() {
		Inscriptions inscriptions = Inscriptions.getInscriptions();
		Equipe testEquipe = inscriptions.createEquipe("Les Manouches");
		Personne test = inscriptions.createPersonne("nom", "prenom", "mail");
		testEquipe.add(test);
		assertTrue(testEquipe.remove(test));
	}
	
	@Test
	public void testgetMembreEquipe() {
		Inscriptions inscriptions = Inscriptions.getInscriptions();
		Equipe testEquipe = inscriptions.createEquipe("Les Manouches");
		Personne test = inscriptions.createPersonne("nom", "prenom", "mail");
		testEquipe.add(test);
		testEquipe.getMembres();
	}



//COMPETITION------------------------------------------------------------------------------------	
	@Test
	public void testGetSetNomComp() {
		/**
		 * personne get et set prenom
		 */
		Inscriptions inscriptions = Inscriptions.getInscriptions();
		Competition testcompetition = inscriptions.createCompetition("Competition", null, false);
	testcompetition.setNom("marche");
	assertEquals("marche", testcompetition.getNom());
	}

	@Test
	public void testSetGetDate() {
		
		Inscriptions inscriptions = Inscriptions.getInscriptions();
		Competition testcompetition = inscriptions.createCompetition("Competition", null, false);
	
		
	}
	@Test
	public void testComparetoComp() {
		
		Inscriptions inscriptions = Inscriptions.getInscriptions();
		Competition testcompetition = inscriptions.createCompetition("Competition", null, false);
		Competition testcompetition2 = inscriptions.createCompetition("Competition", null, false);
	assertEquals(0,testcompetition.compareTo(testcompetition2));
	}

	@Test
	public void testRemoveComp() {
		Inscriptions inscriptions = Inscriptions.getInscriptions();
		Competition testcompetition = inscriptions.createCompetition("Competition", null, false);
		Equipe testEquipe = inscriptions.createEquipe("Les Manouches");
		testcompetition.add(testEquipe);
		assertNull(testcompetition.remove(testEquipe));
	}

	@Test
	public void testreDelete() {
		Inscriptions inscriptions = Inscriptions.getInscriptions();
		Competition testcompetition = inscriptions.createCompetition("Competition", null, false);
		Equipe testEquipe = inscriptions.createEquipe("Les Manouches");
		testcompetition.add(testEquipe);

	}
	
	@Test
	public void testinscritptionOuverteComp() {
		Inscriptions inscriptions = Inscriptions.getInscriptions();
		Competition testcompetition = inscriptions.createCompetition("Competition", null, false);
		assertTrue(testcompetition.inscriptionsOuvertes());
	}

}
