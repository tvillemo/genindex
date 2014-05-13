import java.awt.GridLayout;
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

public class InterfaceUS5_UneCommande extends JFrame implements ActionListener
{

	private JPanel panelListe;
	private JPanel panelButton;
	private JPanel panelChoix;
	
	private JButton butAnnuler;
	private JButton butQuitter;

	public InterfaceUS5_UneCommande()
	{
		panelListe = new JPanel();
		
	    butAnnuler = new JButton("Annuler");
	    butAnnuler.addActionListener(this);
	    butAnnuler = new JButton("Annuler");
	    butAnnuler.addActionListener(this);
	    
	    butAnnuler = new JButton("Retour");
	    butAnnuler.addActionListener(this);
	    butQuitter = new JButton("Quitter");
	    butQuitter.addActionListener(this);

	    panelButton = new JPanel();
	    panelButton.setLayout(new GridLayout(1, 2));
	    
	    panelButton.add(butAnnuler);
	    panelButton.add(butQuitter);
	    panelButton = new JPanel();
	    panelButton.add(butAnnuler);
	    panelButton.add(butQuitter);
		
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
			InterfaceUS5_Commande retour = new InterfaceUS5_Commande();
    		this.dispose();
		}
		if (point.getSource()==butQuitter)
		{
			this.dispose();
		}
    }
	
	public static void main(String[] args)
	{
		InterfaceUS5_UneCommande test = new InterfaceUS5_UneCommande();

	}
}
