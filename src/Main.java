import java.util.ArrayList;


public class Main {

	public static void main(String[] args) 
	{
		Database d = new Database();
		
		
		
		//d.DisplayResultsQuery("select * from ADRESS");
		
		//Samples s = d.searchSample(""+2);
		
		//s.printSample(s);
		
		
		ArrayList<Types_analysis> t =  d.searchTypesAnalysis("plume", "Sexage");
		
		for (int i = 0; i < t.size(); i++)
		{
			System.out.println(i);
		}
		
		
		d.close();
	}

}
