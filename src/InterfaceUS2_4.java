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
	
	private Customers custom;
	private Animals animal;
	
	private Database d = new Database();
	
	public InterfaceUS2_4(Animals animal,Customers custom)
	{
		this.custom=custom;
		labNomClient = new JLabel("Client :" + custom.getLastName() + custom.getFirstName());
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
		ArrayList<String> items = d.getAnalyseByAnimal(animal.getIdAnimal());
		//System.out.println(items.get(0));
		for (int i=0;i< items.size();i++)
		{
			analyse.addItem(items.get(i));
		}
		
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
	    butAnnuler.addActionListener(this);
	    butValider.addActionListener(this);
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
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent point)
    {
		if (point.getSource()==butValider)
		{
			boolean bool=true;
			if(nbEch.getText().length()==0)
			{
				Object[] options = { "OK" };
				int n = JOptionPane.showOptionDialog(new JFrame(),
						"Veuillez remplir le nombre d'échantillon(s)", "",
				       JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null,
				       options, options);	
				bool = false;
			}
		
			if(bool=true)
			{
				int prio;
				if(buttonPrio.isSelected())
				{
					prio=1;
				}
				else
				{
					prio=0;
				}
				//Creation du test en java
				java.sql.Date date = d.dateJour();
				Types_analysis t= new Types_analysis(analyse.getSelectedItem().toString(), 0);
				Orders o= new Orders(Integer.parseInt(nbEch.getText()), new Date(date.getDay(),date.getMonth(),date.getYear()), custom ,t);
				d.saveOrder(o, d.getIdTest(analyse.getSelectedItem().toString()), custom.getID(), Integer.parseInt(nbEch.getText()), prio);
				
				Object[] options = { "OK" };
				int n = JOptionPane.showOptionDialog(new JFrame(),
						"Votre commande a bien été enregistrée", "",
				       JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				       options, options);
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
	      InterfaceUS2_4 us = new InterfaceUS2_4(new Animals (12, "choupette"),new Customers("dupond", 86000,"Poitiers", "090909",1));
    }
}
