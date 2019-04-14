package interfaceGraphic;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class NavBar
{	
	private Pages pages;
	
	private final Font policeMenu = new Font("Arial", Font.BOLD, 19);
	private final Font policeItem = new Font("Arial", Font.PLAIN, 18);

	NavBar(Pages pages)
	{
		this.pages = pages;
	}

	public JMenuBar getMenuBar()
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("MENU");
		JMenuItem equipes = getItemEquipes();
		JMenuItem personnes = getItemPersonnes();
		JMenuItem competitions = getItemCompetitions();
		
		menu.add(equipes);
		menu.add(personnes);
		menu.add(competitions);
		menuBar.add(menu);
		
		menu.setFont(policeMenu);
		equipes.setFont(policeItem);
		personnes.setFont(policeItem);
		competitions.setFont(policeItem);
		
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
				pages.close();
				pages.getEquipes().getFenetre().setVisible(true);
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
				pages.close();
				pages.getPersonnes().getFenetre().setVisible(true);
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
				pages.close();
				pages.getCompetitions().getFenetre().setVisible(true);
			}
		});
		
		return item;
	}
}