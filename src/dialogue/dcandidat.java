package dialogue;

import java.util.ArrayList;

import commandLineMenus.*;
import inscriptions.*;


public class dcandidat {
	
	static Inscriptions dinscriptions = Inscriptions.getInscriptions();

	Menu menuCandidats(Competition competition)
	{
		Menu menu = new Menu("Editer Candidat", "4");
		menu.add(afficherCandidats(competition));
		
		if(competition.inscriptionsOuvertes()) {
			if (competition.estEnEquipe()) {
				menu.add(ajoutEquipe(competition));
			}
			else if (!(competition.estEnEquipe())) {
				menu.add(ajoutPersonne(competition));
				
			}
			menu.add(selectionnerCandidat(competition));
		}

		
		menu.addBack("q");
		return menu;
	}
	
	// Dialogue permettant de choisir l'option 1 pour afficher la liste des candidat de la compétition
	private Option afficherCandidats(Competition competition)
	{
		return new Option("Affichez les Candidats", "1", () -> {System.out.println(competition.getCandidats());});
	}
	
	// Dialogue permettant de choisir l'option 2 pour ajouter une personne à la compétition en listant les personne à inscrire et leur donnant un index
	private List<Personne> ajoutPersonne(Competition competition)
	{
		return new List<Personne>("Ajouter une Personne", "2", 
				() -> new ArrayList<>(competition.getPersonnesAInscrire()),
				(index, element) -> {competition.add(element);}
				);
	}
	
	//Dialogue permettant de choisir l'option 2 pour ajouter une équipe à la compétition en listant les équipe qui ne sont pas inscrite et leur donnant un index
	private List<Equipe> ajoutEquipe(Competition competition)
	{
		return new List<Equipe>("Ajouter une Equipe", "2", 
				() -> new ArrayList<>(competition.getEquipesAInscrire()),
				(index, element) -> {competition.add(element);}
				);
	}
	
	//Renvoie la liste des candidat inscrit à la compétition avec un index si choisis l'option 3
	private List<Candidat> selectionnerCandidat(Competition competition)
	{	
		return new List<Candidat>("Supprimer un candidat" , "3", 
				() -> new ArrayList<>(competition.getCandidats()),
				(element) -> SupCandidat(element,competition)
				);
	}
	
	private Option SupCandidat(Candidat candidat , Competition competition)
	{
		return new Option("Supprimez un candidat" + " " + candidat.getNom(), "", () -> {competition.remove(candidat);});
	}
	
}