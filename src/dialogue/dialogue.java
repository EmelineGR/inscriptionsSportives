package dialogue;

import java.io.IOException;

import commandLineMenus.*;
import inscriptions.*;

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
		menu.add( new dequipe().menuEquipe());
		menu.add(new dpersonne().menuPersonne());
		menu.add(new dcompetition().menuCompetition());
		menu.add(menuQuitter());
		return menu;
	}
	
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
		return new Option("Quitter et enregistrer", "qe", 
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
		return new Option("Quitter sans enregistrer", "qsa", Action.QUIT);
	}
	

	
	public static void main(String[] args)
	{
		dialogue dialogue = new dialogue(Inscriptions.getInscriptions());
			dialogue.start();
		
	}
}