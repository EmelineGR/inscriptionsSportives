package interfaceGraphic;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.*;

public class Fenetre
{
	private JFrame frame;
	private NavBar menu;
	
	private final Font policeTitre = new Font("MONOSPACED", Font.BOLD, 30);
	
	public Fenetre()
    {
		menu = new NavBar(this);
		
		frame = new JFrame();
		
		frame.setTitle("Application");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setJMenuBar(menu.getMenuBar());
		frame.setContentPane(getAccueilPanel());
		frame.setSize(700, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
    }
	
	JFrame getJFrame()
	{
		return frame;
	}
	
	private void enableFenetre(boolean b)
	{
		frame.setEnabled(b);
	}
	
	private JPanel getAccueilPanel()
	{
		JPanel panel = new JPanel();
		
		JLabel titre = new JLabel("Inscriptions Sportives");
		titre.setFont(policeTitre);
		panel.add(titre, "Center");
		panel.setBorder(new EmptyBorder(20, 0, 15, 0));
		
		return panel;
	}
	
	private JPanel getEquipesPanel()
	{
		JPanel panel = new JPanel();
			
		return panel;
	}

	private JPanel getPersonnesPanel()
	{
		JPanel panel = new JPanel();
		
		return panel;
	}
	
	private JPanel getCompetitionsPanel()
	{
		JPanel panel = new JPanel();
		
		return panel;
	}
	
	private ActionListener getBoutonListener(final String label)
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				
			}
		};
	}
	
	private JButton getBouton(String label)
	{
		JButton bt = null;
		
		switch (label)
		{
			case "EQUIPES": bt = getBouton("equipes"); break;
			case "PERSONNES": bt = getBouton("personnes"); break;
			case "COMPETITIONS": bt = getBouton("competitions");	break;
			case "QUITTER": bt = getBouton("quitter"); break;
			default: throw new RuntimeException("Bouton inconnue : " + label);
		}
		
		bt.addActionListener(getBoutonListener(label));
		return bt;
	}
}