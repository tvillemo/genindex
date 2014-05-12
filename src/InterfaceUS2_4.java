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

public class InterfaceUS2_4 extends JFrame implements ActionListener
{
	private JLabel labNomClient;
	private JPanel panelClient;
	
	private JLabel labNbEch;
	private JTextField nbEch;
	private JLabel labAnalyse;
	private JComboBox analyse;
	
	private JRadioButton buttonPrio;  
	private JPanel panelButton;
	
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panelEch;
	
	private JButton butAnnuler;
	private JButton butValider;
	private JPanel panButton;
	private JPanel panelButtons;
	
	public InterfaceUS2_4()
	{
		labNomClient = new JLabel("Nom du client :");
		panelClient=new JPanel();
		panelClient.add(labNomClient);
		
		this.add(panelClient, BorderLayout.NORTH);
		
		panelClient.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createEtchedBorder(), "Client :"));
		
		labNbEch = new JLabel("Saisir le nombre d'échantillons");
		nbEch = new JTextField();
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1,2));
		panel1.add(labNbEch);
		panel1.add(nbEch);
		
		labAnalyse = new JLabel("Analyse");
		analyse = new JComboBox();
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,2));
		panel2.add(labAnalyse);
		panel2.add(analyse);
		
		buttonPrio   = new JRadioButton("Prioritaire"  , false);
		panelButton = new JPanel();
		panelButton.setLayout(new GridLayout(1, 1));
		panelButton.add(buttonPrio);
		
		panelEch = new JPanel();
		panelEch.setLayout(new GridLayout(5, 1));
		panelEch.add(panel1);
		panelEch.add(panel2);
		panelEch.add(panelButton);
		
		this.add(panelEch, BorderLayout.CENTER);
		
		panelEch.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createEtchedBorder(), "Gerstion des échantillons :"));
		
		butAnnuler = new JButton("Annuler");
	    butValider = new JButton("Valider la commande");
	    panButton = new JPanel();
	    panButton.add(butAnnuler);
	    panButton.add(butValider);
	    panelButtons = new JPanel();
	    panelButtons.add(panButton); 
	    
	    this.add(panelButtons, BorderLayout.SOUTH);
		
		// visibilité
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.pack();
	    this.setSize(400,500);
	    this.setVisible(true);
	
	}
	
	public void actionPerformed(ActionEvent point)
    {

    }
	
	public static void main(String[] args) 
	{    
       InterfaceUS2_4 us = new InterfaceUS2_4();
    }
}
