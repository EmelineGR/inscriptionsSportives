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
		equipes.setFont(policeItem);
		menu.add(equipes);
		
		JMenuItem personnes = new JMenuItem("PERSONNES");
		personnes.setFont(policeItem);
		menu.add(personnes);
		
		JMenuItem competitions = new JMenuItem("COMPETITIONS");
		competitions.setFont(policeItem);
		menu.add(competitions);
		
		JMenuItem quitter = new JMenuItem();
		quitter = getItemQuitter();
		quitter.setFont(policeItem);
		menu.add(quitter);
		
		menuBar.add(menu);
		
		return menuBar;
	}
	
	private JMenuItem getItemQuitter()
	{
		JMenuItem item = new JMenuItem("QUITTER");
		
		item.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				fenetre.getJFrame().dispose();
			}
		});
		
		return item;
	}
}