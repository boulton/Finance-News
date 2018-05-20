package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Requete  {
	
	
	static int TotalEntree ;
	static int Date[][] = new int [10000][4];
	static float Donnee[][] = new float[10000][7];
	 String adresse = adresse() ;
	
	
	public void Requete()
	{
		
		int i= 0;
		String DonneeBrut = "";
		String Temp2[] = new String[4];
		String DonneeIntermediaire[][] = new String[10000][8];
	
		
		try{
			URL lien = new URL(adresse);
			InputStreamReader donnee = new InputStreamReader(lien.openStream());
			BufferedReader tampon = new BufferedReader(donnee);	
			
			while((DonneeBrut = tampon.readLine()) != null)
			{
				DonneeIntermediaire[i] = DonneeBrut.split(",");
				// DonneeIntermediaire[] [ 0:Date, 1:Ouverture, 2:Haut, 3:Bas, 4:Fermeture, 5:Volume, 6:Adj Fermeture ] 		
				
				if(DonneeIntermediaire[i][0].contains("-"))
				{
					Temp2 = ((DonneeIntermediaire[i][0]).split("-")); //la date en xxxx-yy-zz
					for (int f=0; f<3; f++){
						Date[i][f] = Integer.parseInt(Temp2[f]);
					}
					for(int f=1; f<6; f++ ){
						Donnee[i][f] =  Float.parseFloat( DonneeIntermediaire[i][f]);
					}
					i++;
				}	
			}
			TotalEntree = i;
			
			// Debug : System.out.println("Requete()");
			
		   /* for(int j=0; j<TotalEntree; j++){
			* System.out.println( Date[j][0]+"/"+Date[j][1]+"/"+Date[j][2]+"= "+Donnee[j][1]);
			* }
			*/
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("pas d'acces aux serveurs");	
		}
	}
	
	private String adresse()
	{	
		String indice[] = {"%5EFCHI","%5EFTSE","NYX" };
		int AnneeDebut = 2000;
		int AnneeFin = 2013;
		int MoisDebut = 0; // numéroté de 0 a 11
		int JourDebut = 1;
	
		String chemin = "http://ichart.finance.yahoo.com/table.csv?s="+indice[0]+"&d=4&e=3&f="+AnneeFin+"&g=d&a="+MoisDebut+"&b="+JourDebut+"&c="+AnneeDebut+"&ignore=.csv";
		return chemin;
	}
	
	private String adresse(int kelIndice, int AnneeDebut, int MoisDebut, int JourDebut, int AnneeFin)
	{
		String indice[] = {"%5EFCHI","%5EFTSE","NYX" };
	 String chemin = "http://ichart.finance.yahoo.com/table.csv?s="+indice[kelIndice]+"&d=4&e=3&f="+AnneeFin+"&g=d&a="+MoisDebut+"&b="+JourDebut+"&c="+AnneeDebut+"&ignore=.csv";
	 return chemin;
	}
	
	public int getTotalEntree()
	{
		//System.out.println(TotalEntree);
		return TotalEntree;
	}
	
	public int[][] getDate()
	{
		return Date;
	}
	
	public float[][] getDonnee()
	{
		return Donnee;
	}
	
	public void setParam(int kelIndice , int AnneeDebut, int MoisDebut, int JourDebut, int AnneeFin)
	{
		adresse = adresse(kelIndice, AnneeDebut, MoisDebut, JourDebut, AnneeFin);
		Requete();
	}
	
}
