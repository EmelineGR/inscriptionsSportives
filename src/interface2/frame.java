package interface2;


import javax.swing.JFrame;
 class frame {


	 
	private NavBar frame;
	
// frame est la derniere class appelé dans la creation de l'objet
		  public frame(){
			setFrame(new NavBar());// frame est un Fbutton
		    frame.getNavBar().getPages().setTitle("Accueil");// ajout du titre de la fenetre
		    frame.getNavBar().getPages().setSize(800, 800);// taille de la fenetre
		    frame.getNavBar().getPages().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // bouton de fermeture de la fenetre
		    frame.getNavBar().getPages().setLocationRelativeTo(null);
		    frame.getNavBar().getPages().setVisible(true);
		  }


		public void setFrame(NavBar frame) {
			this.frame = frame;
		}


		public NavBar getFrame() {
			return frame;
		}



	

	
}
