import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author Audrey
 */

public class InterfaceUS5 extends JFrame implements ActionListener
{

	private JPanel panelChoix;
	private JPanel panelDonnees;	
	private JPanel panelButton;
	
	private JLabel labNumC;
	private JLabel labNomC;
	private JLabel labPrenomC;
	private JLabel labCorp;
	private JLabel labSeparation1, labSeparation2;

	private JPanel panelNum;
	private JPanel panelNom;
	private JPanel panelPrenom;
	private JPanel panelCorp;
	
	private JTextField fieldNumC;
	private JTextField fieldNomC;
	private JTextField fieldPrenomC;
	private JTextField fieldCorp;
	
	private JButton butAnnuler;
	private JButton butValider;
	
	public InterfaceUS5() 
	{
	    
	    labNumC = new JLabel("Numéro du client :");
	    fieldNumC = new JTextField();
	    panelNum = new JPanel();
	    panelNum.setLayout(new GridLayout(1,2));
	    panelNum.add(labNumC);
	    panelNum.add(fieldNumC);
	    
		labNomC = new JLabel("Nom du client :");
	    fieldNomC = new JTextField();
	    panelNom = new JPanel();
	    panelNom.setLayout(new GridLayout(1,2));
	    panelNom.add(labNomC);
	    panelNom.add(fieldNomC);
	    
	    labPrenomC = new JLabel("Prénom du client :");
	    fieldPrenomC = new JTextField();
	    panelPrenom = new JPanel();
	    panelPrenom.setLayout(new GridLayout(1,2));
	    panelPrenom.add(labPrenomC);
	    panelPrenom.add(fieldPrenomC);
	    
	    labCorp = new JLabel("Corporation :");	    
	    fieldCorp = new JTextField();
	    panelCorp = new JPanel();
	    panelCorp.setLayout(new GridLayout(1,2));
	    panelCorp.add(labCorp);
	    panelCorp.add(fieldCorp);
	    
	    labSeparation1 = new JLabel();
	    labSeparation2 = new JLabel();
	    
	    panelDonnees = new JPanel();
	    panelDonnees.setLayout(new GridLayout(6, 1));
	    
	    panelDonnees.add(panelNum);
	    panelDonnees.add(labSeparation1);
	    panelDonnees.add(panelNom);
	    panelDonnees.add(panelPrenom);
	    panelDonnees.add(labSeparation2);
	    panelDonnees.add(panelCorp);

	    butAnnuler = new JButton("Annuler");
	    butAnnuler.addActionListener(this);
	    butValider = new JButton("Valider");
	    butValider.addActionListener(this);

	    panelButton = new JPanel();
	    panelButton.setLayout(new GridLayout(1, 2));
	    
	    panelButton.add(butAnnuler);
	    panelButton.add(butValider);
	    panelButton = new JPanel();
	    panelButton.add(butAnnuler);
	    panelButton.add(butValider);
	    
	    panelChoix = new JPanel();
	    panelChoix.add(panelDonnees);
	    panelChoix.add(panelButton);
	    
	    this.add(panelChoix);
	    
	    panelChoix.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createEtchedBorder(), "Saisie des informations relatives au client :"));
	    
 
	    
		 // visibilité
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(300, 250);
        this.setVisible(true);
	}

	
	public void actionPerformed(ActionEvent point)
    {
		if (point.getSource()==butValider)
		{

		}
		if (point.getSource()==butAnnuler)
		{
			this.dispose();
		}
    }
	
	
	public static void main(String[] args)
	{
		InterfaceUS5 test = new InterfaceUS5();

	}

}
