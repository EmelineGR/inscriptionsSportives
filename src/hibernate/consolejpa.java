package hibernate;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import hibernate.Passerelle;
import inscriptions.Competition;

public class consolejpa {



	 public static void main(String[] args) throws Exception {
Passerelle.open();
hibernate.Competition emeline = new hibernate.Competition();
Passerelle.save(emeline);
}
	    

}