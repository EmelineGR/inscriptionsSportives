package dialogue;

import static commandLineMenus.rendering.examples.util.InOut.getString;

import java.util.ArrayList;

import commandLineMenus.List;
import commandLineMenus.Menu;
import commandLineMenus.Option;
import inscriptions.Inscriptions;
import inscriptions.Personne;

public class dpersonne {
	
	static Inscriptions dinscriptions = Inscriptions.getInscriptions();
	///  personne---------------------------------------------------------------------------
	protected Menu menuPersonne()
	{
		Menu menu = new Menu("Gérer les Personnes", "2");
		menu.add(affichePersonnes());
		menu.add(ajouterPersonnes());
		menu.add(selectionnerPersonnes());
		menu.addBack("q");
		return menu;
	}

	private Option affichePersonnes()
	{
		return new Option("Afficher les Personnes", "1", () -> {System.out.println(dinscriptions.getPersonnes());});
	}
	
	private Option ajouterPersonnes()
	{
		return new Option("Ajouter une Personnes", "2", () -> {dinscriptions.createPersonne(getString("nom : "),getString("prenom : "),getString("mail : "));});
	}
	
	private List<Personne> selectionnerPersonnes()
	{
		return new List<Personne>("Sélectionner une Personnes", "3", 
				() -> new ArrayList<>(dinscriptions.getPersonnes()),
				(element) -> editerPersonnes(element)
				);
	}
	
	
	
	
	
	
	

	private Menu editerPersonnes(Personne personne)
	{
	
		Menu menu = new Menu("Editer " +  personne.getNom());
		menu.add(afficheinfo(personne));
		menu.add(modifier(personne));
		menu.add(afficherCompetitions(personne));
		menu.add(afficherEquipe(personne));
		menu.add(supprimerPersonne(personne));
		menu.addBack("q");
		return menu;
	}


	
	private Option 	afficherCompetitions(Personne personne)
	{
		return new Option("afficher les competitions", "3", () -> { System.out.println(personne.getCompetitions()); });
	}
	
	private Option 	supprimerPersonne(Personne personne)
	{
		return new Option("supprimer la personne", "5", () -> {personne.delete(); });
	}
	
	private Option  afficherEquipe(Personne personne)
	{
		return new Option("afficher les Equipes", "4", () -> { System.out.println(personne.getEquipes()); });
	}
	
	
	private Option afficheinfo(Personne personne)
	{
		return new Option("afficher informations", "1", () -> { System.out.println(personne.getNom() + " " + personne.getPrenom() + " " + personne.getMail()); });
	}
	
	
	private Menu modifier(Personne personne)
	{
		Menu menu = new Menu("Editer " +  personne.getNom(),"2");
		menu.add(nom(personne));
		menu.add(prenom(personne));
		menu.add(mail(personne));
		menu.addBack("q");
		return menu;
	}
	private Option nom(Personne personne)
	{
		return new Option("modifier nom", "1", () -> { personne.setNom(getString("nom : ")); });
	}
	
	private Option prenom(Personne personne)
	{
		return new Option("modifier prenom", "2", () -> { personne.setPrenom(getString("prenom : ")); });
	}
	
	private Option mail(Personne personne)
	{
		return new Option("modifier mail", "3", () -> { personne.setMail(getString("mail : ")); });
	}
	///  personne---------------------------------------------------------------------------


}
