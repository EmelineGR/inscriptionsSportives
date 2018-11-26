package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

class TestCompetition {
	Inscriptions inscriptions = Inscriptions.getInscriptions();
	LocalDate eme3 = LocalDate.of(2014,11,26);
	LocalDate eme = LocalDate.of(2019,11,26);
	Competition testcompetition = inscriptions.createCompetition("Competition", eme3, false);
	Personne test = inscriptions.createPersonne("nom", "prenom", "mail");
	Equipe testEquipe = inscriptions.createEquipe("Les Manouches");
	Competition testcompetition2 = inscriptions.createCompetition("Competition", eme, true);

	
	
	
	
	

	@Test
	public void testGetSetNom() {
		/**
		 * personne get et set prenom
		 */

	testcompetition.setNom("marche");
	assertEquals("marche", testcompetition.getNom());
	}

	
	
	
	@Test
	public void inscrioOuverte() {
		testcompetition.setDateCloture(eme);
	assertTrue(testcompetition.inscriptionsOuvertes());
	}
	
	
	
	
	@Test
	public void getdatecloture() {
		testcompetition.setDateCloture(eme);
		LocalDate eme2 = testcompetition.getDateCloture();
	assertEquals(eme,eme2);
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
	public void getAddEquipes() {
testcompetition2.add(testEquipe);
assertTrue(testcompetition2.getCandidats().contains(testEquipe));
		
	}
	
	@Test
	public void remove() {
		testEquipe.add(test);
		assertTrue(test.getEquipes().contains(testEquipe));
		
		testEquipe.remove(test);
		assertFalse(test.getEquipes().contains(testEquipe));
	}
	
	
	
	
	
	
	
	@Test
	public void getPersonneAinscrire() {
		Personne emeline = inscriptions.createPersonne("emeline", "emeline", "emeline");
	
		assertTrue(testcompetition.getPersonnesAInscrire().contains(emeline));
		
		
	}
	
	
	
	
	
	

}
