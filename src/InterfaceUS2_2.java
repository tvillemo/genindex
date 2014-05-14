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
	private JLabel labNomC;
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
	
	private  Customers custom;
	private Animals animal;
	private Database d=new Database();
	
	public InterfaceUS2_2(Customers custom)
	{
		this.custom=custom;
		labNomClient = new JLabel("Client :" + custom.getLastName() + custom.getFirstName());
		panelClient=new JPanel();
		panelClient.add(labNomClient);	
	
		this.add(panelClient, BorderLayout.NORTH);
		
		panelClient.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createEtchedBorder(), "Client :"));
		
		labNomAnimal = new JLabel("Nom de l'animal");
		nomAnimal = new JTextField();
		nomAnimal.addActionListener(this);
		JPanel panelAn1 = new JPanel();
		panelAn1.setLayout(new GridLayout(1,2));
		panelAn1.add(labNomAnimal);
		panelAn1.add(nomAnimal);
		
		labIDAnimal = new JLabel("Identifiant de l'animal");
		IDAnimal = new JTextField();
		IDAnimal.addActionListener(this);
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
	    butValider.addActionListener(this);
	    butAnnuler.addActionListener(this);
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
		if (point.getSource()==butValider)
		{
			boolean bool = true;
			if(nomAnimal.getText().length()==0) 
			{
				if(IDAnimal.getText().length()==0)
				{
					Object[] options = { "OK" };
					int n = JOptionPane.showOptionDialog(new JFrame(),
							"Veuillez remplir au moins un des champs", "",
					       JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null,
					       options, options);
					bool=false;
				}
			}
			if(bool=true)
			{
				animal = new Animals(Integer.parseInt(IDAnimal.getText()), nomAnimal.getText());
				
				//System.out.println(nomAnimal.getText());			
				//System.out.println(animal.getName());
				System.out.println(custom.getID());
				
				if(d.IfAnimalExist(animal,custom))
				{
					InterfaceUS2_4 test = new InterfaceUS2_4(animal,custom);
		    		this.dispose();
				}
				else
				{
					InterfaceUS2_3 test = new InterfaceUS2_3(custom);
		    		this.dispose();
				}
			}
		}
		if(point.getSource()==butAnnuler)
		{
			this.dispose();
		}
    }
	
	public static void main(String[] args) 
	{    
       InterfaceUS2_2 us = new InterfaceUS2_2(new Customers("dupond", 86000,"Poitiers", "090909",1));
    }
}
=======
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
	private JLabel labNomC;
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
	
	public InterfaceUS2_2(Customers custom)
	{
		labNomClient = new JLabel("Client :" + custom.getLastName() + custom.getFirstName());
		panelClient=new JPanel();
		panelClient.add(labNomClient);	
	
		this.add(panelClient, BorderLayout.NORTH);
		
		panelClient.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createEtchedBorder(), "Client :"));
		
		labNomAnimal = new JLabel("Nom de l'animal");
		nomAnimal = new JTextField();
		nomAnimal.addActionListener(this);
		JPanel panelAn1 = new JPanel();
		panelAn1.setLayout(new GridLayout(1,2));
		panelAn1.add(labNomAnimal);
		panelAn1.add(nomAnimal);
		
		labIDAnimal = new JLabel("Identifiant de l'animal");
		IDAnimal = new JTextField();
		IDAnimal.addActionListener(this);
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
	    butValider.addActionListener(this);
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
		if (point.getSource()==butValider)
		{
			boolean bool = true;
			if(nomAnimal.getText().length()==0) 
			{
				if(IDAnimal.getText().length()==0)
				{
					Object[] options = { "OK" };
					int n = JOptionPane.showOptionDialog(new JFrame(),
							"Veuillez remplir au moins un des champs", "",
					       JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null,
					       options, options);
					bool=false;
				}
			}
			if(bool=true)
			{
				
			}
		}
		if(point.getSource()==butAnnuler)
		{
			this.dispose();
		}
    }
	
	public static void main(String[] args) 
	{    
       //InterfaceUS2_2 us = new InterfaceUS2_2();
    }
}
>>>>>>> branch 'master' of https://github.com/tvillemo/genindex.git
