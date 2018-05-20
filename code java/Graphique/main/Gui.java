package main;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JApplet;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

class Gui extends JPanel implements MouseListener {
		 
	Button bout = new Button("Rafraichir");
	String Date[] = {"1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013"};
	JList ListeDate1 = new JList(Date);
	JList ListeDate2 = new JList(Date);
	
	public void Gui()
	{		
		 JPanel p1 = new JPanel();
		 Dessin p2 = new Dessin();
		 		 
		 
		 
		ListeDate1.setVisibleRowCount(3);
		ListeDate2.setVisibleRowCount(3);
		ListeDate1.addMouseListener(this);
		ListeDate2.addMouseListener(this);
		
		bout.addMouseListener(this);
		
	
		p1.add(new JScrollPane(ListeDate1));
		p1.add(new JScrollPane(ListeDate2));
		p1.add(bout);
		p1.setMaximumSize(new Dimension(100,100));
		p1.setLayout(new BoxLayout(p1,BoxLayout.PAGE_AXIS));
		
		
		p2.setMaximumSize(new Dimension(800,400));		
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(p2);
		this.add(p1);
		this.setSize(getPreferredSize());
		this.setVisible(true);		
		this.repaint();
		
		//Verification pour le débug
		System.out.println("Gui");	
	}
	
public void mouseClicked(MouseEvent e)
	{
		if(e.getSource() == bout ){
		System.out.println(e.getSource()+" bout :"+bout);
		
		int Annee = Integer.parseInt(ListeDate1.getSelectedValue().toString());
		int Annee2 = Integer.parseInt(ListeDate2.getSelectedValue().toString());
		
		Traitement Traitement = new Traitement();
		Gui foo = new Gui();
		
		
		new Requete().setParam(0, Annee, 0, 0, Annee2);
		Traitement.Traitement();
		foo.Gui();
		System.out.println(Annee);
		}
	}

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


}

class Dessin extends JPanel {
	    
	Thread t = new Thread(new Pointeur());
	Pointeur Pointeur = new Pointeur();
	private int Largeur = Traitement.Largeur;
	private int Hauteur = 400;
	private int[] points = new int[10000];
	private int EchelleMax = 7000 ; //valeurs maximale des points de la bourse
	private int TailleCarr = 20 ; // taille du Carrelage	
	
	public Dessin()
	{
		Traitement Traitement = new Traitement();

		points = Traitement.dimension();
		t.start();
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		g.drawRect(0, 0, getWidth()-1, getHeight()-1);
		
		for (int i=0; i<(Largeur/TailleCarr); i++)
		{
			g.drawLine(10, (TailleCarr*i), (Largeur-10), (TailleCarr*i));	//horizontal
			g.drawLine((TailleCarr*i), 10, (TailleCarr*i), (Hauteur-10)); // vertical
		}
		
		for(int i=0; i<(Largeur); i++){
			//System.out.println("i: "+i+" "+points[i]);
			g.drawLine(i, points[i], (i+1), points[(i+1)]);	
		}	
		Pointeur.Curseur(g, points);	
	}
	
	public int getLargeur()
	{
		return Largeur;
	}
	
	public int getHauteur()
	{
		return Hauteur;
	}
	
	public int getEchelleMax()
	{
		return EchelleMax;
	}
}

// ----------------------NE FONCTIONNE PAS -------------------------------
class Pointeur extends JApplet implements Runnable  {
	
		private int val;
		private int Abscisse ;
		private static int[]  points2 = new int[10000] ;
		
		public void Curseur(Graphics g, int[] points)
			{	 
				points2 = points;
				// débug System.out.println(" val: "+val);
				
				g.drawLine( 0, val , 0, val);
				g.drawLine( val, 0, val, 0);
			}
		 
		public void run() {
			for(int i=0, k=1; i<k; k++)
			{	
				try {
					Thread.sleep(100);
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				Abscisse = (int) MouseInfo.getPointerInfo().getLocation().getX();
				val = (points2[Abscisse]);
				// System.out.println("Abscisse: "+Abscisse+" val: "+val);
				
			}
		}
	}	
//----------------------------------------------------------------------------

