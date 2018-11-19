package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

class TestEquipe {
	Inscriptions inscriptions = Inscriptions.getInscriptions();
	Competition testcompetition = inscriptions.createCompetition("Competition", null, false);
	Personne test = inscriptions.createPersonne("nom", "prenom", "mail");
	Equipe testEquipe = inscriptions.createEquipe("Les Manouches");
	Competition testcompetition2 = inscriptions.createCompetition("Competition", null, false);
	LocalDate eme = LocalDate.of(2014,3, 1);
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
