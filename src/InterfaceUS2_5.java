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

public class InterfaceUS2_5 extends JFrame 
{
	private JLabel labNomClient;
	private JPanel panelClient;
	
	private JLabel labOK;
	private JPanel panelOK;
	
	private JButton butValider;
	private JPanel panButton;
	
	public InterfaceUS2_5()
	{
		labNomClient = new JLabel("Nom du client :");
		panelClient=new JPanel();
		panelClient.add(labNomClient);
		
		this.add(panelClient, BorderLayout.NORTH);
		
		panelClient.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createEtchedBorder(), "Client :"));
		
		labOK = new JLabel("Votre commande a bien été enregistrée !");
		panelOK=new JPanel();
		panelOK.add(labOK);
		
		this.add(panelOK, BorderLayout.CENTER);
		
		panelOK.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createEtchedBorder(), "Commande :"));
		
		butValider = new JButton("OK");
	    panButton = new JPanel();
	    panButton.add(butValider);
	    
	    this.add(panButton, BorderLayout.SOUTH);
	    
	 // visibilité
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.pack();
	    this.setSize(400,500);
	    this.setVisible(true);
	}
	
	public static void main(String[] args) 
	{    
       InterfaceUS2_5 us = new InterfaceUS2_5();
    }
}
