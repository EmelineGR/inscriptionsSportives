package inscriptions;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import hibernate.Passerelle;

/**
 * Candidat Ã  un Ã©vÃ©nement sportif, soit une personne physique, soit une Ã©quipe.
 *
 */
@Entity @Table(name="Candidat")// CLASS = NEW ENTITER CANDIDAT
@Inheritance(strategy=InheritanceType.JOINED)//La clé primaire de l' entité fille a également une contrainte de clé étrangère sur la clé primaire de celle mere ici
public abstract class Candidat implements Comparable<Candidat>, Serializable
{
	@Transient
	private static final long serialVersionUID = -6035399822298694746L;
	
	@Transient// elle n'est pas prit en compte par hibernate
	private Inscriptions inscriptions;
	
    @Id @GeneratedValue( strategy=GenerationType.IDENTITY )// cle primaire avec generation gerer par la bdd
	private int num_candidat;
    
	@Column (name="nom_candidat")// column est obligatoire permet de mapper les column de la bdd
    private String nom;
	
    @ManyToMany(cascade = CascadeType.PERSIST)// si un champs de la bdd est supprimer et qu'il avait une cle etrangere supprime sa cle
    @JoinTable(name = "constituer", joinColumns = @JoinColumn(name = "num_candidat"),// SERT A CREER UN l'entiter CONSTITUER AVEC LA COLUMN NUM CANDIDAT ET NUM_COMPET 
    inverseJoinColumns = @JoinColumn(name = "NumCompet"))// voir video https://www.youtube.com/watch?v=zbH59X281f4&t=324s
	private Set<Competition> competitions; 
	
	
	Candidat(Inscriptions inscriptions, String nom)
	{
	
		this.inscriptions = inscriptions;	
		this.nom = nom;
		competitions = new TreeSet<>();
	
	}

	Candidat(){
		// constructeur pour hibernate
	}
	/**
	 * Retourne le nom du candidat.
	 * @return
	 */
	
	public String getNom()
	{
		return nom;
	}

	/**
	 * Modifie le nom du candidat.
	 * @param nom
	 */
	
	public void setNom(String nom)
	{
		this.nom = nom;
	}

	/**
	 * Retourne toutes les compÃ©titions auxquelles ce candidat est inscrit.s
	 * @return
	 */

	public Set<Competition> getCompetitions()
	{
		return Collections.unmodifiableSet(competitions);
	}
	
	boolean add(Competition competition)
	{
		return competitions.add(competition);
	}

	boolean remove(Competition competition)
	{
		
		return competitions.remove(competition);
	}

	/**
	 * Supprime un candidat de l'application.
	 */
	
	public void delete()
	{
		for (Competition c : competitions)
			
			c.remove(this);
		inscriptions.delete(this);
	}
	
	@Override
	public int compareTo(Candidat o)
	{
		return getNom().compareTo(o.getNom());
	}
	
	@Override
	public String toString()
	{
		return "\n" + getNom() + " -> inscrit Ã  " + getCompetitions();
	}
}
