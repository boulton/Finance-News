package main;

import javax.swing.JApplet;



public class Traitement extends JApplet {

	Requete Demande = new Requete();
	
	private static float DonneeTraitee[][]= new float [10000][7];
	private static int DateTraitee[][] = new int[10000][4]; 
	private int[] Proportion = new int[10000] ;
	static int Largeur = 800 ;
	 int Hauteur = 400 ;

	
	
	public void Traitement()
	{
	
		int EntreeMax = Demande.getTotalEntree() ; // EntreeMax correspond au nombre d'entrée la plus recente
		 int DateNonTraitee[][] = Demande.getDate();
		 float DonneeNonTraitee[][] = Demande.getDonnee();	
		
		 
		for( int i =1 ; EntreeMax-i>0; i++ )
		{
			//System.out.println("i:"+i);
			DonneeTraitee[i] = DonneeNonTraitee[(EntreeMax-i)];
			DateTraitee[i] = DateNonTraitee[(EntreeMax-i)];
		}
		// Debug : System.out.println("Traitement");
	}
	
	public int[] dimension(){
		
		
		
		int EntreeMax = Demande.getTotalEntree();
		int Saut = (int) ((EntreeMax-1)/Largeur);
		int quanta = 0;
		int EchelleMax = 7000 ;
		
		// Debug : System.out.println("dimension()");
		for(int i=0; i<Largeur; i++ )
		{
			quanta = i+Saut;
			if( i+Saut>EntreeMax){ 
				quanta = 0;	
			}
			
			Proportion[i] = ( (int) ((DonneeTraitee[quanta][1])/EchelleMax*Hauteur) );
			//System.out.println("Proportion: "+ Proportion[i] );
		}
		return Proportion;
	}
	
	public int[][] getDate(){
		return DateTraitee;
	}
	
	public float[][] getDonnee(){
		return DonneeTraitee;
	}
	
	public int[] getProportion()
	{
		dimension();
		return Proportion;
	}
}