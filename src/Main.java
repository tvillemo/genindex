import java.util.ArrayList;


public class Main {

	public static void main(String[] args) 
	{
		Database d = new Database();

		
		ArrayList<Customers> test = d.searchCustomersByName("Sansa", "Clement");
		
		System.out.println(test.get(0).getFirstName());
		System.out.println(test.get(1));

		d.close();



	}

}