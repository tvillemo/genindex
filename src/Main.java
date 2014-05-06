
public class Main {

	public static void main(String[] args) 
	{
		Database d = new Database();
		
		
		
		//d.DisplayResultsQuery("select * from ADRESS");
		
		Samples s = d.searchSample(""+2);
		
		//s.printSample(s);
		
		d.close();
	}

}
