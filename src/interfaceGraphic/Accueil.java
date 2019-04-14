package interfaceGraphic;

import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Accueil
{
	private final Fenetre fenetre;
	
	private final Font policeTitre = new Font("MONOSPACED", Font.BOLD, 30);
	
	public Accueil()
    {
		fenetre = new Fenetre();
		setAccueilPanel();
    }
	
	private void setAccueilPanel()
	{
		JPanel panel = new JPanel();
		
		JLabel titre = new JLabel("Inscriptions Sportives");
		titre.setFont(policeTitre);
		panel.add(titre, "Center");
		panel.setBorder(new EmptyBorder(20, 0, 15, 0));
		
		fenetre.getFenetre().setContentPane(panel);
	}
	
	public JFrame getFenetre()
	{
		return fenetre.getFenetre();
	}
}
