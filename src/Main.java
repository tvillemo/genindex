import java.util.ArrayList;


public class Main {

	public static void main(String[] args) 
	{
		Database d = new Database();
		
		
		
		//d.DisplayResultsQuery("Select IDSAMPLE, NAMETYPE from SAMPLE where IDSAMPLE=2;");
		
		//Samples s = d.searchSample(""+2);
		
		//s.printSample(s);

		Customers c = new Customers(null, 0, null, null, 0);
		c.setName("Alex", "Robert");
		c.setAdressClient(new Adress(23,"rue des Roses",45000,"Orléans"));
		c.setPro(false);
		
		d.saveCustomer(c);
		
		/*System.out.println(d.IfCustomerExist(new Customers(null, 0, null, null, 1)));
		
		System.out.println(d.IfCustomerExist(c));*/		

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
