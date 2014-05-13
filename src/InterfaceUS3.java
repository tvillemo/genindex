


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
*
* @author Audrey
*/

public class InterfaceUS3 extends JFrame implements ActionListener
{

	private JPanel ajoutPanel;
	private JLabel nomLabel, catLabel, labelSeparation1, labelSeparation2;
	private JTextField nomField;
	private JComboBox catBox;
	private JButton valideButton, annuleButton;
	private Database d;
	
	public InterfaceUS3()
	{
		d = new Database();
		
		// création panel, label, ...
		
		ajoutPanel = new JPanel(new GridLayout(4,2));
		
		nomLabel = new JLabel("Nom de l'espèce :");
		catLabel = new JLabel("Catégorie associée :");
		labelSeparation1 = new JLabel();
		labelSeparation2 = new JLabel();
		
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
	            BorderFactory.createEtchedBorder(), "Ajout d'une espèce :"));

	    
		// ajout des labels dans le panel ajoutPanel
	    
		this.add(ajoutPanel, BorderLayout.CENTER);
		
		ajoutPanel.add(nomLabel);
		ajoutPanel.add(nomField);
		ajoutPanel.add(catLabel);
		ajoutPanel.add(catBox);
		ajoutPanel.add(labelSeparation1);
		ajoutPanel.add(labelSeparation2);
		ajoutPanel.add(valideButton);
		ajoutPanel.add(annuleButton);
		
		// visibilité
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(500,200);
        this.setVisible(true);

    }
			
	
	public void actionPerformed(ActionEvent point)
    {
		if (point.getSource()==valideButton)
		{
			if (nomField.getText().length()==0)
			{
				Object[] options = { "OK" };
				int n = JOptionPane.showOptionDialog(new JFrame(),
						"Veuillez saisir le nom de l'espèce", "",
				       JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null,
				       options, options);
			}
			else if (d.verifSpecies(nomField.getText()))
			{
				d.saveSpecies(nomField.getText(), d.getIdCategory(catBox.getSelectedItem().toString()));
				Object[] options = { "OK" };
				int n = JOptionPane.showOptionDialog(new JFrame(),
						"Votre espèce a bien été enregistrée", "",
				       JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				       options, options);
			}
			else
			{
				Object[] options = { "OK" };
				int n = JOptionPane.showOptionDialog(new JFrame(),
						"Cette espèce existe déjà", "",
				       JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				       options, options);
			}

		}
		if (point.getSource()==annuleButton)
		{
			this.dispose();
		}
    }
	
	public static void main (String[] args) {
		InterfaceUS3 test = new InterfaceUS3();
	}
}
