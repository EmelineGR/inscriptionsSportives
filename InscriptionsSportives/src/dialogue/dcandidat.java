package dialogue;

import java.util.ArrayList;

import commandLineMenus.List;
import commandLineMenus.Menu;
import commandLineMenus.Option;
import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;


public class dcandidat {
	
	static Inscriptions dinscriptions = Inscriptions.getInscriptions();
	

	Menu menuCandidats(Competition competition)
	{
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
		menu.add(selectCandidat(competition));
		return menu;
	}
	
	
	private Option affiCandidat(Competition competition)
	{
		return new Option("Afficher les Candidats de " + competition.getNom(), "1", () ->{System.out.println(competition.getCandidats());});
	}
		
	private List<Candidat> selectionnerMembres(Competition competition)
	{	
		return new List<Candidat>("Supprimer membres" , "1", 
				() -> new ArrayList<>(competition.getCandidats()),
				(element) -> suprCandidat(element,equipe)
				);
	}
	
	private Option suprCandidat(Candidat element ,Competition competition)
	{
		return new Option("Supprimer le Candidat" , "", () -> {equipe.remove(element);});
	}
	
	/*private Option selectCandidat(Competition competition)
	{
		return null;
	}*/
}