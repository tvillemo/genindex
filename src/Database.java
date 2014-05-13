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
		// liste en attendant les requètes
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
	//	 * Lance une requète et l'affiche pour les tests
	//	 */
	//	public void DisplayResultsQuery(String query)
	//	{
	//		try
	//		{
	//			if (myStatement.execute(query)){
	//				results= myStatement.executeQuery(query);
	//				while (results.next()) 
	//				{	
	//					System.out.println(results.getString("CORPORATIONNAME")));
	//				}
	//				results.close();
	//			}
	//		}
	//		catch (SQLException ex) 
	//		{
	//			System.out.println("Erreur requète test");
	//		}
	//	}
	
	/**
	 * Lance une requète et l'affiche pour les tests
	 */
	public void DisplayResultsQuery(String query)
	{
		ResultSet results = null;
		try
		{
			if (myStatement.execute(query)){
				results= myStatement.executeQuery(query);
				while (results.next()) 
				{	
					System.out.println(results.getString(results.findColumn("CORPORATIONNAME")));
				}
				results.close();
			}
		}
		catch (SQLException ex) 
		{
			System.out.println("Erreur requète test");
		}
	}

	/**
	 * Connexion à la BDD
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
			System.out.println("Le driver n'a pas été chargé");
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

	//DONE
	/**
	 * This function permits to search the order in the database that have the customer in parameter.
	 */
	public ArrayList<Orders> searchOrder(Customers customer) {

		ResultSet resultsOrder = null;
		ArrayList<Orders> liste= new ArrayList<Orders>();
		Orders myOrder = null;


		String QueryOrder="Select idLot, datelot from LOT WHERE idClient="+customer.getID();

		try
		{
			resultsOrder = myStatement.executeQuery(QueryOrder);

			while(resultsOrder.next())
			{
				Date d = new Date(resultsOrder.getDate("datelot").getDay(),resultsOrder.getDate("datelot").getMonth(),resultsOrder.getDate("datelot").getYear());

				//myOrder= new Orders(Integer.parseInt(resultsOrder.getString("idLot")), d, customer,new Types_analysis("PCR",95));

				liste.add(myOrder);
			}

		}
		catch (SQLException ex) 
		{
			System.out.println("Erreur requête search Order");
		}
		// Bouml preserved body begin 00042F02
		return(liste);
		// Bouml preserved body end 00042F02
	}

	//DONE
	/**
	 * This function permits to search the order in the database that has this id.
	 */
	public Orders searchOrder(int id) {

		ResultSet resultsOrder = null;
		ResultSet resultsNbEch = null;
		ResultSet resultsEch = null;
		Orders myOrder = null;
		Customers myCustomer = null;
		Animals myAnimal = null;
		Samples mySample = null;

		String QueryOrder="Select IDClient, datelot from LOT WHERE idlot="+id;
		String QueryNbEch="Select COUNT(idSample) as nb from Sample WHERE idlot="+id;
		String QueryEch="Select idSample, nameType, dateSampling, nameSpecies, birthAnimal  from Sample, SampleType, Animal, Species WHERE Sample.idType=Sampletype.idtype AND Sample.idAnimal=Animal.idAnimal AND Animal.idSpecies=Species.idSpecies AND idlot="+id;

		try
		{
			resultsOrder = myStatement.executeQuery(QueryOrder);
			resultsNbEch = myStatement.executeQuery(QueryNbEch);

			//Creation du client
			myCustomer=searchCustomerID(Integer.parseInt(resultsOrder.getString("IDClient")));

			//Creation de la date
			Date d = new Date(resultsOrder.getDate("datelot").getDay(),resultsOrder.getDate("datelot").getMonth(),resultsOrder.getDate("datelot").getYear());

			//Creation du lot
			//myOrder = new Orders(Integer.parseInt(resultsNbEch.getString("nb")), d, myCustomer,new Types_analysis("PCR",95));
			//Ajout des echantillons

			//			Samples(String Identifier, String Type_sample, Date D_sampling, Animals anim)
			//			
			//			addSample(Samples sample)

			//Ajout des echantillons
			resultsEch = myStatement.executeQuery(QueryEch);
			while(resultsEch.next())
			{
				myAnimal = new Animals(resultsEch.getString("nameSpecies"), resultsEch.getString("birthAnimal"));

				//Creation de la date
				Date di = new Date(resultsEch.getDate("dateSampling").getDay(),resultsEch.getDate("dateSampling").getMonth(),resultsEch.getDate("dateSampling").getYear());


				//mySample= new Samples(resultsEch.getString("idSample"), resultsEch.getString("nameType"), di, myAnimal);

				myOrder.addSample(mySample);
			}
		}
		catch (SQLException ex) 
		{
			System.out.println("Erreur requète search order");
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

	public void saveOrder(Orders order) 
	{
		String QuerySample="";
		
		try
		{
			saveInvoice(order.getInvoice());
			saveCustomer(order.getCustomer());
			for (Samples s : order.getSamples())
			{
				saveSample(s);
			}
			myStatement.executeQuery(QuerySample);
		}
		catch (SQLException ex) 
		{
			System.out.println("Erreur requête saveOrder");
		}
	}
	
	@SuppressWarnings("deprecation")
	public void saveInvoice(Invoice in){
		try {
			myStatement.execute("insert into Invoice (idInvoice,dateInvoice,priceWithTVA,priceWithoutTVA) values("+in.getID()+",trunc(sysdate),"+in.getPrice()+","+in.getPriceNoTVA()+")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	//DONE and WORKS
	//Créer un Sample avec ID == 0 pour les requètes non ID
	/**
	 * This function know if a customer already exist
	 */
	public boolean IfCustomerExist(Customers custom) 
	{
		
		String QueryCustomId="SELECT COUNT(idClient) FROM Client WHERE idClient="+custom.getID();
		String QueryCustom="SELECT COUNT(idClient) FROM Client, Adress WHERE Client.idAdress=Adress.idAdress AND nameClient='"+custom.getLastName()+"' AND firstNameClient='"+custom.getFirstName()+"' AND num="+custom.getAdressClient().getNumber()+" AND CP="+custom.getAdressClient().getZipCode()+" AND town='"+custom.getAdressClient().getCity()+"' AND street='"+custom.getAdressClient().getStreet()+"'";
		String QueryCustomPro="SELECT COUNT(idClient) FROM Client, Adress WHERE Client.idAdress=Adress.idAdress AND corporationName='"+custom.getNomSociete()+"' AND num="+custom.getAdressClient().getNumber()+" AND CP="+custom.getAdressClient().getZipCode()+" AND town='"+custom.getAdressClient().getCity()+"' AND street='"+custom.getAdressClient().getStreet()+"'";
		ResultSet myResult;
		boolean bool = false;
		
		try
		{
			if (custom.getID() != 0)
			{
				myResult=myStatement.executeQuery(QueryCustomId);
			}
			else if (custom.isPro())
			{
				myResult=myStatement.executeQuery(QueryCustomPro);
			}
			else
			{
				myResult=myStatement.executeQuery(QueryCustom);
			}
			myResult.next();
			if (myResult.getInt(1) == 0)
			{
				bool = false;
			}
			else
			{
				bool = true;
			}
		}
		catch (SQLException ex) 
		{
			System.out.println("Erreur requête IfCustomerExist");
		}
		
		
		return bool;
	}
	
	//DONE and WORKS
	/**
	 * This function know if an animal already exist
	 */
	public boolean IfAnimalExist(Animals animal, Customers custom) 
	{
		String QuerySample="SELECT COUNT(Animal.idAnimal) FROM Animal, Sample, Lot, Client WHERE Animal.idAnimal=Sample.idAnimal AND Sample.idLot=Lot.idLot AND Lot.idClient=Client.idClient AND Client.idClient='"+custom.getID()+"' AND Animal.nameAnimal='"+animal.getName()+"'";
		ResultSet myResult;
		boolean bool = false;
		
		try
		{
			myResult=myStatement.executeQuery(QuerySample);
			
			myResult.next();
			System.out.println(QuerySample);
			if (myResult.getInt(1) == 0)
			{
				bool = false;
			}
			else
			{
				bool = true;
			}
		}
		catch (SQLException ex) 
		{
			System.out.println("Erreur requête IfAnimalExist");
		}
		
		return bool;
	}
	
	//DONE and WORKS
	/**
	 * This function permits to get all categories of the database
	 * @return : ArrayList of string of Categories names
	 * @author jeremy & mathilde
	 */
	public ArrayList<String> getAllCategory() 
	{
		ResultSet resultsSamples;
		String QuerySample="SELECT nameCategory FROM Category";
		ArrayList<String> maListe = new ArrayList<String>();
		
		try
		{
			resultsSamples = myStatement.executeQuery(QuerySample);
			while(resultsSamples.next())
			{
				maListe.add(resultsSamples.getString(1));
			}
		}
		catch (SQLException ex) 
		{
			System.out.println(ex.getMessage());
			System.out.println("Erreur requête getAllCategory");
		}
		return maListe;
	}
	
	//DONE and WORKS
	/**
	 * This function permits to get all species by categories
	 * @return : ArrayList of string of Species 
	 * @author jeremy & mathilde
	 */
	public ArrayList<String> getSpeciesByCategory(String category) 
	{
		ResultSet resultsSamples;
		String QuerySample="SELECT nameSpecies, Species.idSpecies FROM Category, Species WHERE Category.idCategory=Species.idCategory AND nameCategory='"+category+"'";
		ArrayList<String> maListe = new ArrayList<String>();
		
		try
		{
			resultsSamples = myStatement.executeQuery(QuerySample);
			while(resultsSamples.next())
			{
				maListe.add(resultsSamples.getString(1));
			}
		}
		catch (SQLException ex) 
		{
			System.out.println("Erreur requête getSpeciesByCategory");
		}
		return maListe;
	}
	
	//DONE and WORKS
	/**
	 * This function permits to get analyse by categories
	 * @return : ArrayList of string of analysis
	 * @author jeremy & mathilde
	 */
	public ArrayList<String> getAnalyseByCategory(String category) 
	{
		ResultSet resultsSamples;
		String QuerySample="SELECT nameTest, TestType.idTest FROM Category, Species, Can, TestType WHERE  Category.idCategory=Species.idCategory AND Species.idSpecies=Can.idSpecies AND Can.idTest=TestType.idTest AND nameCategory='"+category+"'";
		ArrayList<String> maListe = new ArrayList<String>();
		
		try
		{
			resultsSamples = myStatement.executeQuery(QuerySample);
			while(resultsSamples.next())
			{
				maListe.add(resultsSamples.getString(1));
			}
		}
		catch (SQLException ex) 
		{
			System.out.println(ex.getMessage());
			System.out.println("Erreur requête getAnalyseByCategory");
		}
		return maListe;
	}


	//DONE and WORKS (Peut être rajouter la liste des analyses)
	@SuppressWarnings("deprecation")
	public Samples searchSample(int id) 
	{
		ResultSet resultsSample = null;
		Samples mySample = null;

		String QuerySample="Select IDSAMPLE, NAMETYPE, DATESAMPLING, STATUTSAMPLE, NAMESPECIES, BIRTHANIMAL from SAMPLE natural join SAMPLETYPE natural join ANIMAL natural join SPECIES where IDSAMPLE ="+id;

		try
		{
			resultsSample = myStatement.executeQuery(QuerySample);
			resultsSample.next();
			
			Date d = new Date(resultsSample.getDate("DATESAMPLING").getDay(),resultsSample.getDate("DATESAMPLING").getMonth(),resultsSample.getDate("DATESAMPLING").getYear());

			mySample = new Samples( resultsSample.getInt("IDSAMPLE"), resultsSample.getString("NAMETYPE"), d, new Animals(resultsSample.getString("NAMESPECIES"),resultsSample.getString("BIRTHANIMAL")));
			
			if (resultsSample.getString("STATUTSAMPLE").equals("Analyse"))
			{
				mySample.setAnalyzed();
			}
		}
		catch (SQLException ex) 
		{
			System.out.println(ex.getMessage());
			System.out.println("Erreur requête Sample");
		}

		return mySample;
	}

	//DONE
	public List<Samples> getListSamples() 
	{
		List<Samples> listS = new ArrayList<Samples>();

		ResultSet resultsSamples = null;

		String QuerySample="Select IDSAMPLE from SAMPLE";

		try
		{
			resultsSamples = myStatement.executeQuery(QuerySample);
			while(resultsSamples.next())
			{
				listS.add(searchSample(resultsSamples.getInt("IDSAMPLE")));
			}
		}
		catch (SQLException ex) 
		{
			System.out.println("Erreur requête Sample");
		}

		return(listS);
	}

	public void saveSample(Samples sample) 
	{
		//		
		//		ResultSet resultsSamples = null;
		//		String QuerySampleType="Insert into SAMPLETYPE values("+sample.getType()+")";
		//		String QuerySample="Insert into SAMPLE values("+sample.getId();
		//		
		//		try
		//		{
		//			resultsSamples = myStatement.executeQuery(QuerySample);
		//		}
		//		catch (SQLException ex) 
		//		{
		//			System.out.println("Erreur requête Sample");
		//		}

		this.sample = sample;
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
	public Users getUser(int id) {
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
		/*if(name.equals(customer.getLastName()))
		{
			return customer;
		}
		else
		{
			Customers cust = new Customers("jean", "dupond", 86000,"Poitiers", "090909",1);
			return cust;
		}*/
		return customer;
		// Bouml preserved body end 00023545
	}

	public Customers searchCustomerID(int ID) {
		// Bouml preserved body begin 000235C5
		/*if(customer.getID()==ID)
		{
			return customer;
		}
		else
		{
			Customers cust = new Customers("jean", "dupond", 86000,"Poitiers", "090909",1);
			return cust;
		}*/
		return customer;
		// Bouml preserved body end 000235C5
	}

	public boolean saveCustomer(Customers cust) {
		// Bouml preserved body begin 00023645
		
		boolean ClientProInsere = false;
		boolean ClientInsere = false;

		ResultSet resultsNbAdressSociete = null;
		ResultSet resultsCustomer = null;
		ResultSet resultsNbClient = null;
		ResultSet resultsIdAdress = null;
		ResultSet resultsNbAdressFacturation = null;
		ResultSet resultsAdressFact = null;
		ResultSet resultsNbPro = null;
		ResultSet resultsIdAdressFact = null;
		ResultSet resultsNbAdressClient = null;
		ResultSet resultsClientPro;
		ResultSet resultsAddClientPro;
		ResultSet resultsClient;
		String QueryClient;
		
		// Si c'est un professionnel
		if (cust.isPro()){
			// vérifier si l'adresse de la société n'existe pas déjà dans la base de données avec l'id
			String QueryNbAdressSociete = "SELECT COUNT(idAdress) AS nbAdress FROM Adress WHERE idAdress="+cust.getAdressClient().getIdAdress();
				
			try {
				resultsNbAdressSociete = myStatement.executeQuery(QueryNbAdressSociete);
				
				resultsNbAdressSociete.next();
				// Si elle n'existe pas, on l'ajoute
				if (resultsNbAdressSociete.getInt("nbAdress") == 0){
					String QueryCustomer = "INSERT INTO Adress (NUM, CP, TOWN, STREET) VALUES ("+cust.getAdressClient().getNumber() + "," + cust.getAdressClient().getZipCode() + ",'" + cust.getAdressClient().getCity() + "','" + cust.getAdressClient().getStreet()+"')";
					
					resultsCustomer = myStatement.executeQuery(QueryCustomer);	
				}
			}
			catch (SQLException ex) {
				System.out.println("Erreur requête AdressSociete");
			}										
			
			try {		
					
				//Si le client n'existe pas, on l'ajoute dans la table Client
				if (!IfCustomerExist(cust)){					
					if (cust.getFax() != null) {							
						QueryClient = "INSERT INTO Client (LOGIN, IDADRESS, CORPORATIONNAME, NAMECLIENT, PHONECLIENT, FAXCLIENT, FIRSTNAMECLIENT) VALUES (null," + cust.getAdressClient().getIdAdress() + ",'" + cust.getNomSociete() + "','" + cust.getLastName() + "','" + cust.getPhone() + "','" + cust.getFax() + "','" + cust.getFirstName() + "')";
					}
					else {						
						QueryClient = "INSERT INTO Client (LOGIN, IDADRESS, CORPORATIONNAME, NAMECLIENT, PHONECLIENT, FAXCLIENT, FIRSTNAMECLIENT) VALUES (null," + cust.getAdressClient().getIdAdress() + ",'" + cust.getNomSociete() + "','" + cust.getLastName() + "','" + cust.getPhone() + "', null,'" + cust.getFirstName() + "')";
						
					}
					
					resultsClientPro = myStatement.executeQuery(QueryClient);
				}
			}
			catch (SQLException ex) {
				System.out.println("Erreur requête Client");
			}	
			
			// Si on a une adresse de facturation
			if (cust.getAdressFacturation() != null) {				
				// on vérifie si elle existe dans la BDD avec l'id
				String QueryNbAdressFacturation = "SELECT COUNT(idAdress) AS nbAdress FROM Adress WHERE idAdress="+cust.getAdressFacturation().getIdAdress();
			
				try {									
					resultsNbAdressFacturation = myStatement.executeQuery(QueryNbAdressFacturation);
					
					resultsNbAdressFacturation.next();
					// Si elle n'existe pas, on l'ajoute
					if (resultsNbAdressFacturation.getInt("nbAdress") == 0){
						String QueryAdressPro = "INSERT INTO Adress (NUM, CP, TOWN, STREET) VALUES ("+cust.getAdressFacturation().getNumber() + "," + cust.getAdressFacturation().getZipCode() + ",'" + cust.getAdressFacturation().getCity() + "','" + cust.getAdressFacturation().getStreet()+"')";
						
						resultsAdressFact = myStatement.executeQuery(QueryAdressPro);
					}	
				}
				catch (SQLException ex) {
					System.out.println("Erreur requête adresseFacturation");
				}
			}
			
			// On vérifie si le client pro existe dans la table ProfessionnalClient
			String QueryNbPro = "SELECT COUNT(corporationName) AS nbPro FROM ProfessionalClient WHERE corporationName='"+cust.getNomSociete() +"'";
			
			try {
				resultsNbPro = myStatement.executeQuery(QueryNbPro);					
					
				resultsNbPro.next();
				// Si il n'existe pas, on l'ajoute (il faut vérifier si on a un mail de facturation et un departement de paiement pour le customer donné
				if (resultsNbPro.getInt("nbPro") == 0){		
					if(cust.getAdressFacturation() != null){
						if (cust.getEmail() != null) {	
							if (cust.getDepartementFacturation() != null) {
								QueryClient = "INSERT INTO ProfessionalClient VALUES ('" + cust.getNomSociete() + "'," + cust.getAdressFacturation().getIdAdress() + ",'" + cust.getEmail() + "','" + cust.getDepartementFacturation() +"')";
							}
							else {
								QueryClient = "INSERT INTO ProfessionalClient VALUES ('" + cust.getNomSociete() + "'," + cust.getAdressFacturation().getIdAdress() + ",'" + cust.getEmail() + "', null)";
							}
						}
						else {
							if (cust.getDepartementFacturation() != null) {
								QueryClient = "INSERT INTO ProfessionalClient VALUES ('" + cust.getNomSociete() + "'," + cust.getAdressFacturation().getIdAdress() + ", null,'" + cust.getDepartementFacturation() +"')";
							}
							else {
								QueryClient = "INSERT INTO ProfessionalClient VALUES ('" + cust.getNomSociete() + "'," + cust.getAdressFacturation().getIdAdress() + ", null, null)";
							}
						}
					}
					else {
						if (cust.getEmail() != null) {	
							if (cust.getDepartementFacturation() != null) {
								QueryClient = "INSERT INTO ProfessionalClient VALUES ('" + cust.getNomSociete() + "', null,'" + cust.getEmail() + "','" + cust.getDepartementFacturation() +"')";
							}
							else {
								QueryClient = "INSERT INTO ProfessionalClient VALUES ('" + cust.getNomSociete() + "', null,'" + cust.getEmail() + "', null)";
							}
						}
						else {
							if (cust.getDepartementFacturation() != null) {
								QueryClient = "INSERT INTO ProfessionalClient VALUES ('" + cust.getNomSociete() + "', null, null,'" + cust.getDepartementFacturation() +"')";
							}
							else {
								QueryClient = "INSERT INTO ProfessionalClient VALUES ('" + cust.getNomSociete() + "', null, null, null)";
							}
						}
					}										
					resultsAddClientPro = myStatement.executeQuery(QueryClient);
					ClientProInsere = true;
				}
			}
			catch (SQLException ex) {
				System.out.println("Erreur requête ClientPro");
			}							
		}
		
		// Sinon c'est un particulier
		else {
			// vérifier si l'adresse du client n'existe pas déjà dans la base de données avec l'id
			String QueryNbAdressClient = "SELECT COUNT(idAdress) AS nbAdress FROM Adress WHERE idAdress="+cust.getAdressClient().getIdAdress();						
			
			try {					
				resultsNbAdressClient = myStatement.executeQuery(QueryNbAdressClient);
				
				resultsNbAdressClient.next();
				// Si elle n'existe pas, on l'ajoute
				if (resultsNbAdressClient.getInt("nbAdress") == 0){					
					String QueryCustomer = "INSERT INTO Adress (NUM, CP, TOWN, STREET) VALUES ("+cust.getAdressClient().getNumber() + "," + cust.getAdressClient().getZipCode() + ",'" + cust.getAdressClient().getCity() + "','" + cust.getAdressClient().getStreet()+"')";
					
					resultsCustomer = myStatement.executeQuery(QueryCustomer);						
				}
			}
			catch (SQLException ex) {
				System.out.println("Erreur requête AdressClient");
			}										
			try {
				
				//Si le client n'existe pas, on l'ajoute
				if (!IfCustomerExist(cust)){										
					if (cust.getFax() != null) {							
						QueryClient = "INSERT INTO Client (LOGIN, IDADRESS, CORPORATIONNAME, NAMECLIENT, PHONECLIENT, FAXCLIENT, FIRSTNAMECLIENT) VALUES (null," + cust.getAdressClient().getIdAdress() + ", null,'" + cust.getLastName() + "','" + cust.getPhone() + "','" + cust.getFax() + "','" + cust.getFirstName() + "')";
					}
					else {						
						QueryClient = "INSERT INTO Client (LOGIN, IDADRESS, CORPORATIONNAME, NAMECLIENT, PHONECLIENT, FAXCLIENT, FIRSTNAMECLIENT) VALUES (null," + cust.getAdressClient().getIdAdress() + ", null,'" + cust.getLastName() + "','" + cust.getPhone() + "', null,'" + cust.getFirstName() + "')";
					}
					
					resultsClient = myStatement.executeQuery(QueryClient);
					ClientInsere = true;
				}
			}
			catch (SQLException ex) {
				System.out.println("Erreur requête Client Particulier");
			}
		}
		
		if (ClientProInsere || ClientInsere){
			return true;
		}
		else {
			return false;
		}
	}

	public Analysis searchAnalysis(Types_analysis type) {
		// Bouml preserved body begin 00023745
		if(this.analysis.getTypeAnalysis()== type)
		{
			return this.analysis;
		}
		else
		{
			Analysis ana = new Analysis(2, typeAna, d2,null,null,"en cours");
			return ana;
		}
		// Bouml preserved body end 00023745
	}



	public List<Types_analysis> getListAnalysisType() {
		// Bouml preserved body begin 000236C5
		List<Types_analysis> listTA = new ArrayList<Types_analysis>();
		listTA.add(this.typeAna);
		return(listTA);
		// Bouml preserved body end 000236C5
	}

	public Analysis searchAnalysisID(int ID) {
		// Bouml preserved body begin 000237C5
		if(this.analysis.getID()== ID)
		{
			return this.analysis;
		}
		else
		{
			Analysis ana = new Analysis(2, typeAna, d2,null,null,"en cours");
			return ana;
		}
		// Bouml preserved body end 000237C5
	}

	public void saveAnalysis(Analysis analysis) {
		// Bouml preserved body begin 00023845
		String query="insert into Analysis values ("+analysis.getID()+","+analysis.getSecondReader().getId()+","+analysis.getFirstReader().getId()+","+analysis.getIDMother()+","+analysis.getIDFather()+","+analysis.getID()+","+analysis.getStatut()+","+analysis.getResult1()+","+analysis.getResult2()+")";

		try {
			myStatement.execute(query);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Types_analysis> searchTypesAnalysis(String name,String test) {
		// Bouml preserved body begin 000238C5
		ArrayList<Types_analysis> typeAnalysisOut=new ArrayList<Types_analysis>();
		ResultSet result;
		int typeID=0;
		int typeTest=0;
		try{
			result=myStatement.executeQuery("select idtype from sampletype where nametype="+name);
			if (result.next()){
				typeID=result.getInt("idtype");
				result=myStatement.executeQuery("select idtest from testtype where nametest="+test);
				if(result.next()){
					typeTest=result.getInt("idtest");

				}
				else{
					System.out.println("le type de test demandé n'est pas connu");
				}
			}
			else{
				System.out.println("le type d'échantillon demandé n'est pas connu");
			}


		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return typeAnalysisOut;
		// Bouml preserved body end 000238C5
	}

	public void saveAnalysisType(Types_analysis typeAnalysis) {
		// Bouml preserved body begin 00023945

		ResultSet result;
		int testID=0;
		int typeID=0;
		try {
			String query="insert into cost values ("+typeID+",0)";
			myStatement.execute(query);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Bouml preserved body end 00023945
	
	/**
	 * This function permits to verify if the name of the species is on the database, it returns true if it isn't in.
	 * @param : name of the species
	 * @return : false si l'espece existe déjà
	 * @author mathilde
	 */
	public boolean verifSpecies(String species) {
		String QuerySample="Select COUNT(Species.idSpecies) From Species Where Species.nameSpecies = '"+species+"'";
		try
		{
			ResultSet monRes = myStatement.executeQuery(QuerySample);
			monRes.next();
			if (Integer.parseInt(monRes.getString(1)) == 0) {
				return(true);
			}
		}
		catch (SQLException ex) 
		{
			System.out.println(ex.getMessage());
			System.out.println("Erreur requête vérification species dans la base");
		}
		return(false);
	}
	
	/**
	 * This function permits to get the id of a Sting name Category
	 * @param : name of the species
	 * @return : -1 if the id dosn't exist
	 * @author mathilde
	 */
	public int getIdCategory(String category) 
	{
		String QuerySample="Select idCategory From Category Where nameCategory = '"+category+"'";
		try
		{
			ResultSet monRes = myStatement.executeQuery(QuerySample);
			monRes.next();
			return(Integer.parseInt(monRes.getString(1)));
		}
		catch (SQLException ex) 
		{
			System.out.println(ex.getMessage());
			System.out.println("Erreur requête recupere idCategory");
		}
		return(-1);
	}
	
	/**
	 * This function permits to save a species in the database
	 * @param : name of the species, id of the category
	 * @author mathilde
	 */
	public void saveSpecies(String species, int idCategory) 
	{
		String QuerySample="Insert into Species values(1,'"+species+"',"+idCategory+")";
		try
		{
			myStatement.executeQuery(QuerySample);
		}
		catch (SQLException ex) 
		{
			System.out.println(ex.getMessage());
			System.out.println("Erreur requête insert species");
		}
	}
}

