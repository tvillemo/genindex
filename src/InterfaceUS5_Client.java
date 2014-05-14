import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

public class InterfaceUS5_Client extends JFrame implements ActionListener
{

	private JPanel panelListe;
	private JPanel panelButton;
	private JPanel panelChoix;
	
	private JButton butAnnuler;
	private JButton butValider;
	
	private JLabel labChoixNum;
	private JTextField fieldChoixNum;

	public InterfaceUS5_Client(ArrayList<Customers> liste)
	{
		panelListe = new JPanel();
		
		butAnnuler = new JButton("Annuler");
		butAnnuler.addActionListener(this);
		butValider = new JButton("Valider");
		butValider.addActionListener(this);
	    
		panelButton = new JPanel();
		panelButton.setLayout(new GridLayout(1, 2));
		panelButton.add(butAnnuler);
		panelButton.add(butValider);
		
	    panelChoix = new JPanel();
	    panelChoix.add(panelListe);
	    panelChoix.add(panelButton);
	    
	    this.add(panelChoix);
	    
	    panelChoix.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createEtchedBorder(), "Choisir le client souhaité :"));
	    
		 // visibilité
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(300, 250);
        this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent point)
    {
		if (point.getSource()==butAnnuler)
		{
			InterfaceUS5 retour = new InterfaceUS5();
    		this.dispose();
		}
    }
	

}
