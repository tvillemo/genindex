import java.util.ArrayList;


public class Main {

	public static void main(String[] args) 
	{
		Database d = new Database();
		
		
		
		//d.DisplayResultsQuery("Select IDSAMPLE, NAMETYPE from SAMPLE where IDSAMPLE=2;");
		
		//Samples s = d.searchSample(""+2);
		
		//s.printSample(s);

//		Customers c = new Customers(null, 0, null, null, 1);
//		c.setName("Auguste", "Dupond");
//		c.setAdressClient(new Adress(56,"rue des Pivers",59000,"Dunkerque"));
//		c.setNomSociete("");
//		c.setPro(false);
//		
//		Animals a = new Animals(null, null);
//		a.setName("51423565");
		

		ArrayList<String> X = d.getAnalyseByCategory("Oiseaux");
		
		for (int i = 0; i< X.size();i++)
		{
			System.out.println(X.get(i));
		}
//		Ovins
//		Oiseaux
//		Canins
//		Felins
//		Bovins
//		Porcins
//		Poissons d'aquaculture
//		Huitres
//		Crevettes
//		Gazelles
//		Girafes
//		Iguanes
//		Chevaux
//		Renards
		
		//System.out.println(d.IfCustomerExist(c));
		
		//System.out.println(d.IfAnimalExist(a,c));

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
