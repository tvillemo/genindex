import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Robin
 */

public class InterfaceUS1 extends JPanel {  

     private JButton valider;
     private JRadioButton proButton;
    private JRadioButton parButton;
    
    public InterfaceUS1 (){
        /* Panel du haut avec les radioButton*/
    JRadioButton proButton   = new JRadioButton("Professionnel"  , false);
    JRadioButton parButton    = new JRadioButton("Particulier"   , false);
    
    ButtonGroup bgroup = new ButtonGroup();
    bgroup.add(proButton);
    bgroup.add(parButton);
    
    JPanel radioPanel = new JPanel();
    radioPanel.setLayout(new GridLayout(2, 1));
    radioPanel.add(proButton);
    radioPanel.add(parButton);
   
    radioPanel.setBorder(BorderFactory.createTitledBorder(
           BorderFactory.createEtchedBorder(), "Type de client :"));
    
       /*Panel avec les info du client*/
  
    JLabel nomSociete = new JLabel("* Nom de Societe :");
    JTextField nSTF = new JTextField ();
    JPanel zone = new JPanel();
    zone.setLayout(new GridLayout(1,2));
    zone.add(nomSociete);
    zone.add(nSTF);
    
    JLabel numRue = new JLabel(" Numero de rue :");
    JTextField nRTF = new JTextField ();
    JPanel zone1 = new JPanel();
    zone1.setLayout(new GridLayout(1,2));
    zone1.add(numRue);
    zone1.add(nRTF);
    
    JLabel rue = new JLabel(" Nom de rue :");
    JTextField rTF = new JTextField ();
    JPanel zone2 = new JPanel();
    zone2.setLayout(new GridLayout(1,2));
    zone2.add(rue);
    zone2.add(rTF);
    
    JLabel codePostal = new JLabel("Code postal :");
    JTextField cDTF = new JTextField ();
    JPanel zone3 = new JPanel();
    zone3.setLayout(new GridLayout(1,2));
    zone3.add(codePostal);
    zone3.add(cDTF);
    
    JLabel ville = new JLabel("Nom de la ville :");
    JTextField vTF = new JTextField ();
    JPanel zone4 = new JPanel();
    zone4.setLayout(new GridLayout(1,2));
    zone4.add(ville);
    zone4.add(vTF);
    
    JLabel nom = new JLabel("*Nom du client :");
    JTextField nTF = new JTextField ();
    JPanel zone5 = new JPanel();
    zone5.setLayout(new GridLayout(1,2));
    zone5.add(nom);
    zone5.add(nTF);
    
    JLabel prenom = new JLabel("*Prenom du client :");
    JTextField pTF = new JTextField ();
    JPanel zone6 = new JPanel();
    zone6.setLayout(new GridLayout(1,2));
    zone6.add(prenom);
    zone6.add(pTF);
    
    JLabel telephone = new JLabel("*Telephone du client :");
    JTextField tTF = new JTextField ();
    JPanel zone7 = new JPanel();
    zone7.setLayout(new GridLayout(1,2));
    zone7.add(telephone);
    zone7.add(tTF);
    
    JLabel fax = new JLabel("Fax du client :");
    JTextField fTF = new JTextField ();
    JPanel zone8 = new JPanel();
    zone8.setLayout(new GridLayout(1,2));
    zone8.add(fax);
    zone8.add(fTF);
    
    JLabel champ = new JLabel("* : Champ obligatoire");
    
    /*Adresse*/
    JPanel adresse = new JPanel();
    adresse.setLayout(new GridLayout(2, 2));
    adresse.add(zone1);
    adresse.add(zone2);
    adresse.add(zone3);
    adresse.add(zone4);
    
    adresse.setBorder(BorderFactory.createTitledBorder(
           BorderFactory.createEtchedBorder(), "Adresse du client :"));
    
     /*Buton valider*/
    JButton valider = new JButton ("Valider");
    valider.setSize(1,2);
    
    /*Info client*/
    JPanel infoClient = new JPanel();
    infoClient.setLayout(new GridLayout(9, 2));
    infoClient.add(zone);
    infoClient.add(adresse);
    infoClient.add(zone5);
    infoClient.add(zone6);
    infoClient.add(zone7);
    infoClient.add(zone8);
    infoClient.add(champ);
    infoClient.add(valider);
    infoClient.setBorder(BorderFactory.createTitledBorder(
           BorderFactory.createEtchedBorder(), "Saisie des informations relatives au client :"));
    
    
   
    /*On ajoute tout au putain de frame*/
    JFrame frame = new JFrame("US1");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(radioPanel, BorderLayout.PAGE_START);
    frame.add(infoClient, BorderLayout.PAGE_END);
    JFrame.setDefaultLookAndFeelDecorated(true);
        
    frame.pack();
    frame.setVisible(true);
    }
    
    public static void main(String[] args) {    
                InterfaceUS1 us = new InterfaceUS1();
    }
}
