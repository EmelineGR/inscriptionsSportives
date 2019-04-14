package interfaceGraphic;

import javax.swing.*;

public class Fenetre
{	
	private JFrame fenetre;
	
	public Fenetre()
    {
		fenetre = new JFrame();
		
		fenetre.setTitle("Application");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setResizable(false);
		fenetre.setLayout(null);
		fenetre.setSize(700, 500);
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(false);
    }
	
	public JFrame getFenetre()
	{
		return fenetre;
	}
}