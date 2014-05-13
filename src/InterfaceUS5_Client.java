import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class InterfaceUS5_Client extends JFrame implements ActionListener
{

	private JPanel panelListe;
	private JPanel panelButton;
	
	private JButton butAnnuler;

	public InterfaceUS5_Client()
	{
		panelListe = new JPanel();
		panelButton = new JPanel();
		
	    butAnnuler = new JButton("Annuler");
	    butAnnuler.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent point)
    {
		if (point.getSource()==butAnnuler)
		{

		}
    }
}
