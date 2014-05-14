import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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
	private JComboBox<String> categorie;
	private JLabel labSp;
	private JComboBox<String> espece = new JComboBox<String>();
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
	
	private Animals animal;
	
	private int count=0;
	private Customers custom;
	
	private Database d = new Database();
	
	
	public InterfaceUS2_3(Customers custom, String nomEntre)
	{
		//System.out.println("coucou");
		
		d = new Database();
		this.custom=custom; 
		
		//System.out.println("coucou pito"); 
		
		labNomClient = new JLabel("Client :" + custom.getLastName() + custom.getFirstName());
		
		//System.out.println("coucou pito pito");
		
		panelClient=new JPanel();
		panelClient.add(labNomClient);
		
		this.add(panelClient, BorderLayout.NORTH);
		
		panelClient.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createEtchedBorder(), "Client :"));
		
		labCategorie = new JLabel("Catégorie de l'animal");

		categorie = new JComboBox<String>();
				
		categorie.addActionListener(this);
		ArrayList<String> items = d.getAllCategory();
		
		for (String s: items)
		{
			categorie.addItem(s);
		}
		
		JPanel panelAni1 = new JPanel();
		panelAni1.setLayout(new GridLayout(1,2));
		panelAni1.add(labCategorie);
		panelAni1.add(categorie);
		
		labSp = new JLabel("Espèce de l'animal");
		JPanel panelAni2 = new JPanel();
		panelAni2.setLayout(new GridLayout(1,2));
		panelAni2.add(labSp);
		panelAni2.add(espece);
		
		
		labNomAn = new JLabel("Nom de l'animal");
		nomAnimal = new JTextField(nomEntre);
		JPanel panelAni3 = new JPanel();
		panelAni3.setLayout(new GridLayout(1,2));
		panelAni3.add(labNomAn);
		panelAni3.add(nomAnimal);
		
		labSexe = new JLabel("Sexe de l'animal");
		sexe = new JComboBox();
		sexe.addItem("Male");
		sexe.addItem("Femelle");
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
		if (point.getSource()==categorie)
		{	
			ArrayList<String> items = d.getSpeciesByCategory(categorie.getSelectedItem().toString());
			InterfaceUS2_3.this.espece.removeAllItems();
			for (int i=0;i< items.size();i++)
			{
				System.out.println(items.get(i));
				InterfaceUS2_3.this.espece.addItem(items.get(i));
			}

			InterfaceUS2_3.this.espece.repaint();
		}
		
		if(point.getSource()==butValider)
		{
			boolean bool=true;
			if(nomAnimal.getText().length()==0)
			{
				Object[] options = { "OK" };
				int n = JOptionPane.showOptionDialog(new JFrame(),
						"Veuillez remplir le nom de l'animal", "",
				       JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null,
				       options, options);
				 bool = false;
			}
			if(dateNaissance.getText().length()==0)
			{
				Object[] options = { "OK" };
				int n = JOptionPane.showOptionDialog(new JFrame(),
						"Veuillez remplir la date de naissance de l'animal", "",
				       JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null,
				       options, options);
				 bool = false;
			}
			if(bool=true)
			{
				int sex=1;
				String s=sexe.getSelectedItem().toString();
				if(sexe.getSelectedItem().toString()=="Male")
				{
					sex=1;
				}
				else
				{
					sex=0;
				}
				animal = new Animals(sex, nomAnimal.getText(), espece.getSelectedItem().toString(), dateNaissance.getText());
				d.saveAnimal(animal);
				int idTmp;
				idTmp = d.getMaxID();
				animal.setIdAnimal(idTmp);
				InterfaceUS2_4 test = new InterfaceUS2_4(animal,custom);
	    		this.dispose();
			}
		}
		
		if (point.getSource()==butAnnuler)
		{
			this.dispose();
		}
	}
   
	
	public static void main(String[] args) 
	{    
       InterfaceUS2_3 us = new InterfaceUS2_3(new Customers("dupond", 86000,"Poitiers", "090909",1), "pp");
    }
}
