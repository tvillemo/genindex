import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
*
* @author Audrey
*/

public class InterfaceUS5_Commande extends JFrame implements ActionListener
{

	private JPanel panelListe;
	private JPanel panelButton;
	private JPanel panelChoix;
	
	private JButton butAnnuler;

	public InterfaceUS5_Commande()
	{
		panelListe = new JPanel();
		
	    butAnnuler = new JButton("Retour à la liste des clients");
	    butAnnuler.addActionListener(this);
	    
		panelButton = new JPanel();
		panelButton.add(butAnnuler);
		
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
			InterfaceUS5_Client retour = new InterfaceUS5_Client();
    		this.dispose();
		}
    }
	
	public static void main(String[] args)
	{
		InterfaceUS5_Commande test = new InterfaceUS5_Commande();

	}
}
