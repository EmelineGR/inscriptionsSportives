package dialogue;

import java.util.ArrayList;

import commandLineMenus.*;
import inscriptions.*;


public class dcandidat {
	
	static Inscriptions dinscriptions = Inscriptions.getInscriptions();
	final ArrayList<Candidat> Candidats = new ArrayList<>();
	private Competition competition;
	
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
	
}