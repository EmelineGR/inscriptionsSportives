package inscriptions;

import java.util.Collections;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.*;

import hibernate.Passerelle;
/**
 * Représente une Equipe. C'est-à-dire un ensemble de personnes pouvant 
 * s'inscrire à une compétition.
 * 
 */
@Entity @Table(name="Equipe")
@PrimaryKeyJoinColumn(name="num_candidat")// HIBERNATE VA CHERCHER NUM_CANDIDAT ET EN FAIRE LA CLE PRIMAIRE DE EQUIPE DONC LA RELATION MERE ,FILLE
public class Equipe extends Candidat
{
	@Transient
	private static final long serialVersionUID = 4147819927233466035L;
	@Transient
	private  Inscriptions inscriptions;
	@ManyToMany( cascade = CascadeType.PERSIST)
	@OrderBy("num_candidat asc")// je sais pas pourquoi mais d'apres l'erreur " A sorted collection must define and ordering or sorting" il faut mettre un ordre a cette relation
	private SortedSet<Personne> membres = new TreeSet<>();
	

	Equipe(Inscriptions inscriptions, String nom)
	{
		super(inscriptions, nom);
		

	}

	Equipe(){
		//CONTRUSCTEUR FOR HIBERNATE
	}
	/**
	 * Retourne l'ensemble des personnes formant l'équipe.
	 */
	
	public SortedSet<Personne> getMembres()
	{
		return Collections.unmodifiableSortedSet(membres);
	}
	
	/**
	 * Ajoute une personne dans l'équipe.
	 * @param membre
	 * @return
	 */

	public boolean add(Personne membre)
	{
		membre.add(this);
		return membres.add(membre);
	}

	/**
	 * Supprime une personne de l'équipe. 
	 * @param membre
	 * @return
	 */
	
	public boolean remove(Personne membre)
	{
		membre.remove(this);
		return membres.remove(membre);
	}

	/**
	 * Retourne les personnes que l'on peut ajouter dans cette équipe.
	 * @return les personnes que l'on peut ajouter dans cette équipe.
	 */
	
	public Set<Personne> getPersonnesAAjouter()
	{
		// TODO retourner les personnes que l'on peut ajouter dans cette équipe.
		Set<Personne> PersonneAAjouter = new TreeSet<>();
		for (Personne personnes : Inscriptions.getInscriptions().getPersonnes())
			if (!getMembres().contains(personnes))
				PersonneAAjouter.add(personnes);
		return PersonneAAjouter;
	}
	
	@Override
	public void delete()
	{
		super.delete();
	}
	
	@Override
	public String toString()
	{
		return "Equipe " + super.toString();
	}
}
