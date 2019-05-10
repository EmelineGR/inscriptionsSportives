package interface2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;



public class fbutton {
// fbutton ajoute les bouttons de la navbar de l'interface graphique
	private pages fbutton;
	
	
	public void setFbutton(pages pages) {
		this.fbutton = pages;
	}


	public fbutton() {
		setFbutton(new pages());
	
	    JPanel boutonPane = new JPanel();// c'est un Jpanel qui est juste placer en haut de la page

	    // creation d'un bouton
	    JButton Accueil = new JButton("Accueil");// nom du bouton
	    //Définition de l'action du bouton2
	    Accueil.addActionListener(new ActionListener(){// action du bouton
	      public void actionPerformed(ActionEvent event){				
	    	  // cl = layout manager , voir la class Pages, 
	        fbutton.cl.show(fbutton.getContent(), fbutton.listContent[0]);//
	        //cette fonction va prendre les differentes Page comme equipes personnes... dans le layout content de la classe pages et afficher le numero 0 de la liste
	   
	        fbutton.getPages().setTitle(fbutton.listContent[0]);// cette fonction va changer le titre de la fenetre 
	      }
	    });
	    
	    JButton Equipes = new JButton("Equipes");
	    //Définition de l'action du bouton2
	    Equipes.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent event){				
	    	  // cl = layout manager , voir la class Pages, 
		        fbutton.cl.show(fbutton.getContent(), fbutton.listContent[1]);//
		        //cette fonction va prendre les differentes Page comme equipes personnes... dans le layout content de la classe pages et afficher le numero 0 de la liste
		   
		        fbutton.getPages().setTitle(fbutton.listContent[1]);// cette fonction va changer le titre de la fenetre 
	      }
	    });
	    
	    JButton Personnes = new JButton("Personnes");
	    //Définition de l'action du bouton2
	    Personnes.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent event){				
	    	  // cl = layout manager , voir la class Pages, 
		        fbutton.cl.show(fbutton.getContent(), fbutton.listContent[2]);//
		        //cette fonction va prendre les differentes Page comme equipes personnes... dans le layout content de la classe pages et afficher le numero 0 de la liste
		   
		        fbutton.getPages().setTitle(fbutton.listContent[2]);// cette fonction va changer le titre de la fenetre 
	      }
	    });
			
	    JButton Competition = new JButton("Competition");
	    //Définition de l'action du bouton2
	    Competition.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent event){				
	    	  // cl = layout manager , voir la class Pages, 
		        fbutton.cl.show(fbutton.getContent(), fbutton.listContent[3]);//
		        //cette fonction va prendre les differentes Page comme equipes personnes... dans le layout content de la classe pages et afficher le numero 0 de la liste
		   
		        fbutton.getPages().setTitle(fbutton.listContent[3]);// cette fonction va changer le titre de la fenetre 
	      }

	    });
	    
	
	    
	  
		// ajout des differents bouton
	    boutonPane.add(Accueil);
	    boutonPane.add(Equipes);
	    boutonPane.add(Personnes);
	    boutonPane.add(Competition);
	    
	    fbutton.getPages().getContentPane().add(boutonPane, BorderLayout.NORTH);// placement en haut de la page
	}


	public pages getFbutton() {
		return fbutton;
	}





}
