import java.util.ArrayList;


public class Main {

	public static void main(String[] args) 
	{
		Database d = new Database();
		
		
		
		//d.DisplayResultsQuery("Select IDSAMPLE, NAMETYPE from SAMPLE where IDSAMPLE=2;");
		
		//Samples s = d.searchSample(""+2);
		
		//s.printSample(s);

		Customers c = new Customers(null, 0, null, null, 0);
		c.setName("Lili", "Jones");
		c.setPhone("+33148963214");
		//c.setNomSociete("Equita");
		//c.setDepartementFacturation("Compta");
		//c.setEmail("lTaylor@equita.com");
		c.setAdressClient(new Adress(63,"avenue Perrier",31000,"Toulouse"));		
		c.getAdressClient().setIdAdress(22);
		//c.setAdressFacturation(c.getAdressClient());
		//c.getAdressFacturation().setIdAdress(22);				
		c.setPro(false);
		

		d.saveCustomer(c);


//		ArrayList<Types_analysis> t =  d.searchTypesAnalysis("plume", "Sexage");
//		
//		for (int i = 0; i < t.size(); i++)
//		{
//			System.out.println(i);
//		}
//		
		
		d.close();



	}

}
