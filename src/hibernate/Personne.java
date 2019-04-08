package hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
class Personne
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int num;

	private String nom;

	private String prenom;
	
	private String mail;

	public Personne(String prenom, String nom, String mail)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.setMail(mail);
	}

	int getNum()
	{
		return num;
	}

	void setNum(int num)
	{
		this.num = num;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString()
	{
		return prenom + " " + nom;
	}

}
