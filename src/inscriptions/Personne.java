package inscriptions;

import java.util.Collections;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.*;

import hibernate.Passerelle;

/**
 * Représente une personne physique pouvant s'inscrire à une compétition.
 */
@Entity @Table(name="Personne")
@PrimaryKeyJoinColumn(name="num_candidat")
public class Personne extends Candidat
{
	@Transient
	private static final long serialVersionUID = 4434646724271327254L;
	
	@Transient
	private Inscriptions inscriptions;
	
	 @Column (name="prenom")
	private String prenom;
	 
	 @Column (name="mail")
	private String mail;
	 
	@ManyToMany( cascade = CascadeType.PERSIST)
	@JoinTable(name = "composer", joinColumns = @JoinColumn(name = "num_candidat_Personne"),
    inverseJoinColumns = @JoinColumn(name = "num_candidat_Equipe"))
	private Set<Equipe> equipes;
	 
	Personne(Inscriptions inscriptions, String nom, String prenom, String mail)
	{
		
		super(inscriptions, nom);
		this.prenom = prenom;
		this.mail = mail;
		equipes = new TreeSet<>();

	}


	Personne(){
		//constructeur for hibernate
	}
	/**
	 * Retourne le prénom de la personne.
	 * @return
	 */
	
	public String getPrenom()
	{
		return prenom;
	}

	/**
	 * Modifie le prénom de la personne.
	 * @param prenom
	 */
	
	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	/**
	 * Retourne l'adresse électronique de la personne.
	 * @return
	 */
	
	public String getMail()
	{
		return mail;
	}

	/**
	 * Modifie l'adresse électronique de la personne.
	 * @param mail
	 */
	
	public void setMail(String mail)
	{
		this.mail = mail;
	}

	/**
	 * Retoure les équipes dont cette personne fait partie.
	 * @return
	 */
	
	public Set<Equipe> getEquipes()
	{
		return Collections.unmodifiableSet(equipes);
	}
	
	boolean add(Equipe equipe)
	{
		return equipes.add(equipe);
	}

	boolean remove(Equipe equipe)
	{
		return equipes.remove(equipe);
	}
	
	@Override
	public void delete()
	{
		
		super.delete();
		for (Equipe e : equipes)
			e.remove(this);
		

		
	}
	
	@Override
	public String toString()
	{
		return super.toString() + " membre de " + equipes.toString();
	}
}
