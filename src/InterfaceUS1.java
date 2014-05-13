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


public class InterfaceUS1 extends JFrame implements  ActionListener{
    
  

     private JButton valider;
     private JRadioButton proButton;

    private JRadioButton parButton;
    private String last;
    private JTextField nRTF;
    private JTextField rTF;
    private JTextField cDTF;        
    private JTextField vTF;        
    private JTextField nTF;        
    private JTextField pTF;        
    private JTextField tTF;         
    private JTextField fTF; 
    private boolean pro = false;
    private JFrame frame;
    private JPanel adresse;
    private JPanel radioPanel;
    private ButtonGroup bgroup;
    private JLabel numRue;
    private JLabel rue;
    private JPanel zone1;
    private JPanel zone3;
    private JPanel zone4;
    private JPanel zone5;
    private JPanel zone6;
    private JPanel zone7;
    private JPanel zone2;
    private JPanel zone8;
    private JLabel codePostal;
    private JLabel ville;
    private JLabel nom;
    private JLabel prenom;
    private JLabel telephone;
    private JLabel fax;
    private JLabel champ;
    private JPanel infoClient;
    private JTextField nSTF;
    private JTextField nRTF2;
    private JTextField rTF2;
    private JTextField cDTF2;        
    private JTextField vTF2;  
    private JTextField depTF;
    private JTextField mailTF;
    private JPanel infoPar;
    
    private JLabel nomSociete;
    private JPanel zone10;
    private JPanel zone11;
    private JLabel numRue2;
    private JLabel rue2;
    private JPanel zone22;
    private JLabel codePostal2;
    private JLabel ville2;
    private JPanel zone44;
    private JPanel zone33;
    private JLabel dep;
    private JPanel zone43;
    private JPanel adressePro;
    private JLabel mailF;      
    private JPanel infoPro;
    private JPanel zone42;
    private Adress adressPro;
    private Adress adress;
    
    private boolean save;
    
