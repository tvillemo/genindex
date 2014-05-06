
public class Main {

	public static void main(String[] args) 
	{
		Database d = new Database();
		
		d.ConnectBDD();
		d.DisplayResultsQuery("select *");
		d.close();
	}

}
