import java.util.ArrayList;


public class Main {

	public static void main(String[] args) 
	{
		Database d = new Database();
		
		
		//boolean bool = d.verifSpecies("BBB");
		//System.out.println("le booléen est "+bool);
		
		int id = d.getIdCategory("Oiseaux");
		System.out.println("l'id est"+id);
		
		d.saveSpecies("Limousine", 5);
		
		//d.DisplayResultsQuery("Select IDSAMPLE, NAMETYPE from SAMPLE where IDSAMPLE=2;");
		
		//Samples s = d.searchSample(""+2);
		
		//s.printSample(s);
		
//		
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
