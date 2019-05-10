package interface2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class NavBar {
private pages NavBar;
	
	private final Font policeMenu = new Font("Arial", Font.BOLD, 19);
	private final Font policeItem = new Font("Arial", Font.PLAIN, 18);
	JMenuBar menuBar = new JMenuBar();
	JMenu menu = new JMenu("MENU");
	JMenuItem accueil = getItemAccueil();
	JMenuItem equipes = getItemEquipes();
	JMenuItem personnes = getItemPersonnes();
	JMenuItem competitions = getItemCompetitions();


	public NavBar()
	{
		setNavBar(new pages());
	
		
		menu.add(accueil);
		menu.add(equipes);
		menu.add(personnes);
		menu.add(competitions);
		menuBar.add(menu);
		
		menu.setFont(policeMenu);
		accueil.setFont(policeMenu);
		equipes.setFont(policeItem);
		personnes.setFont(policeItem);
		competitions.setFont(policeItem);
		
		NavBar.getPages().setJMenuBar(menuBar);
	}

	
	public pages getNavBar() {
		return NavBar;
	}


	public void setNavBar(pages pages) {
		NavBar = pages;
	}

	private JMenuItem getItemAccueil()
	{
		JMenuItem item = new JMenuItem("Accueil");
		
		item.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
		    	  // cl = layout manager , voir la class Pages, 
		        NavBar.cl.show(NavBar.getContent(), NavBar.listContent[0]);//
		        //cette fonction va prendre les differentes Page comme equipes personnes... dans le layout content de la classe pages et afficher le numero 0 de la liste
		   
		        NavBar.getPages().setTitle(NavBar.listContent[0]);// cette fonction va changer le titre de la fenetre 
			}
		});
		
		return item;
	}
	
	private JMenuItem getItemEquipes()
	{
		JMenuItem item = new JMenuItem("EQUIPES");
		
		item.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
		    	  // cl = layout manager , voir la class Pages, 
		        NavBar.cl.show(NavBar.getContent(), NavBar.listContent[1]);//
		        //cette fonction va prendre les differentes Page comme equipes personnes... dans le layout content de la classe pages et afficher le numero 0 de la liste
		   
		        NavBar.getPages().setTitle(NavBar.listContent[1]);// cette fonction va changer le titre de la fenetre 
			}
		});
		
		return item;
	}
	
	private JMenuItem getItemPersonnes()
	{
		JMenuItem item = new JMenuItem("PERSONNES");
		
		item.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
			  	  // cl = layout manager , voir la class Pages, 
		        NavBar.cl.show(NavBar.getContent(), NavBar.listContent[2]);//
		        //cette fonction va prendre les differentes Page comme equipes personnes... dans le layout content de la classe pages et afficher le numero 0 de la liste
		   
		        NavBar.getPages().setTitle(NavBar.listContent[2]);// cette fonction va changer le titre de la fenetre 
			}
		});
		
		return item;
	}
	
	private JMenuItem getItemCompetitions()
	{
		JMenuItem item = new JMenuItem("COMPETITIONS");
		
		item.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
			  	  // cl = layout manager , voir la class Pages, 
		        NavBar.cl.show(NavBar.getContent(), NavBar.listContent[3]);//
		        //cette fonction va prendre les differentes Page comme equipes personnes... dans le layout content de la classe pages et afficher le numero 0 de la liste
		   
		        NavBar.getPages().setTitle(NavBar.listContent[3]);// cette fonction va changer le titre de la fenetre 
			}
		});
		
		return item;
	}
}
