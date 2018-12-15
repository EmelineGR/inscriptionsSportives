package dialogue;

import static commandLineMenus.rendering.examples.util.InOut.getString;

import java.util.ArrayList;

import commandLineMenus.*;
import inscriptions.*;

public class dequipe {

	static Inscriptions dinscriptions = Inscriptions.getInscriptions();

	
	/// equipe ---------------------------------------------------------------------------
	Menu menuEquipe()
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
		return new Option("Ajouter une Equipe", "2", () -> {dinscriptions.createEquipe(getString("Nom de l'Equipe : "));});
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
		Menu menu = new Menu("Editer "+ equipe.getNom());
		menu.add(EquipePersonnes(equipe));
		menu.add(afficherMembres(equipe));
		menu.add(supprimerEquipe(equipe));
		menu.addBack("q");
		return menu;
	}
	private Option afficherMembres(Equipe equipe)
	{
		return new Option("Afficher les Membres", "2", () -> {System.out.println(equipe.getMembres());});
	}						
			
	private Option supprimerEquipe(Equipe equipe)
	{
		return new Option("Supprimer equipe", "3", () -> {equipe.delete();});
	}
						
	private Menu EquipePersonnes(Equipe equipe)
	{
		Menu menu = new Menu("Editer membres ","1");
		menu.add(selectionnerMembres(equipe));
		menu.add(PersonneAAjouter(equipe));
		menu.addBack("q");
		return menu;
	}
	
	private List<Personne> selectionnerMembres(Equipe equipe)
	{	
		return new List<Personne>("Supprimer membres" , "1", 
				() -> new ArrayList<>(equipe.getMembres()),
				(element) -> supprimerMembres(element,equipe)
				);
	}
		
	private Option ajouterMembres(Personne element,Equipe equipe)
	{	
		return new Option("Ajouter un membres" + " " + element.getNom(), "", () -> {equipe.add(element);});
	}
		
	private List<Personne> PersonneAAjouter(Equipe equipe)
	{
		List<Personne> personnes = new List<>("Ajouter membres", "2", 
				() -> new ArrayList<>(equipe.getPersonnesAAjouter()),
				(element) -> ajouterMembres(element,equipe)
				);
			/*	personnes.setListItemRenderer(new ListItemRenderer<Personne>() {
					
					@Override
					public String title(int index, Personne item) {
						return item.toString();
					}
					
					@Override
					public String shortcut(int index, Personne item) {
						return "" + (index + 1);
					}
					
					@Override
					public String empty() {
						return "No item to select.\n";
					}
				});*/
		return personnes;
	}
					
	private Option supprimerMembres(Personne element ,Equipe equipe)
	{
		return new Option("Supprimer le Membres" , "", () -> {equipe.remove(element);});
	}
}
