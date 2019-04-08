package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import hibernate.Passerelle;
import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

class TestHibernate {
	
	@Test
	 public final void test() {
		Passerelle.open();
		hibernate.Competition emeline = new hibernate.Competition();
		Passerelle.save(emeline);
	}

}
