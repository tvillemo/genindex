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

public class InterfaceUS2_2 extends JFrame implements ActionListener
{
	private JLabel labNomClient;
	private JPanel panelClient;
	
	private JLabel labNomAnimal;
	private JTextField nomAnimal;
	private JLabel labIDAnimal;
	private JTextField IDAnimal;
	private JPanel panelAnimal;
	private JPanel panelAn1;
	private JPanel panelAn2;
	
	private JButton butAnnuler;
	private JButton butValider;
	private JPanel panButton;
	private JPanel panelButton;
	
	public InterfaceUS2_2()
	{
		labNomClient = new JLabel("Nom du client :");
		panelClient=new JPanel();
		panelClient.add(labNomClient);	
	
		this.add(panelClient, BorderLayout.NORTH);
		
		panelClient.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createEtchedBorder(), "Client :"));
		
		labNomAnimal = new JLabel("Nom de l'animal");
		nomAnimal = new JTextField();
		JPanel panelAn1 = new JPanel();
		panelAn1.setLayout(new GridLayout(1,2));
		panelAn1.add(labNomAnimal);
		panelAn1.add(nomAnimal);
		
		labIDAnimal = new JLabel("Identifiant de l'animal");
		IDAnimal = new JTextField();
		JPanel panelAn2 = new JPanel();
		panelAn2.setLayout(new GridLayout(1,2));
		panelAn2.add(labIDAnimal);
		panelAn2.add(IDAnimal);
		
		panelAnimal = new JPanel();
		panelAnimal.setLayout(new GridLayout(4, 1));
		panelAnimal.add(panelAn1);
		panelAnimal.add(panelAn2);
		
		this.add(panelAnimal, BorderLayout.CENTER);
		
		panelAnimal.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createEtchedBorder(), "Choisir un animal :"));
		
		
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
    
	public void actionPerformed(ActionEvent point)
    {

    }
	
	public static void main(String[] args) 
	{    
       InterfaceUS2_2 us = new InterfaceUS2_2();
    }
}
