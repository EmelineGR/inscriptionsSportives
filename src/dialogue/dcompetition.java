package dialogue;

import static commandLineMenus.rendering.examples.util.InOut.getString;

import java.time.LocalDate;
import java.util.ArrayList;
import commandLineMenus.List;
import commandLineMenus.Menu;
import commandLineMenus.Option;
import inscriptions.Competition;
import inscriptions.Inscriptions;

public class dcompetition {
	
	static Inscriptions dinscriptions = Inscriptions.getInscriptions();
	
	Menu menuCompetition()
	{
		Menu menu = new Menu("Gérer les Competitions", "3");
		menu.add(afficheCompetition());
		menu.add(ajouterCompetition());
		menu.add(selectionnerCompetition());
		menu.addBack("q");
		return menu;
	}

	private Option afficheCompetition()
	{
		return new Option("Afficher les Competitions", "1", () -> {System.out.println(dinscriptions.getCompetitions());});
	}
	
	
	private Option ajouterCompetition()
	{		
		return new Option("Ajouter une Competition", "2", () -> {dinscriptions.createCompetition(getString("Nom de la Compétition : "), LocalDate.parse(getString("Date Cloture (YYYY-MM-DD) : ")), Boolean.parseBoolean(getString("Compétition réservé aux équipes (O/N) : ")) );});
	}
	
	private List<Competition> selectionnerCompetition()
	{
		return new List<Competition>("Sélectionner une Compétition", "3", 
				() -> new ArrayList<>(dinscriptions.getCompetitions()),
				(element) -> editerCompetition(element)
				);
	}
		
	private Menu editerCompetition(Competition competition)
	{
		Menu menu = new Menu("Editer"+ " " + competition.getNom());
		menu.add(afficherInfoComp(competition));
		menu.add(supprimerCompetition(competition));
		menu.add(new dcandidat().menuCandidats(competition));
		menu.addBack("q");
		return menu;
	}
	
	private Option afficherInfoComp(Competition competition)
	{
	
		return new Option("Afficher les détails de la compétition", "1", () -> {System.out.println(competition.getNom() + " " + competition.getDateCloture().toString() + " " + String.valueOf(competition.estEnEquipe()));});
				
	}

	private Option supprimerCompetition(Competition competition) 
	{
		return new Option("Supprimer " + " " + competition.getNom(), "2", () -> {competition.delete();});
	}
	
		
}
