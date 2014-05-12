


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
	private Database d;
	
	public InterfaceUS3()
	{
		d = new Database();
		
		// cr�ation du panel et des labels
		ajoutPanel = new JPanel(new GridLayout(3,2));
		nomLabel = new JLabel("Nom de l'esp�ce :");
		catLabel = new JLabel("Cat�gorie associ�e :");
		nomField = new JTextField();
		catBox = new JComboBox();
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
		ajoutPanel.add(valideButton);
		ajoutPanel.add(annuleButton);
		
		// visibilit�
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(500,150);
        this.setVisible(true);

    }
			
	
	public void actionPerformed(ActionEvent point)
    {
		if (point.getSource()==valideButton)
		{
			if (d.verifSpecies(nomField.getText()))
			{
				//System.out.println(catBox.getSelectedItem().toString());
				d.saveSpecies(nomField.getText(), d.getIdCategory(catBox.getSelectedItem().toString()));
				Object[] options = { "OK" };
				int n = JOptionPane.showOptionDialog(new JFrame(),
						"Votre esp�ce a bien �t� enregistr�e", "",
				       JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				       options, options[1]);
			}
			else
			{
				Object[] options = { "OK" };
				int n = JOptionPane.showOptionDialog(new JFrame(),
						"Cette esp�ce existe d�j�", "",
				       JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				       options, options[1]);
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
