


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class InterfaceUS3 extends JFrame implements ActionListener
{

	private JPanel ajoutPanel;
	private JLabel nomLabel, catLabel, label1, label2;
	private JTextField nomField;
	private JComboBox catBox;
	private JButton valideButton, annuleButton;
	private Database d;
	
	public InterfaceUS3()
	{
		d = new Database();
		
		// cr�ation panel, label, ...
		
		ajoutPanel = new JPanel(new GridLayout(4,2));
		
		nomLabel = new JLabel("Nom de l'esp�ce :");
		catLabel = new JLabel("Cat�gorie associ�e :");
		label1 = new JLabel();
		label2 = new JLabel();
		
		nomField = new JTextField();
		
		catBox = new JComboBox();
		ArrayList<String> items = d.getAllCategory();
		for (int i=0;i< items.size();i++)
		{
			catBox.addItem(items.get(i));
		}
			
		valideButton = new JButton("valider");
		valideButton.addActionListener(this);
		annuleButton = new JButton("annuler");
		annuleButton.addActionListener(this);

	    ajoutPanel.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createEtchedBorder(), "Ajout d'une esp�ce :"));

	    
		// ajout des labels dans le panel ajoutPanel
	    
		this.add(ajoutPanel, BorderLayout.CENTER);
		
		ajoutPanel.add(nomLabel);
		ajoutPanel.add(nomField);
		ajoutPanel.add(catLabel);
		ajoutPanel.add(catBox);
		ajoutPanel.add(label1);
		ajoutPanel.add(label2);
		ajoutPanel.add(valideButton);
		ajoutPanel.add(annuleButton);
		
		// visibilit�
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(500,200);
        this.setVisible(true);

    }
			
	
	public void actionPerformed(ActionEvent point)
    {
		if (point.getSource()==valideButton)
		{
			if (nomField.getSelectedText() == null)
			{
				Object[] options = { "OK" };
				int n = JOptionPane.showOptionDialog(new JFrame(),
						"Veuillez saisir le nom de l'esp�ce", "",
				       JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				       options, options);
			}
			else if (d.verifSpecies(nomField.getText()))
			{
				d.saveSpecies(nomField.getText(), d.getIdCategory(catBox.getSelectedItem().toString()));
				Object[] options = { "OK" };
				int n = JOptionPane.showOptionDialog(new JFrame(),
						"Votre esp�ce a bien �t� enregistr�e", "",
				       JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				       options, options);
			}
			else
			{
				Object[] options = { "OK" };
				int n = JOptionPane.showOptionDialog(new JFrame(),
						"Cette esp�ce existe d�j�", "",
				       JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				       options, options);
			}

		}
		if (point.getSource()==annuleButton)
		{
			
		}
    }
	
	public static void main (String[] args) {
		InterfaceUS3 test = new InterfaceUS3();
	}
}
