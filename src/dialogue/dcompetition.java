package dialogue;

import static commandLineMenus.rendering.examples.util.InOut.getString;

import java.time.LocalDate;
import java.util.ArrayList;
import commandLineMenus.*;
import inscriptions.*;

public class dcompetition {
	
	static Inscriptions dinscriptions = Inscriptions.getInscriptions();
	
	Menu menuCompetition()
	{
		Menu menu = new Menu("G�rer les Competitions", "3");
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
		return new Option("Ajouter une Competition", "2", () -> {dinscriptions.createCompetition(getString("Nom de la Comp�tition : "), LocalDate.parse(getString("Date Cloture (YYYY-MM-DD) : ")), Boolean.parseBoolean(getString("Comp�tition r�serv� aux �quipes (true/false) : ")) );});
	}
	
	private List<Competition> selectionnerCompetition()
	{
		return new List<Competition>("S�lectionner une Comp�tition", "3", 
				() -> new ArrayList<>(dinscriptions.getCompetitions()),
				(element) -> editerCompetition(element)
				);
	}
		
	private Menu editerCompetition(Competition competition)
	{
		Menu menu = new Menu("Editer"+ " " + competition.getNom());
		menu.add(afficherInfoComp(competition));
		menu.add(modifierCompetition(competition));
		menu.add(supprimerCompetition(competition));
		menu.add(new dcandidat().menuCandidats(competition));
		menu.addBack("q");
		return menu;
	}
	
	private Option afficherInfoComp(Competition competition)
	{
	
		return new Option("Afficher les d�tails de la comp�tition", "1", () -> {System.out.println(competition.getNom() + " " + competition.getDateCloture().toString() + " " + String.valueOf(competition.estEnEquipe()));});
				
	}

	private Option supprimerCompetition(Competition competition) 
	{
		return new Option("Supprimer " + " " + competition.getNom(), "3", () -> {competition.delete();});
	}
	
	private Menu modifierCompetition(Competition competition)
	{
		Menu menu = new Menu("modifier " +  competition.getNom(),"2");
		menu.add(nomComp(competition));
		menu.add(dateCloture(competition));
		menu.addBack("q");
		return menu;
	}
	
	private Option nomComp(Competition competition) 
	{
		return new Option("Modifier nom", "1", () -> { competition.setNom(getString("Nom : ")); });
	}

	private Option dateCloture(Competition competition) 
	{
		return new Option("Modifier date de cloture", "2", () -> { competition.setDateCloture(LocalDate.parse(getString("Date Cloture (YYYY-MM-DD) : "))); });
	}
	

}
