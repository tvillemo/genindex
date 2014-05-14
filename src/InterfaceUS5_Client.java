import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
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

	private DefaultTableModel dataModel;
	private JTable table;
	private JScrollPane scrollpane;

	private JLabel labChoixNum;
	private JTextField fieldChoixNum;

	private ArrayList<Customers> liste;

	private Database d;

	public InterfaceUS5_Client(final ArrayList<Customers> li)
	{

		d = new Database();
		liste = li;

		dataModel = new DefaultTableModel();
		dataModel.addColumn("ID");
		dataModel.addColumn("Prénom");
		dataModel.addColumn("Nom");
		dataModel.addColumn("Adresse");

		for (int i =0 ; i < liste.size(); i++)
		{
			String[] info = { ""+liste.get(i).getID(), liste.get(i).getLastName(), liste.get(i).getFirstName(), liste.get(i).getAdressClient().toString() };
			dataModel.addRow(info);
		}

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
		this.setSize(500, 550);
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
				if (fieldChoixNum.getText().length()==0)
				{
					Object[] options = { "OK" };
					int n = JOptionPane.showOptionDialog(new JFrame(),
							"Veuillez saisir l'identifiant d'un client", "",
							JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null,
							options, options);
				}
				else if (fieldChoixNum.getText().length()!=0)
				{
					InterfaceUS5_Commande test =new InterfaceUS5_Commande(d.searchOrderByCustomer(new Customers(null, 0, null, null, Integer.parseInt(fieldChoixNum.getText()))));
					this.dispose();
				}
			}
		}
	}
