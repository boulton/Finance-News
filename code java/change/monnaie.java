import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public  class monnaie extends JApplet
					 implements MouseListener{
	
	String[] Nom1 = {"Euro","Dollar US","Livre Anglaise","Franc Suisse","Yen",
					 "Dollar Canadien","Dollar Australien",
					 "Baht Thaïlandais","Birr Ethiopien","Bolivar Vénuézuélien Fuerte",
					 "Boliviano Bolivien","Balboa Panaméen","Colòn Costaricain",
					 "Couronne Danoise","Couronne Estonienne","Couronne Islandaise",
					 "Couronne Norvégienne","Couronne Suédoise","Couronne Tchèque",
					 "Colon Salvadorien","Cordoba Nicaragayen","Couronne Slovaque",
					 "Gourde Haïtienne","Dollar Jamaiquain","Gulden Neerlandais",
					 "Once d'Or","Once de Platine","Once d'Argent","Real Bresilien",
					 "Peso Dominicain","Peso Argentin","Peso Colombien","Peso Mexicain",
					 "Rouble russe","Peso Cubain"
					 };																		
	String[] symbol1 = {"EUR","USD","GBP","CHF","JPY","CAD","AUD","THB","ETB",
						"VEF","BOB","PAB","CRC","DKK","EEK","ISK","NOK",
						"SEK","CZk","SVC","NIO","SKK","HTG","JMD","ANG",
						"XAU","XPT","XAG","BRL","DOP","ARS","COP","MXN",
						"RUB","CUP",
						};
	String[] lettre = {"€","$","£","Fr","¥","$CA","$AUD","฿","birr"," bolívar",
					   " boliviano"," balboa"," colón"," kroner",
					   " kroner"," króna"," króna"," krona"," koruna"," colón"," colón",
					   " krona"," Gourdes","$","Gulden"," Onces"," Onces"," Onces",
					   " Real"," Pesos"," Pesos"," Pesos"," Pesos"," Rouble"," Pesos"		
					   };
	String lettreOn = null;
	float conversion = 0;
	String conversion_Text = null;
	JList liste1 = new JList(Nom1);	
	JList liste2 = new JList(Nom1);
	String symbolOn = null;
	String symbolOn2 = null;
	Float val1 = (float) 1 ;
	JButton ok = new JButton("Convertir");
	JTextField montant1 = new JTextField();
	JTextField montant2 = new JTextField();
	public void init() 
	{
				Fenetre();
	}

	public void Fenetre()
	{
		JPanel p = new JPanel();
		JPanel panliste = new JPanel();
		JPanel panliste2 = new JPanel();
		
		JScrollPane scroll1 = new JScrollPane(liste1);
		
		liste1.setVisibleRowCount(3);
		liste2.setVisibleRowCount(3);
		liste1.addMouseListener(this);
		liste2.addMouseListener(this);
		ok.addMouseListener(this);
		
		montant1.setText(val1.toString());
		montant1.setColumns(1);
		montant1.setMaximumSize(new Dimension(100, 50));
		montant1.setMinimumSize(new Dimension(100, 50));
		montant2.setText(conversion_Text);
		montant2.setColumns(1);
		montant2.setMaximumSize(new Dimension(100, 50));
		
		panliste.setLayout(new BorderLayout());
		panliste2.setLayout(new BorderLayout());
		
		p.setAlignmentX(CENTER_ALIGNMENT);
		
		panliste.add(scroll1,BorderLayout.NORTH);
		panliste.add(montant1,BorderLayout.SOUTH);
		panliste2.add(new JScrollPane(liste2), BorderLayout.NORTH);
		panliste2.add(montant2, BorderLayout.SOUTH);
		
		p.add(panliste);
		p.add(panliste2);
		
		p.add(ok ,BorderLayout.PAGE_END);
		
		this.setSize(370,120);
		this.setContentPane(p);
		this.revalidate();
		this.setVisible(true);
	}
	
	void rafraichissement()
	{
		JPanel p = new JPanel();
		JPanel panliste = new JPanel();
		JPanel panliste2 = new JPanel();
		
		JScrollPane scroll1 = new JScrollPane(liste1);
		
		
		
		liste1.setVisibleRowCount(3);
		liste2.setVisibleRowCount(3);
	//	liste1.addMouseListener(this);
	//	liste2.addMouseListener(this);
	//	ok.addMouseListener(this);
		
		montant1.setText(val1.toString());
		montant1.setColumns(1);
		montant1.setMaximumSize(new Dimension(100, 50));
		montant1.setMinimumSize(new Dimension(100, 50));
		montant2.setText(conversion_Text);
		montant2.setColumns(1);
		montant2.setMaximumSize(new Dimension(100, 50));
		
		panliste.setLayout(new BorderLayout());
		panliste2.setLayout(new BorderLayout());
		
		p.setAlignmentX(CENTER_ALIGNMENT);
		
		panliste.add(scroll1,BorderLayout.NORTH);
		panliste.add(montant1,BorderLayout.SOUTH);
		panliste2.add(new JScrollPane(liste2), BorderLayout.NORTH);
		panliste2.add(montant2, BorderLayout.SOUTH);
		
		p.add(panliste);
		p.add(panliste2);
		
		p.add(ok ,BorderLayout.PAGE_END);
		
		this.setSize(370,120);
		this.setContentPane(p);
		this.revalidate();
		this.setVisible(true);
	}
 void genererUrl()
{
	int j = 0 ;
	int i = 0 ;
	String supStr[][]= new String[100][100];
	String nouvelleAdresse= "http://download.finance.yahoo.com/d/quotes.csv?s="+symbolOn+symbolOn2+"=X"+"&f=b";
				
		try 
		{
			
			URL url = new URL(nouvelleAdresse);
			InputStreamReader fichier;
			fichier = new InputStreamReader(url.openStream());
			BufferedReader tampon = new BufferedReader(fichier);
			String s ;
		
			while ((s=tampon.readLine())!=null)
			{
				i++;
				supStr[i] = s.replace('"',' ').split(",");
			}
		
		
			/* Debug
			  for(j=0; j<1; j++)
			{
				for(i=0;i<1;i++)
				{
					System.out.println(supStr[j+1][i]);
					
				}
				
			}*/
			conversion = Float.parseFloat(supStr[1][0]);
			conversion = (conversion * val1) ;
			conversion_Text = String.valueOf(conversion)+lettreOn;
			montant2.setText(conversion_Text);

			rafraichissement();
		}
		catch(IOException e1 )
		{
			System.out.println(" erreur");	
		}
		
	
}
 public void mousePressed(MouseEvent e)
 	{
	 
	}


public void mouseClicked(MouseEvent arg0) 
{
	//System.out.println(arg0.getSource());
	if(arg0.getSource()==ok)
	{
		val1 = Float.parseFloat(montant1.getText());
		genererUrl();
	}
	else
	{
	 String selectionner =  (String) liste1.getSelectedValue();
	 //System.out.println(selectionner);
	 int i=0;
	 for(i=0;i<6;i++)
	 	{
		 	if(selectionner== Nom1[i])
		 	{
			 symbolOn = symbol1[i];
			}
		}
	 
	 String selectionner2 = (String) liste2.getSelectedValue();
	// System.out.println("liste 2:"+selectionner2);
	 int k=0;
	 for(k=0;k<6;k++)
	 {
		 if(selectionner2== Nom1[k])
		 {
			 symbolOn2 = symbol1[k];
			 lettreOn = lettre[k];
		 }
	 }
	
	}
}

@Override
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
	
}