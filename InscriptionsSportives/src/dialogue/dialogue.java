package dialogue;

import static commandLineMenus.rendering.examples.util.InOut.getString;

import java.io.IOException;
import java.util.ArrayList;

import commandLineMenus.Action;
import commandLineMenus.List;
import commandLineMenus.Menu;
import commandLineMenus.Option;
import commandLineMenus.examples.employees.core.Department;
import commandLineMenus.examples.employees.core.Employee;
import commandLineMenus.examples.employees.core.ImpossibleToSaveException;
import commandLineMenus.examples.employees.core.ManageEmployees;
import commandLineMenus.examples.employees.userDialog.PersonnelConsole;
import inscriptions.Equipe;
import inscriptions.Inscriptions;

public class dialogue 
{
	private Inscriptions dinscriptions;
	
	public dialogue(Inscriptions inscriptions)
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
		menu.add(menuEquipe());
		menu.add(menuQuitter());
		return menu;
	}
	
	
	
	/// equipe ---------------------------------------------------------------------------
	private Menu menuEquipe()
	{
		Menu menu = new Menu("Gérer les Equipes", "1");
		menu.add(afficheEquipe());
		menu.add(ajouterEquipe());
		menu.add(selectionnerEquipe());
		menu.addBack("q");
		return menu;
	}

	private Option afficheEquipe()
	{
		return new Option("Afficher les Equipes", "1", () -> {System.out.println(dinscriptions.getEquipes());});
	}
	
	private Option ajouterEquipe()
	{
		return new Option("Ajouter une Equipe", "2", () -> {dinscriptions.createEquipe(getString("nom : "));});
	}
	
	private List<Equipe> selectionnerEquipe()
	{
		return new List<Equipe>("Sélectionner une Equipe", "3", 
				() -> new ArrayList<>(dinscriptions.getEquipes()),
				(element) -> editerEquipe(element)
				);
	}
	
	private Menu editerEquipe(Equipe equipe)
	{
		Menu menu = new Menu("Editer ");
		menu.addBack("q");
		return menu;
	}

	
	/// equipe ---------------------------------------------------------------------------
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