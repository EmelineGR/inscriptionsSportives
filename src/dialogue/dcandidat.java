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
		menu.add(selectionnerEquipe(competition));
		menu.addBack("q");
		return menu;
	}
	
	private Option afficherCandidats(Competition competition)
	{
		return new Option("Afficher les Candidats", "1", () -> {System.out.println(competition.getCandidats());});
	}
	
	private List<Candidat> selectionnerEquipe(Competition competition)
	{	
		return new List<Candidat>("Supprimer un candidat" , "2", 
				() -> new ArrayList<>(competition.getCandidats()),
				(element) -> SupCandidat(element,competition)
				);
	}
	private Option SupCandidat(Candidat candidat , Competition competition)
	{
		return new Option("Supprimer un candidat" + " " + candidat.getNom(), "", () -> {competition.remove(candidat);});
	}
	

	/*private Competition competition;

	Menu menuCandidats(Competition competition)
	{
		this.competition = competition;
		
		for(Candidat candidat : dinscriptions.getCandidats())
		{
			if((candidat instanceof Equipe && competition.estEnEquipe()) && !competition.getCandidats().contains(candidat) ||
					(candidat instanceof Personne && !competition.estEnEquipe() && !competition.getCandidats().contains(candidat)))
			{
				Candidats.add(candidat);
			}
		}
		
		Menu menu = new Menu("Gérer les Candidats", "3");
		menu.add(affiCandidat(competition));
		menu.add(MenusupprCandidat(competition));
		
		
		
		return menu;
	}
	
	
	private Option affiCandidat(Competition competition)
	{
		return new Option("Afficher les Candidats de " + competition.getNom(), "1", () ->{Candidats.forEach(candidat->System.out.println(candidat));});
	}
	
	private Menu menusupprCandidat(Competition competition)
	{
		// Creates a menu with an option for each people in the list
		List<Candidat> menu = new List<Candidat>("Suppression d'un candidat","2",
				new ListData<Candidat>()		
				{
					// Returns the data needed to refresh the list 
					// each time it is displayed. 
					public java.util.List<Candidat> getList()
					{
						return Candidats;
					}	
				},
				new ListAction<Candidat>()
				{				
					// Triggered each time an item is selected
					public void itemSelected(int index, Candidat candidat)
					{
						competition.remove(candidat);
						System.out.println("Vous avez supprimé " + candidat.getNom());
					}
				});
		return menu;
	}
	*/
}