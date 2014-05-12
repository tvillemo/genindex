import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anne-So
 */

public class InterfaceUS2 extends JFrame
{
	private JRadioButton proButton;  
	private JPanel radioPanel;
	
	private JPanel panelClient;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panelAdresse;
	private JPanel panelAd1;
	private JPanel panelAd2;
	private JPanel panelAd3;
	private JPanel panelAd4;
	
	private JLabel labNomClient;
	private JLabel labPrenomClient;
	private JLabel labNumClient;
	private JLabel labCorporation;
	
	private JLabel labNumAd;
	private JLabel labRue;
	private JLabel labCP;
	private JLabel labVille;
	
	private JTextField fieldNomC;
	private JTextField fieldPrenomC;
	private JTextField fieldNumC;
	private JTextField fieldCorp;
	
	private JTextField fieldNumA;
	private JTextField fieldRue;
	private JTextField fieldCP;
	private JTextField fieldVille;
	
	private JButton butAnnuler;
	private JButton butValider;
	private JPanel panButton;
	private JPanel panelButton;
	
	public InterfaceUS2()
	{
		proButton   = new JRadioButton("Professionnel"  , false);
		radioPanel = new JPanel();
		radioPanel.setLayout(new GridLayout(1, 1));
	    radioPanel.add(proButton);	    
	    
	    labNomClient = new JLabel("Nom du client :");
	    fieldNomC = new JTextField();
	    JPanel panel1 = new JPanel();
	    panel1.setLayout(new GridLayout(1,2));
	    panel1.add(labNomClient);
	    panel1.add(fieldNomC);
	    
	    labPrenomClient = new JLabel("Prénom du client :");
	    fieldPrenomC = new JTextField();
	    JPanel panel2 = new JPanel();
	    panel2.setLayout(new GridLayout(1,2));
	    panel2.add(labPrenomClient);
	    panel2.add(fieldPrenomC);
	    
	    labNumClient = new JLabel("Numéro du client :");
	    fieldNumC = new JTextField();
	    JPanel panel3 = new JPanel();
	    panel3.setLayout(new GridLayout(1,2));
	    panel3.add(labNumClient);
	    panel3.add(fieldNumC);
	    
	    labCorporation = new JLabel("Corporation :");	    
	    fieldCorp = new JTextField();	 
	    JPanel panel4 = new JPanel();
	    panel4.setLayout(new GridLayout(1,2));
	    panel4.add(labCorporation);
	    panel4.add(fieldCorp);
	    
	    panelClient = new JPanel();
	    panelClient.setLayout(new GridLayout(5, 1));
	    panelClient.add(radioPanel);
	    panelClient.add(panel1);
	    panelClient.add(panel2);
	    panelClient.add(panel3);
	    panelClient.add(panel4);
	    
	    this.add(panelClient, BorderLayout.NORTH);
	    
	    panelClient.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createEtchedBorder(), "Saisie des informations relatives au client :"));
	    
	    labNumAd = new JLabel("Numéro :");	    
	    fieldNumA = new JTextField();	 
	    JPanel panelAd1 = new JPanel();
	    panelAd1.setLayout(new GridLayout(1,2));
	    panelAd1.add(labNumAd);
	    panelAd1.add(fieldNumA);
	    
	    labRue = new JLabel("Rue :");	    
	    fieldRue = new JTextField();	 
	    JPanel panelAd2 = new JPanel();
	    panelAd2.setLayout(new GridLayout(1,2));
	    panelAd2.add(labRue);
	    panelAd2.add(fieldRue);
	    
	    labCP = new JLabel("Code postal :");	    
	    fieldCP = new JTextField();	 
	    JPanel panelAd3 = new JPanel();
	    panelAd3.setLayout(new GridLayout(1,2));
	    panelAd3.add(labCP);
	    panelAd3.add(fieldCP);
	    
	    labVille = new JLabel("Ville :");	    
	    fieldVille = new JTextField();	 
	    JPanel panelAd4 = new JPanel();
	    panelAd4.setLayout(new GridLayout(1,2));
	    panelAd4.add(labVille);
	    panelAd4.add(fieldVille);
	    
	    panelAdresse = new JPanel();
	    panelAdresse.setLayout(new GridLayout(4, 1));
	    panelAdresse.add(panelAd1);
	    panelAdresse.add(panelAd2);
	    panelAdresse.add(panelAd3);
	    panelAdresse.add(panelAd4);
	    
	    this.add (panelAdresse, BorderLayout.CENTER);
	    
	    panelAdresse.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createEtchedBorder(), "Saisie de l'adresse du client :"));
	    
	    butAnnuler = new JButton("Annuler");
	    butValider = new JButton("Valider");
	    panButton = new JPanel();
	    panButton.add(butAnnuler);
	    panButton.add(butValider);
	    panelButton = new JPanel();
	    panelButton.add(panButton); 
	    
	    this.add(panelButton, BorderLayout.SOUTH);
	    
	    
	    
	 // visibilité
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(400,500);
        this.setVisible(true);
	}
	
	public static void main(String[] args) 
	{    
       InterfaceUS2 us = new InterfaceUS2();
    }

}
 