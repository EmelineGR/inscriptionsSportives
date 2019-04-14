package interfaceGraphic;

public class InscSportives
{
	private Pages pages;
	private NavBar menu;
	
	public InscSportives()
	{
		pages = new Pages();
		menu = new NavBar(pages);
		pages.getAccueil().getFenetre().setJMenuBar(menu.getMenuBar());
		pages.getEquipes().getFenetre().setJMenuBar(menu.getMenuBar());
		pages.getPersonnes().getFenetre().setJMenuBar(menu.getMenuBar());
		pages.getCompetitions().getFenetre().setJMenuBar(menu.getMenuBar());
		
		pages.getAccueil().getFenetre().setVisible(true);
	}
}
