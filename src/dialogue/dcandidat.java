package dialogue;

import static commandLineMenus.rendering.examples.util.InOut.getString;

import java.util.ArrayList;

import commandLineMenus.*;
import inscriptions.*;


public class dcandidat {
	
	static Inscriptions dinscriptions = Inscriptions.getInscriptions();

	Menu menuCandidats(Competition competition)
	{
		Menu menu = new Menu("Editer Candidat", "3");
		menu.add(afficherCandidats(competition));
		menu.add(ajoutCandidat(competition));
		menu.add(selectionnerEquipe(competition));
		menu.addBack("q");
		return menu;
	}
	
	private Option afficherCandidats(Competition competition)
	{
		return new Option("Affichez les Candidats", "1", () -> {System.out.println(competition.getCandidats());});
	}
	
	
	private Option ajoutCandidat(Competition competition)
	{
		if (competition.estEnEquipe() && competition.inscriptionsOuvertes())
			return ajoutEquipe(competition);
		else if (!competition.estEnEquipe() && competition.inscriptionsOuvertes())
			return ajoutPersonne(competition);
		else 
			return afficherCandidats(competition);
	}
	
	private List<Personne> ajoutPersonne(final Competition competition)
	{
		return new List<>("Ajouter une Personne", "2", 
				() -> new ArrayList<>(competition.getPersonnesAInscrire()),
				(index, element) -> {competition.add(element);}
				);
	}
	
	private List<Equipe> ajoutEquipe(final Competition competition)
	{
		return new List<>("Ajouter une Equipe", "2", 
				() -> new ArrayList<>(competition.getEquipesAInscrire()),
				(index, element) -> {competition.add(element);}
				);
	}
	
	private List<Candidat> selectionnerEquipe(Competition competition)
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