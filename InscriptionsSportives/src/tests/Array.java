package inscriptions;

import static org.junit.Assert.*;

import org.junit.Test;

public class Array {

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}


	@Test
	public void testGetSetPrenom() {
		Inscriptions inscriptions = Inscriptions.getInscriptions();
	Personne test = inscriptions.createPersonne("nom", "prenom", "mail");
	test.setPrenom("marche");
	assertEquals("marche", test.getPrenom());
	}

	@Test
	public void testGetSetMail() {
		Inscriptions inscriptions = Inscriptions.getInscriptions();
		Personne test = inscriptions.createPersonne("nom", "prenom", "mail");
		test.setMail("marche");
		assertEquals("marche", test.getMail());
	}

	@Test
	public void testGetaddEquipes() {
		Inscriptions inscriptions = Inscriptions.getInscriptions();
		Personne test = inscriptions.createPersonne("nom", "prenom", "mail");
	
		Competition testcompetition = inscriptions.createCompetition("Competition", null, false);
		testcompetition.add(test);
		assertEquals("Competition",test.getEquipes());
	}


	@Test
	public void testRemoveEquipe() {
		Inscriptions inscriptions = Inscriptions.getInscriptions();
		Competition testcompetition = inscriptions.createCompetition("Competition", null, false);
		testcompetition.delete();
		assertEquals("",testcompetition.toString());
	}

	@Test
	public void testGetSetNom() {
		Inscriptions inscriptions = Inscriptions.getInscriptions();
		Personne test = inscriptions.createPersonne("nom", "prenom", "mail");
		test.setNom("marche");
		assertEquals("marche", test.getNom());
	}

	@Test
	public void testGetSetCompetition() {
		fail("Not yet implemented");
	}


	@Test
	public void testRemoveCompetition() {
		fail("Not yet implemented");
	}

	@Test
	public void testCompareTo() {
		fail("Not yet implemented");
	}

}
