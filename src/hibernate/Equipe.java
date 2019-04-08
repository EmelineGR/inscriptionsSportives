package hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
class Equipe
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int num;

	private String nom;

	public Equipe(String nom)
	{
		this.nom = nom;
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
}
