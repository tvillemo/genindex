import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
*
* @author Audrey
*/

public class InterfaceUS5_Client extends JFrame implements ActionListener
{

	private JPanel panelButton;
	private JPanel panelChoix;
	private JPanel panelChoixNum;
	
	private JButton butAnnuler;
	private JButton butValider;
	
	private TableModel dataModel;
	private JTable table;
	private JScrollPane scrollpane;
	
	private JLabel labChoixNum;
	private JTextField fieldChoixNum;
	
	private ArrayList<Customers> liste;

	public InterfaceUS5_Client(final ArrayList<Customers> li)
	{
		liste = li;
		dataModel = new AbstractTableModel()
		{
		     public int getColumnCount() { return 4; }
		     public int getRowCount() { return liste.size();}
		     public Object getValueAt(int row, int col) { return new Integer(row*col); }
		};
		
		// Insert data in JTable
		Object[][] data = new Object[4][liste.size()];
		for (int i =0 ; i < liste.size(); i++)
		{
			data[0][i]=""+liste.get(i).getID();
			data[1][i]=liste.get(i).getLastName();
			data[2][i]=liste.get(i).getFirstName();
			data[3][i]=liste.get(i).getAdressClient().toString();
			
			System.out.println(data[0][i]);
			System.out.println(data[1][i]);
			System.out.println(data[2][i]);
			System.out.println(data[3][i]);
			System.out.println("--------------------");
		}
		
		
		//Object[] dataET = {"","","",""};
		table = new JTable(dataModel);
		
		scrollpane = new JScrollPane(table);
		
		
		
		labChoixNum = new JLabel("Choisir l'identifiant :");
		fieldChoixNum = new JTextField();

		panelChoixNum = new JPanel();
		panelChoixNum.setLayout(new GridLayout(1, 2));
		panelChoixNum.add(labChoixNum);
		panelChoixNum.add(fieldChoixNum);

		butAnnuler = new JButton("Annuler");
		butAnnuler.addActionListener(this);
		butValider = new JButton("Valider");
		butValider.addActionListener(this);

		panelButton = new JPanel();
		panelButton.setLayout(new GridLayout(1, 2));
		panelButton.add(butAnnuler);
		panelButton.add(butValider);

	    panelChoix = new JPanel();
	    panelChoix.add(scrollpane);
	    panelChoix.add(panelChoixNum);
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
		if (point.getSource()==butValider)
		{
			//InterfaceUS5_Commande test = InterfaceUS5_Commande(null);
			this.dispose();
		}
    }
	

}
