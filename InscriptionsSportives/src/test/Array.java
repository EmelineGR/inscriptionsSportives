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

	Inscriptions inscriptions = Inscriptions.getInscriptions();
	Competition testcompetition = inscriptions.createCompetition("Competition", null, false);
	Personne test = inscriptions.createPersonne("nom", "prenom", "mail");
	Equipe testEquipe = inscriptions.createEquipe("Les Manouches");
	Competition testcompetition2 = inscriptions.createCompetition("Competition", null, false);
//PERSONNE-----------------------------------------------------------------------------

	@Test
	public void testGetSetPrenom() {
		/**
		 * personne get et set prenom
		 */

	test.setPrenom("marche");
	assertEquals("marche", test.getPrenom());
	}

	@Test
	public void testGetSetMail() {
		/**
		 * personne get set mail
		 */

		test.setMail("marche");
		assertEquals("marche", test.getMail());
	}
	@Test
	public void testGetSetNom() {

		test.setNom("marche");
		assertEquals("marche", test.getNom());
	}


//EQUIPES------------------------------------------------------------------------------------

	@Test
	public void testAddRemoveEquipe() {

		testEquipe.add(test);
		assertTrue(testEquipe.remove(test));
	}
	
	@Test
	public void testgetMembreEquipe() {

		testEquipe.add(test);
		testEquipe.getMembres();
	}



//COMPETITION------------------------------------------------------------------------------------	
	@Test
	public void testGetSetNomComp() {
		/**
		 * personne get et set prenom
		 */

	testcompetition.setNom("marche");
	assertEquals("marche", testcompetition.getNom());
	}

	@Test
	public void testSetGetDate() {
		

	
		
	}
	@Test
	public void testComparetoComp() {
		
	
	assertEquals(0,testcompetition.compareTo(testcompetition2));
	}

	@Test
	public void testRemoveComp() {

		testcompetition.add(testEquipe);
		assertNull(testcompetition.remove(testEquipe));
	}

	@Test
	public void testreDelete() {
		testcompetition.add(testEquipe);

	}
	
	@Test
	public void testinscritptionOuverteComp() {

		assertTrue(testcompetition.inscriptionsOuvertes());
	}
	


}
