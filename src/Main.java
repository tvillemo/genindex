import java.util.ArrayList;


public class Main {

	public static void main(String[] args) 
	{
		Database d = new Database();
		
		
		
		//d.DisplayResultsQuery("Select IDSAMPLE, NAMETYPE from SAMPLE where IDSAMPLE=2;");
		
		//Samples s = d.searchSample(""+2);
		
		//s.printSample(s);

		Customers c = new Customers(null, 0, null, null, 0);
		c.setName("Auguste", "Dupond");
		c.setAdressClient(new Adress(56,"rue des Pivers",59000,"Dunkerque"));
		c.setPro(false);
		

		System.out.println(d.IfCustomerExist(new Customers(null, 0, null, null, 1)));
		
		System.out.println(d.IfCustomerExist(c));

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
