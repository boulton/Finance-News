package main;


import javax.swing.JApplet;

public class main extends JApplet  {
	 
	public void init() 
	{		
		Requete Demande = new Requete();
		Traitement Traitement = new Traitement();
		Gui foo = new Gui();

		
		Demande.Requete();
		Traitement.Traitement();
		foo.Gui();
		
		this.setContentPane(foo);
		this.setSize(900,500);
		this.setVisible(true);
	}

}