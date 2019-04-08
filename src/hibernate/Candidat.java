package hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity @Table( name = "Candidat")
@Inheritance(strategy=InheritanceType.JOINED)
public class Candidat {
	
	 @Id @GeneratedValue( strategy=GenerationType.IDENTITY )// permet de dire que num  competition  est la clé primaire
	private int Num_Candidat;
	 private String Nom_Candidat;

}
