


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

public class InterfaceUS3 extends JFrame implements ActionListener
{

	private JPanel ajoutPanel;
	private JLabel nomLabel, catLabel;
	private JTextField nomField;
	private JComboBox catBox;
	private JButton valideButton, annuleButton;
	
	public InterfaceUS3()
	{
		
		// création du panel et des labels
		ajoutPanel = new JPanel(new GridLayout(3,2));
		nomLabel = new JLabel("Nom de l'espèce :");
		catLabel = new JLabel("Catégorie associée :");
		nomField = new JTextField();
		catBox = new JComboBox();
		valideButton = new JButton("valider");
		valideButton.addActionListener(this);
		annuleButton = new JButton("annuler");
		annuleButton.addActionListener(this);

	    ajoutPanel.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createEtchedBorder(), "Ajout d'une espèce :"));
		
		// ajout des labels dans le panel ajoutPanel
		this.add(ajoutPanel, BorderLayout.CENTER);
		ajoutPanel.add(nomLabel);
		ajoutPanel.add(nomField);
		ajoutPanel.add(catLabel);
		ajoutPanel.add(catBox);
		ajoutPanel.add(valideButton);
		ajoutPanel.add(annuleButton);
		
		// visibilité
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(400,150);
        this.setVisible(true);

    }
			
	
	public void actionPerformed(ActionEvent point)
    {
		if (point.getSource()==valideButton)
		{
			//verifSpecies();
		}
		if (point.getSource()==annuleButton)
		{
			
		}
    }
	
	public static void main (String[] args) {
		InterfaceUS3 test = new InterfaceUS3();
	}
}
