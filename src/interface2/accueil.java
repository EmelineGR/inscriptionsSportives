package interface2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class accueil extends JPanel {
	 private JPanel accueil;
	 JPanel content = new JPanel();
	 JButton bouton = new JButton("Cliquez ici !");
	 JButton bouton2 = new JButton("Ou là !");
	 JLabel jlabel = new JLabel("This is a label");
	
	public accueil() {
		 
		this.setBackground(Color.PINK);
		
		 
		
		bouton.setSize(100,100);
		this.add(bouton);
 
		
		bouton2.setSize(100,100);
		this.add(bouton2);
		
	    jlabel.setFont(new Font("Verdana",1,20));
	    this.add(jlabel);
	    this.jlabel.setVisible(false);
	        
	    JLabel label1 = new JLabel();
	    label1.setText("simple text");
	    label1.setBounds(0, 0, 200, 50);
	 
	    content.add(label1);
	    

	        
	   JTextField textField = new JTextField(8);
        
        textField.setFont(textField.getFont().deriveFont(50f));
        this.add(textField);

	    bouton.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent event){
	    	jlabel.setVisible(true);	
	      }
	    });
	    
	    bouton2.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	jlabel.setVisible(false);	
		      }
		    });
	    
	
	    this.add(content, BorderLayout.LINE_START);
	}


    
  

	

}
