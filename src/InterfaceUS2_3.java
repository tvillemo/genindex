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
	private JTextField categorie;
	private JLabel labSp;
	private JTextField espece;
	private JLabel labSp;
	private JTextField espece;
	
	public InterfaceUS2_3()
	{
		labNomClient = new JLabel("Nom du client :");
		panelClient=new JPanel();
		panelClient.add(labNomClient);
		
		this.add(panelClient, BorderLayout.NORTH);
		
		panelClient.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createEtchedBorder(), "Client :"));
		
		
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
