package interfaceGraphic;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class NavBar
{
	private final Fenetre fenetre;
	
	private final Font policeMenu = new Font("Arial", Font.BOLD, 19);
	private final Font policeItem = new Font("Arial", Font.PLAIN, 18);

	NavBar(Fenetre fenetre)
	{
		this.fenetre = fenetre;
	}

	JMenuBar getMenuBar()
	{
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menu = new JMenu("MENU");
		menu.setFont(policeMenu);
		
		JMenuItem equipes = new JMenuItem("EQUIPES");
		equipes = getItemEquipes();
		equipes.setFont(policeItem);
		menu.add(equipes);
		
		JMenuItem personnes = new JMenuItem("PERSONNES");
		personnes = getItemPersonnes();
		personnes.setFont(policeItem);
		menu.add(personnes);
		
		JMenuItem competitions = new JMenuItem("COMPETITIONS");
		competitions = getItemCompetitions();
		competitions.setFont(policeItem);
		menu.add(competitions);
		
		menuBar.add(menu);
		
		return menuBar;
	}
	
	private JMenuItem getItemEquipes()
	{
		JMenuItem item = new JMenuItem("EQUIPES");
		
		item.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				fenetre.getAccueilPanel().setVisible(false);
				System.out.println("Vous avez cliqué sur EQUIPES !");
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
				fenetre.getAccueilPanel().setEnabled(false);
				System.out.println("Vous avez cliqué sur PERSONNES !");
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
				fenetre.getAccueilPanel().setEnabled(false);
				System.out.println("Vous avez cliqué sur COMPETITIONS !");
			}
		});
		
		return item;
	}
}