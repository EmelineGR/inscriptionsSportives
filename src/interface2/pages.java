package interface2;


import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;



public class pages {
	
	 private JFrame pages;
	 String[] listContent = {"Accueil", "Equipes", "Personnes","Competitions"};// permet juste de donner un nom a chaque pages
	 JPanel content = new JPanel();
	 CardLayout cl = new CardLayout();// cardLayout gere l'affichage des differents
	// Chaque panneau correspond à un onglet de boîte de dialogue et contient plusieurs contrôles. Par défaut, c'est le premier onglet qui est affiché. 
	// voir https://www.jmdoudoux.fr/java/dej/chap-awt.htm
	 
	 JPanel card1 = new JPanel();	
	 JPanel card4 = new JPanel();
	 JPanel accueil = new accueil();
	 JPanel card3 = new JPanel();


	

public pages(){
	setPages(new JFrame());
    //On définit le layout
    content.setLayout(cl);
    //On ajoute les cartes à la pile avec un nom pour les retrouver
    content.add(card1, listContent[0]);
    content.add(accueil, listContent[1]);
    content.add(card3, listContent[2]);
    content.add(card4, listContent[3]);
    
    pages.getContentPane().add(content, BorderLayout.CENTER);// placement du jpanel content avec les differentes pages gerer par le cardlayout manager
    
	}

public JFrame getPages() {
	return pages;
}



public void setPages(JFrame pages) {
	this.pages = pages;
}

public String[] getListContent() {
	return listContent;
}

public void setListContent(String[] listContent) {
	this.listContent = listContent;
}

public JPanel getContent() {
	return content;
}

public void setContent(JPanel content) {
	this.content = content;
}

public CardLayout getCl() {
	return cl;
}

public void setCl(CardLayout cl) {
	this.cl = cl;
}












}