    private static Database d;
    
    
    public InterfaceUS1 (){
    	
    	d = new Database();
    	
        /* Panel du haut avec les radioButton*/
	    proButton   = new JRadioButton("Professionnel"  , false);
	    parButton    = new JRadioButton("Particulier"   , false);
	    
    bgroup = new ButtonGroup();
    bgroup.add(proButton);
    bgroup.add(parButton);
    
    radioPanel = new JPanel();
    radioPanel.setLayout(new GridLayout(2, 1));
    radioPanel.add(proButton);
    radioPanel.add(parButton);
   
    radioPanel.setBorder(BorderFactory.createTitledBorder(
           BorderFactory.createEtchedBorder(), "Type de client :"));
    
    proButton.addActionListener(this);
    
       /*Panel avec les info du client*/
  
   
    
    numRue = new JLabel(" Numero de rue :");
    nRTF = new JTextField ();
    zone1 = new JPanel();
    zone1.setLayout(new GridLayout(1,2));
    zone1.add(numRue);
    zone1.add(nRTF);
    
    rue = new JLabel(" Nom de rue :");
    rTF = new JTextField ();
    zone2 = new JPanel();
    zone2.setLayout(new GridLayout(1,2));
    zone2.add(rue);
    zone2.add(rTF);
    
    codePostal = new JLabel("Code postal :");
    cDTF = new JTextField ();
    zone3 = new JPanel();
    zone3.setLayout(new GridLayout(1,2));
    zone3.add(codePostal);
    zone3.add(cDTF);
    
    ville = new JLabel("Nom de la ville :");
    vTF = new JTextField ();
    zone4 = new JPanel();
    zone4.setLayout(new GridLayout(1,2));
    zone4.add(ville);
    zone4.add(vTF);
    
    nom = new JLabel("*Nom du client :");
    nTF = new JTextField ();
    zone5 = new JPanel();
    zone5.setLayout(new GridLayout(1,2));
    zone5.add(nom);
    zone5.add(nTF);
    
    prenom = new JLabel("*Prenom du client :");
    pTF = new JTextField ();
    zone6 = new JPanel();
    zone6.setLayout(new GridLayout(1,2));
    zone6.add(prenom);
    zone6.add(pTF);
    
    telephone = new JLabel("*Telephone du client :");
    tTF = new JTextField ();
    zone7 = new JPanel();
    zone7.setLayout(new GridLayout(1,2));
    zone7.add(telephone);
    zone7.add(tTF);
    
    fax = new JLabel("Fax du client :");
    fTF = new JTextField ();
    zone8 = new JPanel();
    zone8.setLayout(new GridLayout(1,2));
    zone8.add(fax);
    zone8.add(fTF);
    
    champ = new JLabel("* : Champ obligatoire");
    
    /*Adresse*/
    adresse = new JPanel();
    adresse.setLayout(new GridLayout(2, 2));
    adresse.add(zone1);
    adresse.add(zone2);
    adresse.add(zone3);
    adresse.add(zone4);
    
    adresse.setBorder(BorderFactory.createTitledBorder(
           BorderFactory.createEtchedBorder(), "Adresse du client :"));
    
     /*Buton valider*/

     valider = new JButton ("Valider");
     valider.addActionListener(this);
     
     
     
     
    infoPar = new JPanel();
    infoPar.setLayout(new GridLayout(6, 2));
    infoPar.add(zone5);
    infoPar.add(zone6);
    infoPar.add(zone7);
    infoPar.add(zone8);
    infoPar.add(adresse);
    infoPar.add(champ);
    infoPar.setBorder(BorderFactory.createTitledBorder(
           BorderFactory.createEtchedBorder(), "Saisie des informations relatives au client particulier :"));

    
    
    //infoClient
    infoClient = new JPanel();
    infoClient.setLayout(new GridLayout(1,1));
    infoClient.add(infoPar);
    infoClient.setBorder(BorderFactory.createTitledBorder(
           BorderFactory.createEtchedBorder(), "Saisie des informations relatives au client :"));
    
    
   /*Info Pro*/
    
        
    nomSociete = new JLabel("* Nom de Societe :");
    nSTF = new JTextField ();
    zone10 = new JPanel();
    zone10.setLayout(new GridLayout(1,2));
    zone10.add(nomSociete);
    zone10.add(nSTF);
    
    numRue2 = new JLabel(" *Numero de rue :");
    nRTF2 = new JTextField ();
    zone11 = new JPanel();
    zone11.setLayout(new GridLayout(1,2));
    zone11.add(numRue2);
    zone11.add(nRTF2);
    
    rue2 = new JLabel(" *Nom de rue :");
    rTF2 = new JTextField ();
    zone22 = new JPanel();
    zone22.setLayout(new GridLayout(1,2));
    zone22.add(rue2);
    zone22.add(rTF2);
    
    codePostal2 = new JLabel("*Code postal :");
    cDTF2 = new JTextField ();
    zone33 = new JPanel();
    zone33.setLayout(new GridLayout(1,2));
    zone33.add(codePostal2);
    zone33.add(cDTF2);
    
    ville2 = new JLabel("*Nom de la ville :");
    vTF2 = new JTextField ();
    zone44 = new JPanel();
    zone44.setLayout(new GridLayout(1,2));
    zone44.add(ville2);
    zone44.add(vTF2);
    
    dep = new JLabel("*Departement de facturation :");
    depTF = new JTextField ();
    zone42 = new JPanel();
    zone42.setLayout(new GridLayout(1,2));
    zone42.add(dep);
    zone42.add(depTF);
    
    mailF = new JLabel("*Mail de Facturation :");
    mailTF = new JTextField ();
    zone43 = new JPanel();
    zone43.setLayout(new GridLayout(1,2));
    zone43.add(mailF);
    zone43.add(mailTF);
    
    /*Adresse*/
    adressePro = new JPanel();
    adressePro.setLayout(new GridLayout(2, 1));
    adressePro.add(zone11);
    adressePro.add(zone22);
    adressePro.add(zone33);
    adressePro.add(zone44);
    
    adressePro.setBorder(BorderFactory.createTitledBorder(
          BorderFactory.createEtchedBorder(), "*Adresse de facturation :"));
    
    
    
    /*Info client pro*/
    infoPro = new JPanel();
    //infoPro.setLayout(new GridLayout(9, 2));
    infoPro.add(zone10);
    infoPro.add(zone42);
    infoPro.add(zone43);
    infoPro.add(adressePro);
    infoPro.setBorder(BorderFactory.createTitledBorder(
           BorderFactory.createEtchedBorder(), "Saisie des informations relatives au client Profesionnel :"));
    
    
    
    
    /*On ajoute tout au putain de frame*/
    frame = new JFrame("US1");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(radioPanel, BorderLayout.PAGE_START);
    frame.add(infoClient);
    frame.add(valider, BorderLayout.PAGE_END);
    JFrame.setDefaultLookAndFeelDecorated(true);
        
    frame.pack();
    frame.setVisible(true);
    }
    

    
    
