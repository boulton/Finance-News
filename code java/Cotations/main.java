

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;


public class main extends JApplet 
{	

	private JPanel p = new JPanel();
	private int Largeur = 230;
	private int Hauteur = 360; 
	private int SocieteSelectionner = 1;
	private Object[][] donnee = new Object[20][100] ;
	private String supStr[][] = new String[100][100];
	private boolean lancement = true;
	

	private String[] entete = {"sigle", "Nom", "Changement en %", "capitalisation"};
	private JLabel img = new JLabel();
	private JPanel Over = new JPanel();
	private JPanel Over_Gauche = new JPanel();
	private JPanel Over_Droite = new JPanel();
	private JPanel TablePane = new JPanel();
	private JTable t = new JTable(donnee, entete);
	private TableColumn column = null;
	private BufferedImage imageVert = null;
	private BufferedImage imageRouge = null;
	
	
	public void init() 
	{
		int j ; // place de la societe dans le tableau
		int i = 1 ; // 5 informations sont demander volume nom ...
		
		try 
		{
			URL url = new URL("http://finance.yahoo.com/d/quotes.csv?s=XOM+CVX+JNJ+MSFT+SBUX+CSTR+JCP+AMZN+PP.PA+MC.PA+BNP.PA+VK.PA+RI.PA+FP.PA+CAP.PA+AC.PA+ML.PA+EI.PA+PUB.PA+RNO.PA&f=snp2j1a2");
			InputStreamReader fichier;
			fichier = new InputStreamReader(url.openStream());
			BufferedReader tampon = new BufferedReader(fichier);
			String s ;
			while ((s=tampon.readLine())!=null) // recuperation des donnée brut
			{
				supStr[i] = s.replace('"',' ').split(",");
				i++;
			}
			for(j=0; j<20; j++) // tableau a 2 entrée, 1) la cotation et 2) les données 
			{
				for(i=0;i<5;i++){
					donnee[j][i]=supStr[j+1][i]; // 1iere ligne de supstr est vide 
				}	
			}
		
			p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
			p.setAlignmentX(CENTER_ALIGNMENT);
			this.setContentPane(p);
			this.setSize(Largeur,Hauteur);
			this.setVisible(true);
		}
		catch(IOException e1 ){
			System.out.println(" erreur");	
		}
		
		ornements();
	}


	void ornements() 
	{	
		try 
		{          
			URL urlVert = new URL("http://www.servimg.com/u/f83/11/64/78/95/fleche10.gif");
		   	URL urlRouge= new URL("http://i83.servimg.com/u/f83/11/64/78/95/fleche11.gif");
		    imageVert= ImageIO.read(urlVert);
		    imageRouge= ImageIO.read(urlRouge);
		} 
		catch (IOException e){ 
		      e.printStackTrace();
		      System.out.println("Une érreur inattendue est intervenue :troll:"+e);
		}
		if(lancement) // permet de différencié entre le rafraichissement et le premier lancement ou tout s'initialise 
		{
			for (int i = 0; i < 4; i++) //reduction de la taille des colonnes
			{ 
				column = t.getColumnModel().getColumn(i); 
				column.setPreferredWidth(50); 
				column.setWidth(50); 
				column.setMaxWidth(50); 
				column.setMinWidth(50); 
			}
		 }
		 
		if(supStr[SocieteSelectionner][2].contains("-"))
		{
			 img =new JLabel(new ImageIcon(imageRouge));
		}
		else
		{
			 img =new JLabel(new ImageIcon(imageVert));
		}
		/* differentes dispostion d'éssai:
		 *  
		 * Over.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
		 * Over_Gauche.setLayout(new FlowLayout());
		 * Over_Gauche.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		 * Over_Droite.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		 */
		Over_Droite.add(img, BorderLayout.CENTER);
		Over_Droite.add(new JLabel("<html><h2>"+supStr[SocieteSelectionner][2]+"</h2><html>"),BorderLayout.NORTH);
		Over_Gauche.add(new JLabel("<html><center><h1>"+supStr[SocieteSelectionner][0]+"</h1></center><br>"+supStr[SocieteSelectionner][1]+"<br><center>"+supStr[SocieteSelectionner][4]+" $</center>"+"</html>"), BorderLayout.CENTER);
		
		// TablePane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		// TablePane.setMaximumSize(new Dimension(64000,150));
		
		if(lancement)
		{
			t.setMaximumSize(new Dimension(250,120));
			t.setPreferredScrollableViewportSize(new Dimension(t.getPreferredSize().width,90));
			t.addMouseListener(new MouseAdapter()
			{ 
				public void mouseClicked(MouseEvent e)
				{
					int ligne = 1+t.getSelectedRow();
					int colonne= t.getSelectedColumn();
					Over_Droite.removeAll();
					Over_Gauche.removeAll();
					SocieteSelectionner = ligne;
					ornements();
				}
			});
		
		
			TablePane.add(t.getTableHeader(),BorderLayout.NORTH);
			TablePane.add(t ,BorderLayout.AFTER_LAST_LINE);
			TablePane.add(new JScrollPane(t));
			
			Over.add(Over_Gauche, BorderLayout.WEST);
			Over.add(Over_Droite, BorderLayout.EAST);
			Over.add(TablePane,BorderLayout.AFTER_LAST_LINE);
			p.add(Over);
		}
		
		lancement=false; // ce n'est plus le 1ier lancement donc faux	
		p.validate();
	}
	
	

}
