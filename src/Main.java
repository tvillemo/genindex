import java.util.ArrayList;


public class Main {

	public static void main(String[] args) 
	{
		Database d = new Database();

		
		ArrayList<Customers> c = d.searchCustomersByName("Sansa","Clement");
		
		System.out.println(c.get(1).getFirstName());
		System.out.println(c.get(1).getLastName());
		System.out.println(c.get(1).getAdressClient().getNumber());
		d.close();

	}

}