    /********************************************************************/
    
   
   
    
     @Override
    public void actionPerformed(ActionEvent e) {
        if ( e.getSource() == proButton )
        {
            if (proButton.isSelected()) {
                System.out.println("Pro");
                     pro = true;  
                     infoClient.removeAll();
                     infoClient.setLayout(new GridLayout(2, 2));
                     infoClient.add(infoPar);
                     infoClient.add(infoPro);                    
                     infoClient.setBorder(BorderFactory.createTitledBorder(
                               BorderFactory.createEtchedBorder(), "Saisie des informations relatives au client :"));

                     
                     frame.revalidate();
                }
            else {  
                pro = false;
                infoClient.removeAll();
                //infoClient.setLayout(new GridLayout(9, 2));
                infoClient.add(adresse);
                infoClient.add(zone5);
                infoClient.add(zone6);
                infoClient.add(zone7);
                infoClient.add(zone8);
                infoClient.add(champ);
                infoClient.add(valider);
                infoClient.setBorder(BorderFactory.createTitledBorder(
                          BorderFactory.createEtchedBorder(), "Saisie des informations relatives au client :"));

                infoClient.revalidate();
            }
        }
        if ( e.getSource() == valider ) {
        	System.out.println("Valide ok");
        	Customers C = new Customers (nTF.getText(),//Nom
        		Integer.parseInt(nRTF.getText()),// numero rue
        		rTF.getText(),// rue
        		tTF.getText(),// telephone
        		0);// Id
	        C.setFax(fTF.getText());
	        C.setPro(pro);
	        C.setName(pTF.getText(),nTF.getText());
	        adress = new Adress(Integer.parseInt(nRTF.getText()),rTF.getText(),Integer.parseInt(cDTF.getText()),vTF.getText());
	        C.setAdressClient(adress);
	        if (pro) {
	        	C.setNomSociete(nSTF.getText());
	        	C.setDepartementFacturation(depTF.getText());
	        	C.setEmail(mailTF.getText());
	        	adressPro = new Adress(Integer.parseInt(nRTF2.getText()),rTF2.getText(),Integer.parseInt(cDTF2.getText()),vTF2.getText());
	        	C.setAdressFacturation(adressPro);
	        }
	        
	        save = d.saveCustomer(C);
	        
	        if (save) {
	        	JOptionPane.showMessageDialog(this, "Le client a bien été ajouté", "Enregistrement", JOptionPane.ERROR_MESSAGE);
	        }
	        else {
	        	JOptionPane.showMessageDialog(this, "Le client existe déjà dans la base de données", "Enregistrement", JOptionPane.ERROR_MESSAGE);
	        }
        }             
    }
    
    

    public static void main(String[] args) {        	        
    	InterfaceUS1 us = new InterfaceUS1();
    	d.close();
                              
    }
}
