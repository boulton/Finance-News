import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
   
public class Calculatrice 	extends JApplet  
{

	private JPanel container = new JPanel();
  //Tableau stockant les éléments à afficher dans la calculatrice
  String[] tab_string = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "=", "C", "+", "-", "*", "/"};
  //Un bouton par élément à afficher
  JButton[] tab_button = new JButton[tab_string.length];
  private JLabel ecran = new JLabel();
  private Dimension dim = new Dimension(50, 40);
  private Dimension dim2 = new Dimension(50, 31);
  private double chiffre1;
  private boolean clicOperateur = false, update = false;
  private String operateur = "";
   
  public void init()
  {
    this.setSize(240, 260);
   
    initComposant();
    this.setContentPane(container);
    this.setVisible(true);
  }	   
	   
  private void initComposant(){
	
	ecran = new JLabel("0");
    ecran.setHorizontalAlignment(JLabel.RIGHT);
    ecran.setPreferredSize(new Dimension(220, 20));
    
    JPanel operateur = new JPanel();      
    operateur.setPreferredSize(new Dimension(55, 225));
    
    JPanel chiffre = new JPanel();
    chiffre.setPreferredSize(new Dimension(165, 225));
    
    JPanel panEcran = new JPanel();
    panEcran.setPreferredSize(new Dimension(220, 30));
 
    //On crée les boutons
    for(int i = 0; i < tab_string.length; i++)
    {
      tab_button[i] = new JButton(tab_string[i]);
      tab_button[i].setPreferredSize(dim);
    
      switch(i){
        //on définit le comportement à avoir grâce à un listener pour les operateur +-*/=
        case 11 :
          tab_button[i].addActionListener(new EgalListener());
          chiffre.add(tab_button[i]);
          break;
          
        case 12 :
          tab_button[i].setForeground(Color.red);
          tab_button[i].addActionListener(new ResetListener());
          operateur.add(tab_button[i]);
          break;
          
        case 13 :
          tab_button[i].addActionListener(new PlusListener());
          tab_button[i].setPreferredSize(dim2);
          operateur.add(tab_button[i]);
          break;
        
        case 14 :
          tab_button[i].addActionListener(new MoinsListener());
          tab_button[i].setPreferredSize(dim2);
          operateur.add(tab_button[i]);
          break;    
        
        case 15 :   
          tab_button[i].addActionListener(new MultiListener());
          tab_button[i].setPreferredSize(dim2);
          operateur.add(tab_button[i]);
          break;
        
        case 16 :
          tab_button[i].addActionListener(new DivListener());
          tab_button[i].setPreferredSize(dim2);
          operateur.add(tab_button[i]);
          break;
        
        default :
          //les chiffre sont les autres ecouter avec:
          chiffre.add(tab_button[i]);
          tab_button[i].addActionListener(new ChiffreListener());
          break;

      }
    }
    panEcran.add(ecran);
    panEcran.setBorder(BorderFactory.createLineBorder(Color.black));
    
    container.add(panEcran, BorderLayout.NORTH);
    container.add(chiffre, BorderLayout.CENTER);
    container.add(operateur, BorderLayout.EAST);
  }
 
  //Méthode pour les calculs selon l'operateur
  private void calcul()
  {
    if(operateur.equals("+"))
    {
    	chiffre1 = chiffre1 + 
    	Double.valueOf(ecran.getText()).doubleValue();
    	ecran.setText(String.valueOf(chiffre1));
    }
    if(operateur.equals("-"))
    {
    	chiffre1 = chiffre1 - 
        Double.valueOf(ecran.getText()).doubleValue();
    	ecran.setText(String.valueOf(chiffre1));
    }          
    if(operateur.equals("*"))
    {
    	chiffre1 = chiffre1 * 
        Double.valueOf(ecran.getText()).doubleValue();
    	ecran.setText(String.valueOf(chiffre1));
    }     
    if(operateur.equals("/"))
    {
      try{
    	  chiffre1 = chiffre1 / 
          Double.valueOf(ecran.getText()).doubleValue();
    	  ecran.setText(String.valueOf(chiffre1));
      	 } 
      catch(ArithmeticException e) {
        ecran.setText("0");
      }
    }
    
  }
 
  
  //Permet de stocker les chiffres et de les afficher
  class ChiffreListener implements ActionListener {
    public void actionPerformed(ActionEvent e){
      //On affiche le chiffre additionnel dans le label
      String str = ((JButton)e.getSource()).getText();
      if(update){
        update = false;
      }
      else{
        if(!ecran.getText().equals("0"))
          str = ecran.getText() + str;
      }
      ecran.setText(str);
    }
  }
 
  // bouton =
  class EgalListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      calcul();
      update = true;
      clicOperateur = false;
    }
  }
 
  // bouton +
  class PlusListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      if(clicOperateur){
        calcul();
        ecran.setText(String.valueOf(chiffre1));
      }
      else{
        chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
        clicOperateur = true;
      }
      operateur = "+";
      update = true;
    }
  }
 
  // bouton -
  class MoinsListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      if(clicOperateur){
        calcul();
        ecran.setText(String.valueOf(chiffre1));
      }
      else{
        chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
        clicOperateur = true;
      }
      operateur = "-";
      update = true;
    }
  }
 
  // bouton *
  class MultiListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      if(clicOperateur){
        calcul();
        ecran.setText(String.valueOf(chiffre1));
      }
      else{
        chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
        clicOperateur = true;
      }
      operateur = "*";
      update = true;
    }
  }
 
  // bouton /
  class DivListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      if(clicOperateur){
        calcul();
        ecran.setText(String.valueOf(chiffre1));
      }
      else{
        chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
        clicOperateur = true;
      }
      operateur = "/";
      update = true;
    }
  }
 
  // bouton C
  class ResetListener implements ActionListener {
    public void actionPerformed(ActionEvent arg0){
      clicOperateur = false;
      update = true;
      chiffre1 = 0;
      operateur = "";
      ecran.setText("");
    }
  }      
}