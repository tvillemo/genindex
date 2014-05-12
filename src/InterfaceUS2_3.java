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

public class InterfaceUS2_3 extends JFrame implements ActionListener
{

	private JLabel labNomClient;
	private JPanel panelClient;
	
	private JLabel labCategorie;
	private JComboBox categorie;
	private JLabel labSp;
	private JComboBox espece;
	private JLabel labNomAn;
	private JTextField nomAnimal;
	private JLabel labSexe;
	private JComboBox sexe;
	private JLabel labDateNaissance;
	private JTextField dateNaissance;
	private JPanel panelAnimal;
	private JPanel panelAni1;
	private JPanel panelAni2;
	private JPanel panelAni3;
	private JPanel panelAni4;
	private JPanel panelAni5;
	
	private JButton butAnnuler;
	private JButton butValider;
	private JPanel panButton;
	private JPanel panelButton;
	
	public InterfaceUS2_3()
	{
		labNomClient = new JLabel("Nom du client :");
		panelClient=new JPanel();
		panelClient.add(labNomClient);
		
		this.add(panelClient, BorderLayout.NORTH);
		
		panelClient.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createEtchedBorder(), "Client :"));
		
		labCategorie = new JLabel("Catégorie de l'animal");
		categorie = new JComboBox();
		JPanel panelAni1 = new JPanel();
		panelAni1.setLayout(new GridLayout(1,2));
		panelAni1.add(labCategorie);
		panelAni1.add(categorie);
		
		labSp = new JLabel("Espèce de l'animal");
		espece = new JComboBox();
		JPanel panelAni2 = new JPanel();
		panelAni2.setLayout(new GridLayout(1,2));
		panelAni2.add(labSp);
		panelAni2.add(espece);
		
		labNomAn = new JLabel("Nom de l'animal");
		nomAnimal = new JTextField();
		JPanel panelAni3 = new JPanel();
		panelAni3.setLayout(new GridLayout(1,2));
		panelAni3.add(labNomAn);
		panelAni3.add(nomAnimal);
		
		labSexe = new JLabel("Sexe de l'animal");
		sexe = new JComboBox();
		JPanel panelAni4 = new JPanel();
		panelAni4.setLayout(new GridLayout(1,2));
		panelAni4.add(labSexe);
		panelAni4.add(sexe);
		
		labDateNaissance = new JLabel("Date de naissance de l'animal");
		dateNaissance = new JTextField();
		JPanel panelAni5 = new JPanel();
		panelAni5.setLayout(new GridLayout(1,2));
		panelAni5.add(labDateNaissance);
		panelAni5.add(dateNaissance);
		
		panelAnimal = new JPanel();
		panelAnimal.setLayout(new GridLayout(5, 1));
		panelAnimal.add(panelAni1);
		panelAnimal.add(panelAni2);
		panelAnimal.add(panelAni3);
		panelAnimal.add(panelAni4);
		panelAnimal.add(panelAni5);
		
		this.add(panelAnimal, BorderLayout.CENTER);
		
		panelAnimal.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createEtchedBorder(), "Nouvel animal :"));
		
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
       InterfaceUS2_3 us = new InterfaceUS2_3();
    }
}
