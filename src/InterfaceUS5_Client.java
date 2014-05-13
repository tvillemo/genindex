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

public class InterfaceUS5_Client extends JFrame implements ActionListener
{

	private JPanel panelListe;
	private JPanel panelButton;
	private JPanel panelChoix;
	
	private JButton butAnnuler;

	public InterfaceUS5_Client(Customers c)
	{
		panelListe = new JPanel();
		
	    butAnnuler = new JButton("Annuler");
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
			InterfaceUS5 retour = new InterfaceUS5();
    		this.dispose();
		}
    }
	

}
