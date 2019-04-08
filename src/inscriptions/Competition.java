package inscriptions;

import java.io.Serializable;

import java.util.Collections;
import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.*;
/**
 * Représente une compétition, c'est-à-dire un ensemble de candidats 
 * inscrits à un événement, les inscriptions sont closes à la date dateCloture.
 *
 */
@Entity @Table( name = "Competition")
public class Competition implements Comparable<Competition>, Serializable
{
	@Transient
	private static final long serialVersionUID = -2882150118573759729L;
	@Transient
	private Inscriptions inscriptions;
	
	private String nom;
	
	@ManyToMany(mappedBy="competitions", cascade = CascadeType.PERSIST)
	private Set<Candidat> candidats;
	  
	private LocalDate dateCloture;
	private boolean enEquipe = false;

	Competition(Inscriptions inscriptions, String nom, LocalDate dateCloture, boolean enEquipe)
	{
		this.enEquipe = enEquipe;
		this.inscriptions = inscriptions;
		this.nom = nom;
		this.dateCloture = dateCloture;
		candidats = new TreeSet<>();
	}
	
	/**
	 * Retourne le nom de la compétition.
	 * @return
	 */
	
	public String getNom()
	{
		return nom;
	}
	
	/**
	 * Modifie le nom de la compétition.
	 */
	
	public void setNom(String nom)
	{
		this.nom = nom ;
	}
	
	/**
	 * Retourne vrai si les inscriptions sont encore ouvertes, 
	 * faux si les inscriptions sont closes.
	 * @return
	 */
	
	public boolean inscriptionsOuvertes()
	{
		// TODO Fait ! retourner vrai si et seulement si la date système est antérieure à la date de clôture.
		LocalDate DateSys = LocalDate.now();
		return DateSys.isBefore(getDateCloture());
	}
	
	/**
	 * Retourne la date de cloture des inscriptions.
	 * @return
	 */
	
	public LocalDate getDateCloture()
	{
		return dateCloture;
	}
	
	/**
	 * Est vrai si et seulement si les inscriptions sont réservées aux équipes.
	 * @return
	 */
	
	public boolean estEnEquipe()
	{
		return enEquipe;
	}
	
	/**
	 * Modifie la date de cloture des inscriptions. Il est possible de la reculer 
	 * mais pas de l'avancer.
	 * @param dateCloture
	 */
	
	public void setDateCloture(LocalDate dateCloture)
	{
		// TODO Fait ! vérifier que l'on avance pas la date.
		if (dateCloture.isAfter(this.dateCloture));
			this.dateCloture = dateCloture;
	}
	
	/**
	 * Retourne l'ensemble des candidats inscrits.
	 * @return
	 */
	
	public Set<Candidat> getCandidats()
	{
		return Collections.unmodifiableSet(candidats);
	}
	
	/**
	 * Inscrit un candidat de type Personne à la compétition. Provoque une
	 * exception si la compétition est réservée aux équipes ou que les 
	 * inscriptions sont closes.
	 * @param personne
	 * @return
	 */
	
	public boolean add(Personne personne)
	{
		// TODO Fait ! vérifier que la date de clôture n'est pas passée

		if (enEquipe || ! inscriptionsOuvertes())
			throw new RuntimeException();
		personne.add(this);
		return candidats.add(personne);
	}

	/**
	 * Inscrit un candidat de type Equipe à la compétition. Provoque une
	 * exception si la compétition est réservée aux personnes ou que 
	 * les inscriptions sont closes.
	 * @param personne
	 * @return
	 */

	public boolean add(Equipe equipe)
	{
		// TODO Fait ! vérifier que la date de clôture n'est pas passée
		if (!enEquipe || !inscriptionsOuvertes())
			throw new RuntimeException();
		equipe.add(this);
		return candidats.add(equipe);
	}
	
	/**
	 * Retourne les personnes que l'on peut inscrire à cette competition.
	 * @return les personnes que l'on peut inscrire à cette compétition.
	 */
	
	public Set<Personne> getPersonnesAInscrire()
	{
		// TODO Fait ! retourner les personnes que l'on peut inscrire à cette compétition.
		Set<Personne> PersonneAInscrire = new TreeSet<>();
		for (Personne personnes : inscriptions.getPersonnes())
			if (!(getCandidats()).contains(personnes))
				PersonneAInscrire.add(personnes);
		return PersonneAInscrire;
	}
	/**
	 * Retourne les equipes que l'on peut inscrire à cette competition.
	 * @return les equipes que l'on peut inscrire à cette compétition.
	 */
	/*ajouter pour les dialogues*/
	public Set<Equipe> getEquipesAInscrire()
	{
		
		Set<Equipe> EquipeAInscrire = new TreeSet<>();
		for (Equipe equipes : inscriptions.getEquipes())
			if (!(getCandidats()).contains(equipes))
				EquipeAInscrire.add(equipes);
		return EquipeAInscrire;
	}

	/**
	 * Désinscrit un candidat.
	 * @param candidat
	 * @return
	 */
	
	public boolean remove(Candidat candidat)
	{
		candidat.remove(this);
		return candidats.remove(candidat);
	}
	
	/**
	 * Supprime la compétition de l'application.
	 */
	
	public void delete()
	{
		for (Candidat candidat : candidats)
			remove(candidat);
		inscriptions.delete(this);
	}
	
	@Override
	public int compareTo(Competition o)
	{
		return getNom().compareTo(o.getNom());
	}
	
	@Override
	public String toString()
	{
		return getNom();
	}
}
