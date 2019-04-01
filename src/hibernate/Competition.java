package hibernate;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table( name = "Competition")
class Competition
{
	 @Id @GeneratedValue( strategy=GenerationType.IDENTITY )// permet de dire que num  competition  est la clé primaire
	private int Num_Competition;

	private String Nom_Competition;

	private LocalDate DateCloture_Comp;

	Competition()
	{
	}

	public Competition(String Nom_Competition, LocalDate DateCloture_Comp)
	{
		this.Nom_Competition = Nom_Competition;
		this.DateCloture_Comp = DateCloture_Comp;
	}

	int getNum()
	{
		return Num_Competition;
	}

	void setNum(int Num_Competition)
	{
		this.Num_Competition = Num_Competition;
	}

	public String getNom()
	{
		return Nom_Competition;
	}

	public void setNom(String Nom_Competition)
	{
		this.Nom_Competition = Nom_Competition;
	}

	public LocalDate getDateCloture()
	{
		return DateCloture_Comp;
	}

	public void setDateCloture(LocalDate DateCloture_Comp)
	{
		this.DateCloture_Comp = DateCloture_Comp;
	}

	@Override
	public String toString()
	{
		return "num : "+getNum()+ " ; nom : "+getNom()+" ; date cloture : "+getDateCloture();
	}
}
