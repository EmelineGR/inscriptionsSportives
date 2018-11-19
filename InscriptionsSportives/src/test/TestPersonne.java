package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

class TestPersonne {
	Inscriptions inscriptions = Inscriptions.getInscriptions();
	Competition testcompetition = inscriptions.createCompetition("Competition", null, false);
	Personne test = inscriptions.createPersonne("nom", "prenom", "mail");
	Equipe testEquipe = inscriptions.createEquipe("Les Manouches");
	Competition testcompetition2 = inscriptions.createCompetition("Competition", null, false);
	LocalDate eme = LocalDate.of(2014,3, 1);


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

	@Test
	public void getAddEquipes() {
testEquipe.add(test);
assertTrue(test.getEquipes().contains(testEquipe));
		
	}
	
	@Test
	public void remove() {
		testEquipe.add(test);
		assertTrue(test.getEquipes().contains(testEquipe));
		
		testEquipe.remove(test);
		assertFalse(test.getEquipes().contains(testEquipe));
	}
}
