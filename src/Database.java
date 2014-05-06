/**
 * This class manage all the methods of the different classes which interact with the database.
 */

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class Database 
{

	//--- Database Connection ---//
	private Connection myConnexion;
	private Statement myStatement;
	private final String MYURL = "jdbc:oracle:thin:@//192.168.24.3/pfpbs";
	private final String MYUSER = "gp28";
	private final String MYPASSWORD = "nounours";

	

	//--- Table -> Class ---//
	private Animals animal; 
	private Samples sample;
	private Types_analysis typeAna;
	private Analysis analysis;
	private Users user;
	private Date d1;
	private Date d2;
	private Customers customer;
	private Orders order;
	private Adress adress;
	public Storage storage;

	public Database() 
	{
		// liste en attendant les requ�tes
//		d1 = new Date(23,12,10);
//		d2 = new Date(23,12,11);
//		customer =  new Customers("jean", "dupont", 86000,"Poitiers", "090909",1);
//		order =  new Orders(1, d1,d2, 1, customer);
//		animal = new Animals("cat","2010");
//		sample = new Samples("1", "blood", d1, d2, animal);
//		this.typeAna = new Types_analysis("PCR", 40);
//		this.analysis = new Analysis(1, typeAna, d2);
//		sample.addAnalysis(analysis);
//		user = new Users("jean", "dupont", "@");
//		order.addSample(sample);
//		storage = new Storage("freezer", 60);
//		adress = new Adress(86000,"Poitiers");
		
		ConnectBDD();
		
	}

//	/**
//	 * Lance une requ�te et l'affiche pour les tests
//	 */
//	public void DisplayResultsQuery(String query)
//	{
//		try
//		{
//			if (myStatement.execute(query)){
//				results= myStatement.executeQuery(query);
//				while (results.next()) 
//				{	
//					System.out.println(results.getObject(results.findColumn("CORPORATIONNAME")));
//				}
//				results.close();
//			}
//		}
//		catch (SQLException ex) 
//		{
//			System.out.println("Erreur requ�te test");
//		}
//	}

	/**
	 * Connexion � la BDD
	 */
	public void ConnectBDD()
	{
		ResultSet resultSet = null;
		if (testDriver()) 
		{
			try 
			{
				myConnexion = DriverManager.getConnection(MYURL, MYUSER, MYPASSWORD);
				myStatement = myConnexion.createStatement();
				//System.out.println("Connection successful");
			} 
			catch (SQLException ex) 
			{
				Logger.getLogger("ConnectBDD").log(Level.SEVERE, null, ex);
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}
		}
		else
		{
			System.out.println("testdriver false");
		}
	}

	/**
	 * Test des driver de la BDD
	 */
	public boolean testDriver() 
	{
		//   Chargement du driver JDBC pour Oracle */
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Le driver n'a pas �t� charg�");
			return false;
		}

	}

	/**
	 * Fermeture de la connexion
	 */
	public void close() 
	{
		try 
		{
			this.myStatement.close();
			this.myConnexion.close();    
		} 
		catch (SQLException ex) 
		{
			System.out.println("Mysql connection fermeture failed !!!");
		}
	}



	/**
	 * This function permits to list all the orders in the database.
	 */
	public List<Orders> getListOrder() {
		// Bouml preserved body begin 0003D002
		List<Orders> list = new ArrayList<Orders>();
		list.add(this.order);
		return(list);
		// Bouml preserved body end 0003D002
	}

	/**
	 * This function permits to search the order in the database that have the customer in parameter.
	 */
	public Orders searchOrder(Customers customer) {
		// Bouml preserved body begin 00042F02
		return(this.order);
		// Bouml preserved body end 00042F02
	}

	/**
	 * This function permits to search the order in the database that has this id.
	 */
	public Orders searchOrder(int id) {
		
		ResultSet resultsOrder = null;
		ResultSet resultsNbEch = null;
		Orders myOrder = null;
		Customers myCustomer = null;
		
		String QueryOrder="Select IDClient, datelot from LOT WHERE idlot="+id;
		String QueryNbEch="Select COUNT(idSample) as nb from Sample WHERE idlot="+id;
		String QueryEch="Select idSample, nameType, dateSampling,  from Sample, SampleType WHERE idlot="+id;
		
		try
		{
			resultsOrder = myStatement.executeQuery(QueryOrder);
			resultsNbEch = myStatement.executeQuery(QueryNbEch);
			
			//Creation du client
			myCustomer=searchCustomerID(Integer.parseInt(resultsOrder.getString("IDClient")));
			
			//Creation de la date
			Date d = new Date(resultsOrder.getDate("datelot").getDay(),resultsOrder.getDate("datelot").getMonth(),resultsOrder.getDate("datelot").getYear());
			
			//Creation du lot
			myOrder = new Orders(Integer.parseInt(resultsNbEch.getString("nb")), d, myCustomer);
			//Ajout des echantillons
			
//			Samples(String Identifier, String Type_sample, Date D_sampling, Animals anim)
//			
//			addSample(Samples sample)
		}
		catch (SQLException ex) 
		{
			System.out.println("Erreur requ�te search order");
		}
		//searchCustomerID(int ID)
		
		//return mySample;
		// Bouml preserved body begin 00042F82
		return(this.order);
		// Bouml preserved body end 00042F82
	}

	/**
	 * This function permits to save in the database the order in parameter.
	 */
	public void saveOrder(Orders order) {
		// Bouml preserved body begin 00043082
		this.order =order;
		// Bouml preserved body end 00043082
	}

	//DONE
	public Samples searchSample(String id) 
	{
		ResultSet resultsSample = null;
		Samples mySample = null;
		
		String QuerySample="Select IDSAMPLE, NAMETYPE,  from SAMPLE natural join SAMPLETYPE";
		
		try
		{
			resultsSample = myStatement.executeQuery(QuerySample);
			mySample = new Samples( resultsSample.getNString("IDSAMPLE"), resultsSample.getNString("NAMETYPE"), new Date(0,0,0), new Date(0,0,0), new Animals("",""));
		}
		catch (SQLException ex) 
		{
			System.out.println("Erreur requ�te test");
		}
		 
		return mySample;
	}

	public List<Samples> getListSamples() {
		// Bouml preserved body begin 00043182
		List<Samples> listS = new ArrayList<Samples>();
		listS.add(this.sample);
		return(listS);
		// Bouml preserved body end 00043182
	}

	public void saveSample(Samples sample) {
		// Bouml preserved body begin 00043202
		this.sample = sample;
		// Bouml preserved body end 00043202
	}

	public Animals searchAnimal(String specie) 
	{
		// Bouml preserved body begin 00043282
		return this.animal;
		// Bouml preserved body end 00043282
	}

	/**
	 * This function permits to get the user that use this session.
	 */
	public Users getUser() {
		// Bouml preserved body begin 00043502
		return user;
		// Bouml preserved body end 00043502
	}

	public List<Customers> getListCustomers() {
		// Bouml preserved body begin 000234C5
		List<Customers> listC = new ArrayList<Customers>();
		listC.add(this.customer);
		return(listC);
		// Bouml preserved body end 000234C5
	}

	public Customers searchCustomerName(String name) {
		// Bouml preserved body begin 00023545
		if(name.equals(customer.getLastName()))
		{
			return customer;
		}
		else
		{
			Customers cust = new Customers("jean", "dupond", 86000,"Poitiers", "090909",1);
			return cust;
		}
		// Bouml preserved body end 00023545
	}

	public Customers searchCustomerID(int ID) {
		// Bouml preserved body begin 000235C5
		if(customer.getID()==ID)
		{
			return customer;
		}
		else
		{
			Customers cust = new Customers("jean", "dupond", 86000,"Poitiers", "090909",1);
			return cust;
		}
		// Bouml preserved body end 000235C5
	}

	public void saveCustomer(Customers cust) {
		// Bouml preserved body begin 00023645
		if(cust.getID()==customer.getID())
		{
			customer=cust;
		}
		else
		{
			System.out.println("new data record");
		}
		// Bouml preserved body end 00023645
	}

	public List<Types_analysis> getListAnalysisType() {
		// Bouml preserved body begin 000236C5
		List<Types_analysis> listTA = new ArrayList<Types_analysis>();
		listTA.add(this.typeAna);
		return(listTA);
		// Bouml preserved body end 000236C5
	}

	public Analysis searchAnalysis(Types_analysis type) {
		// Bouml preserved body begin 00023745
		if(this.analysis.getTypeAnalysis()== type)
		{
			return this.analysis;
		}
		else
		{
			Analysis ana = new Analysis(2, typeAna, d2);
			return ana;
		}
		// Bouml preserved body end 00023745
	}

	public Analysis searchAnalysisID(int ID) {
		// Bouml preserved body begin 000237C5
		if(this.analysis.getID()== ID)
		{
			return this.analysis;
		}
		else
		{
			Analysis ana = new Analysis(2, typeAna, d2);
			return ana;
		}
		// Bouml preserved body end 000237C5
	}

	public void saveAnalysis(Analysis analysis) {
		// Bouml preserved body begin 00023845
		if(analysis.getID()==this.analysis.getID())
		{
			this.analysis = analysis;
		}
		else
		{
			System.out.println("new data record");
		}
		// Bouml preserved body end 00023845
	}

	public Types_analysis searchTypesAnalysis(String name) {
		// Bouml preserved body begin 000238C5
		if(name.equals(this.typeAna.getType()))
		{
			return this.typeAna;
		}
		else
		{
			Types_analysis tAna = new Types_analysis("PCR", 45);
			return tAna;
		}
		// Bouml preserved body end 000238C5
	}

	public void saveAnalysisType(Types_analysis typeAnalysis) {
		// Bouml preserved body begin 00023945
		if(typeAnalysis.getType().equals(this.typeAna.getType()))
		{
			this.typeAna = typeAnalysis;
		}
		else
		{
			System.out.println("new data record");
		}
		// Bouml preserved body end 00023945
	}

}
