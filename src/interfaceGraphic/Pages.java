package interfaceGraphic;

public class Pages
{
	private Accueil accueil;
	private Equipes equipes;
	private Personnes personnes;
	private Competitions competitions;

	public Pages()
	{
		accueil = new Accueil();
		equipes = new Equipes();
		personnes = new Personnes();
		competitions = new Competitions();
	}
	
	public Accueil getAccueil()
	{
		return accueil;
	}
	
	public Equipes getEquipes()
	{
		return equipes;
	}
	
	public Personnes getPersonnes()
	{
		return personnes;
	}
	
	public Competitions getCompetitions()
	{
		return competitions;
	}
	
	public void close()
	{
		accueil.getFenetre().setVisible(false);
		equipes.getFenetre().setVisible(false);
		personnes.getFenetre().setVisible(false);
		competitions.getFenetre().setVisible(false);
	}
}
