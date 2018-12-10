package dialogue;

import static commandLineMenus.rendering.examples.util.InOut.getString;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

import commandLineMenus.Action;
import commandLineMenus.List;
import commandLineMenus.Menu;
import commandLineMenus.Option;
import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;

public class dcompetition {

	private Inscriptions dinscriptions;
	
	public dcompetition(Inscriptions inscriptions)
	{
		this.dinscriptions = inscriptions;
	}
	
	public void start()
	{
		menuPrincipal().start();
	}
	
	private Menu menuPrincipal()
	{
		Menu menu = new Menu("Gestion du personnel des ligues");
		menu.add(menuCompetition());
		menu.add(menuQuitter());
		return menu;
	}
			
	/// Competition ---------------------------------------------------------------------------
	private Menu menuCompetition()
	{
		Menu menu = new Menu("Gérer les Equipes", "1");
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
	
	public static DateTimeFormatter ofLocalizedDateTime(FormatStyle dateTimeStyle)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dateTimeStyle");
		
	}
	
	private Option ajouterCompetition()
	{
		return new Option("Ajouter une Competition", "2", () -> {dinscriptions.createCompetition(getString("nom : "), ofLocalizedDateTime.getString("Date Cloture (YYYY-MM-DD) : "), getString("Compétition réservé aux équipes : "));});
		
		
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
		Menu menu = new Menu("Editer ");
		menu.addBack("q");
		return menu;
	}

		
	/// Compétition ---------------------------------------------------------------------------
	private Menu menuQuitter()
	{
		Menu menu = new Menu("Quitter", "q");
		menu.add(quitterEtEnregistrer());
		menu.add(quitterSansEnregistrer());
		menu.addBack("r");
		return menu;
	}
		
		
	private Option quitterEtEnregistrer()
	{
		return new Option("Quitter et enregistrer", "q", 
				() -> 
				{
					try
					{
						dinscriptions.sauvegarder();
						Action.QUIT.optionSelected();
					} 
					catch (IOException e)
					{
						System.out.println("Impossible d'effectuer la sauvegarde");
					}
				}
			);
	}
	
	private Option quitterSansEnregistrer()
	{
		return new Option("Quitter sans enregistrer", "a", Action.QUIT);
	}
			
	public static void main(String[] args)
	{
		dialogue dialogue = new dialogue(Inscriptions.getInscriptions());
			dialogue.start();		
	}
}
